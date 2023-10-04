package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.CostManageMapper;
import com.scwl.pojo.CostManage;
import com.scwl.pojo.ResBean;
import com.scwl.service.CostManageService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostManageServiceImpl implements CostManageService {
    @Autowired
    private CostManageMapper costManageMapper;
    @Autowired
    private LogService logService;
    @Override
    public ResBean getAllCost(Integer pageNum, Integer pageSize, CostManage costManage) {
        PageHelper.startPage(pageNum,pageSize);
        List<CostManage> costList = costManageMapper.getAllCost(costManage);
        PageInfo<CostManage> pageInfo = new PageInfo<>(costList);
        return ResBean.success("查詢成功",pageInfo);
    }

    @Override
    public ResBean addCost(CostManage costManage) {
        try{
            costManageMapper.insert(costManage);
            logService.addLog("INSERT","cost_manage",costManage.getId(),"新增id为"+costManage.getId()+"的成本管理信息");

            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }
}
