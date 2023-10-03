package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.ManageStateMapper;
import com.scwl.pojo.ManageState;
import com.scwl.pojo.ResBean;
import com.scwl.service.ManageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ManageStateServiceImpl implements ManageStateService {
    @Autowired
    private ManageStateMapper manageStateMapper;
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
            if(null!=manageState.getLetRate()){
                manageState.setLetRate(manageState.getLetRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
            }
            manageStateMapper.insert(manageState);
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }
}
