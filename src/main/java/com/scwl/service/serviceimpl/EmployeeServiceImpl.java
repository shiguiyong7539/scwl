package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.EmployeeMapper;
import com.scwl.pojo.Employee;
import com.scwl.pojo.EmployeeExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.EmployeeService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LogService logService;

    @Override
    public ResBean getEmpList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setOrderByClause("id ASC");
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        return  ResBean.success("",pageInfo);
    }

    @Override
    public ResBean addEmployee(Employee employee) {
        try{
            employeeMapper.insert(employee);
            logService.addLog("INSERT","employee",employee.getId(),"新增id为"+employee.getId()+"的员工信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
                return  ResBean.error("添加失败");
        }

    }
}
