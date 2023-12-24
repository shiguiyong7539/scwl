package com.scwl.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.math.BigDecimal;
import java.util.Date;

public class RentLeaseInfo {
    /**
     */
    @ExcelProperty("序号")
    private Integer id;

    /**
     * 承租人id
     */
    @ExcelIgnore
    private Integer lesseeId;

    /**
     * 资产id
     */
    @ExcelIgnore
    private Integer assetId;

    /**
     * 租约状态（1.租赁中，2，正常完了不在续约，3，提前退租）
     */
    @ExcelIgnore
    private Integer status;

    /**
     * 交租周期（月度，季度，年度）
     */
    @ExcelProperty("交租周期")
    private String rentCycle;

    /**
     * 租赁起始日期
     */
    @ExcelProperty("租赁日期")
    @DateTimeFormat("YYYY-MM-dd")
    @ColumnWidth(15)
    private Date leaseDate;

    /**
     * 租金结算日
     */
    @ExcelProperty("交租日期")
    @DateTimeFormat("YYYY-MM-dd")
    @ColumnWidth(15)
    private Date payDate;

    /**
     * 租赁合约到期日
     */
    @ExcelProperty("到期日期")
    @DateTimeFormat("YYYY-MM-dd")
    @ColumnWidth(15)
    private Date expireDate;

    /**
     * 退租日期
     */
    @ExcelProperty("退租日期")
    @DateTimeFormat("YYYY-MM-dd")
    @ColumnWidth(15)
    private Date quitDate;

    /**
     * 租赁单价
     */
    @ExcelProperty("租金（元）")
    private BigDecimal leaseUnitPrice;

    /**
     * 押金
     */
    @ExcelProperty("押金（元）")
    private BigDecimal cashPledge;

    /**
     * 免租月数
     */
    @ExcelProperty("总免租（月）")
    private Integer freeMonth;

    /**
     * 免租月数计数
     */
    @ExcelProperty("免租剩余（月）")
    private Integer freeMonthNum;

    /**
     */
    @ExcelProperty("状态")
    private String remark;
    /**
     * 0,未删除，1删除
     */
    @ExcelIgnore
    private Integer isDelete;
    /**
     */
    @ExcelProperty("添加日期")
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

    public Integer getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Integer lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRentCycle() {
        return rentCycle;
    }

    public void setRentCycle(String rentCycle) {
        this.rentCycle = rentCycle == null ? null : rentCycle.trim();
    }

    public Date getLeaseDate() {
        return leaseDate;
    }

    public void setLeaseDate(Date leaseDate) {
        this.leaseDate = leaseDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public BigDecimal getLeaseUnitPrice() {
        return leaseUnitPrice;
    }

    public void setLeaseUnitPrice(BigDecimal leaseUnitPrice) {
        this.leaseUnitPrice = leaseUnitPrice;
    }

    public BigDecimal getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(BigDecimal cashPledge) {
        this.cashPledge = cashPledge;
    }

    public Integer getFreeMonth() {
        return freeMonth;
    }

    public void setFreeMonth(Integer freeMonth) {
        this.freeMonth = freeMonth;
    }

    public Integer getFreeMonthNum() {
        return freeMonthNum;
    }

    public void setFreeMonthNum(Integer freeMonthNum) {
        this.freeMonthNum = freeMonthNum;
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