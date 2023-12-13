package com.scwl.controller;

import com.scwl.pojo.Budget;
import com.scwl.pojo.ResBean;
import com.scwl.service.BudGetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

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
        try {
            return  budGetService.getAllBudget(pageNum,pageSize,budget);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResBean.error("获取失败");
        }
    }

    /**
     * 添加
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/addBudget")
    public Object addBudget(HttpServletRequest request, Budget budget){
        return  budGetService.addBudget(budget);
    }

    /**
     * 更新
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/updateBudget")
    public Object updateBudget(HttpServletRequest request, Budget budget){
        return  budGetService.updateBudget(budget);
    }

    /**
     * 删除
     * @param request
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBudget")
    public Object deleteBudget(HttpServletRequest request, String ids) {
        return  budGetService.deleteBudget(ids);
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
