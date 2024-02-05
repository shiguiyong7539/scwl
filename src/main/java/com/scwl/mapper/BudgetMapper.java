package com.scwl.mapper;

import com.scwl.pojo.Budget;
import com.scwl.pojo.BudgetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BudgetMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(BudgetExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(BudgetExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(Budget record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(Budget record);

    /**
     * @param example
     * @return 
     */
    List<Budget> selectByExample(BudgetExample example);

    /**
     * @param id
     * @return 
     */
    Budget selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") Budget record, @Param("example") BudgetExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") Budget record, @Param("example") BudgetExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(Budget record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(Budget record);

    List<Budget> getBudgetByMonth(int monthNum);
    List<Budget> getBudgetByYear(Integer yearNum);
    List<Budget> getDepartment();
    List<Budget> getBudgetByDepartment(String department);
    List<Budget> getBudgetByDepartmentByYear(String department,Integer yearNum);
    Budget getLastDate();
    Budget getLastDateByYear(Integer yearNum);
}