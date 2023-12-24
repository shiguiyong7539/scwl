package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.ManageStateMapper;
import com.scwl.pojo.ManageState;
import com.scwl.pojo.ManageStateExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.LogService;
import com.scwl.service.ManageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            ManageState currentMonth = manageStateMapper.getCurrentMonth(manageState.getType());
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
    public ResBean getManageStateByCenter() {
        HashMap<String, Object> hashMap = new HashMap<>();
        //租金收入（欠收）当年度总额
        ManageState totalByThisYear = manageStateMapper.getTotalByThisYear("资产经营");
        //租金总收入
        hashMap.put("rent_total",totalByThisYear.getRentIncome().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
        //经营业务收入当年度总额
        ManageState totalByThisYear1 = manageStateMapper.getTotalByThisYear("经营业务收入");
        hashMap.put("in_total",totalByThisYear1.getRentIncome().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));

        //租金收入（图形化）
        List<ManageState> income = manageStateMapper.getDataByColumn("rent_income", "资产经营");
        hashMap.put("income",income);
        String  income_lastDate= new SimpleDateFormat("yyyy年MM月dd日").format(income.get(income.size() - 1).getPeriodicTime());
        hashMap.put("income_lastDate","截至"+income_lastDate);
        //欠收租金（图形化）
        List<ManageState> arrears = manageStateMapper.getDataByColumn("rent_arrears", "资产经营");
        hashMap.put("arrears",arrears);
        String  arrears_lastDate= new SimpleDateFormat("yyyy年MM月dd日").format(arrears.get(arrears.size() - 1).getPeriodicTime());
        hashMap.put("arrears_lastDate","截至"+arrears_lastDate);
        //出租率（图形化）
        List<ManageState> rate = manageStateMapper.getDataByColumn("let_rate", "资产经营");
        hashMap.put("rate",rate);
        String  rate_lastDate= new SimpleDateFormat("yyyy年MM月dd日").format(rate.get(rate.size() - 1).getPeriodicTime());
        hashMap.put("rate_lastDate","截至"+rate_lastDate);
        //经营业务（图形化）
        List<Map<String,Object>> list = new ArrayList<>();
        List<ManageState> allName = manageStateMapper.getAllName();
            for (ManageState manageState : allName) {
                List<ManageState> manageStateList = manageStateMapper.getManageStateByManage(manageState.getName());
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("manage",manageStateList);
                list.add(map1);
            }
        //欠收(当前)
        for (int i = 0; i < arrears.size(); i++) {
            if(null!=arrears.get(arrears.size()-(i+1)).getRentArrears()){
                hashMap.put("arrears_now",arrears.get(arrears.size()-(i+1)).getRentArrears().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
                break;
            }
        }

         hashMap.put("list",list);
        //经营业务收入截至日期
        Map<String, Object> map = list.get(list.size() - 1);
        List<ManageState> manage = (List<ManageState>) map.get("manage");
        String  manage_lastDate= new SimpleDateFormat("yyyy年MM月dd日").format(manage.get(manage.size()-1).getPeriodicTime());
        hashMap.put("manage_lastDate","截至"+manage_lastDate);
        return ResBean.success("success",hashMap);




    }

    @Override
    public ResBean getTotalManage() {
        //经营业务收入当年度总额
        List<ManageState> list = manageStateMapper.getManageStateByTotal();
        return ResBean.success("success",list);
    }
}
