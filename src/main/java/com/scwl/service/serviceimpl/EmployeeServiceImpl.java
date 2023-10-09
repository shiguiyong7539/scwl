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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ResBean getByCenter() {
        //按年龄分组
        List<Map> byAgeGroup = employeeMapper.getByAgeGroup();
        for (int i = 0; i < byAgeGroup.size(); i++) {
            Map map = byAgeGroup.get(i);
            Long age = (Long) map.get("age_group");
            if(age>=60){
                Long ageHigh = age+9;
                map.put("age_range","60岁以上");
            }else {
                Long ageHigh = age+9;
                map.put("age_range",age+"-"+ageHigh+"岁");
            }

        }
        //按学历分组
        List<Map> byEduGroup = employeeMapper.getByEduGroup();
        //按职称分组
        List<Map> byRankGroup = employeeMapper.getByRankGroup();
        //按用工方式分组
        List<Map> byModeGroup = employeeMapper.getByModeGroup();
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",byAgeGroup);
        map.put("edu",byEduGroup);
        map.put("rank",byRankGroup);
        map.put("mode",byModeGroup);
        return ResBean.success("success",map);
    }
}
