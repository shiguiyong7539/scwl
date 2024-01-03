package com.scwl.mapper;

import com.scwl.pojo.RentAsset;
import com.scwl.pojo.RentAssetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentAssetMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(RentAssetExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(RentAssetExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(RentAsset record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(RentAsset record);

    /**
     * @param example
     * @return 
     */
    List<RentAsset> selectByExample(RentAssetExample example);

    /**
     * @param id
     * @return 
     */
    RentAsset selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") RentAsset record, @Param("example") RentAssetExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") RentAsset record, @Param("example") RentAssetExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(RentAsset record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(RentAsset record);

    RentAsset getByName(String name);

    RentAsset getCurrentAcreageRate();

}