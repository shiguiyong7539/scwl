package com.scwl.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RentLeaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @return 
     */
    public RentLeaseInfoExample() {
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

        public Criteria andLesseeIdIsNull() {
            addCriterion("lessee_id is null");
            return (Criteria) this;
        }

        public Criteria andLesseeIdIsNotNull() {
            addCriterion("lessee_id is not null");
            return (Criteria) this;
        }

        public Criteria andLesseeIdEqualTo(Integer value) {
            addCriterion("lessee_id =", value, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdNotEqualTo(Integer value) {
            addCriterion("lessee_id <>", value, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdGreaterThan(Integer value) {
            addCriterion("lessee_id >", value, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lessee_id >=", value, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdLessThan(Integer value) {
            addCriterion("lessee_id <", value, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdLessThanOrEqualTo(Integer value) {
            addCriterion("lessee_id <=", value, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdIn(List<Integer> values) {
            addCriterion("lessee_id in", values, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdNotIn(List<Integer> values) {
            addCriterion("lessee_id not in", values, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdBetween(Integer value1, Integer value2) {
            addCriterion("lessee_id between", value1, value2, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andLesseeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lessee_id not between", value1, value2, "lesseeId");
            return (Criteria) this;
        }

        public Criteria andAssetIdIsNull() {
            addCriterion("asset_id is null");
            return (Criteria) this;
        }

        public Criteria andAssetIdIsNotNull() {
            addCriterion("asset_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssetIdEqualTo(Integer value) {
            addCriterion("asset_id =", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotEqualTo(Integer value) {
            addCriterion("asset_id <>", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdGreaterThan(Integer value) {
            addCriterion("asset_id >", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("asset_id >=", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdLessThan(Integer value) {
            addCriterion("asset_id <", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdLessThanOrEqualTo(Integer value) {
            addCriterion("asset_id <=", value, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdIn(List<Integer> values) {
            addCriterion("asset_id in", values, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotIn(List<Integer> values) {
            addCriterion("asset_id not in", values, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdBetween(Integer value1, Integer value2) {
            addCriterion("asset_id between", value1, value2, "assetId");
            return (Criteria) this;
        }

        public Criteria andAssetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("asset_id not between", value1, value2, "assetId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRentCycleIsNull() {
            addCriterion("rent_cycle is null");
            return (Criteria) this;
        }

        public Criteria andRentCycleIsNotNull() {
            addCriterion("rent_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andRentCycleEqualTo(String value) {
            addCriterion("rent_cycle =", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleNotEqualTo(String value) {
            addCriterion("rent_cycle <>", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleGreaterThan(String value) {
            addCriterion("rent_cycle >", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleGreaterThanOrEqualTo(String value) {
            addCriterion("rent_cycle >=", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleLessThan(String value) {
            addCriterion("rent_cycle <", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleLessThanOrEqualTo(String value) {
            addCriterion("rent_cycle <=", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleLike(String value) {
            addCriterion("rent_cycle like", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleNotLike(String value) {
            addCriterion("rent_cycle not like", value, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleIn(List<String> values) {
            addCriterion("rent_cycle in", values, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleNotIn(List<String> values) {
            addCriterion("rent_cycle not in", values, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleBetween(String value1, String value2) {
            addCriterion("rent_cycle between", value1, value2, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andRentCycleNotBetween(String value1, String value2) {
            addCriterion("rent_cycle not between", value1, value2, "rentCycle");
            return (Criteria) this;
        }

        public Criteria andLeaseDateIsNull() {
            addCriterion("lease_date is null");
            return (Criteria) this;
        }

        public Criteria andLeaseDateIsNotNull() {
            addCriterion("lease_date is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseDateEqualTo(Date value) {
            addCriterionForJDBCDate("lease_date =", value, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("lease_date <>", value, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("lease_date >", value, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_date >=", value, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateLessThan(Date value) {
            addCriterionForJDBCDate("lease_date <", value, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_date <=", value, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateIn(List<Date> values) {
            addCriterionForJDBCDate("lease_date in", values, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("lease_date not in", values, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_date between", value1, value2, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andLeaseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_date not between", value1, value2, "leaseDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Date value) {
            addCriterionForJDBCDate("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Date value) {
            addCriterionForJDBCDate("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Date> values) {
            addCriterionForJDBCDate("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNull() {
            addCriterion("expire_date is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expire_date >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Date value) {
            addCriterionForJDBCDate("expire_date <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Date> values) {
            addCriterionForJDBCDate("expire_date in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expire_date not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expire_date between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expire_date not between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateIsNull() {
            addCriterion("quit_date is null");
            return (Criteria) this;
        }

        public Criteria andQuitDateIsNotNull() {
            addCriterion("quit_date is not null");
            return (Criteria) this;
        }

        public Criteria andQuitDateEqualTo(Date value) {
            addCriterionForJDBCDate("quit_date =", value, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("quit_date <>", value, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateGreaterThan(Date value) {
            addCriterionForJDBCDate("quit_date >", value, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("quit_date >=", value, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateLessThan(Date value) {
            addCriterionForJDBCDate("quit_date <", value, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("quit_date <=", value, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateIn(List<Date> values) {
            addCriterionForJDBCDate("quit_date in", values, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("quit_date not in", values, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("quit_date between", value1, value2, "quitDate");
            return (Criteria) this;
        }

        public Criteria andQuitDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("quit_date not between", value1, value2, "quitDate");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceIsNull() {
            addCriterion("lease_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceIsNotNull() {
            addCriterion("lease_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceEqualTo(BigDecimal value) {
            addCriterion("lease_unit_price =", value, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("lease_unit_price <>", value, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("lease_unit_price >", value, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_unit_price >=", value, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceLessThan(BigDecimal value) {
            addCriterion("lease_unit_price <", value, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_unit_price <=", value, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceIn(List<BigDecimal> values) {
            addCriterion("lease_unit_price in", values, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("lease_unit_price not in", values, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_unit_price between", value1, value2, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLeaseUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_unit_price not between", value1, value2, "leaseUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCashPledgeIsNull() {
            addCriterion("cash_pledge is null");
            return (Criteria) this;
        }

        public Criteria andCashPledgeIsNotNull() {
            addCriterion("cash_pledge is not null");
            return (Criteria) this;
        }

        public Criteria andCashPledgeEqualTo(BigDecimal value) {
            addCriterion("cash_pledge =", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeNotEqualTo(BigDecimal value) {
            addCriterion("cash_pledge <>", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeGreaterThan(BigDecimal value) {
            addCriterion("cash_pledge >", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_pledge >=", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeLessThan(BigDecimal value) {
            addCriterion("cash_pledge <", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_pledge <=", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeIn(List<BigDecimal> values) {
            addCriterion("cash_pledge in", values, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeNotIn(List<BigDecimal> values) {
            addCriterion("cash_pledge not in", values, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_pledge between", value1, value2, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_pledge not between", value1, value2, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andFreeMonthIsNull() {
            addCriterion("free_month is null");
            return (Criteria) this;
        }

        public Criteria andFreeMonthIsNotNull() {
            addCriterion("free_month is not null");
            return (Criteria) this;
        }

        public Criteria andFreeMonthEqualTo(Integer value) {
            addCriterion("free_month =", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNotEqualTo(Integer value) {
            addCriterion("free_month <>", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthGreaterThan(Integer value) {
            addCriterion("free_month >", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_month >=", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthLessThan(Integer value) {
            addCriterion("free_month <", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthLessThanOrEqualTo(Integer value) {
            addCriterion("free_month <=", value, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthIn(List<Integer> values) {
            addCriterion("free_month in", values, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNotIn(List<Integer> values) {
            addCriterion("free_month not in", values, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthBetween(Integer value1, Integer value2) {
            addCriterion("free_month between", value1, value2, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("free_month not between", value1, value2, "freeMonth");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumIsNull() {
            addCriterion("free_month_num is null");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumIsNotNull() {
            addCriterion("free_month_num is not null");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumEqualTo(Integer value) {
            addCriterion("free_month_num =", value, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumNotEqualTo(Integer value) {
            addCriterion("free_month_num <>", value, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumGreaterThan(Integer value) {
            addCriterion("free_month_num >", value, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_month_num >=", value, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumLessThan(Integer value) {
            addCriterion("free_month_num <", value, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumLessThanOrEqualTo(Integer value) {
            addCriterion("free_month_num <=", value, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumIn(List<Integer> values) {
            addCriterion("free_month_num in", values, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumNotIn(List<Integer> values) {
            addCriterion("free_month_num not in", values, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumBetween(Integer value1, Integer value2) {
            addCriterion("free_month_num between", value1, value2, "freeMonthNum");
            return (Criteria) this;
        }

        public Criteria andFreeMonthNumNotBetween(Integer value1, Integer value2) {
            addCriterion("free_month_num not between", value1, value2, "freeMonthNum");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterionForJDBCDate("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterionForJDBCDate("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterionForJDBCDate("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_time not between", value1, value2, "addTime");
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