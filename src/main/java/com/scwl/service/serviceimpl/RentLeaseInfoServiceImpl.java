package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.RentAssetMapper;
import com.scwl.mapper.RentBillMapper;
import com.scwl.mapper.RentLeaseInfoMapper;
import com.scwl.mapper.RentLesseeMapper;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
import com.scwl.service.RentLeaseInfoService;
import com.scwl.vo.RentLeaseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@Service
public class RentLeaseInfoServiceImpl implements RentLeaseInfoService {
    @Autowired
    private LogService logService;
    @Autowired
    private RentLeaseInfoMapper rentLeaseInfoMapper;
    @Autowired
    private RentAssetMapper rentAssetMapper;
    @Autowired
    private RentLesseeMapper rentLesseeMapper;

    @Autowired
    private RentBillMapper billMapper;

    @Override
    public ResBean getLeaseInfoList(Integer pageNum, Integer pageSize, RentLeaseInfoVo rentLeaseInfoVo) {
        PageHelper.startPage(pageNum,pageSize);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String current = format.format(new Date());
        List<RentLeaseInfoVo> list = rentLeaseInfoMapper.getLeaseInfoList(rentLeaseInfoVo);
        for (RentLeaseInfoVo leaseInfoVo : list) {
            String expireMonth = format.format(leaseInfoVo.getExpireDate());
            if(current.equals(expireMonth)){
                leaseInfoVo.setRemark("当月到期");
            }
        }
        PageInfo<RentLeaseInfoVo> pageInfo = new PageInfo<>(list);
        return  ResBean.success("查询成功",pageInfo);
    }

