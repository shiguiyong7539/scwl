package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class CapitalPosition {
    private Integer id;

    private String type;

    private String category;

    private BigDecimal income;

    private BigDecimal incomeTotal;

    private BigDecimal contractExpend;

    private BigDecimal specialExpend;

    private BigDecimal dailyExpend;

    private Date term;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(BigDecimal incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public BigDecimal getContractExpend() {
        return contractExpend;
    }

    public void setContractExpend(BigDecimal contractExpend) {
        this.contractExpend = contractExpend;
    }

    public BigDecimal getSpecialExpend() {
        return specialExpend;
    }

    public void setSpecialExpend(BigDecimal specialExpend) {
        this.specialExpend = specialExpend;
    }

    public BigDecimal getDailyExpend() {
        return dailyExpend;
    }

    public void setDailyExpend(BigDecimal dailyExpend) {
        this.dailyExpend = dailyExpend;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}