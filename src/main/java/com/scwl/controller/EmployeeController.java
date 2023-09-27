package com.scwl.controller;

import com.scwl.pojo.User;
import com.scwl.service.EmployeeService;
import com.scwl.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class EmployeeController {


    @Resource
    EmployeeService employeeService;

    /**
     * 已登录
     * @return
     */
    @RequestMapping("/getEmployeeList")
    @ResponseBody
    public Object getEmployeeList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
        return employeeService.getEmpList(pageNum,pageSize);
    }

}