package com.scwl.controller;

import com.scwl.pojo.CapitalPosition;
import com.scwl.pojo.Employee;
import com.scwl.pojo.User;
import com.scwl.service.CapitalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class CapitalController {


    @Resource
    CapitalService capitalService;


    /**
     * 获取资金状况
     * @return
     */
    @RequestMapping("/getCapital")
    @ResponseBody
    public Object getCapital(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
        return capitalService.getCapital(pageNum,pageSize);
    }


    /**
     * 人事添加员工信息
     * @return
     */
    @RequestMapping("/addCapital")
    @ResponseBody
    public Object addCapital(HttpServletRequest request, CapitalPosition capital){
        return capitalService.addCapital(capital);
    }

}