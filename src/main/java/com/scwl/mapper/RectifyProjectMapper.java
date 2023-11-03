package com.scwl.mapper;

import com.scwl.pojo.RectifyProject;
import com.scwl.pojo.RectifyProjectExample;
import com.scwl.vo.RectifyProjectVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RectifyProjectMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(RectifyProjectExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(RectifyProjectExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(RectifyProject record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(RectifyProject record);

    /**
     * @param example
     * @return 
     */
    List<RectifyProject> selectByExample(RectifyProjectExample example);

    /**
     * @param id
     * @return 
     */
    RectifyProject selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") RectifyProject record, @Param("example") RectifyProjectExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") RectifyProject record, @Param("example") RectifyProjectExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(RectifyProject record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(RectifyProject record);

}