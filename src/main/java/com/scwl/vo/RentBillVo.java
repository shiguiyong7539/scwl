package com.scwl.vo;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.scwl.pojo.RentBill;

public class RentBillVo extends RentBill {

    /**
     * 资产名
     */
    @ExcelProperty("资产名")
    @ColumnWidth(30)
    private String assetName;

    /**
     * 面积
     */
    @ExcelProperty("面积(㎡)")
    @ColumnWidth(20)
    private Double acreage;

    /**
     * 资产地址
     */
    @ExcelIgnore
    private String assetAddress;

    /**
     * 资产状态（1，空置，2，租赁中）
     */
    @ExcelIgnore
    private Integer assetStatus;

    /**
     * 承租人姓名
     */
    @ExcelProperty("租户姓名")
    @ColumnWidth(30)
    private String lesseeName;

    /**
     * 电话
     */
    @ExcelProperty("电话")
    private String phone;

    /**
     * 性别
     */
    @ExcelIgnore
    private String sex;

    /**
     * 身份证
     */
    @ExcelIgnore
    private String identityCard;

    /**
     * 承租人住址
     */
    @ExcelIgnore
    private String personAddress;

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public String getAssetAddress() {
        return assetAddress;
    }

    public void setAssetAddress(String assetAddress) {
        this.assetAddress = assetAddress;
    }

    public Integer getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(Integer assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getLesseeName() {
        return lesseeName;
    }

    public void setLesseeName(String lesseeName) {
        this.lesseeName = lesseeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
