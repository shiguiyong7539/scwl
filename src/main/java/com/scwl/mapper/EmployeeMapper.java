package com.scwl.mapper;

import com.scwl.pojo.Employee;
import com.scwl.pojo.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int getTotal();

    List<Map> getByAgeGroup();

    List<Map> getByEduGroup();
    //按职称分组
    List<Map> getByRankGroup();
    //按用工方式分组
    List<Map>  getByModeGroup();

    Employee getLastDate();
}