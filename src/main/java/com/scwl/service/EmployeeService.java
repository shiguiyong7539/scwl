package com.scwl.service;

import com.scwl.pojo.Employee;
import com.scwl.pojo.ResBean;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface EmployeeService {

    ResBean getEmpList(Integer pageNum, Integer pageSize);
    ResBean addEmployee(Employee employee);
    ResBean getByCenter();
    ResBean uploadMemberFile( List<String[]> data) throws ParseException;
}
