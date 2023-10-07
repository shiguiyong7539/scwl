package com.scwl.controller;

import com.scwl.pojo.Contract;
import com.scwl.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ContractController {


    @Resource
    private ContractService contractService;

    /**
     * admin合同一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param costManage
     * @return
     */
    @RequestMapping("/getAllContract")
    public Object getAllContract(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
        return  contractService.getAllContract(pageNum,pageSize);
    }

    /**
     * 添加合同
     * @param request
     * @param costManage
     * @return
     */
    @RequestMapping("/addContract")
    public Object addContract(HttpServletRequest request, Contract contract){
        return  contractService.addContract(contract);
    }

    /**
     * 合同数据图形化展示
     * @param request
     * @param period
     * @param condition
     * @return
     */
    @RequestMapping("/getContractByCenter")
    public Object getContractByCenter(HttpServletRequest request){
        return  contractService.getContractByCenter();
    }

}
