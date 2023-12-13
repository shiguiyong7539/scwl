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

    /**
     * admin资金管理一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param manageState
     * @return
     */
    @RequestMapping("/getAllManageState")
    public Object getAllManageState(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, ManageState manageState){
        return  manageStateService.getAllManageState(pageNum,pageSize,manageState);
    }

    /**
     * 添加资金管理
     * @param request
     * @param manageState
     * @return
     */
    @RequestMapping("/addState")
    public Object addState(HttpServletRequest request, ManageState manageState){
        return  manageStateService.addState(manageState);
    }

    /**
     * 更新资金管理
     * @param request
     * @param manageState
     * @return
     */
    @RequestMapping("/updateState")
    public Object updateState(HttpServletRequest request, ManageState manageState){
        return  manageStateService.updateState(manageState);
    }

    /**
     * 删除
     * @param request
     * @param manageState
     * @return
     */
    @RequestMapping("/deleteState")
    public Object deleteState(HttpServletRequest request, String ids){
        return  manageStateService.deleteState(ids);
    }
    /**
     * 经营数据展览中心
     * @param request
     * @param period
     * @param condition
     * @return
     */
    @RequestMapping("/getManageStateByCenter")
    public Object getManageStateByCenter(HttpServletRequest request){
        return  manageStateService.getManageStateByCenter();
    }


    /**
     * 经营业务总收入趋势
     * @param request
     * @return
     */
    @RequestMapping("/getTotalManage")
    public Object getTotalManage(HttpServletRequest request){
        return  manageStateService.getTotalManage();
    }
}
