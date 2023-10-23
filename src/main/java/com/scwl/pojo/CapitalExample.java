package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CapitalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @return 
     */
    public CapitalExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @param orderByClause
     * @return 
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @return 
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @param distinct
     * @return 
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @return 
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @return 
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @param criteria
     * @return 
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @return 
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @return 
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @return 
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @return 
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFinishRateIsNull() {
            addCriterion("finish_rate is null");
            return (Criteria) this;
        }

        public Criteria andFinishRateIsNotNull() {
            addCriterion("finish_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFinishRateEqualTo(BigDecimal value) {
            addCriterion("finish_rate =", value, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateNotEqualTo(BigDecimal value) {
            addCriterion("finish_rate <>", value, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateGreaterThan(BigDecimal value) {
            addCriterion("finish_rate >", value, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("finish_rate >=", value, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateLessThan(BigDecimal value) {
            addCriterion("finish_rate <", value, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("finish_rate <=", value, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateIn(List<BigDecimal> values) {
            addCriterion("finish_rate in", values, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateNotIn(List<BigDecimal> values) {
            addCriterion("finish_rate not in", values, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("finish_rate between", value1, value2, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("finish_rate not between", value1, value2, "finishRate");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagIsNull() {
            addCriterion("finish_rate_tag is null");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagIsNotNull() {
            addCriterion("finish_rate_tag is not null");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagEqualTo(BigDecimal value) {
            addCriterion("finish_rate_tag =", value, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagNotEqualTo(BigDecimal value) {
            addCriterion("finish_rate_tag <>", value, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagGreaterThan(BigDecimal value) {
            addCriterion("finish_rate_tag >", value, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("finish_rate_tag >=", value, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagLessThan(BigDecimal value) {
            addCriterion("finish_rate_tag <", value, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("finish_rate_tag <=", value, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagIn(List<BigDecimal> values) {
            addCriterion("finish_rate_tag in", values, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagNotIn(List<BigDecimal> values) {
            addCriterion("finish_rate_tag not in", values, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("finish_rate_tag between", value1, value2, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andFinishRateTagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("finish_rate_tag not between", value1, value2, "finishRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateIsNull() {
            addCriterion("operat_rate is null");
            return (Criteria) this;
        }

        public Criteria andOperatRateIsNotNull() {
            addCriterion("operat_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOperatRateEqualTo(BigDecimal value) {
            addCriterion("operat_rate =", value, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateNotEqualTo(BigDecimal value) {
            addCriterion("operat_rate <>", value, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateGreaterThan(BigDecimal value) {
            addCriterion("operat_rate >", value, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operat_rate >=", value, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateLessThan(BigDecimal value) {
            addCriterion("operat_rate <", value, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operat_rate <=", value, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateIn(List<BigDecimal> values) {
            addCriterion("operat_rate in", values, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateNotIn(List<BigDecimal> values) {
            addCriterion("operat_rate not in", values, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operat_rate between", value1, value2, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operat_rate not between", value1, value2, "operatRate");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagIsNull() {
            addCriterion("operat_rate_tag is null");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagIsNotNull() {
            addCriterion("operat_rate_tag is not null");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagEqualTo(BigDecimal value) {
            addCriterion("operat_rate_tag =", value, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagNotEqualTo(BigDecimal value) {
            addCriterion("operat_rate_tag <>", value, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagGreaterThan(BigDecimal value) {
            addCriterion("operat_rate_tag >", value, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operat_rate_tag >=", value, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagLessThan(BigDecimal value) {
            addCriterion("operat_rate_tag <", value, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operat_rate_tag <=", value, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagIn(List<BigDecimal> values) {
            addCriterion("operat_rate_tag in", values, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagNotIn(List<BigDecimal> values) {
            addCriterion("operat_rate_tag not in", values, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operat_rate_tag between", value1, value2, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andOperatRateTagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operat_rate_tag not between", value1, value2, "operatRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateIsNull() {
            addCriterion("income_rate is null");
            return (Criteria) this;
        }

        public Criteria andIncomeRateIsNotNull() {
            addCriterion("income_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeRateEqualTo(BigDecimal value) {
            addCriterion("income_rate =", value, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateNotEqualTo(BigDecimal value) {
            addCriterion("income_rate <>", value, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateGreaterThan(BigDecimal value) {
            addCriterion("income_rate >", value, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_rate >=", value, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateLessThan(BigDecimal value) {
            addCriterion("income_rate <", value, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_rate <=", value, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateIn(List<BigDecimal> values) {
            addCriterion("income_rate in", values, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateNotIn(List<BigDecimal> values) {
            addCriterion("income_rate not in", values, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_rate between", value1, value2, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_rate not between", value1, value2, "incomeRate");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagIsNull() {
            addCriterion("income_rate_tag is null");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagIsNotNull() {
            addCriterion("income_rate_tag is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagEqualTo(BigDecimal value) {
            addCriterion("income_rate_tag =", value, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagNotEqualTo(BigDecimal value) {
            addCriterion("income_rate_tag <>", value, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagGreaterThan(BigDecimal value) {
            addCriterion("income_rate_tag >", value, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_rate_tag >=", value, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagLessThan(BigDecimal value) {
            addCriterion("income_rate_tag <", value, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_rate_tag <=", value, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagIn(List<BigDecimal> values) {
            addCriterion("income_rate_tag in", values, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagNotIn(List<BigDecimal> values) {
            addCriterion("income_rate_tag not in", values, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_rate_tag between", value1, value2, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andIncomeRateTagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_rate_tag not between", value1, value2, "incomeRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateIsNull() {
            addCriterion("cash_rate is null");
            return (Criteria) this;
        }

        public Criteria andCashRateIsNotNull() {
            addCriterion("cash_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCashRateEqualTo(BigDecimal value) {
            addCriterion("cash_rate =", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateNotEqualTo(BigDecimal value) {
            addCriterion("cash_rate <>", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateGreaterThan(BigDecimal value) {
            addCriterion("cash_rate >", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_rate >=", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateLessThan(BigDecimal value) {
            addCriterion("cash_rate <", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_rate <=", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateIn(List<BigDecimal> values) {
            addCriterion("cash_rate in", values, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateNotIn(List<BigDecimal> values) {
            addCriterion("cash_rate not in", values, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_rate between", value1, value2, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_rate not between", value1, value2, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateTagIsNull() {
            addCriterion("cash_rate_tag is null");
            return (Criteria) this;
        }

        public Criteria andCashRateTagIsNotNull() {
            addCriterion("cash_rate_tag is not null");
            return (Criteria) this;
        }

        public Criteria andCashRateTagEqualTo(BigDecimal value) {
            addCriterion("cash_rate_tag =", value, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagNotEqualTo(BigDecimal value) {
            addCriterion("cash_rate_tag <>", value, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagGreaterThan(BigDecimal value) {
            addCriterion("cash_rate_tag >", value, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_rate_tag >=", value, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagLessThan(BigDecimal value) {
            addCriterion("cash_rate_tag <", value, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_rate_tag <=", value, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagIn(List<BigDecimal> values) {
            addCriterion("cash_rate_tag in", values, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagNotIn(List<BigDecimal> values) {
            addCriterion("cash_rate_tag not in", values, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_rate_tag between", value1, value2, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCashRateTagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_rate_tag not between", value1, value2, "cashRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNull() {
            addCriterion("cost_rate is null");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNotNull() {
            addCriterion("cost_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCostRateEqualTo(BigDecimal value) {
            addCriterion("cost_rate =", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotEqualTo(BigDecimal value) {
            addCriterion("cost_rate <>", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThan(BigDecimal value) {
            addCriterion("cost_rate >", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_rate >=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThan(BigDecimal value) {
            addCriterion("cost_rate <", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_rate <=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateIn(List<BigDecimal> values) {
            addCriterion("cost_rate in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotIn(List<BigDecimal> values) {
            addCriterion("cost_rate not in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_rate between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_rate not between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateTagIsNull() {
            addCriterion("cost_rate_tag is null");
            return (Criteria) this;
        }

        public Criteria andCostRateTagIsNotNull() {
            addCriterion("cost_rate_tag is not null");
            return (Criteria) this;
        }

        public Criteria andCostRateTagEqualTo(BigDecimal value) {
            addCriterion("cost_rate_tag =", value, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagNotEqualTo(BigDecimal value) {
            addCriterion("cost_rate_tag <>", value, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagGreaterThan(BigDecimal value) {
            addCriterion("cost_rate_tag >", value, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_rate_tag >=", value, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagLessThan(BigDecimal value) {
            addCriterion("cost_rate_tag <", value, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_rate_tag <=", value, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagIn(List<BigDecimal> values) {
            addCriterion("cost_rate_tag in", values, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagNotIn(List<BigDecimal> values) {
            addCriterion("cost_rate_tag not in", values, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_rate_tag between", value1, value2, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andCostRateTagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_rate_tag not between", value1, value2, "costRateTag");
            return (Criteria) this;
        }

        public Criteria andUseCapitalIsNull() {
            addCriterion("use_capital is null");
            return (Criteria) this;
        }

        public Criteria andUseCapitalIsNotNull() {
            addCriterion("use_capital is not null");
            return (Criteria) this;
        }

        public Criteria andUseCapitalEqualTo(BigDecimal value) {
            addCriterion("use_capital =", value, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalNotEqualTo(BigDecimal value) {
            addCriterion("use_capital <>", value, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalGreaterThan(BigDecimal value) {
            addCriterion("use_capital >", value, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("use_capital >=", value, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalLessThan(BigDecimal value) {
            addCriterion("use_capital <", value, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("use_capital <=", value, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalIn(List<BigDecimal> values) {
            addCriterion("use_capital in", values, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalNotIn(List<BigDecimal> values) {
            addCriterion("use_capital not in", values, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_capital between", value1, value2, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUseCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_capital not between", value1, value2, "useCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalIsNull() {
            addCriterion("un_use_capital is null");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalIsNotNull() {
            addCriterion("un_use_capital is not null");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalEqualTo(BigDecimal value) {
            addCriterion("un_use_capital =", value, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalNotEqualTo(BigDecimal value) {
            addCriterion("un_use_capital <>", value, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalGreaterThan(BigDecimal value) {
            addCriterion("un_use_capital >", value, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("un_use_capital >=", value, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalLessThan(BigDecimal value) {
            addCriterion("un_use_capital <", value, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("un_use_capital <=", value, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalIn(List<BigDecimal> values) {
            addCriterion("un_use_capital in", values, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalNotIn(List<BigDecimal> values) {
            addCriterion("un_use_capital not in", values, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("un_use_capital between", value1, value2, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andUnUseCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("un_use_capital not between", value1, value2, "unUseCapital");
            return (Criteria) this;
        }

        public Criteria andQuarterlyIsNull() {
            addCriterion("quarterly is null");
            return (Criteria) this;
        }

        public Criteria andQuarterlyIsNotNull() {
            addCriterion("quarterly is not null");
            return (Criteria) this;
        }

        public Criteria andQuarterlyEqualTo(String value) {
            addCriterion("quarterly =", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyNotEqualTo(String value) {
            addCriterion("quarterly <>", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyGreaterThan(String value) {
            addCriterion("quarterly >", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyGreaterThanOrEqualTo(String value) {
            addCriterion("quarterly >=", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyLessThan(String value) {
            addCriterion("quarterly <", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyLessThanOrEqualTo(String value) {
            addCriterion("quarterly <=", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyLike(String value) {
            addCriterion("quarterly like", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyNotLike(String value) {
            addCriterion("quarterly not like", value, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyIn(List<String> values) {
            addCriterion("quarterly in", values, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyNotIn(List<String> values) {
            addCriterion("quarterly not in", values, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyBetween(String value1, String value2) {
            addCriterion("quarterly between", value1, value2, "quarterly");
            return (Criteria) this;
        }

        public Criteria andQuarterlyNotBetween(String value1, String value2) {
            addCriterion("quarterly not between", value1, value2, "quarterly");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("add_date is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("add_date is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(Date value) {
            addCriterionForJDBCDate("add_date =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("add_date <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(Date value) {
            addCriterionForJDBCDate("add_date >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_date >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(Date value) {
            addCriterionForJDBCDate("add_date <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_date <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<Date> values) {
            addCriterionForJDBCDate("add_date in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("add_date not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_date between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_date not between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}