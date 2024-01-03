package com.scwl.mapper;

import com.scwl.pojo.RentLeaseInfo;
import com.scwl.pojo.RentLeaseInfoExample;
import com.scwl.vo.RentLeaseInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentLeaseInfoMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(RentLeaseInfoExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(RentLeaseInfoExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(RentLeaseInfo record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(RentLeaseInfo record);

    /**
     * @param example
     * @return 
     */
    List<RentLeaseInfo> selectByExample(RentLeaseInfoExample example);

    /**
     * @param id
     * @return 
     */
    RentLeaseInfo selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") RentLeaseInfo record, @Param("example") RentLeaseInfoExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") RentLeaseInfo record, @Param("example") RentLeaseInfoExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(RentLeaseInfo record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(RentLeaseInfo record);


    List<RentLeaseInfoVo> getLeaseInfoList(RentLeaseInfoVo rentLeaseInfoVo);

    List<RentLeaseInfo> getCurrentInfo();

    List<RentLeaseInfo> getExpire();

    RentLeaseInfo getLastTotalAcreage();
    RentLeaseInfo getTotalAcreage();
}