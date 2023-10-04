package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.SysLogMapper;
import com.scwl.mapper.TaskMapper;
import com.scwl.pojo.ResBean;
import com.scwl.pojo.Task;
import com.scwl.pojo.TaskExample;
import com.scwl.service.LogService;
import com.scwl.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private LogService logService;


    @Override
    public ResBean getTask(int pageNum, int pageSize, Task task) {
        PageHelper.startPage(pageNum,pageSize);
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andProjectEqualTo(task.getProject());
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageInfo<Task> pageInfo = new PageInfo<>(tasks);
        return ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addTask(Task task) {
        try{
            taskMapper.insert(task);
            logService.addLog("INSERT","task",task.getId(),"新增"+task.getProject()+"id为"+task.getId()+"的任务信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean getTaskByCenter(String period, String condition) {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        if(period.equals("年")){
            List<Task> tasks = taskMapper.getTaskByYear(condition);
            return ResBean.success("success",tasks);
        }else {
            period ="%Y%m";
            List<Task> tasks =   taskMapper.getTaskByMonth(period,condition.replace("-","").substring(0,6));
            return ResBean.success("success",tasks);
        }


    }
}
