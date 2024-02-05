package com.scwl.controller;

import com.scwl.pojo.*;
import com.scwl.service.RiskControlService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RiskControlController {

    @Resource
    private RiskControlService riskControlService;

    /**
     * admin涉诉一览
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
     * 添加涉诉
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/addRisk")
    public Object addRisk(HttpServletRequest request, RiskControl riskControl){
        return  riskControlService.addRisk(riskControl);
    }


    /**
     * admin整改一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param
     * @return
     */
    @RequestMapping("/getAllRectify")
    public Object getAllRectify(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, SupervisionRectify supervisionRectify){
        return  riskControlService.getAllRectify(pageNum,pageSize,supervisionRectify);
    }

    /**
     * 添加整改
     * @param request
     * @param
     * @return
     * JSON.stringify({
     *obj : obj,
     *strList : strList
     *}), var obj = {
     *     key1: "value1",
     *     key2: "value2"
     * };
     *
     * var strList = ["str1", "str2", "str3"];
     */
    @RequestMapping("/addRectify")
    public Object addRectify(HttpServletRequest request,SupervisionRectify supervisionRectify){
        return  riskControlService.addRectify(supervisionRectify);
    }


    /**
     * 修改整改
     * @param request
     * @param
     * @return
     */
    @RequestMapping("/updateRectify")
    public Object updateRectify(HttpServletRequest request,SupervisionRectify supervisionRectify){
        return  riskControlService.updateRectify(supervisionRectify);
    }


    /**
     * 查看整改详情
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getRectifyDetail")
    public Object getRectifyDetail(HttpServletRequest request,String id){
        return  riskControlService.getRectifyDetail(id);
    }


    /**
     * 监督项目
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getProjectList")
    public Object getProjectList(HttpServletRequest request){
        return  riskControlService.getProjectList();
    }



    /**
     * 监督项目和事项
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getProjectListAndMatters")
    public Object getProjectListAndMatters(HttpServletRequest request){
        return  riskControlService.getProjectListAndMatters();
    }

    /**
     * 监督事项
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getMatterList")
    public Object getMatterList(HttpServletRequest request,String id){
        return  riskControlService.getMatterList(id);
    }

    /**
     * 添加监督项目
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/addProject")
    public Object addProject(HttpServletRequest request, RectifyProject project){
        return  riskControlService.addProject(project);
    }
    /**
     * 添加监督事项
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/addMatter")
    public Object addMatter(HttpServletRequest request, RectifyMatter matter){
        return  riskControlService.addMatter(matter);
    }



    /**
     * 涉诉 +整改图形化展示
     * @param request
     * @param
     * @param
     * @return
     */
    @RequestMapping("/getRiskByCenter")
    public Object getRiskByCenter(HttpServletRequest request,Integer yearNum){
        return  riskControlService.getRiskByCenter(yearNum);
    }
}
