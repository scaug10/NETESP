package com.g10.ssm.po.testdatabase;

import java.util.ArrayList;
import java.util.List;

public class TestItemsDesignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestItemsDesignExample() {
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

        public Criteria andTestItemsDesignIdIsNull() {
            addCriterion("test_items_design_id is null");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdIsNotNull() {
            addCriterion("test_items_design_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdEqualTo(Integer value) {
            addCriterion("test_items_design_id =", value, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdNotEqualTo(Integer value) {
            addCriterion("test_items_design_id <>", value, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdGreaterThan(Integer value) {
            addCriterion("test_items_design_id >", value, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_items_design_id >=", value, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdLessThan(Integer value) {
            addCriterion("test_items_design_id <", value, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_items_design_id <=", value, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdIn(List<Integer> values) {
            addCriterion("test_items_design_id in", values, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdNotIn(List<Integer> values) {
            addCriterion("test_items_design_id not in", values, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdBetween(Integer value1, Integer value2) {
            addCriterion("test_items_design_id between", value1, value2, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andTestItemsDesignIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_items_design_id not between", value1, value2, "testItemsDesignId");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNull() {
            addCriterion("exam_type is null");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNotNull() {
            addCriterion("exam_type is not null");
            return (Criteria) this;
        }

        public Criteria andExamTypeEqualTo(String value) {
            addCriterion("exam_type =", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotEqualTo(String value) {
            addCriterion("exam_type <>", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThan(String value) {
            addCriterion("exam_type >", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_type >=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThan(String value) {
            addCriterion("exam_type <", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThanOrEqualTo(String value) {
            addCriterion("exam_type <=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLike(String value) {
            addCriterion("exam_type like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotLike(String value) {
            addCriterion("exam_type not like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeIn(List<String> values) {
            addCriterion("exam_type in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotIn(List<String> values) {
            addCriterion("exam_type not in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeBetween(String value1, String value2) {
            addCriterion("exam_type between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotBetween(String value1, String value2) {
            addCriterion("exam_type not between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdIsNull() {
            addCriterion("lowerlimit_difficulty_id is null");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdIsNotNull() {
            addCriterion("lowerlimit_difficulty_id is not null");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdEqualTo(Integer value) {
            addCriterion("lowerlimit_difficulty_id =", value, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdNotEqualTo(Integer value) {
            addCriterion("lowerlimit_difficulty_id <>", value, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdGreaterThan(Integer value) {
            addCriterion("lowerlimit_difficulty_id >", value, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lowerlimit_difficulty_id >=", value, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdLessThan(Integer value) {
            addCriterion("lowerlimit_difficulty_id <", value, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdLessThanOrEqualTo(Integer value) {
            addCriterion("lowerlimit_difficulty_id <=", value, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdIn(List<Integer> values) {
            addCriterion("lowerlimit_difficulty_id in", values, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdNotIn(List<Integer> values) {
            addCriterion("lowerlimit_difficulty_id not in", values, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdBetween(Integer value1, Integer value2) {
            addCriterion("lowerlimit_difficulty_id between", value1, value2, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andLowerlimitDifficultyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lowerlimit_difficulty_id not between", value1, value2, "lowerlimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdIsNull() {
            addCriterion("toplimit_difficulty_id is null");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdIsNotNull() {
            addCriterion("toplimit_difficulty_id is not null");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdEqualTo(Integer value) {
            addCriterion("toplimit_difficulty_id =", value, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdNotEqualTo(Integer value) {
            addCriterion("toplimit_difficulty_id <>", value, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdGreaterThan(Integer value) {
            addCriterion("toplimit_difficulty_id >", value, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("toplimit_difficulty_id >=", value, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdLessThan(Integer value) {
            addCriterion("toplimit_difficulty_id <", value, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdLessThanOrEqualTo(Integer value) {
            addCriterion("toplimit_difficulty_id <=", value, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdIn(List<Integer> values) {
            addCriterion("toplimit_difficulty_id in", values, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdNotIn(List<Integer> values) {
            addCriterion("toplimit_difficulty_id not in", values, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdBetween(Integer value1, Integer value2) {
            addCriterion("toplimit_difficulty_id between", value1, value2, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andToplimitDifficultyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("toplimit_difficulty_id not between", value1, value2, "toplimitDifficultyId");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andItemsOrderIsNull() {
            addCriterion("items_order is null");
            return (Criteria) this;
        }

        public Criteria andItemsOrderIsNotNull() {
            addCriterion("items_order is not null");
            return (Criteria) this;
        }

        public Criteria andItemsOrderEqualTo(Integer value) {
            addCriterion("items_order =", value, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderNotEqualTo(Integer value) {
            addCriterion("items_order <>", value, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderGreaterThan(Integer value) {
            addCriterion("items_order >", value, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("items_order >=", value, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderLessThan(Integer value) {
            addCriterion("items_order <", value, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderLessThanOrEqualTo(Integer value) {
            addCriterion("items_order <=", value, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderIn(List<Integer> values) {
            addCriterion("items_order in", values, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderNotIn(List<Integer> values) {
            addCriterion("items_order not in", values, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderBetween(Integer value1, Integer value2) {
            addCriterion("items_order between", value1, value2, "itemsOrder");
            return (Criteria) this;
        }

        public Criteria andItemsOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("items_order not between", value1, value2, "itemsOrder");
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