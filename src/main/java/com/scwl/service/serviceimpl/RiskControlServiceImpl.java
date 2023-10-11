package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.RiskControlMapper;
import com.scwl.pojo.ResBean;
import com.scwl.pojo.RiskControl;
import com.scwl.pojo.RiskControlExample;
import com.scwl.service.LogService;
import com.scwl.service.RiskControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskControlServiceImpl implements RiskControlService {

    @Autowired
    private RiskControlMapper riskControlMapper;

    @Autowired
    private LogService logService;
    @Override
    public ResBean getAllRisk(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RiskControlExample example = new RiskControlExample();
        example.setOrderByClause("add_time desc");
        List<RiskControl> contracts = riskControlMapper.selectByExample(example);
        PageInfo<RiskControl> pageInfo = new PageInfo<>(contracts);
        return ResBean.success("success",pageInfo);
    }

    @Override
    public ResBean addRisk(RiskControl riskControl) {
        try{
            riskControlMapper.insert(riskControl);
            logService.addLog("INSERT","risk_control",riskControl.getId(),"新增id为"+riskControl.getId()+"的成本管理信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean getRiskByCenter() {
        //总件数
        List<RiskControl> list = riskControlMapper.getTotal();
        for (RiskControl riskControl : list) {
            //当年度总数
            int totalYear = riskControlMapper.getTotalYear(riskControl.getName());
            riskControl.setYearNum(totalYear);
        }
        return  ResBean.success("success",list);
    }
}
