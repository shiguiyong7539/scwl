package com.scwl.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.math.BigDecimal;
import java.util.Date;

public class RentBill {
    /**
     */
    @ExcelProperty("序号")
    private Integer id;

    /**
     * 资产id
     */
    @ExcelIgnore
    private Integer assetId;

    /**
     * 租户id
     */
    @ExcelIgnore
    private Integer lesseeId;

    /**
     * 租约id
     */
    @ExcelIgnore
    private Integer leaseInfoId;

    /**
     * 租金
     */
    @ExcelProperty("缴纳租金")
    private BigDecimal amount;

    /**
     * 欠费金额
     */
    @ExcelProperty("欠费金额")
    private BigDecimal amountOwed;

    /**
     * 交租日期
     */
    @ExcelProperty("交租日期")
    @DateTimeFormat("YYYY-MM-dd")
    @ColumnWidth(15)
    private Date rentDay;

    /**
     * 状态（1，已交，2，欠费，3，免租期内免租金）
     */
    @ExcelIgnore
    private Integer status;

    /**
     */
    @ExcelProperty("状态")//导出时表示状态
    private String remark;
    /**
     * 0,未删除，1删除
     */
    @ExcelIgnore
    private Integer isDelete;
    /**
     */
    @ExcelProperty("账单日期")
    @DateTimeFormat("YYYY-MM-dd")
    @ColumnWidth(15)
    private Date addTime;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public Integer getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Integer lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Integer getLeaseInfoId() {
        return leaseInfoId;
    }

    public void setLeaseInfoId(Integer leaseInfoId) {
        this.leaseInfoId = leaseInfoId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(BigDecimal amountOwed) {
        this.amountOwed = amountOwed;
    }

    public Date getRentDay() {
        return rentDay;
    }

    public void setRentDay(Date rentDay) {
        this.rentDay = rentDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}