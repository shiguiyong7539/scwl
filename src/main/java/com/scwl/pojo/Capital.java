package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Capital {
    private Integer id;

    private BigDecimal finishRate;

    private BigDecimal operatRate;

    private BigDecimal incomeRate;

    private BigDecimal cashRate;

    private BigDecimal costRate;

    private BigDecimal useCapital;

    private Date addDate;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getFinishRate() {
        return finishRate;
    }

    public void setFinishRate(BigDecimal finishRate) {
        this.finishRate = finishRate;
    }

    public BigDecimal getOperatRate() {
        return operatRate;
    }

    public void setOperatRate(BigDecimal operatRate) {
        this.operatRate = operatRate;
    }

    public BigDecimal getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(BigDecimal incomeRate) {
        this.incomeRate = incomeRate;
    }

    public BigDecimal getCashRate() {
        return cashRate;
    }

    public void setCashRate(BigDecimal cashRate) {
        this.cashRate = cashRate;
    }

    public BigDecimal getCostRate() {
        return costRate;
    }

    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    public BigDecimal getUseCapital() {
        return useCapital;
    }

    public void setUseCapital(BigDecimal useCapital) {
        this.useCapital = useCapital;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}