package com.scwl.mapper;

import com.scwl.pojo.SysLog;
import com.scwl.pojo.SysLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLogMapper {
    int countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}