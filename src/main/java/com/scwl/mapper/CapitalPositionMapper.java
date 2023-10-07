package com.scwl.mapper;

import com.scwl.pojo.CapitalPosition;
import com.scwl.pojo.CapitalPositionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapitalPositionMapper {
    int countByExample(CapitalPositionExample example);

    int deleteByExample(CapitalPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CapitalPosition record);

    int insertSelective(CapitalPosition record);

    List<CapitalPosition> selectByExample(CapitalPositionExample example);

    CapitalPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CapitalPosition record, @Param("example") CapitalPositionExample example);

    int updateByExample(@Param("record") CapitalPosition record, @Param("example") CapitalPositionExample example);

    int updateByPrimaryKeySelective(CapitalPosition record);

    int updateByPrimaryKey(CapitalPosition record);

    List<CapitalPosition> getCapitalByMonth(String period, String condition);

    List<CapitalPosition> getCapitalByYear(String condition);

    List<CapitalPosition> getIncome();

    List<CapitalPosition> getExpend();

}