    @Override
    @Transactional
    public ResBean addLeaseInfo(RentLeaseInfo rentLeaseInfo) {
        try{
            Date payDate = rentLeaseInfo.getPayDate();
            //下个月的交租日
            LocalDate localDate = Instant.ofEpochMilli(payDate.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate().plusMonths(1);
            RentLessee rentLessee = rentLesseeMapper.selectByPrimaryKey(rentLeaseInfo.getLesseeId());
            BigDecimal preAmount = rentLessee.getAccount();
            RentAsset rentAsset = rentAssetMapper.selectByPrimaryKey(rentLeaseInfo.getAssetId());
            if(null==rentLeaseInfo.getCashPledge()){
                rentLeaseInfo.setCashPledge(new BigDecimal(0));
            }
            if(null==rentLeaseInfo.getFreeMonth()){
                rentLeaseInfo.setFreeMonth(0);
            }
            rentLeaseInfo.setFreeMonthNum(rentLeaseInfo.getFreeMonth());
            rentLeaseInfo.setQuitDate(rentLeaseInfo.getExpireDate());
            rentLeaseInfo.setAddTime(new Date());
            rentLeaseInfo.setPayDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            rentLeaseInfo.setIsDelete(0);
            rentLeaseInfoMapper.insert(rentLeaseInfo);
            rentAsset.setStatus(2);
            rentAssetMapper.updateByPrimaryKey(rentAsset);
            rentLessee.setAccount(rentLessee.getAccount().subtract(rentLeaseInfo.getLeaseUnitPrice()).subtract(rentLeaseInfo.getCashPledge()));
            rentLessee.setPledgeAmount(rentLessee.getPledgeAmount().add(rentLeaseInfo.getCashPledge()));
            rentLesseeMapper.updateByPrimaryKey(rentLessee);
            String content=rentLessee.getLesseeName()+"->租金缴纳："+rentLeaseInfo.getLeaseUnitPrice()+"元;押金缴纳："+rentLeaseInfo.getCashPledge()+"元；缴纳前账户余额是："+preAmount+"元;缴纳后账户余额是："+rentLessee.getAccount()+"元";
            logService.addLog("UPDATE", "rent_lessee", rentLessee.getId(), content);
            //生成当月缴费单
            RentBill bill = new RentBill();
            bill.setStatus(1);
            bill.setLesseeId(rentLessee.getId());
            bill.setAssetId(rentAsset.getId());
            bill.setLeaseInfoId(rentLeaseInfo.getId());
            bill.setAmount(rentLeaseInfo.getLeaseUnitPrice());
            bill.setAmountOwed(new BigDecimal(0));
            bill.setRentDay(payDate);
            bill.setAddTime(bill.getRentDay());
            billMapper.insert(bill);
            logService.addLog("INSERT","rent_lease_info",rentLeaseInfo.getId(),"新增id为"+rentLeaseInfo.getId()+"，名称："+rentLessee.getLesseeName()+"的租约信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean editLeaseInfo(RentLeaseInfo rentLeaseInfo) {
        try{
            RentLeaseInfo oldInfo = rentLeaseInfoMapper.selectByPrimaryKey(rentLeaseInfo.getId());
            if(null!=rentLeaseInfo.getExpireDate()){
              return   reletInfo(oldInfo,rentLeaseInfo);
            }
            if(null!=rentLeaseInfo.getRemark()&&""!=rentLeaseInfo.getRemark()){
                //退租
                return outInfo(rentLeaseInfo);
            }
            return  ResBean.success("修改成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean deleteLeaseInfo(String ids) {
        try{ Gson gson = new Gson();
            Integer[] idList = gson.fromJson(ids, Integer[].class);
            for (Integer id : idList) {
                RentLeaseInfo rentLeaseInfo = rentLeaseInfoMapper.selectByPrimaryKey(id);
                rentLeaseInfo.setIsDelete(1);
                rentLeaseInfoMapper.updateByPrimaryKey(rentLeaseInfo);
                logService.addLog("DELETE", "rent_lease_info", id, "删除id为" + id + "的租约信息");
            }
            return  ResBean.success("删除成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean uploadLeaseInfoFile(List<String[]> data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i);
            RentLeaseInfo rentLeaseInfo = new RentLeaseInfo();
            String assetName = strings[0];
            RentAsset asset = rentAssetMapper.getByName(assetName);

            String lesseName = strings[1];
            String phone = strings[2];
            RentLessee rentLessee = rentLesseeMapper.getByNameAndPhone(lesseName, phone);
            if(null!=asset&&null!=rentLessee){
               rentLeaseInfo.setAssetId(asset.getId());
               rentLeaseInfo.setLesseeId(rentLessee.getId());
               rentLeaseInfo.setRentCycle(strings[3]);
               rentLeaseInfo.setLeaseUnitPrice(new BigDecimal(strings[4]));
               rentLeaseInfo.setCashPledge(new BigDecimal(strings[5]));
               rentLeaseInfo.setLeaseDate(formatter.parse(strings[6]));
               rentLeaseInfo.setExpireDate(formatter.parse(strings[7]));
               if(strings[8].equals("正常")){
                   rentLeaseInfo.setStatus(1);
               }else {
                   rentLeaseInfo.setStatus(2);
               }
                rentLeaseInfoMapper.insert(rentLeaseInfo);
            }
        }
        return  ResBean.success("ok");
    }

    @Override
    public ResBean autoExpire() {
        List<RentLeaseInfo> list = rentLeaseInfoMapper.getExpire();
        for (RentLeaseInfo info : list) {
            info.setStatus(2);
            rentLeaseInfoMapper.updateByPrimaryKey(info);
            RentAsset rentAsset = rentAssetMapper.selectByPrimaryKey(info.getAssetId());
            rentAsset.setStatus(1);
            rentAssetMapper.updateByPrimaryKey(rentAsset);
        }
        return ResBean.success("正常到期"+list.size()+"个租约");
    }

    //续租
    public ResBean reletInfo(RentLeaseInfo oldInfo,RentLeaseInfo rentLeaseInfo){
        RentLessee rentLessee = rentLesseeMapper.selectByPrimaryKey(oldInfo.getLesseeId());
        String content="";
        //未到期续租
        if(oldInfo.getStatus()==1){
            oldInfo.setExpireDate(rentLeaseInfo.getExpireDate());
            content="给租户->"+rentLessee.getLesseeName()+"续租到"+oldInfo.getExpireDate();
        }else {
            //TODO已到期续租(暂时不让到期的在续租，再续租就重新添加租约) 
            return  ResBean.error("续租失败，已到期，请重新添加租约");
        }
        rentLeaseInfoMapper.updateByPrimaryKey(oldInfo);
        logService.addLog("UPDATE","rent_lease_info",rentLeaseInfo.getId(),content);
        return  ResBean.success("续租成功");

    }
    //退租
    public ResBean outInfo(RentLeaseInfo info ){
        Gson gson = new Gson();
        Integer[] ids = gson.fromJson(info.getRemark(), Integer[].class);
        for (Integer id : ids) {
           RentLeaseInfo oldInfo = rentLeaseInfoMapper.selectByPrimaryKey(id);
           RentLessee rentLessee = rentLesseeMapper.selectByPrimaryKey(oldInfo.getLesseeId());
           BigDecimal account = rentLessee.getAccount();
           BigDecimal pledgeAmount = rentLessee.getPledgeAmount();
            RentAsset rentAsset = rentAssetMapper.selectByPrimaryKey(oldInfo.getAssetId());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
           String currentDate = format.format(new Date());
           String expireDate = format.format(oldInfo.getExpireDate());
           //是否提前退租
           if(currentDate.equals(expireDate)){
               //正常当月退租
               oldInfo.setStatus(2);
           }else {
               //提前退租
               oldInfo.setStatus(3);
           }
        //把押金返回到账户余额
           rentLessee.setAccount(rentLessee.getAccount().add(oldInfo.getCashPledge()));
           rentLessee.setPledgeAmount(rentLessee.getPledgeAmount().subtract(oldInfo.getCashPledge()));
           rentLeaseInfoMapper.updateByPrimaryKey(oldInfo);
           rentAsset.setStatus(1);
           rentAssetMapper.updateByPrimaryKey(rentAsset);
           String  infoContent="给租户->"+rentLessee.getLesseeName()+"退租";
           logService.addLog("UPDATE","rent_lease_info",oldInfo.getId(),infoContent);
           if(oldInfo.getCashPledge().compareTo(new BigDecimal(0))>0){
               String  lesseeContent="给租户->"+rentLessee.getLesseeName()+"退押金到账户余额;"+"退租前余额："+account
                       +"元；退租前押金账户是："+pledgeAmount+"元;"+"退租后余额："+rentLessee.getAccount()
                       +"元；退租后押金账户是："+rentLessee.getPledgeAmount()+"元;";
               logService.addLog("UPDATE","rent_lessee",oldInfo.getId(),lesseeContent);
           }
        }
        return  ResBean.success("退租成功");

    }
}
