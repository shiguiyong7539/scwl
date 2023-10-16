package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Capital {
    /**
     */
    private Integer id;

    /**
     * 融资计划完成率
     */
    private BigDecimal finishRate;

    /**
     * 融资计划完成率指标
     */
    private BigDecimal finishRateTag;

    /**
     * 运营费用节约率
     */
    private BigDecimal operatRate;

    /**
     * 运营费用节约率指标
     */
    private BigDecimal operatRateTag;

    /**
     * 营业收入增长率
     */
    private BigDecimal incomeRate;

    /**
     * 营业收入增长率指标
     */
    private BigDecimal incomeRateTag;

    /**
     * 营业现金比率
     */
    private BigDecimal cashRate;

    /**
     * 营业现金比率指标
     */
    private BigDecimal cashRateTag;

    /**
     * 营业现金比率
     */
    private BigDecimal costRate;

    /**
     * 营业现金比率指标
     */
    private BigDecimal costRateTag;

    /**
     * 可用资金
     */
    private BigDecimal useCapital;

    /**
     * 不可用资金
     */
    private BigDecimal unUseCapital;

    /**
     */
    private Date addDate;

    /**
     */
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

    public BigDecimal getFinishRateTag() {
        return finishRateTag;
    }

    public void setFinishRateTag(BigDecimal finishRateTag) {
        this.finishRateTag = finishRateTag;
    }

    public BigDecimal getOperatRate() {
        return operatRate;
    }

    public void setOperatRate(BigDecimal operatRate) {
        this.operatRate = operatRate;
    }

    public BigDecimal getOperatRateTag() {
        return operatRateTag;
    }

    public void setOperatRateTag(BigDecimal operatRateTag) {
        this.operatRateTag = operatRateTag;
    }

    public BigDecimal getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(BigDecimal incomeRate) {
        this.incomeRate = incomeRate;
    }

    public BigDecimal getIncomeRateTag() {
        return incomeRateTag;
    }

    public void setIncomeRateTag(BigDecimal incomeRateTag) {
        this.incomeRateTag = incomeRateTag;
    }

    public BigDecimal getCashRate() {
        return cashRate;
    }

    public void setCashRate(BigDecimal cashRate) {
        this.cashRate = cashRate;
    }

    public BigDecimal getCashRateTag() {
        return cashRateTag;
    }

    public void setCashRateTag(BigDecimal cashRateTag) {
        this.cashRateTag = cashRateTag;
    }

    public BigDecimal getCostRate() {
        return costRate;
    }

    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    public BigDecimal getCostRateTag() {
        return costRateTag;
    }

    public void setCostRateTag(BigDecimal costRateTag) {
        this.costRateTag = costRateTag;
    }

    public BigDecimal getUseCapital() {
        return useCapital;
    }

    public void setUseCapital(BigDecimal useCapital) {
        this.useCapital = useCapital;
    }

    public BigDecimal getUnUseCapital() {
        return unUseCapital;
    }

    public void setUnUseCapital(BigDecimal unUseCapital) {
        this.unUseCapital = unUseCapital;
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