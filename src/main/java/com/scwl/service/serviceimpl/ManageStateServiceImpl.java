package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.ManageStateMapper;
import com.scwl.pojo.ManageState;
import com.scwl.pojo.RentBill;
import com.scwl.pojo.ResBean;
import com.scwl.service.LogService;
import com.scwl.service.ManageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class ManageStateServiceImpl implements ManageStateService {
    @Autowired
    private ManageStateMapper manageStateMapper;
    @Autowired
    private LogService logService;
    @Override
    public ResBean getAllManageState(int pageNum, int pageSize, ManageState manageState) {
        String msg="查询成功！";
        if(manageState.getType().equals("资产经营")&&!manageState.getName().equals("")){
            manageState.setName("");
            msg +="选择资产经营的时候无法选择项目名称";
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ManageState> manageList = manageStateMapper.getAllManageState(manageState);
        PageInfo<ManageState> pageInfo = new PageInfo<>(manageList);
        return ResBean.success(msg,pageInfo);
    }

    @Override
    public ResBean addState(ManageState manageState) {
        try{
            if(manageState.getType().equals("资产经营")){
                manageState.setName("资产经营");
            }
            ManageState currentMonth = manageStateMapper.getByMonth(manageState);
            if(null!=currentMonth){
                return  ResBean.success("当月已经存在无法再添加，请前去修改!");
            }
            manageStateMapper.insert(manageState);
            logService.addLog("INSERT","manage_state",manageState.getId(),"新增id为"+manageState.getId()+"的经营状况信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean updateState(ManageState manageState) {
        try{
            ManageState manage= manageStateMapper.selectByPrimaryKey(manageState.getId());
            manage.setRentArrears(manageState.getRentArrears());
            manage.setLetRate(manageState.getLetRate());
            manage.setRentIncome(manageState.getRentIncome());
            manageStateMapper.updateByPrimaryKey(manage);
            logService.addLog("UPDATE","manage_state",manageState.getId(),"更新id为"+manageState.getId()+"的经营状况信息");
            return  ResBean.success("修改成功");
        }catch (Exception e){
            return  ResBean.error("修改失败");
        }
    }

    @Override
    public ResBean deleteState(String ids) {
        Integer[] idList = new Gson().fromJson(ids, Integer[].class);
        for (Integer id : idList) {
            manageStateMapper.deleteByPrimaryKey(id);
            logService.addLog("DELETE","manage_state",id,"删除id为"+id+"的经营状况信息");
        }
        return  ResBean.success("删除成功");
    }

    @Override
    public ResBean getManageStateByCenter(Integer yearNum) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if(null!=yearNum){
            //查询当年12个月的数据
            //租金收入（图形化）
            List<ManageState> income = manageStateMapper.getDataByColumnByYear(yearNum,"rent_income", "资产经营");
            BigDecimal zero = BigDecimal.ZERO;
            BigDecimal rent_total = zero;
            for (ManageState manageState : income) {
                rent_total = rent_total.add(manageState.getRentIncome());
            }
            //租金收入（欠收）当年度总额
            hashMap.put("rent_total", rent_total.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP));
            hashMap.put("income", income);
            String income_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(income.get(income.size() - 1).getPeriodicTime());
            hashMap.put("income_lastDate", "截至" + income_lastDate);
            //欠收租金（图形化）
            List<ManageState> arrears = manageStateMapper.getDataByColumnByYear(yearNum,"rent_arrears", "资产经营");
            hashMap.put("arrears", arrears);
            String arrears_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(arrears.get(arrears.size() - 1).getPeriodicTime());
            hashMap.put("arrears_lastDate", "截至" + arrears_lastDate);
            //出租率（图形化）
            List<ManageState> rate = manageStateMapper.getDataByColumnByYear(yearNum,"let_rate", "资产经营");
            hashMap.put("rate", rate);
            String rate_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(rate.get(rate.size() - 1).getPeriodicTime());
            hashMap.put("rate_lastDate", "截至" + rate_lastDate);
            //最后一个月的出租率
            String letRate_now = "";
            for (int i = rate.size()-1; i >=0; i--) {
                if(null!=rate.get(i).getLetRate()){
                    BigDecimal letRate = rate.get(i).getLetRate();
                    letRate_now  =   letRate.remainder(BigDecimal.ONE).abs().compareTo(BigDecimal.ONE)>0?letRate.setScale(2,BigDecimal.ROUND_HALF_UP) +"%":letRate.stripTrailingZeros()+"%";
                    break;
                }
            }
            hashMap.put("letRate_now", letRate_now);
            //经营业务（图形化）
            List<Map<String, Object>> list = new ArrayList<>();
            BigDecimal in_total = zero;
            List<ManageState> allName = manageStateMapper.getAllName();
            for (ManageState manageState : allName) {
                List<ManageState> manageStateList = manageStateMapper.getManageStateByManageByYear(yearNum,manageState.getName());
                if(manageStateList.size()>0){
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("manage", manageStateList);
                list.add(map1);
                for (ManageState state : manageStateList) {
                    in_total = in_total.add(state.getRentIncome());
                }
                }
            }
            hashMap.put("in_total", in_total.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP));

            //欠收(当前)
            List<ManageState> current_total = manageStateMapper.getDataByColumnByYear(yearNum,"rent_arrears", "资产经营");
            for (int i = current_total.size() - 1; i >= 0; i--) {
                if (current_total.get(i).getCurrentTotal() != null) {
                    hashMap.put("arrears_now", current_total.get(i).getCurrentTotal().divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP));
                    break;
                }
            }
            hashMap.put("list", list);
            //经营业务收入截至日期
            Map<String, Object> map = list.get(list.size() - 1);
            List<ManageState> manage = (List<ManageState>) map.get("manage");
            String manage_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(manage.get(manage.size() - 1).getPeriodicTime());
            hashMap.put("manage_lastDate", "截至" + manage_lastDate);
            return ResBean.success("success", hashMap);
        }else {
            //租金收入（图形化）
            List<ManageState> income = manageStateMapper.getDataByColumn("rent_income", "资产经营");
            BigDecimal zero = BigDecimal.ZERO;
            BigDecimal rent_total = zero;
            for (ManageState manageState : income) {
                rent_total = rent_total.add(manageState.getRentIncome());
            }
            //租金收入（欠收）当年度总额
            hashMap.put("rent_total", rent_total.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP));
            hashMap.put("income", income);
            String income_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(income.get(income.size() - 1).getPeriodicTime());
            hashMap.put("income_lastDate", "截至" + income_lastDate);
            //欠收租金（图形化）
            List<ManageState> arrears = manageStateMapper.getDataByColumn("rent_arrears", "资产经营");
            hashMap.put("arrears", arrears);
            String arrears_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(arrears.get(arrears.size() - 1).getPeriodicTime());
            hashMap.put("arrears_lastDate", "截至" + arrears_lastDate);
            //出租率（图形化）
            List<ManageState> rate = manageStateMapper.getDataByColumn("let_rate", "资产经营");
            hashMap.put("rate", rate);
            String rate_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(rate.get(rate.size() - 1).getPeriodicTime());
            hashMap.put("rate_lastDate", "截至" + rate_lastDate);
            //当前出租率
            String letRate_now = "";
            for (int i = rate.size()-1; i >=0; i--) {
                if(null!=rate.get(i).getLetRate()){
                    BigDecimal letRate = rate.get(i).getLetRate();
                    letRate_now  =   letRate.remainder(BigDecimal.ONE).abs().compareTo(BigDecimal.ONE)>0?letRate.setScale(2,BigDecimal.ROUND_HALF_UP) +"%":letRate.stripTrailingZeros()+"%";
                    break;
                }
            }
            hashMap.put("letRate_now", letRate_now);
            //经营业务（图形化）
            List<Map<String, Object>> list = new ArrayList<>();
            BigDecimal in_total = zero;
            List<ManageState> allName = manageStateMapper.getAllName();
            for (ManageState manageState : allName) {
                List<ManageState> manageStateList = manageStateMapper.getManageStateByManage(manageState.getName());
                if(manageStateList.size()>0){
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("manage", manageStateList);
                list.add(map1);
                for (ManageState state : manageStateList) {
                    in_total = in_total.add(state.getRentIncome());
                }
            }}
            hashMap.put("in_total", in_total.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP));
            //欠收(当前)
           // List<ManageState> current_total = manageStateMapper.getDataByColumn("current_total", "资产经营");
              List<ManageState> current_total = manageStateMapper.getDataByColumn("rent_arrears", "资产经营");
            for (int i = current_total.size() - 1; i >= 0; i--) {
                if (current_total.get(i).getCurrentTotal() != null) {
                    hashMap.put("arrears_now", current_total.get(i).getCurrentTotal().divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP));
                    break;
                }
            }
            hashMap.put("list", list);
            //经营业务收入截至日期
            Map<String, Object> map = list.get(list.size() - 1);
            List<ManageState> manage = (List<ManageState>) map.get("manage");
            String manage_lastDate = new SimpleDateFormat("yyyy年MM月dd日").format(manage.get(manage.size() - 1).getPeriodicTime());
            hashMap.put("manage_lastDate", "截至" + manage_lastDate);
            return ResBean.success("success", hashMap);
        }

    }

    @Override
    public ResBean getTotalManage(Integer yearNum) {
        //经营业务收入当年度总额
        if(null!=yearNum){
            List<ManageState> list = manageStateMapper.getManageStateByTotalByYearNum(yearNum);
            return ResBean.success("success",list);
        }else {
            List<ManageState> list = manageStateMapper.getManageStateByTotal();
            return ResBean.success("success",list);
        }
    }

    @Override
    public void deductArrears(RentBill bill, BigDecimal money) {
        //扣除当前月份起的总欠费
        Date addTime = bill.getAddTime();
        LocalDate localDate = addTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        //获取当前月份后的所有账单
        List<ManageState> afterList = manageStateMapper.getafter(year, month);
        for (ManageState state : afterList) {
            state.setCurrentTotal(state.getCurrentTotal().subtract(money));
            manageStateMapper.updateByPrimaryKey(state);
        }
    }
}
