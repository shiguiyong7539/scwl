package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ManageStateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @return 
     */
    public ManageStateExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRentIncomeIsNull() {
            addCriterion("rent_income is null");
            return (Criteria) this;
        }

        public Criteria andRentIncomeIsNotNull() {
            addCriterion("rent_income is not null");
            return (Criteria) this;
        }

        public Criteria andRentIncomeEqualTo(BigDecimal value) {
            addCriterion("rent_income =", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeNotEqualTo(BigDecimal value) {
            addCriterion("rent_income <>", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeGreaterThan(BigDecimal value) {
            addCriterion("rent_income >", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_income >=", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeLessThan(BigDecimal value) {
            addCriterion("rent_income <", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_income <=", value, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeIn(List<BigDecimal> values) {
            addCriterion("rent_income in", values, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeNotIn(List<BigDecimal> values) {
            addCriterion("rent_income not in", values, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_income between", value1, value2, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_income not between", value1, value2, "rentIncome");
            return (Criteria) this;
        }

        public Criteria andRentArrearsIsNull() {
            addCriterion("rent_arrears is null");
            return (Criteria) this;
        }

        public Criteria andRentArrearsIsNotNull() {
            addCriterion("rent_arrears is not null");
            return (Criteria) this;
        }

        public Criteria andRentArrearsEqualTo(BigDecimal value) {
            addCriterion("rent_arrears =", value, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsNotEqualTo(BigDecimal value) {
            addCriterion("rent_arrears <>", value, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsGreaterThan(BigDecimal value) {
            addCriterion("rent_arrears >", value, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_arrears >=", value, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsLessThan(BigDecimal value) {
            addCriterion("rent_arrears <", value, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_arrears <=", value, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsIn(List<BigDecimal> values) {
            addCriterion("rent_arrears in", values, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsNotIn(List<BigDecimal> values) {
            addCriterion("rent_arrears not in", values, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_arrears between", value1, value2, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andRentArrearsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_arrears not between", value1, value2, "rentArrears");
            return (Criteria) this;
        }

        public Criteria andLetRateIsNull() {
            addCriterion("let_rate is null");
            return (Criteria) this;
        }

        public Criteria andLetRateIsNotNull() {
            addCriterion("let_rate is not null");
            return (Criteria) this;
        }

        public Criteria andLetRateEqualTo(BigDecimal value) {
            addCriterion("let_rate =", value, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateNotEqualTo(BigDecimal value) {
            addCriterion("let_rate <>", value, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateGreaterThan(BigDecimal value) {
            addCriterion("let_rate >", value, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("let_rate >=", value, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateLessThan(BigDecimal value) {
            addCriterion("let_rate <", value, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("let_rate <=", value, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateIn(List<BigDecimal> values) {
            addCriterion("let_rate in", values, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateNotIn(List<BigDecimal> values) {
            addCriterion("let_rate not in", values, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("let_rate between", value1, value2, "letRate");
            return (Criteria) this;
        }

        public Criteria andLetRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("let_rate not between", value1, value2, "letRate");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeIsNull() {
            addCriterion("periodic_time is null");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeIsNotNull() {
            addCriterion("periodic_time is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeEqualTo(Date value) {
            addCriterionForJDBCDate("periodic_time =", value, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("periodic_time <>", value, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("periodic_time >", value, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("periodic_time >=", value, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeLessThan(Date value) {
            addCriterionForJDBCDate("periodic_time <", value, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("periodic_time <=", value, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeIn(List<Date> values) {
            addCriterionForJDBCDate("periodic_time in", values, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("periodic_time not in", values, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("periodic_time between", value1, value2, "periodicTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("periodic_time not between", value1, value2, "periodicTime");
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