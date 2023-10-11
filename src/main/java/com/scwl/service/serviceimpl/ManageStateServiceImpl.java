package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        PageHelper.startPage(pageNum,pageSize);
        List<ManageState> manageList = manageStateMapper.getAllManageState(manageState);
        PageInfo<ManageState> pageInfo = new PageInfo<>(manageList);
        return ResBean.success("查詢成功",pageInfo);
    }

    @Override
    public ResBean addState(ManageState manageState) {
        try{
            manageStateMapper.insert(manageState);
            logService.addLog("INSERT","manage_state",manageState.getId(),"新增id为"+manageState.getId()+"的经营状况信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean getManageStateByCenter() {
        HashMap<String, Object> hashMap = new HashMap<>();
        //租金收入（欠收）当年度总额
        ManageState totalByThisYear = manageStateMapper.getTotalByThisYear("资产经营");
        //收入
        hashMap.put("rent_total",totalByThisYear.getRentIncome().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
        //欠收
        hashMap.put("arrears_total",totalByThisYear.getRentArrears().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
        //经营业务收入当年度总额
        ManageState totalByThisYear1 = manageStateMapper.getTotalByThisYear("经营业务收入");
        hashMap.put("in_total",totalByThisYear.getRentIncome().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
        List<Map<String,Object>> list = new ArrayList<>();
            List<ManageState>    manageStates = manageStateMapper.getManageStateByAsset();
            HashMap<String, Object> map = new HashMap<>();
            map.put("manage",manageStates);
            list.add(map);

            List<ManageState> allName = manageStateMapper.getAllName();
            for (ManageState manageState : allName) {
                List<ManageState> manageStateList = manageStateMapper.getManageStateByManage(manageState.getName());
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("manage",manageStateList);
                list.add(map1);
        }
         hashMap.put("list",list);
        return ResBean.success("success",hashMap);




    }
}
