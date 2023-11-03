package com.scwl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupervisionRectifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @return 
     */
    public SupervisionRectifyExample() {
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

        public Criteria andHeadLineIsNull() {
            addCriterion("head_line is null");
            return (Criteria) this;
        }

        public Criteria andHeadLineIsNotNull() {
            addCriterion("head_line is not null");
            return (Criteria) this;
        }

        public Criteria andHeadLineEqualTo(String value) {
            addCriterion("head_line =", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineNotEqualTo(String value) {
            addCriterion("head_line <>", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineGreaterThan(String value) {
            addCriterion("head_line >", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineGreaterThanOrEqualTo(String value) {
            addCriterion("head_line >=", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineLessThan(String value) {
            addCriterion("head_line <", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineLessThanOrEqualTo(String value) {
            addCriterion("head_line <=", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineLike(String value) {
            addCriterion("head_line like", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineNotLike(String value) {
            addCriterion("head_line not like", value, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineIn(List<String> values) {
            addCriterion("head_line in", values, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineNotIn(List<String> values) {
            addCriterion("head_line not in", values, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineBetween(String value1, String value2) {
            addCriterion("head_line between", value1, value2, "headLine");
            return (Criteria) this;
        }

        public Criteria andHeadLineNotBetween(String value1, String value2) {
            addCriterion("head_line not between", value1, value2, "headLine");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonIsNull() {
            addCriterion("rectify_person is null");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonIsNotNull() {
            addCriterion("rectify_person is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonEqualTo(String value) {
            addCriterion("rectify_person =", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonNotEqualTo(String value) {
            addCriterion("rectify_person <>", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonGreaterThan(String value) {
            addCriterion("rectify_person >", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("rectify_person >=", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonLessThan(String value) {
            addCriterion("rectify_person <", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonLessThanOrEqualTo(String value) {
            addCriterion("rectify_person <=", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonLike(String value) {
            addCriterion("rectify_person like", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonNotLike(String value) {
            addCriterion("rectify_person not like", value, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonIn(List<String> values) {
            addCriterion("rectify_person in", values, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonNotIn(List<String> values) {
            addCriterion("rectify_person not in", values, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonBetween(String value1, String value2) {
            addCriterion("rectify_person between", value1, value2, "rectifyPerson");
            return (Criteria) this;
        }

        public Criteria andRectifyPersonNotBetween(String value1, String value2) {
            addCriterion("rectify_person not between", value1, value2, "rectifyPerson");
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

        public Criteria andTitleIdsIsNull() {
            addCriterion("title_ids is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdsIsNotNull() {
            addCriterion("title_ids is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdsEqualTo(String value) {
            addCriterion("title_ids =", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsNotEqualTo(String value) {
            addCriterion("title_ids <>", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsGreaterThan(String value) {
            addCriterion("title_ids >", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsGreaterThanOrEqualTo(String value) {
            addCriterion("title_ids >=", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsLessThan(String value) {
            addCriterion("title_ids <", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsLessThanOrEqualTo(String value) {
            addCriterion("title_ids <=", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsLike(String value) {
            addCriterion("title_ids like", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsNotLike(String value) {
            addCriterion("title_ids not like", value, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsIn(List<String> values) {
            addCriterion("title_ids in", values, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsNotIn(List<String> values) {
            addCriterion("title_ids not in", values, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsBetween(String value1, String value2) {
            addCriterion("title_ids between", value1, value2, "titleIds");
            return (Criteria) this;
        }

        public Criteria andTitleIdsNotBetween(String value1, String value2) {
            addCriterion("title_ids not between", value1, value2, "titleIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsIsNull() {
            addCriterion("matter_ids is null");
            return (Criteria) this;
        }

        public Criteria andMatterIdsIsNotNull() {
            addCriterion("matter_ids is not null");
            return (Criteria) this;
        }

        public Criteria andMatterIdsEqualTo(String value) {
            addCriterion("matter_ids =", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsNotEqualTo(String value) {
            addCriterion("matter_ids <>", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsGreaterThan(String value) {
            addCriterion("matter_ids >", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsGreaterThanOrEqualTo(String value) {
            addCriterion("matter_ids >=", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsLessThan(String value) {
            addCriterion("matter_ids <", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsLessThanOrEqualTo(String value) {
            addCriterion("matter_ids <=", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsLike(String value) {
            addCriterion("matter_ids like", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsNotLike(String value) {
            addCriterion("matter_ids not like", value, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsIn(List<String> values) {
            addCriterion("matter_ids in", values, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsNotIn(List<String> values) {
            addCriterion("matter_ids not in", values, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsBetween(String value1, String value2) {
            addCriterion("matter_ids between", value1, value2, "matterIds");
            return (Criteria) this;
        }

        public Criteria andMatterIdsNotBetween(String value1, String value2) {
            addCriterion("matter_ids not between", value1, value2, "matterIds");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeIsNull() {
            addCriterion("supervision_scope is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeIsNotNull() {
            addCriterion("supervision_scope is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeEqualTo(String value) {
            addCriterion("supervision_scope =", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeNotEqualTo(String value) {
            addCriterion("supervision_scope <>", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeGreaterThan(String value) {
            addCriterion("supervision_scope >", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_scope >=", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeLessThan(String value) {
            addCriterion("supervision_scope <", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeLessThanOrEqualTo(String value) {
            addCriterion("supervision_scope <=", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeLike(String value) {
            addCriterion("supervision_scope like", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeNotLike(String value) {
            addCriterion("supervision_scope not like", value, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeIn(List<String> values) {
            addCriterion("supervision_scope in", values, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeNotIn(List<String> values) {
            addCriterion("supervision_scope not in", values, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeBetween(String value1, String value2) {
            addCriterion("supervision_scope between", value1, value2, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionScopeNotBetween(String value1, String value2) {
            addCriterion("supervision_scope not between", value1, value2, "supervisionScope");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayIsNull() {
            addCriterion("supervision_way is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayIsNotNull() {
            addCriterion("supervision_way is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayEqualTo(String value) {
            addCriterion("supervision_way =", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayNotEqualTo(String value) {
            addCriterion("supervision_way <>", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayGreaterThan(String value) {
            addCriterion("supervision_way >", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_way >=", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayLessThan(String value) {
            addCriterion("supervision_way <", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayLessThanOrEqualTo(String value) {
            addCriterion("supervision_way <=", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayLike(String value) {
            addCriterion("supervision_way like", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayNotLike(String value) {
            addCriterion("supervision_way not like", value, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayIn(List<String> values) {
            addCriterion("supervision_way in", values, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayNotIn(List<String> values) {
            addCriterion("supervision_way not in", values, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayBetween(String value1, String value2) {
            addCriterion("supervision_way between", value1, value2, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andSupervisionWayNotBetween(String value1, String value2) {
            addCriterion("supervision_way not between", value1, value2, "supervisionWay");
            return (Criteria) this;
        }

        public Criteria andExistingProblemIsNull() {
            addCriterion("existing_problem is null");
            return (Criteria) this;
        }

        public Criteria andExistingProblemIsNotNull() {
            addCriterion("existing_problem is not null");
            return (Criteria) this;
        }

        public Criteria andExistingProblemEqualTo(String value) {
            addCriterion("existing_problem =", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemNotEqualTo(String value) {
            addCriterion("existing_problem <>", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemGreaterThan(String value) {
            addCriterion("existing_problem >", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemGreaterThanOrEqualTo(String value) {
            addCriterion("existing_problem >=", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemLessThan(String value) {
            addCriterion("existing_problem <", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemLessThanOrEqualTo(String value) {
            addCriterion("existing_problem <=", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemLike(String value) {
            addCriterion("existing_problem like", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemNotLike(String value) {
            addCriterion("existing_problem not like", value, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemIn(List<String> values) {
            addCriterion("existing_problem in", values, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemNotIn(List<String> values) {
            addCriterion("existing_problem not in", values, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemBetween(String value1, String value2) {
            addCriterion("existing_problem between", value1, value2, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andExistingProblemNotBetween(String value1, String value2) {
            addCriterion("existing_problem not between", value1, value2, "existingProblem");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsIsNull() {
            addCriterion("business_tips is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsIsNotNull() {
            addCriterion("business_tips is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsEqualTo(String value) {
            addCriterion("business_tips =", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotEqualTo(String value) {
            addCriterion("business_tips <>", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsGreaterThan(String value) {
            addCriterion("business_tips >", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsGreaterThanOrEqualTo(String value) {
            addCriterion("business_tips >=", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsLessThan(String value) {
            addCriterion("business_tips <", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsLessThanOrEqualTo(String value) {
            addCriterion("business_tips <=", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsLike(String value) {
            addCriterion("business_tips like", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotLike(String value) {
            addCriterion("business_tips not like", value, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsIn(List<String> values) {
            addCriterion("business_tips in", values, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotIn(List<String> values) {
            addCriterion("business_tips not in", values, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsBetween(String value1, String value2) {
            addCriterion("business_tips between", value1, value2, "businessTips");
            return (Criteria) this;
        }

        public Criteria andBusinessTipsNotBetween(String value1, String value2) {
            addCriterion("business_tips not between", value1, value2, "businessTips");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyIsNull() {
            addCriterion("rectify_reply is null");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyIsNotNull() {
            addCriterion("rectify_reply is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyEqualTo(String value) {
            addCriterion("rectify_reply =", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyNotEqualTo(String value) {
            addCriterion("rectify_reply <>", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyGreaterThan(String value) {
            addCriterion("rectify_reply >", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyGreaterThanOrEqualTo(String value) {
            addCriterion("rectify_reply >=", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyLessThan(String value) {
            addCriterion("rectify_reply <", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyLessThanOrEqualTo(String value) {
            addCriterion("rectify_reply <=", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyLike(String value) {
            addCriterion("rectify_reply like", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyNotLike(String value) {
            addCriterion("rectify_reply not like", value, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyIn(List<String> values) {
            addCriterion("rectify_reply in", values, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyNotIn(List<String> values) {
            addCriterion("rectify_reply not in", values, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyBetween(String value1, String value2) {
            addCriterion("rectify_reply between", value1, value2, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andRectifyReplyNotBetween(String value1, String value2) {
            addCriterion("rectify_reply not between", value1, value2, "rectifyReply");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
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
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
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