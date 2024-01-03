package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.*;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
import com.scwl.service.ManageStateService;
import com.scwl.service.RentBillService;
import com.scwl.vo.RentBillVo;
import com.scwl.vo.RentLeaseInfoVo;
import lombok.val;
import org.apache.poi.hssf.record.DVALRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class RentBillServiceImpl implements RentBillService {

    @Autowired
    private RentBillMapper rentBillMapper;
    @Autowired
    private RentLesseeMapper lesseeMapper;
    @Autowired
    private RentAssetMapper assetMapper;
    @Autowired
    private RentLeaseInfoMapper infoMapper;
    @Autowired
    private ManageStateMapper manageStateMapper;
    @Autowired
    private ManageStateService manageStateService;
    @Autowired
    private LogService logService;
    @Override
    public ResBean getBillList(Integer pageNum, Integer pageSize, RentBillVo rentBillVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<RentBillVo> list = rentBillMapper.getBillList(rentBillVo);
        PageInfo<RentBillVo> pageInfo = new PageInfo<>(list);
        return  ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addBill(RentBill rentBill) {
        try{
            rentBill.setAddTime(new Date());
            rentBill.setIsDelete(0);
            rentBillMapper.insert(rentBill);
            logService.addLog("INSERT","rent_bill",rentBill.getId(),"新增id为"+rentBill.getId()+"的租金缴纳信息");
           return  ResBean.success("添加成功");
           }catch (Exception e){
           return ResBean.error(e.getMessage());
       }
    }

    @Override
    public ResBean editBill(RentBill rentBill) {
        try{
            rentBillMapper.updateByPrimaryKey(rentBill);
            logService.addLog("UPDATE","rent_bill",rentBill.getId(),"修改id为"+rentBill.getId()+"的租金缴纳信息");
            return  ResBean.success("修改成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean deleteBill(String ids) {
        try{
            Gson gson = new Gson();
            Integer[] idList = gson.fromJson(ids, Integer[].class);
            for (Integer id : idList) {
                RentBill rentBill = rentBillMapper.selectByPrimaryKey(id);
                rentBill.setIsDelete(1);
                rentBillMapper.updateByPrimaryKey(rentBill);
                logService.addLog("DELETE", "rent_bill", id, "删除id为" + id + "的租金缴纳信息");
            }
            return  ResBean.success("删除成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean deductArrears(String ids) {
        BigDecimal zero = new BigDecimal(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Gson gson = new Gson();
        Integer[] idList = gson.fromJson(ids, Integer[].class);
        for (Integer id : idList) {
            RentBill bill = rentBillMapper.selectByPrimaryKey(id);
            BigDecimal amountOwed = bill.getAmountOwed();
            RentLessee rentLessee = lesseeMapper.selectByPrimaryKey(bill.getLesseeId());
            if(rentLessee.getAccount().compareTo(amountOwed)>=0){
                bill.setAmount(bill.getAmount().add(amountOwed));
                bill.setAmountOwed(zero);
                bill.setStatus(1);
                rentBillMapper.updateByPrimaryKey(bill);
                rentLessee.setAccount(rentLessee.getAccount().subtract(amountOwed));
                lesseeMapper.updateByPrimaryKey(rentLessee);
                manageStateService.deductArrears(bill,amountOwed);
                //查询该租约是否还有欠费租金
                RentBill totalBill = rentBillMapper.getAmountOwed(bill.getLeaseInfoId());
                if(totalBill.getAmountOwed().compareTo(zero)==0){
                    //更新租约状态
                    RentLeaseInfo rentLeaseInfo = infoMapper.selectByPrimaryKey(bill.getLeaseInfoId());
                    rentLeaseInfo.setStatus(1);
                    infoMapper.updateByPrimaryKey(rentLeaseInfo);
                }
                logService.addLog("UPDATE", "rent_bill", id, "给租户" + rentLessee.getLesseeName() + "补交"+format.format(bill.getAddTime())+"的"+amountOwed+"元租金");

            }else {
                return ResBean.success("操作失败，当前租户->"+rentLessee.getLesseeName()+"余额不足");
            }


        }
        return ResBean.success("操作成功");
    }

    /**
     * 自动生成月租金缴纳单
     * @return
     */
    @Override
    public ResBean generateBill() {
        //获取租赁中昨天该缴纳的租金单
        List<RentLeaseInfo> infoList = infoMapper.getCurrentInfo();
        BigDecimal total = new BigDecimal(0);
        BigDecimal totalOwed = new BigDecimal(0);
        for (RentLeaseInfo info : infoList) {
            //判断当天相应的缴费账单是否已经生成，未生成则往下生成
            List<RentBill> billList = rentBillMapper.getByInfoId(info.getId());
            if(billList.size()==0){
            BigDecimal unitPrice = info.getLeaseUnitPrice();
            //获取租户
            RentLessee lessee = lesseeMapper.selectByPrimaryKey(info.getLesseeId());
            BigDecimal account = lessee.getAccount();
            //获取资产
            RentAsset asset = assetMapper.selectByPrimaryKey(info.getAssetId());
            //延期到下个月的缴纳日期
            LocalDate localDate = LocalDate.now().plusMonths(1);
            info.setPayDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            infoMapper.updateByPrimaryKey(info);
            RentBill bill = new RentBill();
              bill.setAddTime(info.getPayDate());
              bill.setAmount(unitPrice);
              bill.setAssetId(asset.getId());
              bill.setLeaseInfoId(info.getId());
              bill.setLesseeId(lessee.getId());
            //判断租户账户金额是否够缴纳租金
            if(account.compareTo(unitPrice)>=0){
                lessee.setAccount(lessee.getAccount().subtract(unitPrice));
                lesseeMapper.updateByPrimaryKey(lessee);
                info.setStatus(1);//租赁中，已缴纳
//                asset.setStatus(2);//租赁中
//                assetMapper.updateByPrimaryKey(asset);
                bill.setStatus(1);//已交
                bill.setRentDay(info.getPayDate());
                bill.setAmountOwed(new BigDecimal(0));
                rentBillMapper.insert(bill);
                total=total.add(unitPrice);
                String content=lessee.getLesseeName()+"->租金缴纳："+info.getLeaseUnitPrice()+"元;"+"缴纳前账户余额是："+account+"元;缴纳后账户余额是："+lessee.getAccount()+"元";
                logService.generateLog("UPDATE", "rent_lessee", lessee.getId(), content);
                continue;
            }
                //租户余额不足时判断是否有免租期
            if(info.getFreeMonthNum()>0){
                //有免租期
                bill.setAmount(new BigDecimal(0));//支付金额为0
                bill.setStatus(1);//已交
                bill.setAmountOwed(new BigDecimal(0));
                bill.setRentDay(info.getPayDate());
                bill.setRemark("当月免租");
                rentBillMapper.insert(bill);
                //扣除免租期
                info.setFreeMonthNum(info.getFreeMonthNum()-1);
                infoMapper.updateByPrimaryKey(info);
                continue;
            }
                //账户月余额不足，也不存在免租期生成欠费账单修改
               if(account.compareTo(new BigDecimal(0))>0){
                   //如果账户还有余额就先扣除只剩0
                   bill.setAmount(account);
                   bill.setStatus(2);//欠费
                   bill.setAmountOwed(unitPrice.subtract(account));//欠费金额
                   bill.setRentDay(info.getPayDate());
                   rentBillMapper.insert(bill);
                   lessee.setAccount(account.subtract(unitPrice));//账户余额更新为负数
                   lessee.setStatus(2);//欠费
                   lesseeMapper.updateByPrimaryKey(lessee);
                   total= totalOwed.add(account);
                   totalOwed= totalOwed.add(bill.getAmountOwed());
                   String content=lessee.getLesseeName()+"->租金缴纳："+bill.getAmount()+"元;"+"缴纳前账户余额是："+account+"元;缴纳后已欠费，欠费金额是："+bill.getAmountOwed()+"元";
                   logService.generateLog("UPDATE", "rent_lessee", lessee.getId(), content);
                   continue;
               }else {
                   bill.setAmount(new BigDecimal(0));
                   bill.setStatus(2);//欠费
                   bill.setAmountOwed(unitPrice);//欠费金额
                   rentBillMapper.insert(bill);
                   lessee.setAccount(account.subtract(unitPrice));//账户余额更新为负数
                   lessee.setStatus(2);//欠费
                   lesseeMapper.updateByPrimaryKey(lessee);
                   totalOwed= totalOwed.add(unitPrice);
                   String content=lessee.getLesseeName()+"->租金缴纳："+bill.getAmount()+"元;"+"缴纳前账户余额是："+account+"元;缴纳后已欠费，欠费金额是："+bill.getAmountOwed()+"元";
                   logService.generateLog("UPDATE", "rent_lessee", lessee.getId(), content);
               }

            }

        };
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String content=now+"：当天应收租金"+total.add(totalOwed)+"元;实收租金"+total+"元;"+"当天欠费："+totalOwed+"元";
        logService.generateLog("INSERT", "sys_log", 0, content);
        return ResBean.success("月账单生成成功->"+content);
    }

    @Override
    public ResBean auToMonthBill() {
        //获取当天是否为月初1号
        int one = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        ManageState lastManage = manageStateMapper.getLastMonth("资金管理");
        if(one == 1){
            //更新上月最新数据（）上个月月底的账单是下个月1号凌晨生成
            RentBill lastBill = rentBillMapper.getAmountAndAmountOwedLastMonth();
            ManageState lastTwoManage = manageStateMapper.getLastTwoMonth("资金管理");
            if(null==lastTwoManage){
                lastTwoManage.setCurrentTotal(new BigDecimal(0));
            }
            if(null!=lastManage){
                updateManageState(lastManage,lastTwoManage,lastBill);
            }else {
                lastManage.setCurrentTotal(new BigDecimal(0));
            }
        }
            //汇总当天当月的租金收入情况
            RentBill bill = rentBillMapper.getAmountAndAmountOwed();
            ManageState manage = manageStateMapper.getCurrentMonth("资金管理");
            updateManageState(manage,lastManage,bill);

        return ResBean.success("资金管理月账单更新成功！");
    }

    @Override
    public List<Map<String, Object>> exportExcel() {
        List<Map<String, Object>> list = new ArrayList<>();
        //获取所有租约
        List<RentLeaseInfoVo> billList = infoMapper.getLeaseInfoList(new RentLeaseInfoVo());
        for (RentLeaseInfoVo info : billList) {
            //租约状态（1.租赁中，2，正常完了不在续约，3，提前退租）
            if(info.getStatus()==1){
                info.setRemark("租赁中");
            }else  if(info.getStatus()==1){
                info.setRemark("已到期");
            }else{
                info.setRemark("提前退租");
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("rentLeaseInfoVo",info);
            //查询对应最近12个月的租金收入
            List<RentBill> bills = getBills(info.getId());
            map.put("rentBill",bills);
            list.add(map);
        }
        return list;
    }

    public  List<RentBill>  getBills(Integer InfoId){
        List<RentBill> bills = new ArrayList<>();
        LocalDate localDate = LocalDate.now().minusMonths(11);
        RentBill bill = rentBillMapper.getLastMonthBill(InfoId,localDate.getMonthValue(),localDate.getYear());
        if(null==bill){
            bill =  new RentBill();
            bill.setAmount(new BigDecimal(-1));
            bill.setAmountOwed(new BigDecimal(-1));
        }
        bills.add(bill);
        for (int i = 0; i < 11; i++) {
            localDate = localDate.plusMonths(1);
            int yaer = localDate.getYear();
            int month = localDate.getMonthValue(); // 月份从0开始，所以需要加1
            bill = rentBillMapper.getLastMonthBill(InfoId,month,yaer);
            if(null==bill){
                bill =  new RentBill();
                bill.setAmount(new BigDecimal(-1));
                bill.setAmountOwed(new BigDecimal(-1));
            }
            bills.add(bill);
        }
        return  bills;

    }

    public void updateManageState(ManageState manage,ManageState lastManage,RentBill bill){
         //查询当月资金管理是否存在账单
        manage.setName("资金管理");
        manage.setType("资金管理");
        manage.setRentIncome(bill.getAmount());
        manage.setLetRate(bill.getAmountOwed());
        manage.setCurrentTotal(bill.getAmountOwed().add(lastManage.getCurrentTotal()));
        if (null == manage.getId()) {
            manage.setPeriodicTime(new Date());
            manageStateMapper.insert(manage);
        } else {
            manageStateMapper.updateByPrimaryKey(manage);
        }
    }
}
