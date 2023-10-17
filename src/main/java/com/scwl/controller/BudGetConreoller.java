package com.scwl.controller;

import com.scwl.pojo.Budget;
import com.scwl.service.BudGetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BudGetConreoller {
    @Resource
    private BudGetService budGetService;


    /**
     * admin成本一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param costManage
     * @return
     */
    @RequestMapping("/getAllBudget")
    public Object getAllBudget(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Budget budget){
        return  budGetService.getAllBudget(pageNum,pageSize,budget);
    }

    /**
     * 添加成本
     * @param request
     * @param costManage
     * @return
     */
    @RequestMapping("/addBudget")
    public Object addBudget(HttpServletRequest request, Budget budget){
        return  budGetService.addBudget(budget);
    }

    /**
     * 成本数据图形化展示
     * @param request
     * @param period
     * @param condition
     * @return
     */
    @RequestMapping("/getBudgetByCenter")
    public Object getBudgetByCenter(HttpServletRequest request,String condition){
        return  budGetService.getBudgetByCenter(condition);
    }

}
