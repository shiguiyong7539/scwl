package com.scwl.mapper;

import com.scwl.pojo.Capital;
import com.scwl.pojo.CapitalExample;
import com.scwl.pojo.Capital;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapitalMapper {
    int countByExample(CapitalExample example);

    int deleteByExample(CapitalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Capital record);

    int insertSelective(Capital record);

    List<Capital> selectByExample(CapitalExample example);

    Capital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Capital record, @Param("example") CapitalExample example);

    int updateByExample(@Param("record") Capital record, @Param("example") CapitalExample example);

    int updateByPrimaryKeySelective(Capital record);

    int updateByPrimaryKey(Capital record);

    List<Capital> getCapitalByMonth(String period, String condition);

    List<Capital> getCapitalByYear(String condition);

    List<Capital> getIncome();
    List<Capital> getIncomeRate();
    Capital getLastDate(Integer type);

    List<Capital> getIncomeByYear(Integer yearNum);
    List<Capital> getIncomeRateByYear(Integer yearNum);
    Capital getLastDateByYear(Integer type,Integer yearNum);


}