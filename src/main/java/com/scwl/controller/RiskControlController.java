package com.scwl.controller;

import com.scwl.pojo.Contract;
import com.scwl.pojo.RiskControl;
import com.scwl.service.RiskControlService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RiskControlController {

    @Resource
    private RiskControlService riskControlService;

    /**
     * admin风控一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param
     * @return
     */
    @RequestMapping("/getAllRisk")
    public Object getAllRisk(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        return  riskControlService.getAllRisk(pageNum,pageSize);
    }

    /**
     * 添加风控
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/addRisk")
    public Object addRisk(HttpServletRequest request, RiskControl riskControl){
        return  riskControlService.addRisk(riskControl);
    }


    /**
     * 风控图形化展示
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getRiskByCenter")
    public Object getRiskByCenter(HttpServletRequest request){
        return  riskControlService.getRiskByCenter();
    }
}
