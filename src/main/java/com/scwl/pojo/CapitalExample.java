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

    public CapitalExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

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