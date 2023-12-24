package com.scwl.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.math.BigDecimal;
import java.util.Date;

public class RentLessee {
    /**
     */
    @ExcelProperty("序号")
    private Integer id;

    /**
     * 承租人姓名
     */
    @ExcelProperty("姓名")
    @ColumnWidth(15)
    private String lesseeName;

    /**
     * 电话
     */
    @ExcelProperty("电话")
    @ColumnWidth(15)
    private String phone;

    /**
     * 性别
     */
    @ExcelProperty("性别")
    private String sex;

    /**
     * 身份证
     */
    @ExcelProperty("身份证")
    @ColumnWidth(20)
    private String identityCard;

    /**
     * 承租人住址
     */
    @ExcelProperty("住址")
    @ColumnWidth(30)
    private String address;

    /**
     * 账户余额
     */
    @ExcelProperty("账户余额")
    private BigDecimal account;

    /**
     * 押金账户
     */
    @ExcelProperty("押金总额")
    private BigDecimal pledgeAmount;

    /**
     */
    @ExcelIgnore
    private Integer status;

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
    @ExcelProperty("添加时间")
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

    public String getLesseeName() {
        return lesseeName;
    }

    public void setLesseeName(String lesseeName) {
        this.lesseeName = lesseeName == null ? null : lesseeName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(BigDecimal pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
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