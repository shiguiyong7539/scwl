package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.DepartmentMapper;
import com.scwl.mapper.EmployeeMapper;
import com.scwl.pojo.*;
import com.scwl.service.EmployeeService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LogService logService;

    @Autowired
    private DepartmentMapper  departmentMapper;


    @Override
    public ResBean getEmpList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setOrderByClause("id ASC");
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        for (Employee employee : employees) {
            employee.setAge(getAge(new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirthday())));
        }
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
        //总人数
        int total = employeeMapper.getTotal();
        //截止日期
        Employee employee = employeeMapper.getLastDate();
        //按年龄分组
        List<Map> byAgeGroup = employeeMapper.getByAgeGroup();
        for (int i = 0; i < byAgeGroup.size(); i++) {
            Map map = byAgeGroup.get(i);
            BigDecimal age = (BigDecimal) map.get("age_group");
            if(age.compareTo(new BigDecimal(60))>1){
                map.put("age_range","60岁以上");
            }else {
                BigDecimal ageHigh = age.add(new BigDecimal(9));
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
        map.put("total",total);
        String str = new SimpleDateFormat("yyyy年MM月dd日").format(employee.getJoinTime());
        map.put("latDate", "截止"+str);
        return ResBean.success("success",map);
    }

    @Override
    public ResBean uploadMemberFile(List<String[]> data) throws ParseException {
        Employee employee = new Employee();
        for (int i = 1; i < data.size(); i++) {
            String[] strings = data.get(i);
            employee.setId(null);
            employee.setName(strings[0]);
            employee.setDepartment(strings[1]);
            employee.setSex(strings[2]);
            employee.setAge(getAge(strings[3]));
            employee.setEducation(strings[4]);
            employee.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(strings[3]));
            employee.setJoinTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-08-01 00:00:00"));
            employee.setEmploymentMode(strings[6]);
            if(strings[4].equals("中专")){
                employee.setRank("初级");
            }else if(strings[4].equals("大专")){
                employee.setRank("中级");
            }else{
                employee.setRank("高级");
            }
            employeeMapper.insert(employee);

        }
        return ResBean.success("上传成功");
    }

    public int getAge(String ymd){
        String[] age = ymd.split("-");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(age[0]), Integer.parseInt(age[1]), Integer.parseInt(age[2]));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
    public Map<String, Integer> getDepartId(List<Department> list){
        HashMap<String, Integer> map = new HashMap<>();
        for (Department department : list) {
            map.put(department.getName(),department.getId());
        }
        return map;
    }
}
