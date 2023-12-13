package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.CapitalMapper;
import com.scwl.pojo.*;
import com.scwl.service.CapitalService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(null!=capital.getQuarterly()&&""!=capital.getQuarterly()){
                String quarterly = capital.getQuarterly();
                String substring = quarterly.substring(0, 7);
                criteria.andQuarterlyLike("%"+substring+"%");
            }
        }

        List<Capital> capitals = capitalMapper.selectByExample(example);
        PageInfo<Capital> pageInfo = new PageInfo<>(capitals);
        return ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addCapital(Capital capital)  {
        try{
            String  res = "【资金比率】";
            if(capital.getType()==1){
                res = "【资金】";
                capital.setQuarterly(new SimpleDateFormat("yyyy-MM-dd").format(capital.getAddDate()));
            }
            CapitalExample example = new CapitalExample();
            example.createCriteria().andTypeEqualTo(capital.getType()).andQuarterlyEqualTo(capital.getQuarterly());
            List<Capital> capitals = capitalMapper.selectByExample(example);
            if(capitals.size()>0){
                return  ResBean.error("添加失败，当前月份的"+res+"数据已经存在,不能再添加，只能修改");
            }
            capital.setAddDate(new Date());
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
        //截至日期
        Capital incom_lastDate = capitalMapper.getLastDate(1);
        Capital rate_lastDate = capitalMapper.getLastDate(2);

        hashMap.put("incom_lastDate",getDate(incom_lastDate.getQuarterly()));
        hashMap.put("rate_lastDate",getDate(rate_lastDate.getQuarterly()));
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

    @Override
    public ResBean deleteCapital(String ids) {
        Integer[] idList = new Gson().fromJson(ids, Integer[].class);
        for (Integer id : idList) {
            capitalMapper.deleteByPrimaryKey(id);
            logService.addLog("DELETE","capital",id,"删除id为"+id+"的资金状况信息");
        }
        return  ResBean.success("删除成功");
    }

    private String getDate(String str){
        String[] split = str.split("-");
        String res="";
        for (int i = 0; i < 3; i++) {
            if(i==0){
                res=split[0];
            }
            if(i==1){
              res += "年"+split[1];
            }
            if(i==2){
                res += "月"+split[2]+"日";
            }

        }
        return  "截至"+res;

    }
}
