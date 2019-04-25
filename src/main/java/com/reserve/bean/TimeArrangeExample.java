package com.reserve.bean;

import java.util.ArrayList;
import java.util.List;

public class TimeArrangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimeArrangeExample() {
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

        public Criteria andMonMorningIsNull() {
            addCriterion("Mon_morning is null");
            return (Criteria) this;
        }

        public Criteria andMonMorningIsNotNull() {
            addCriterion("Mon_morning is not null");
            return (Criteria) this;
        }

        public Criteria andMonMorningEqualTo(String value) {
            addCriterion("Mon_morning =", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningNotEqualTo(String value) {
            addCriterion("Mon_morning <>", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningGreaterThan(String value) {
            addCriterion("Mon_morning >", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Mon_morning >=", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningLessThan(String value) {
            addCriterion("Mon_morning <", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningLessThanOrEqualTo(String value) {
            addCriterion("Mon_morning <=", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningLike(String value) {
            addCriterion("Mon_morning like", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningNotLike(String value) {
            addCriterion("Mon_morning not like", value, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningIn(List<String> values) {
            addCriterion("Mon_morning in", values, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningNotIn(List<String> values) {
            addCriterion("Mon_morning not in", values, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningBetween(String value1, String value2) {
            addCriterion("Mon_morning between", value1, value2, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonMorningNotBetween(String value1, String value2) {
            addCriterion("Mon_morning not between", value1, value2, "monMorning");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonIsNull() {
            addCriterion("Mon_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonIsNotNull() {
            addCriterion("Mon_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonEqualTo(String value) {
            addCriterion("Mon_afternoon =", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonNotEqualTo(String value) {
            addCriterion("Mon_afternoon <>", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonGreaterThan(String value) {
            addCriterion("Mon_afternoon >", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("Mon_afternoon >=", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonLessThan(String value) {
            addCriterion("Mon_afternoon <", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonLessThanOrEqualTo(String value) {
            addCriterion("Mon_afternoon <=", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonLike(String value) {
            addCriterion("Mon_afternoon like", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonNotLike(String value) {
            addCriterion("Mon_afternoon not like", value, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonIn(List<String> values) {
            addCriterion("Mon_afternoon in", values, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonNotIn(List<String> values) {
            addCriterion("Mon_afternoon not in", values, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonBetween(String value1, String value2) {
            addCriterion("Mon_afternoon between", value1, value2, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonAfternoonNotBetween(String value1, String value2) {
            addCriterion("Mon_afternoon not between", value1, value2, "monAfternoon");
            return (Criteria) this;
        }

        public Criteria andMonEveningIsNull() {
            addCriterion("Mon_evening is null");
            return (Criteria) this;
        }

        public Criteria andMonEveningIsNotNull() {
            addCriterion("Mon_evening is not null");
            return (Criteria) this;
        }

        public Criteria andMonEveningEqualTo(String value) {
            addCriterion("Mon_evening =", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningNotEqualTo(String value) {
            addCriterion("Mon_evening <>", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningGreaterThan(String value) {
            addCriterion("Mon_evening >", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningGreaterThanOrEqualTo(String value) {
            addCriterion("Mon_evening >=", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningLessThan(String value) {
            addCriterion("Mon_evening <", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningLessThanOrEqualTo(String value) {
            addCriterion("Mon_evening <=", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningLike(String value) {
            addCriterion("Mon_evening like", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningNotLike(String value) {
            addCriterion("Mon_evening not like", value, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningIn(List<String> values) {
            addCriterion("Mon_evening in", values, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningNotIn(List<String> values) {
            addCriterion("Mon_evening not in", values, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningBetween(String value1, String value2) {
            addCriterion("Mon_evening between", value1, value2, "monEvening");
            return (Criteria) this;
        }

        public Criteria andMonEveningNotBetween(String value1, String value2) {
            addCriterion("Mon_evening not between", value1, value2, "monEvening");
            return (Criteria) this;
        }

        public Criteria andTueMorningIsNull() {
            addCriterion("Tue_morning is null");
            return (Criteria) this;
        }

        public Criteria andTueMorningIsNotNull() {
            addCriterion("Tue_morning is not null");
            return (Criteria) this;
        }

        public Criteria andTueMorningEqualTo(String value) {
            addCriterion("Tue_morning =", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningNotEqualTo(String value) {
            addCriterion("Tue_morning <>", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningGreaterThan(String value) {
            addCriterion("Tue_morning >", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Tue_morning >=", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningLessThan(String value) {
            addCriterion("Tue_morning <", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningLessThanOrEqualTo(String value) {
            addCriterion("Tue_morning <=", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningLike(String value) {
            addCriterion("Tue_morning like", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningNotLike(String value) {
            addCriterion("Tue_morning not like", value, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningIn(List<String> values) {
            addCriterion("Tue_morning in", values, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningNotIn(List<String> values) {
            addCriterion("Tue_morning not in", values, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningBetween(String value1, String value2) {
            addCriterion("Tue_morning between", value1, value2, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueMorningNotBetween(String value1, String value2) {
            addCriterion("Tue_morning not between", value1, value2, "tueMorning");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonIsNull() {
            addCriterion("\"Tue_afternoon\" is null");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonIsNotNull() {
            addCriterion("\"Tue_afternoon\" is not null");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonEqualTo(String value) {
            addCriterion("\"Tue_afternoon\" =", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonNotEqualTo(String value) {
            addCriterion("\"Tue_afternoon\" <>", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonGreaterThan(String value) {
            addCriterion("\"Tue_afternoon\" >", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("\"Tue_afternoon\" >=", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonLessThan(String value) {
            addCriterion("\"Tue_afternoon\" <", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonLessThanOrEqualTo(String value) {
            addCriterion("\"Tue_afternoon\" <=", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonLike(String value) {
            addCriterion("\"Tue_afternoon\" like", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonNotLike(String value) {
            addCriterion("\"Tue_afternoon\" not like", value, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonIn(List<String> values) {
            addCriterion("\"Tue_afternoon\" in", values, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonNotIn(List<String> values) {
            addCriterion("\"Tue_afternoon\" not in", values, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonBetween(String value1, String value2) {
            addCriterion("\"Tue_afternoon\" between", value1, value2, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueAfternoonNotBetween(String value1, String value2) {
            addCriterion("\"Tue_afternoon\" not between", value1, value2, "tueAfternoon");
            return (Criteria) this;
        }

        public Criteria andTueEveningIsNull() {
            addCriterion("\"Tue_evening\" is null");
            return (Criteria) this;
        }

        public Criteria andTueEveningIsNotNull() {
            addCriterion("\"Tue_evening\" is not null");
            return (Criteria) this;
        }

        public Criteria andTueEveningEqualTo(String value) {
            addCriterion("\"Tue_evening\" =", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningNotEqualTo(String value) {
            addCriterion("\"Tue_evening\" <>", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningGreaterThan(String value) {
            addCriterion("\"Tue_evening\" >", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningGreaterThanOrEqualTo(String value) {
            addCriterion("\"Tue_evening\" >=", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningLessThan(String value) {
            addCriterion("\"Tue_evening\" <", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningLessThanOrEqualTo(String value) {
            addCriterion("\"Tue_evening\" <=", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningLike(String value) {
            addCriterion("\"Tue_evening\" like", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningNotLike(String value) {
            addCriterion("\"Tue_evening\" not like", value, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningIn(List<String> values) {
            addCriterion("\"Tue_evening\" in", values, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningNotIn(List<String> values) {
            addCriterion("\"Tue_evening\" not in", values, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningBetween(String value1, String value2) {
            addCriterion("\"Tue_evening\" between", value1, value2, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andTueEveningNotBetween(String value1, String value2) {
            addCriterion("\"Tue_evening\" not between", value1, value2, "tueEvening");
            return (Criteria) this;
        }

        public Criteria andWedMorningIsNull() {
            addCriterion("Wed_morning is null");
            return (Criteria) this;
        }

        public Criteria andWedMorningIsNotNull() {
            addCriterion("Wed_morning is not null");
            return (Criteria) this;
        }

        public Criteria andWedMorningEqualTo(String value) {
            addCriterion("Wed_morning =", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningNotEqualTo(String value) {
            addCriterion("Wed_morning <>", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningGreaterThan(String value) {
            addCriterion("Wed_morning >", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Wed_morning >=", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningLessThan(String value) {
            addCriterion("Wed_morning <", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningLessThanOrEqualTo(String value) {
            addCriterion("Wed_morning <=", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningLike(String value) {
            addCriterion("Wed_morning like", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningNotLike(String value) {
            addCriterion("Wed_morning not like", value, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningIn(List<String> values) {
            addCriterion("Wed_morning in", values, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningNotIn(List<String> values) {
            addCriterion("Wed_morning not in", values, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningBetween(String value1, String value2) {
            addCriterion("Wed_morning between", value1, value2, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedMorningNotBetween(String value1, String value2) {
            addCriterion("Wed_morning not between", value1, value2, "wedMorning");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonIsNull() {
            addCriterion("Wed_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonIsNotNull() {
            addCriterion("Wed_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonEqualTo(String value) {
            addCriterion("Wed_afternoon =", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonNotEqualTo(String value) {
            addCriterion("Wed_afternoon <>", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonGreaterThan(String value) {
            addCriterion("Wed_afternoon >", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("Wed_afternoon >=", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonLessThan(String value) {
            addCriterion("Wed_afternoon <", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonLessThanOrEqualTo(String value) {
            addCriterion("Wed_afternoon <=", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonLike(String value) {
            addCriterion("Wed_afternoon like", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonNotLike(String value) {
            addCriterion("Wed_afternoon not like", value, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonIn(List<String> values) {
            addCriterion("Wed_afternoon in", values, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonNotIn(List<String> values) {
            addCriterion("Wed_afternoon not in", values, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonBetween(String value1, String value2) {
            addCriterion("Wed_afternoon between", value1, value2, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedAfternoonNotBetween(String value1, String value2) {
            addCriterion("Wed_afternoon not between", value1, value2, "wedAfternoon");
            return (Criteria) this;
        }

        public Criteria andWedEveningIsNull() {
            addCriterion("Wed_evening is null");
            return (Criteria) this;
        }

        public Criteria andWedEveningIsNotNull() {
            addCriterion("Wed_evening is not null");
            return (Criteria) this;
        }

        public Criteria andWedEveningEqualTo(String value) {
            addCriterion("Wed_evening =", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningNotEqualTo(String value) {
            addCriterion("Wed_evening <>", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningGreaterThan(String value) {
            addCriterion("Wed_evening >", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningGreaterThanOrEqualTo(String value) {
            addCriterion("Wed_evening >=", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningLessThan(String value) {
            addCriterion("Wed_evening <", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningLessThanOrEqualTo(String value) {
            addCriterion("Wed_evening <=", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningLike(String value) {
            addCriterion("Wed_evening like", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningNotLike(String value) {
            addCriterion("Wed_evening not like", value, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningIn(List<String> values) {
            addCriterion("Wed_evening in", values, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningNotIn(List<String> values) {
            addCriterion("Wed_evening not in", values, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningBetween(String value1, String value2) {
            addCriterion("Wed_evening between", value1, value2, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andWedEveningNotBetween(String value1, String value2) {
            addCriterion("Wed_evening not between", value1, value2, "wedEvening");
            return (Criteria) this;
        }

        public Criteria andThuMorningIsNull() {
            addCriterion("Thu_morning is null");
            return (Criteria) this;
        }

        public Criteria andThuMorningIsNotNull() {
            addCriterion("Thu_morning is not null");
            return (Criteria) this;
        }

        public Criteria andThuMorningEqualTo(String value) {
            addCriterion("Thu_morning =", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningNotEqualTo(String value) {
            addCriterion("Thu_morning <>", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningGreaterThan(String value) {
            addCriterion("Thu_morning >", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Thu_morning >=", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningLessThan(String value) {
            addCriterion("Thu_morning <", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningLessThanOrEqualTo(String value) {
            addCriterion("Thu_morning <=", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningLike(String value) {
            addCriterion("Thu_morning like", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningNotLike(String value) {
            addCriterion("Thu_morning not like", value, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningIn(List<String> values) {
            addCriterion("Thu_morning in", values, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningNotIn(List<String> values) {
            addCriterion("Thu_morning not in", values, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningBetween(String value1, String value2) {
            addCriterion("Thu_morning between", value1, value2, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuMorningNotBetween(String value1, String value2) {
            addCriterion("Thu_morning not between", value1, value2, "thuMorning");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonIsNull() {
            addCriterion("Thu_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonIsNotNull() {
            addCriterion("Thu_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonEqualTo(String value) {
            addCriterion("Thu_afternoon =", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonNotEqualTo(String value) {
            addCriterion("Thu_afternoon <>", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonGreaterThan(String value) {
            addCriterion("Thu_afternoon >", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("Thu_afternoon >=", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonLessThan(String value) {
            addCriterion("Thu_afternoon <", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonLessThanOrEqualTo(String value) {
            addCriterion("Thu_afternoon <=", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonLike(String value) {
            addCriterion("Thu_afternoon like", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonNotLike(String value) {
            addCriterion("Thu_afternoon not like", value, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonIn(List<String> values) {
            addCriterion("Thu_afternoon in", values, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonNotIn(List<String> values) {
            addCriterion("Thu_afternoon not in", values, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonBetween(String value1, String value2) {
            addCriterion("Thu_afternoon between", value1, value2, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuAfternoonNotBetween(String value1, String value2) {
            addCriterion("Thu_afternoon not between", value1, value2, "thuAfternoon");
            return (Criteria) this;
        }

        public Criteria andThuEveningIsNull() {
            addCriterion("Thu_evening is null");
            return (Criteria) this;
        }

        public Criteria andThuEveningIsNotNull() {
            addCriterion("Thu_evening is not null");
            return (Criteria) this;
        }

        public Criteria andThuEveningEqualTo(String value) {
            addCriterion("Thu_evening =", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningNotEqualTo(String value) {
            addCriterion("Thu_evening <>", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningGreaterThan(String value) {
            addCriterion("Thu_evening >", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningGreaterThanOrEqualTo(String value) {
            addCriterion("Thu_evening >=", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningLessThan(String value) {
            addCriterion("Thu_evening <", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningLessThanOrEqualTo(String value) {
            addCriterion("Thu_evening <=", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningLike(String value) {
            addCriterion("Thu_evening like", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningNotLike(String value) {
            addCriterion("Thu_evening not like", value, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningIn(List<String> values) {
            addCriterion("Thu_evening in", values, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningNotIn(List<String> values) {
            addCriterion("Thu_evening not in", values, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningBetween(String value1, String value2) {
            addCriterion("Thu_evening between", value1, value2, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andThuEveningNotBetween(String value1, String value2) {
            addCriterion("Thu_evening not between", value1, value2, "thuEvening");
            return (Criteria) this;
        }

        public Criteria andFriMorningIsNull() {
            addCriterion("Fri_morning is null");
            return (Criteria) this;
        }

        public Criteria andFriMorningIsNotNull() {
            addCriterion("Fri_morning is not null");
            return (Criteria) this;
        }

        public Criteria andFriMorningEqualTo(String value) {
            addCriterion("Fri_morning =", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningNotEqualTo(String value) {
            addCriterion("Fri_morning <>", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningGreaterThan(String value) {
            addCriterion("Fri_morning >", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Fri_morning >=", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningLessThan(String value) {
            addCriterion("Fri_morning <", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningLessThanOrEqualTo(String value) {
            addCriterion("Fri_morning <=", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningLike(String value) {
            addCriterion("Fri_morning like", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningNotLike(String value) {
            addCriterion("Fri_morning not like", value, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningIn(List<String> values) {
            addCriterion("Fri_morning in", values, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningNotIn(List<String> values) {
            addCriterion("Fri_morning not in", values, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningBetween(String value1, String value2) {
            addCriterion("Fri_morning between", value1, value2, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriMorningNotBetween(String value1, String value2) {
            addCriterion("Fri_morning not between", value1, value2, "friMorning");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonIsNull() {
            addCriterion("Fri_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonIsNotNull() {
            addCriterion("Fri_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonEqualTo(String value) {
            addCriterion("Fri_afternoon =", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonNotEqualTo(String value) {
            addCriterion("Fri_afternoon <>", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonGreaterThan(String value) {
            addCriterion("Fri_afternoon >", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("Fri_afternoon >=", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonLessThan(String value) {
            addCriterion("Fri_afternoon <", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonLessThanOrEqualTo(String value) {
            addCriterion("Fri_afternoon <=", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonLike(String value) {
            addCriterion("Fri_afternoon like", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonNotLike(String value) {
            addCriterion("Fri_afternoon not like", value, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonIn(List<String> values) {
            addCriterion("Fri_afternoon in", values, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonNotIn(List<String> values) {
            addCriterion("Fri_afternoon not in", values, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonBetween(String value1, String value2) {
            addCriterion("Fri_afternoon between", value1, value2, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriAfternoonNotBetween(String value1, String value2) {
            addCriterion("Fri_afternoon not between", value1, value2, "friAfternoon");
            return (Criteria) this;
        }

        public Criteria andFriEveningIsNull() {
            addCriterion("Fri_evening is null");
            return (Criteria) this;
        }

        public Criteria andFriEveningIsNotNull() {
            addCriterion("Fri_evening is not null");
            return (Criteria) this;
        }

        public Criteria andFriEveningEqualTo(String value) {
            addCriterion("Fri_evening =", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningNotEqualTo(String value) {
            addCriterion("Fri_evening <>", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningGreaterThan(String value) {
            addCriterion("Fri_evening >", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningGreaterThanOrEqualTo(String value) {
            addCriterion("Fri_evening >=", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningLessThan(String value) {
            addCriterion("Fri_evening <", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningLessThanOrEqualTo(String value) {
            addCriterion("Fri_evening <=", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningLike(String value) {
            addCriterion("Fri_evening like", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningNotLike(String value) {
            addCriterion("Fri_evening not like", value, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningIn(List<String> values) {
            addCriterion("Fri_evening in", values, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningNotIn(List<String> values) {
            addCriterion("Fri_evening not in", values, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningBetween(String value1, String value2) {
            addCriterion("Fri_evening between", value1, value2, "friEvening");
            return (Criteria) this;
        }

        public Criteria andFriEveningNotBetween(String value1, String value2) {
            addCriterion("Fri_evening not between", value1, value2, "friEvening");
            return (Criteria) this;
        }

        public Criteria andSatMorningIsNull() {
            addCriterion("Sat_morning is null");
            return (Criteria) this;
        }

        public Criteria andSatMorningIsNotNull() {
            addCriterion("Sat_morning is not null");
            return (Criteria) this;
        }

        public Criteria andSatMorningEqualTo(String value) {
            addCriterion("Sat_morning =", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningNotEqualTo(String value) {
            addCriterion("Sat_morning <>", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningGreaterThan(String value) {
            addCriterion("Sat_morning >", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Sat_morning >=", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningLessThan(String value) {
            addCriterion("Sat_morning <", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningLessThanOrEqualTo(String value) {
            addCriterion("Sat_morning <=", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningLike(String value) {
            addCriterion("Sat_morning like", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningNotLike(String value) {
            addCriterion("Sat_morning not like", value, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningIn(List<String> values) {
            addCriterion("Sat_morning in", values, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningNotIn(List<String> values) {
            addCriterion("Sat_morning not in", values, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningBetween(String value1, String value2) {
            addCriterion("Sat_morning between", value1, value2, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatMorningNotBetween(String value1, String value2) {
            addCriterion("Sat_morning not between", value1, value2, "satMorning");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonIsNull() {
            addCriterion("Sat_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonIsNotNull() {
            addCriterion("Sat_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonEqualTo(String value) {
            addCriterion("Sat_afternoon =", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonNotEqualTo(String value) {
            addCriterion("Sat_afternoon <>", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonGreaterThan(String value) {
            addCriterion("Sat_afternoon >", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("Sat_afternoon >=", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonLessThan(String value) {
            addCriterion("Sat_afternoon <", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonLessThanOrEqualTo(String value) {
            addCriterion("Sat_afternoon <=", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonLike(String value) {
            addCriterion("Sat_afternoon like", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonNotLike(String value) {
            addCriterion("Sat_afternoon not like", value, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonIn(List<String> values) {
            addCriterion("Sat_afternoon in", values, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonNotIn(List<String> values) {
            addCriterion("Sat_afternoon not in", values, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonBetween(String value1, String value2) {
            addCriterion("Sat_afternoon between", value1, value2, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatAfternoonNotBetween(String value1, String value2) {
            addCriterion("Sat_afternoon not between", value1, value2, "satAfternoon");
            return (Criteria) this;
        }

        public Criteria andSatEveningIsNull() {
            addCriterion("Sat_evening is null");
            return (Criteria) this;
        }

        public Criteria andSatEveningIsNotNull() {
            addCriterion("Sat_evening is not null");
            return (Criteria) this;
        }

        public Criteria andSatEveningEqualTo(String value) {
            addCriterion("Sat_evening =", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningNotEqualTo(String value) {
            addCriterion("Sat_evening <>", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningGreaterThan(String value) {
            addCriterion("Sat_evening >", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningGreaterThanOrEqualTo(String value) {
            addCriterion("Sat_evening >=", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningLessThan(String value) {
            addCriterion("Sat_evening <", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningLessThanOrEqualTo(String value) {
            addCriterion("Sat_evening <=", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningLike(String value) {
            addCriterion("Sat_evening like", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningNotLike(String value) {
            addCriterion("Sat_evening not like", value, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningIn(List<String> values) {
            addCriterion("Sat_evening in", values, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningNotIn(List<String> values) {
            addCriterion("Sat_evening not in", values, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningBetween(String value1, String value2) {
            addCriterion("Sat_evening between", value1, value2, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSatEveningNotBetween(String value1, String value2) {
            addCriterion("Sat_evening not between", value1, value2, "satEvening");
            return (Criteria) this;
        }

        public Criteria andSunMorningIsNull() {
            addCriterion("Sun_morning is null");
            return (Criteria) this;
        }

        public Criteria andSunMorningIsNotNull() {
            addCriterion("Sun_morning is not null");
            return (Criteria) this;
        }

        public Criteria andSunMorningEqualTo(String value) {
            addCriterion("Sun_morning =", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningNotEqualTo(String value) {
            addCriterion("Sun_morning <>", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningGreaterThan(String value) {
            addCriterion("Sun_morning >", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningGreaterThanOrEqualTo(String value) {
            addCriterion("Sun_morning >=", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningLessThan(String value) {
            addCriterion("Sun_morning <", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningLessThanOrEqualTo(String value) {
            addCriterion("Sun_morning <=", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningLike(String value) {
            addCriterion("Sun_morning like", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningNotLike(String value) {
            addCriterion("Sun_morning not like", value, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningIn(List<String> values) {
            addCriterion("Sun_morning in", values, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningNotIn(List<String> values) {
            addCriterion("Sun_morning not in", values, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningBetween(String value1, String value2) {
            addCriterion("Sun_morning between", value1, value2, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunMorningNotBetween(String value1, String value2) {
            addCriterion("Sun_morning not between", value1, value2, "sunMorning");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonIsNull() {
            addCriterion("Sun_afternoon is null");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonIsNotNull() {
            addCriterion("Sun_afternoon is not null");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonEqualTo(String value) {
            addCriterion("Sun_afternoon =", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonNotEqualTo(String value) {
            addCriterion("Sun_afternoon <>", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonGreaterThan(String value) {
            addCriterion("Sun_afternoon >", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonGreaterThanOrEqualTo(String value) {
            addCriterion("Sun_afternoon >=", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonLessThan(String value) {
            addCriterion("Sun_afternoon <", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonLessThanOrEqualTo(String value) {
            addCriterion("Sun_afternoon <=", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonLike(String value) {
            addCriterion("Sun_afternoon like", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonNotLike(String value) {
            addCriterion("Sun_afternoon not like", value, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonIn(List<String> values) {
            addCriterion("Sun_afternoon in", values, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonNotIn(List<String> values) {
            addCriterion("Sun_afternoon not in", values, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonBetween(String value1, String value2) {
            addCriterion("Sun_afternoon between", value1, value2, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunAfternoonNotBetween(String value1, String value2) {
            addCriterion("Sun_afternoon not between", value1, value2, "sunAfternoon");
            return (Criteria) this;
        }

        public Criteria andSunEveningIsNull() {
            addCriterion("Sun_evening is null");
            return (Criteria) this;
        }

        public Criteria andSunEveningIsNotNull() {
            addCriterion("Sun_evening is not null");
            return (Criteria) this;
        }

        public Criteria andSunEveningEqualTo(String value) {
            addCriterion("Sun_evening =", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningNotEqualTo(String value) {
            addCriterion("Sun_evening <>", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningGreaterThan(String value) {
            addCriterion("Sun_evening >", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningGreaterThanOrEqualTo(String value) {
            addCriterion("Sun_evening >=", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningLessThan(String value) {
            addCriterion("Sun_evening <", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningLessThanOrEqualTo(String value) {
            addCriterion("Sun_evening <=", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningLike(String value) {
            addCriterion("Sun_evening like", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningNotLike(String value) {
            addCriterion("Sun_evening not like", value, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningIn(List<String> values) {
            addCriterion("Sun_evening in", values, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningNotIn(List<String> values) {
            addCriterion("Sun_evening not in", values, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningBetween(String value1, String value2) {
            addCriterion("Sun_evening between", value1, value2, "sunEvening");
            return (Criteria) this;
        }

        public Criteria andSunEveningNotBetween(String value1, String value2) {
            addCriterion("Sun_evening not between", value1, value2, "sunEvening");
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