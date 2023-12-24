package com.scwl.mapper;

import com.scwl.pojo.RentBill;
import com.scwl.pojo.RentBillExample;
import com.scwl.vo.RentBillVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentBillMapper {
    /**
     * @param example
     * @return 
     */
    int countByExample(RentBillExample example);

    /**
     * @param example
     * @return 
     */
    int deleteByExample(RentBillExample example);

    /**
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return 
     */
    int insert(RentBill record);

    /**
     * @param record
     * @return 
     */
    int insertSelective(RentBill record);

    /**
     * @param example
     * @return 
     */
    List<RentBill> selectByExample(RentBillExample example);

    /**
     * @param id
     * @return 
     */
    RentBill selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExampleSelective(@Param("record") RentBill record, @Param("example") RentBillExample example);

    /**
     * @param record
     * @param example
     * @return 
     */
    int updateByExample(@Param("record") RentBill record, @Param("example") RentBillExample example);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKeySelective(RentBill record);

    /**
     * @param record
     * @return 
     */
    int updateByPrimaryKey(RentBill record);


    List<RentBillVo> getBillList(RentBillVo rentBillVo);
    List<RentBill> getByInfoId(Integer infoId);
    List<RentBill> isExist(Integer lesseeId);
    RentBill getAmountAndAmountOwedLastMonth();
    RentBill getAmountAndAmountOwed();
    RentBill getLastMonthBill(Integer infoId,Integer month,Integer year);
}