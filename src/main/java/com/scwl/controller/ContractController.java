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
     * @param
     * @return
     */
    @RequestMapping("/getAllContract")
    public Object getAllContract(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize,Contract contract){
        return  contractService.getAllContract(pageNum,pageSize,contract);
    }

    /**
     * 添加合同
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/addContract")
    public Object addContract(HttpServletRequest request, Contract contract){
        return  contractService.addContract(contract);
    }
    /**
     * 添加合同
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/updateContract")
    public Object updateContract(HttpServletRequest request, Contract contract){
        return  contractService.updateContract(contract);
    }

    /**
     * 删除
     * @param request
     * @param contract
     * @return
     */
    @RequestMapping("/deleteContract")
    public Object deleteContract(HttpServletRequest request, String ids){
        return  contractService.deleteContract(ids);
    }

    /**
     * 合同数据图形化展示
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getContractByCenter")
    public Object getContractByCenter(HttpServletRequest request,Integer yearNum){
        return  contractService.getContractByCenter(yearNum);
    }

}
