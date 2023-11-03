package com.scwl.mapper;

import com.scwl.pojo.RectifyMatter;
import com.scwl.pojo.RectifyMatterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RectifyMatterMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(RectifyMatterExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(RectifyMatterExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(RectifyMatter record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(RectifyMatter record);

    /**
     * @param example
     * @return 
     */
    List<RectifyMatter> selectByExample(RectifyMatterExample example);

    /**
     * @param id
     * @return 
     */
    RectifyMatter selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") RectifyMatter record, @Param("example") RectifyMatterExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") RectifyMatter record, @Param("example") RectifyMatterExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(RectifyMatter record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(RectifyMatter record);

    List<RectifyMatter> getByTitleId(Integer tid);

    List<RectifyMatter> getByIds(@Param("matterIds") int[] matterIds);
}