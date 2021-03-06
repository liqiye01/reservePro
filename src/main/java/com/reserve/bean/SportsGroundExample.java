package com.reserve.bean;

import java.util.ArrayList;
import java.util.List;

public class SportsGroundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SportsGroundExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
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

        public Criteria andSpaceIsNull() {
            addCriterion("space is null");
            return (Criteria) this;
        }

        public Criteria andSpaceIsNotNull() {
            addCriterion("space is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceEqualTo(Integer value) {
            addCriterion("space =", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotEqualTo(Integer value) {
            addCriterion("space <>", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThan(Integer value) {
            addCriterion("space >", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("space >=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThan(Integer value) {
            addCriterion("space <", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("space <=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceIn(List<Integer> values) {
            addCriterion("space in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotIn(List<Integer> values) {
            addCriterion("space not in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceBetween(Integer value1, Integer value2) {
            addCriterion("space between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("space not between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdIsNull() {
            addCriterion("time_arrange_id is null");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdIsNotNull() {
            addCriterion("time_arrange_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdEqualTo(String value) {
            addCriterion("time_arrange_id =", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdNotEqualTo(String value) {
            addCriterion("time_arrange_id <>", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdGreaterThan(String value) {
            addCriterion("time_arrange_id >", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdGreaterThanOrEqualTo(String value) {
            addCriterion("time_arrange_id >=", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdLessThan(String value) {
            addCriterion("time_arrange_id <", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdLessThanOrEqualTo(String value) {
            addCriterion("time_arrange_id <=", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdLike(String value) {
            addCriterion("time_arrange_id like", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdNotLike(String value) {
            addCriterion("time_arrange_id not like", value, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdIn(List<String> values) {
            addCriterion("time_arrange_id in", values, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdNotIn(List<String> values) {
            addCriterion("time_arrange_id not in", values, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdBetween(String value1, String value2) {
            addCriterion("time_arrange_id between", value1, value2, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andTimeArrangeIdNotBetween(String value1, String value2) {
            addCriterion("time_arrange_id not between", value1, value2, "timeArrangeId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdIsNull() {
            addCriterion("predict_person_id is null");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdIsNotNull() {
            addCriterion("predict_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdEqualTo(String value) {
            addCriterion("predict_person_id =", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdNotEqualTo(String value) {
            addCriterion("predict_person_id <>", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdGreaterThan(String value) {
            addCriterion("predict_person_id >", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("predict_person_id >=", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdLessThan(String value) {
            addCriterion("predict_person_id <", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdLessThanOrEqualTo(String value) {
            addCriterion("predict_person_id <=", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdLike(String value) {
            addCriterion("predict_person_id like", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdNotLike(String value) {
            addCriterion("predict_person_id not like", value, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdIn(List<String> values) {
            addCriterion("predict_person_id in", values, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdNotIn(List<String> values) {
            addCriterion("predict_person_id not in", values, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdBetween(String value1, String value2) {
            addCriterion("predict_person_id between", value1, value2, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andPredictPersonIdNotBetween(String value1, String value2) {
            addCriterion("predict_person_id not between", value1, value2, "predictPersonId");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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