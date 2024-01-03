package com.scwl.mapper;


import com.scwl.pojo.ManageState;
import com.scwl.pojo.ManageStateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManageStateMapper {
    int countByExample(ManageStateExample example);

    int deleteByExample(ManageStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManageState record);

    int insertSelective(ManageState record);

    List<ManageState> selectByExample(ManageStateExample example);

    ManageState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManageState record, @Param("example") ManageStateExample example);

    int updateByExample(@Param("record") ManageState record, @Param("example") ManageStateExample example);

    int updateByPrimaryKeySelective(ManageState record);

    int updateByPrimaryKey(ManageState record);

    List<ManageState>  getAllManageState(@Param("manageState") ManageState manageState);

    List<ManageState> getTaskByMonth(String period, String condition);

    List<ManageState> getTaskByYear(String condition);

    List<ManageState> getManageStateByAsset();
    ManageState getTotalByThisYear(String type);

    List<ManageState> getAllName();
    List<ManageState> getManageStateByManage(String name);
    List<ManageState> getManageStateByTotal();
    List<ManageState> getDataByColumn(@Param("column") String column,@Param("type") String type);
    ManageState getLastMonth(@Param("type") String type);
    ManageState getCurrentMonth(@Param("type") String type);
    ManageState getLastTwoMonth(@Param("type") String type);
    List<ManageState>  getafter(int year,int month);
}