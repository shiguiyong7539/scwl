package com.scwl.service;


import com.scwl.pojo.ResBean;
import com.scwl.pojo.Task;

import javax.servlet.http.HttpServletRequest;

public interface TaskService {

    ResBean getTask(int pageNum, int pageSize, Task task);

    ResBean addTask(Task task);

    ResBean getTaskByCenter(String period, String condition);

    ResBean getTaskByCenterShow();




}
