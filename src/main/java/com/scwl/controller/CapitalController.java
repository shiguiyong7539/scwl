package com.scwl.controller;

import com.scwl.pojo.Capital;
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
    public Object addCapital(HttpServletRequest request, Capital capital){
        return capitalService.addCapital(capital);
    }

    /**
     * 资金数据展览中心
     * @param request
     * @param period
     * @param condition
     * @return
     */
    @RequestMapping("/getCapitalByCenter")
    public Object getCapitalByCenter(HttpServletRequest request, String period,String condition){
        return  capitalService.getCapitalByCenter(period,condition);
    }

    /**
     * 资金数据展览中心
     * @param request
     * @param period
     * @param condition
     * @return
     */
    @RequestMapping("/getCapitalByCenterShow")
    public Object getCapitalByCenterShow(HttpServletRequest request){
        return  capitalService.getCapitalByCenterShow();
    }

}