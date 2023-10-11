package com.scwl.mapper;

import com.scwl.pojo.RiskControl;
import com.scwl.pojo.RiskControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskControlMapper {
    int countByExample(RiskControlExample example);

    int deleteByExample(RiskControlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskControl record);

    int insertSelective(RiskControl record);

    List<RiskControl> selectByExample(RiskControlExample example);

    RiskControl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskControl record, @Param("example") RiskControlExample example);

    int updateByExample(@Param("record") RiskControl record, @Param("example") RiskControlExample example);

    int updateByPrimaryKeySelective(RiskControl record);

    int updateByPrimaryKey(RiskControl record);

    List<RiskControl> getTotal();
    int getTotalYear(String name);
}