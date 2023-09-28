package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CostManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostManageExample() {
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

        public Criteria andPayOutWageIsNull() {
            addCriterion("pay_out_wage is null");
            return (Criteria) this;
        }

        public Criteria andPayOutWageIsNotNull() {
            addCriterion("pay_out_wage is not null");
            return (Criteria) this;
        }

        public Criteria andPayOutWageEqualTo(BigDecimal value) {
            addCriterion("pay_out_wage =", value, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageNotEqualTo(BigDecimal value) {
            addCriterion("pay_out_wage <>", value, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageGreaterThan(BigDecimal value) {
            addCriterion("pay_out_wage >", value, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_out_wage >=", value, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageLessThan(BigDecimal value) {
            addCriterion("pay_out_wage <", value, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_out_wage <=", value, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageIn(List<BigDecimal> values) {
            addCriterion("pay_out_wage in", values, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageNotIn(List<BigDecimal> values) {
            addCriterion("pay_out_wage not in", values, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_out_wage between", value1, value2, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andPayOutWageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_out_wage not between", value1, value2, "payOutWage");
            return (Criteria) this;
        }

        public Criteria andRentIsNull() {
            addCriterion("rent is null");
            return (Criteria) this;
        }

        public Criteria andRentIsNotNull() {
            addCriterion("rent is not null");
            return (Criteria) this;
        }

        public Criteria andRentEqualTo(BigDecimal value) {
            addCriterion("rent =", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotEqualTo(BigDecimal value) {
            addCriterion("rent <>", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThan(BigDecimal value) {
            addCriterion("rent >", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rent >=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThan(BigDecimal value) {
            addCriterion("rent <", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rent <=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentIn(List<BigDecimal> values) {
            addCriterion("rent in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotIn(List<BigDecimal> values) {
            addCriterion("rent not in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent not between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeIsNull() {
            addCriterion("hydropower_office is null");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeIsNotNull() {
            addCriterion("hydropower_office is not null");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeEqualTo(BigDecimal value) {
            addCriterion("hydropower_office =", value, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeNotEqualTo(BigDecimal value) {
            addCriterion("hydropower_office <>", value, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeGreaterThan(BigDecimal value) {
            addCriterion("hydropower_office >", value, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hydropower_office >=", value, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeLessThan(BigDecimal value) {
            addCriterion("hydropower_office <", value, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hydropower_office <=", value, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeIn(List<BigDecimal> values) {
            addCriterion("hydropower_office in", values, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeNotIn(List<BigDecimal> values) {
            addCriterion("hydropower_office not in", values, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hydropower_office between", value1, value2, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andHydropowerOfficeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hydropower_office not between", value1, value2, "hydropowerOffice");
            return (Criteria) this;
        }

        public Criteria andLaborUnionIsNull() {
            addCriterion("labor_union is null");
            return (Criteria) this;
        }

        public Criteria andLaborUnionIsNotNull() {
            addCriterion("labor_union is not null");
            return (Criteria) this;
        }

        public Criteria andLaborUnionEqualTo(BigDecimal value) {
            addCriterion("labor_union =", value, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionNotEqualTo(BigDecimal value) {
            addCriterion("labor_union <>", value, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionGreaterThan(BigDecimal value) {
            addCriterion("labor_union >", value, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("labor_union >=", value, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionLessThan(BigDecimal value) {
            addCriterion("labor_union <", value, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("labor_union <=", value, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionIn(List<BigDecimal> values) {
            addCriterion("labor_union in", values, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionNotIn(List<BigDecimal> values) {
            addCriterion("labor_union not in", values, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labor_union between", value1, value2, "laborUnion");
            return (Criteria) this;
        }

        public Criteria andLaborUnionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labor_union not between", value1, value2, "laborUnion");
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