package com.scwl.controller;

import com.scwl.pojo.CostManage;
import com.scwl.service.CostManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CostManageConreoller {
    @Resource
    private CostManageService costManageService;


    /**
     * admin成本一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param costManage
     * @return
     */
    @RequestMapping("/getAllCost")
    public Object getAllCost(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize, CostManage costManage){
        return  costManageService.getAllCost(pageNum,pageSize,costManage);
    }

    /**
     * 添加成本
     * @param request
     * @param costManage
     * @return
     */
    @RequestMapping("/addCost")
    public Object addCost(HttpServletRequest request, CostManage costManage){
        return  costManageService.addCost(costManage);
    }

    /**
     * 成本数据图形化展示
     * @param request
     * @param period
     * @param condition
     * @return
     */
    @RequestMapping("/getCostManageByCenter")
    public Object getCostManageByCenter(HttpServletRequest request, String period,String condition){
        return  costManageService.getCostManageByCenter(period,condition);
    }

}
