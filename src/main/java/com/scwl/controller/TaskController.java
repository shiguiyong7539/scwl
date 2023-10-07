package com.scwl.controller;

import com.scwl.pojo.Task;
import com.scwl.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TaskController {
    @Resource
    private TaskService taskService;


    /**
     * 获取任务
     * @return
     */
    @RequestMapping("/getTask")
    @ResponseBody
    public Object getTask(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize, Task task){
        return taskService.getTask(pageNum,pageSize,task);
    }

    /**
     * 获取任务
     * @return
     */
    @RequestMapping("/addTask")
    @ResponseBody
    public Object addTask(HttpServletRequest request, Task task){
        return taskService.addTask(task);
    }


    /**
     * 获取任务到展示平台
     * @return
     */
    @RequestMapping("/getTaskByCenter")
    @ResponseBody
    public Object getTaskByCenter(HttpServletRequest request,String period,String condition){
        return taskService.getTaskByCenter(period,condition);
    }

    /**
     * 获取任务到展示平台
     * @return
     */
    @RequestMapping("/getTaskByCenterShow")
    @ResponseBody
    public Object getTaskByCenterShow(HttpServletRequest request){
        return taskService.getTaskByCenterShow();
    }


}
