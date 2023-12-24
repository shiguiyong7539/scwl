package com.scwl.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.util.Date;

public class RentAsset {
    /**
     */
    @ExcelProperty("序号")
    private Integer id;

    /**
     * 资产名
     */
    @ExcelProperty("资产名")
    @ColumnWidth(30)
    private String assetName;

    /**
     * 面积(㎡)
     */
    @ExcelProperty("面积(㎡)")
    @ColumnWidth(20)
    private Double acreage;

    /**
     * 资产地址
     */
    @ExcelProperty("资产地址")
    @ColumnWidth(30)
    private String address;

    /**
     * 资产状态（1，空置，2，租赁中）
     */
    //@ExcelProperty("1，空置中，2，租赁中）")
   // @ColumnWidth(60)
    @ExcelIgnore
    private Integer status;

    /**
     * 备注
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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