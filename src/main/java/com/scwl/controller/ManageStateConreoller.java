package com.scwl.controller;


import com.scwl.pojo.ManageState;
import com.scwl.service.ManageStateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ManageStateConreoller {
    @Resource
    private ManageStateService manageStateService;

    @RequestMapping("/getAllManageState")
    public Object getAllManageState(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize, ManageState manageState){
        return  manageStateService.getAllManageState(pageNum,pageSize,manageState);
    }

    @RequestMapping("/addState")
    public Object addState(HttpServletRequest request, ManageState manageState){
        return  manageStateService.addState(manageState);
    }
}
