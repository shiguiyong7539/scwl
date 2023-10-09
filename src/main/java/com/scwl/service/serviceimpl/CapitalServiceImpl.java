package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.CapitalMapper;
import com.scwl.mapper.CapitalPositionMapper;
import com.scwl.pojo.*;
import com.scwl.service.CapitalService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

@Service
public class CapitalServiceImpl implements CapitalService {

    @Autowired
    private CapitalMapper capitalMapper;

    @Autowired
    private LogService logService;

    @Override
    public ResBean getCapital(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Capital> capitals = capitalMapper.selectByExample(new CapitalExample());
        PageInfo<Capital> pageInfo = new PageInfo<>(capitals);
        return ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addCapital(Capital capital)  {
        try{
            capital.setFinishRate(capital.getFinishRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
            capital.setOperatRate(capital.getOperatRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
            capital.setIncomeRate(capital.getIncomeRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
            capital.setCashRate(capital.getCashRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
            capital.setCostRate(capital.getCostRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
            capitalMapper.insert(capital);
            logService.addLog("INSERT","capital",capital.getId(),"新增id为"+capital.getId()+"的资金状况信息");

            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }

    }

    @Override
    public ResBean getCapitalByCenter(String period, String condition) {
        if(period.equals("年")){
            List<Capital> capitals = capitalMapper.getCapitalByYear(condition);
            return ResBean.success("success",capitals);
        }else {
            period ="%Y-%m";
            List<Capital> capitals =   capitalMapper.getCapitalByMonth(period,condition.substring(0,7));
            return ResBean.success("success",capitals);
        }
    }

    @Override
    public ResBean getCapitalByCenterShow() {
        List<Capital> income = capitalMapper.getIncome();
        return ResBean.success("success",income);
    }
}
