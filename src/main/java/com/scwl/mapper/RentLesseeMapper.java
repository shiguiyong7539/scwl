package com.scwl.mapper;

import com.scwl.pojo.RentLessee;
import com.scwl.pojo.RentLesseeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentLesseeMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(RentLesseeExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(RentLesseeExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(RentLessee record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(RentLessee record);

    /**
     * @param example
     * @return 
     */
    List<RentLessee> selectByExample(RentLesseeExample example);

    /**
     * @param id
     * @return 
     */
    RentLessee selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") RentLessee record, @Param("example") RentLesseeExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") RentLessee record, @Param("example") RentLesseeExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(RentLessee record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(RentLessee record);


    RentLessee getByNameAndPhone(String lesseName,String phone);
}