package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ManageState {
    /**
     */
    private Integer id;

    /**
     * 资产经营||经营业务收入
     */
    private String name;

    /**
     * 子业务
     */
    private String type;

    /**
     * 租金收入
     */
    private BigDecimal rentIncome;

    /**
     * 欠收租金
     */
    private BigDecimal rentArrears;

    /**
     * 出租率
     */
    private BigDecimal letRate;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getRentIncome() {
        return rentIncome;
    }

    public void setRentIncome(BigDecimal rentIncome) {
        this.rentIncome = rentIncome;
    }

    public BigDecimal getRentArrears() {
        return rentArrears;
    }

    public void setRentArrears(BigDecimal rentArrears) {
        this.rentArrears = rentArrears;
    }

    public BigDecimal getLetRate() {
        return letRate;
    }

    public void setLetRate(BigDecimal letRate) {
        this.letRate = letRate;
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