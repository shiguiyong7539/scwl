package com.scwl.mapper;

import com.scwl.pojo.SupervisionRectify;
import com.scwl.pojo.SupervisionRectifyExample;
import com.scwl.vo.SupervisionRectifyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupervisionRectifyMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(SupervisionRectifyExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(SupervisionRectifyExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(SupervisionRectify record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(SupervisionRectify record);

    /**
     * @param example
     * @return 
     */
    List<SupervisionRectify> selectByExample(SupervisionRectifyExample example);

    /**
     * @param id
     * @return 
     */
    SupervisionRectify selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") SupervisionRectify record, @Param("example") SupervisionRectifyExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") SupervisionRectify record, @Param("example") SupervisionRectifyExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(SupervisionRectify record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(SupervisionRectify record);


    int getTotal();
    int getTotalYear();

}