package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CapitalPositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CapitalPositionExample() {
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

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(BigDecimal value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(BigDecimal value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(BigDecimal value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(BigDecimal value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<BigDecimal> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<BigDecimal> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIsNull() {
            addCriterion("income_total is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIsNotNull() {
            addCriterion("income_total is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalEqualTo(BigDecimal value) {
            addCriterion("income_total =", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotEqualTo(BigDecimal value) {
            addCriterion("income_total <>", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalGreaterThan(BigDecimal value) {
            addCriterion("income_total >", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_total >=", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalLessThan(BigDecimal value) {
            addCriterion("income_total <", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_total <=", value, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalIn(List<BigDecimal> values) {
            addCriterion("income_total in", values, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotIn(List<BigDecimal> values) {
            addCriterion("income_total not in", values, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_total between", value1, value2, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andIncomeTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_total not between", value1, value2, "incomeTotal");
            return (Criteria) this;
        }

        public Criteria andContractExpendIsNull() {
            addCriterion("contract_expend is null");
            return (Criteria) this;
        }

        public Criteria andContractExpendIsNotNull() {
            addCriterion("contract_expend is not null");
            return (Criteria) this;
        }

        public Criteria andContractExpendEqualTo(BigDecimal value) {
            addCriterion("contract_expend =", value, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendNotEqualTo(BigDecimal value) {
            addCriterion("contract_expend <>", value, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendGreaterThan(BigDecimal value) {
            addCriterion("contract_expend >", value, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_expend >=", value, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendLessThan(BigDecimal value) {
            addCriterion("contract_expend <", value, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_expend <=", value, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendIn(List<BigDecimal> values) {
            addCriterion("contract_expend in", values, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendNotIn(List<BigDecimal> values) {
            addCriterion("contract_expend not in", values, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_expend between", value1, value2, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andContractExpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_expend not between", value1, value2, "contractExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendIsNull() {
            addCriterion("special_expend is null");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendIsNotNull() {
            addCriterion("special_expend is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendEqualTo(BigDecimal value) {
            addCriterion("special_expend =", value, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendNotEqualTo(BigDecimal value) {
            addCriterion("special_expend <>", value, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendGreaterThan(BigDecimal value) {
            addCriterion("special_expend >", value, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("special_expend >=", value, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendLessThan(BigDecimal value) {
            addCriterion("special_expend <", value, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("special_expend <=", value, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendIn(List<BigDecimal> values) {
            addCriterion("special_expend in", values, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendNotIn(List<BigDecimal> values) {
            addCriterion("special_expend not in", values, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("special_expend between", value1, value2, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andSpecialExpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("special_expend not between", value1, value2, "specialExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendIsNull() {
            addCriterion("daily_expend is null");
            return (Criteria) this;
        }

        public Criteria andDailyExpendIsNotNull() {
            addCriterion("daily_expend is not null");
            return (Criteria) this;
        }

        public Criteria andDailyExpendEqualTo(BigDecimal value) {
            addCriterion("daily_expend =", value, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendNotEqualTo(BigDecimal value) {
            addCriterion("daily_expend <>", value, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendGreaterThan(BigDecimal value) {
            addCriterion("daily_expend >", value, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("daily_expend >=", value, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendLessThan(BigDecimal value) {
            addCriterion("daily_expend <", value, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendLessThanOrEqualTo(BigDecimal value) {
            addCriterion("daily_expend <=", value, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendIn(List<BigDecimal> values) {
            addCriterion("daily_expend in", values, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendNotIn(List<BigDecimal> values) {
            addCriterion("daily_expend not in", values, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("daily_expend between", value1, value2, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andDailyExpendNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("daily_expend not between", value1, value2, "dailyExpend");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Date value) {
            addCriterionForJDBCDate("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Date value) {
            addCriterionForJDBCDate("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Date value) {
            addCriterionForJDBCDate("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Date value) {
            addCriterionForJDBCDate("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Date> values) {
            addCriterionForJDBCDate("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Date> values) {
            addCriterionForJDBCDate("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("term not between", value1, value2, "term");
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