package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.CapitalMapper;
import com.scwl.pojo.*;
import com.scwl.service.CapitalService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CapitalServiceImpl implements CapitalService {

    @Autowired
    private CapitalMapper capitalMapper;

    @Autowired
    private LogService logService;

    @Override
    public ResBean getCapital(int pageNum, int pageSize, Capital capital) {
        PageHelper.startPage(pageNum,pageSize);
        CapitalExample example = new CapitalExample();
        CapitalExample.Criteria criteria = example.createCriteria();
        if(null!=capital.getType()){
            criteria.andTypeEqualTo(capital.getType());
            if(null!=capital.getQuarterly()&&""!=capital.getQuarterly()&&capital.getType()==2){
            criteria.andQuarterlyEqualTo(capital.getQuarterly());
            }
        }

        List<Capital> capitals = capitalMapper.selectByExample(example);
        PageInfo<Capital> pageInfo = new PageInfo<>(capitals);
        return ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addCapital(Capital capital)  {
        try{
//            capital.setFinishRate(capital.getFinishRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
//            capital.setOperatRate(capital.getOperatRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
//            capital.setIncomeRate(capital.getIncomeRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
//            capital.setCashRate(capital.getCashRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
//            capital.setCostRate(capital.getCostRate().divide(new BigDecimal(100),4, RoundingMode.HALF_UP));
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
        HashMap<String, Object> hashMap = new HashMap<>();
        //可用和不可用资金
        List<Capital> income  = capitalMapper.getIncome();
        //比率
        List<Capital> incomeRate  = capitalMapper.getIncomeRate();
        hashMap.put("list",income);
        hashMap.put("incomeRate",incomeRate);
        if(income.size()>0){
            hashMap.put("use_money",income.get(income.size()-1).getUseCapital().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
            hashMap.put("unUse_money",income.get(income.size()-1).getUnUseCapital().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
        }else {
            hashMap.put("use_money","");
            hashMap.put("unUse_money","");
        }
        return ResBean.success("success",hashMap);
    }

    @Override
    public ResBean updateCapital(Capital capital) {
        try{
            Capital oldCapital = capitalMapper.selectByPrimaryKey(capital.getId());
            if(oldCapital.getType()==1){
                if(null!=capital.getUnUseCapital()){
                    oldCapital.setUnUseCapital(capital.getUnUseCapital());
                }
                if(null!=capital.getUseCapital()){
                    oldCapital.setUseCapital(capital.getUseCapital());
                }
            }else {
                if(null!=capital.getFinishRate()){
                    oldCapital.setFinishRate(capital.getFinishRate());
                }
                if(null!=capital.getOperatRate()){
                    oldCapital.setOperatRate(capital.getOperatRate());
                }
                if(null!=capital.getIncomeRate()){
                    oldCapital.setIncomeRate(capital.getIncomeRate());
                }
                if(null!=capital.getCashRate()){
                    oldCapital.setCashRate(capital.getCashRate());
                }
                if(null!=capital.getCostRate()){
                    oldCapital.setCostRate(capital.getCostRate());
                }
            }
            capitalMapper.updateByPrimaryKey(oldCapital);
            logService.addLog("UPDATE","capital",capital.getId(),"修改id为"+capital.getId()+"的资金状况信息");

            return  ResBean.success("修改成功");
        }catch (Exception e){
            return  ResBean.error("修改失败");
        }
    }
}
