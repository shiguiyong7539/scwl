package com.scwl.service;

import com.scwl.pojo.Employee;
import com.scwl.pojo.ResBean;

import java.util.List;

public interface EmployeeService {

    ResBean getEmpList(Integer pageNum, Integer pageSize);
}
