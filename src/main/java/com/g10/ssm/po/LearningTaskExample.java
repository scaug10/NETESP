package com.g10.ssm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LearningTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LearningTaskExample() {
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

        public Criteria andLearningTaskIdIsNull() {
            addCriterion("learning_task_id is null");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdIsNotNull() {
            addCriterion("learning_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdEqualTo(Integer value) {
            addCriterion("learning_task_id =", value, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdNotEqualTo(Integer value) {
            addCriterion("learning_task_id <>", value, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdGreaterThan(Integer value) {
            addCriterion("learning_task_id >", value, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("learning_task_id >=", value, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdLessThan(Integer value) {
            addCriterion("learning_task_id <", value, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("learning_task_id <=", value, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdIn(List<Integer> values) {
            addCriterion("learning_task_id in", values, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdNotIn(List<Integer> values) {
            addCriterion("learning_task_id not in", values, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("learning_task_id between", value1, value2, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andLearningTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("learning_task_id not between", value1, value2, "learningTaskId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeIsNull() {
            addCriterion("total_learning_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeIsNotNull() {
            addCriterion("total_learning_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeEqualTo(Float value) {
            addCriterion("total_learning_time =", value, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeNotEqualTo(Float value) {
            addCriterion("total_learning_time <>", value, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeGreaterThan(Float value) {
            addCriterion("total_learning_time >", value, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeGreaterThanOrEqualTo(Float value) {
            addCriterion("total_learning_time >=", value, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeLessThan(Float value) {
            addCriterion("total_learning_time <", value, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeLessThanOrEqualTo(Float value) {
            addCriterion("total_learning_time <=", value, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeIn(List<Float> values) {
            addCriterion("total_learning_time in", values, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeNotIn(List<Float> values) {
            addCriterion("total_learning_time not in", values, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeBetween(Float value1, Float value2) {
            addCriterion("total_learning_time between", value1, value2, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andTotalLearningTimeNotBetween(Float value1, Float value2) {
            addCriterion("total_learning_time not between", value1, value2, "totalLearningTime");
            return (Criteria) this;
        }

        public Criteria andLearningProgressIsNull() {
            addCriterion("learning_progress is null");
            return (Criteria) this;
        }

        public Criteria andLearningProgressIsNotNull() {
            addCriterion("learning_progress is not null");
            return (Criteria) this;
        }

        public Criteria andLearningProgressEqualTo(Integer value) {
            addCriterion("learning_progress =", value, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressNotEqualTo(Integer value) {
            addCriterion("learning_progress <>", value, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressGreaterThan(Integer value) {
            addCriterion("learning_progress >", value, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressGreaterThanOrEqualTo(Integer value) {
            addCriterion("learning_progress >=", value, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressLessThan(Integer value) {
            addCriterion("learning_progress <", value, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressLessThanOrEqualTo(Integer value) {
            addCriterion("learning_progress <=", value, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressIn(List<Integer> values) {
            addCriterion("learning_progress in", values, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressNotIn(List<Integer> values) {
            addCriterion("learning_progress not in", values, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressBetween(Integer value1, Integer value2) {
            addCriterion("learning_progress between", value1, value2, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andLearningProgressNotBetween(Integer value1, Integer value2) {
            addCriterion("learning_progress not between", value1, value2, "learningProgress");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNull() {
            addCriterion("is_complete is null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIsNotNull() {
            addCriterion("is_complete is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompleteEqualTo(Boolean value) {
            addCriterion("is_complete =", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotEqualTo(Boolean value) {
            addCriterion("is_complete <>", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThan(Boolean value) {
            addCriterion("is_complete >", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_complete >=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThan(Boolean value) {
            addCriterion("is_complete <", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_complete <=", value, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteIn(List<Boolean> values) {
            addCriterion("is_complete in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotIn(List<Boolean> values) {
            addCriterion("is_complete not in", values, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete between", value1, value2, "isComplete");
            return (Criteria) this;
        }

        public Criteria andIsCompleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete not between", value1, value2, "isComplete");
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