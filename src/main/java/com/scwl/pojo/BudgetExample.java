package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BudgetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @return 
     */
    public BudgetExample() {
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

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andMonthFundsIsNull() {
            addCriterion("month_funds is null");
            return (Criteria) this;
        }

        public Criteria andMonthFundsIsNotNull() {
            addCriterion("month_funds is not null");
            return (Criteria) this;
        }

        public Criteria andMonthFundsEqualTo(BigDecimal value) {
            addCriterion("month_funds =", value, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsNotEqualTo(BigDecimal value) {
            addCriterion("month_funds <>", value, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsGreaterThan(BigDecimal value) {
            addCriterion("month_funds >", value, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_funds >=", value, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsLessThan(BigDecimal value) {
            addCriterion("month_funds <", value, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_funds <=", value, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsIn(List<BigDecimal> values) {
            addCriterion("month_funds in", values, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsNotIn(List<BigDecimal> values) {
            addCriterion("month_funds not in", values, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_funds between", value1, value2, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andMonthFundsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_funds not between", value1, value2, "monthFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsIsNull() {
            addCriterion("real_funds is null");
            return (Criteria) this;
        }

        public Criteria andRealFundsIsNotNull() {
            addCriterion("real_funds is not null");
            return (Criteria) this;
        }

        public Criteria andRealFundsEqualTo(BigDecimal value) {
            addCriterion("real_funds =", value, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsNotEqualTo(BigDecimal value) {
            addCriterion("real_funds <>", value, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsGreaterThan(BigDecimal value) {
            addCriterion("real_funds >", value, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_funds >=", value, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsLessThan(BigDecimal value) {
            addCriterion("real_funds <", value, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_funds <=", value, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsIn(List<BigDecimal> values) {
            addCriterion("real_funds in", values, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsNotIn(List<BigDecimal> values) {
            addCriterion("real_funds not in", values, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_funds between", value1, value2, "realFunds");
            return (Criteria) this;
        }

        public Criteria andRealFundsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_funds not between", value1, value2, "realFunds");
            return (Criteria) this;
        }

        public Criteria andDeviationRateIsNull() {
            addCriterion("deviation_rate is null");
            return (Criteria) this;
        }

        public Criteria andDeviationRateIsNotNull() {
            addCriterion("deviation_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDeviationRateEqualTo(BigDecimal value) {
            addCriterion("deviation_rate =", value, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateNotEqualTo(BigDecimal value) {
            addCriterion("deviation_rate <>", value, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateGreaterThan(BigDecimal value) {
            addCriterion("deviation_rate >", value, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deviation_rate >=", value, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateLessThan(BigDecimal value) {
            addCriterion("deviation_rate <", value, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deviation_rate <=", value, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateIn(List<BigDecimal> values) {
            addCriterion("deviation_rate in", values, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateNotIn(List<BigDecimal> values) {
            addCriterion("deviation_rate not in", values, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deviation_rate between", value1, value2, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andDeviationRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deviation_rate not between", value1, value2, "deviationRate");
            return (Criteria) this;
        }

        public Criteria andMonthDateIsNull() {
            addCriterion("month_date is null");
            return (Criteria) this;
        }

        public Criteria andMonthDateIsNotNull() {
            addCriterion("month_date is not null");
            return (Criteria) this;
        }

        public Criteria andMonthDateEqualTo(Date value) {
            addCriterionForJDBCDate("month_date =", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("month_date <>", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateGreaterThan(Date value) {
            addCriterionForJDBCDate("month_date >", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("month_date >=", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateLessThan(Date value) {
            addCriterionForJDBCDate("month_date <", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("month_date <=", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateIn(List<Date> values) {
            addCriterionForJDBCDate("month_date in", values, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("month_date not in", values, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("month_date between", value1, value2, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("month_date not between", value1, value2, "monthDate");
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