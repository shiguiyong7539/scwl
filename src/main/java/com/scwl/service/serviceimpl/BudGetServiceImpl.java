package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.BudgetMapper;
import com.scwl.pojo.Budget;
import com.scwl.pojo.BudgetExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.BudGetService;
import com.scwl.service.LogService;
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
public class BudGetServiceImpl implements BudGetService {

    @Autowired
    BudgetMapper budgetMapper;

    @Autowired
    private LogService logService;

    @Override
    public ResBean getAllBudget(int pageNum, int pageSize, Budget budget) {
        PageHelper.startPage(pageNum,pageSize);
        BudgetExample example = new BudgetExample();
        BudgetExample.Criteria criteria = example.createCriteria();
        if(null!=budget.getDepartment()&&budget.getDepartment()!=""){
            criteria.andDepartmentEqualTo(budget.getDepartment());
        }
        List<Budget> budgets = budgetMapper.selectByExample(example);
        PageInfo<Budget> pageInfo = new PageInfo<>(budgets);
        return ResBean.success("查詢成功",pageInfo);
    }

    @Override
    public ResBean addBudget(Budget budget) {
        try{
//            BigDecimal rate = (budget.getRealFunds().subtract(budget.getMonthFunds())).divide(budget.getMonthFunds(), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
//            budget.setDeviationRate(rate);
            budgetMapper.insert(budget);
            logService.addLog("INSERT","budget",budget.getId(),"新增id为"+budget.getId()+"的预算执行情况");
            return  ResBean.success("添加成功");
        }catch (Exception e){
        return  ResBean.error("添加失败");
    }
    }

    @Override
    public ResBean getBudgetByCenter(String condition) {
        HashMap<String, Object> map = new HashMap<>();
        BigDecimal planTotal=new BigDecimal(0);
        BigDecimal realTotal=new BigDecimal(0);
        if(condition.equals("月")){
            //当月月度资金/当月资金实际使用情况
            List<Budget> budgetByMonth = budgetMapper.getBudgetByMonth();
            for (Budget budget : budgetByMonth) {
                budget.setMonthFunds(budget.getMonthFunds().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
                budget.setRealFunds(budget.getRealFunds().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
                planTotal=planTotal.add(budget.getMonthFunds());
                realTotal=realTotal.add(budget.getRealFunds());
            }
            map.put("month",budgetByMonth);


        }else {
         //当年月度资金/当年资金实际使用情况
            List<Budget> budgetByYear = budgetMapper.getBudgetByYear();
            for (Budget budget : budgetByYear) {
                budget.setMonthFunds(budget.getMonthFunds().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
                budget.setRealFunds(budget.getRealFunds().divide(new BigDecimal(10000),2,RoundingMode.HALF_UP));
                planTotal=planTotal.add(budget.getMonthFunds());
                realTotal=realTotal.add(budget.getRealFunds());
            }
            map.put("year",budgetByYear);

        }
        map.put("planTotal",planTotal);
        map.put("realTotal",realTotal);
        //近期12月的偏差率
        List<Map<String,Object>> list = new ArrayList<>();
        List<Budget> departments = budgetMapper.getDepartment();
        for (Budget department : departments) {
            List<Budget> budgets = budgetMapper.getBudgetByDepartment(department.getDepartment());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("budgets",budgets);
            list.add(hashMap);
        }
        //截至日期
        Budget lastDate = budgetMapper.getLastDate();
        map.put("list",list);
        map.put("lastDate", "截至"+new SimpleDateFormat("yyyy年MM月dd日").format(lastDate.getMonthDate()));
        return  ResBean.success("查詢成功",map);
    }
}
