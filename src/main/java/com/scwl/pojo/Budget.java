package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Budget {
    /**
     */
    private Integer id;

    /**
     * 部门
     */
    private String department;

    /**
     * 月度资金
     */
    private BigDecimal monthFunds;

    /**
     * 资金实际使用情况
     */
    private BigDecimal realFunds;

    /**
     * 预算偏差率
     */
    private BigDecimal deviationRate;

    /**
     * 月份
     */
    private Date monthDate;

    /**
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public BigDecimal getMonthFunds() {
        return monthFunds;
    }

    public void setMonthFunds(BigDecimal monthFunds) {
        this.monthFunds = monthFunds;
    }

    public BigDecimal getRealFunds() {
        return realFunds;
    }

    public void setRealFunds(BigDecimal realFunds) {
        this.realFunds = realFunds;
    }

    public BigDecimal getDeviationRate() {
        return deviationRate;
    }

    public void setDeviationRate(BigDecimal deviationRate) {
        this.deviationRate = deviationRate;
    }

    public Date getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(Date monthDate) {
        this.monthDate = monthDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}