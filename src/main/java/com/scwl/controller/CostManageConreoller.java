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


    @RequestMapping("/getAllCost")
    public Object getAllCost(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize, CostManage costManage){
        return  costManageService.getAllCost(pageNum,pageSize,costManage);
    }


    @RequestMapping("/addCost")
    public Object addCost(HttpServletRequest request, CostManage costManage){
        return  costManageService.addCost(costManage);
    }

}
