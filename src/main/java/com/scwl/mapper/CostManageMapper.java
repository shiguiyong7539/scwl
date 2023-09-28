package com.scwl.mapper;

import com.scwl.pojo.CostManage;
import com.scwl.pojo.CostManageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostManageMapper {
    int countByExample(CostManageExample example);

    int deleteByExample(CostManageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CostManage record);

    int insertSelective(CostManage record);

    List<CostManage> selectByExample(CostManageExample example);

    CostManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CostManage record, @Param("example") CostManageExample example);

    int updateByExample(@Param("record") CostManage record, @Param("example") CostManageExample example);

    int updateByPrimaryKeySelective(CostManage record);

    int updateByPrimaryKey(CostManage record);

    List<CostManage> getAllCost(@Param("costManage") CostManage costManage);
}