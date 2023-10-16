package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CostManage {
    /**
     */
    private Integer id;

    /**
     * 成本名称
     */
    private String name;

    /**
     * 工资发放
     */
    private BigDecimal payOutWage;

    /**
     * 房租
     */
    private BigDecimal rent;

    /**
     * 水电办公等
     */
    private BigDecimal hydropowerOffice;

    /**
     * 工会
     */
    private BigDecimal laborUnion;

    /**
     */
    private Date periodicTime;

    /**
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPayOutWage() {
        return payOutWage;
    }

    public void setPayOutWage(BigDecimal payOutWage) {
        this.payOutWage = payOutWage;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getHydropowerOffice() {
        return hydropowerOffice;
    }

    public void setHydropowerOffice(BigDecimal hydropowerOffice) {
        this.hydropowerOffice = hydropowerOffice;
    }

    public BigDecimal getLaborUnion() {
        return laborUnion;
    }

    public void setLaborUnion(BigDecimal laborUnion) {
        this.laborUnion = laborUnion;
    }

    public Date getPeriodicTime() {
        return periodicTime;
    }

    public void setPeriodicTime(Date periodicTime) {
        this.periodicTime = periodicTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}