package com.g10.ssm.po.forum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostExample() {
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

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Integer value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Integer value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Integer value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Integer value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Integer> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Integer> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNull() {
            addCriterion("publisher is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("publisher is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(String value) {
            addCriterion("publisher =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(String value) {
            addCriterion("publisher <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(String value) {
            addCriterion("publisher >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("publisher >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(String value) {
            addCriterion("publisher <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(String value) {
            addCriterion("publisher <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLike(String value) {
            addCriterion("publisher like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotLike(String value) {
            addCriterion("publisher not like", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<String> values) {
            addCriterion("publisher in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<String> values) {
            addCriterion("publisher not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(String value1, String value2) {
            addCriterion("publisher between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(String value1, String value2) {
            addCriterion("publisher not between", value1, value2, "publisher");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andIsCreamIsNull() {
            addCriterion("is_cream is null");
            return (Criteria) this;
        }

        public Criteria andIsCreamIsNotNull() {
            addCriterion("is_cream is not null");
            return (Criteria) this;
        }

        public Criteria andIsCreamEqualTo(Boolean value) {
            addCriterion("is_cream =", value, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamNotEqualTo(Boolean value) {
            addCriterion("is_cream <>", value, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamGreaterThan(Boolean value) {
            addCriterion("is_cream >", value, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_cream >=", value, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamLessThan(Boolean value) {
            addCriterion("is_cream <", value, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamLessThanOrEqualTo(Boolean value) {
            addCriterion("is_cream <=", value, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamIn(List<Boolean> values) {
            addCriterion("is_cream in", values, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamNotIn(List<Boolean> values) {
            addCriterion("is_cream not in", values, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cream between", value1, value2, "isCream");
            return (Criteria) this;
        }

        public Criteria andIsCreamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cream not between", value1, value2, "isCream");
            return (Criteria) this;
        }

        public Criteria andReviewTypeIsNull() {
            addCriterion("review_type is null");
            return (Criteria) this;
        }

        public Criteria andReviewTypeIsNotNull() {
            addCriterion("review_type is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTypeEqualTo(Integer value) {
            addCriterion("review_type =", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeNotEqualTo(Integer value) {
            addCriterion("review_type <>", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeGreaterThan(Integer value) {
            addCriterion("review_type >", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_type >=", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeLessThan(Integer value) {
            addCriterion("review_type <", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeLessThanOrEqualTo(Integer value) {
            addCriterion("review_type <=", value, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeIn(List<Integer> values) {
            addCriterion("review_type in", values, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeNotIn(List<Integer> values) {
            addCriterion("review_type not in", values, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeBetween(Integer value1, Integer value2) {
            addCriterion("review_type between", value1, value2, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("review_type not between", value1, value2, "reviewType");
            return (Criteria) this;
        }

        public Criteria andReviewMessageIsNull() {
            addCriterion("review_message is null");
            return (Criteria) this;
        }

        public Criteria andReviewMessageIsNotNull() {
            addCriterion("review_message is not null");
            return (Criteria) this;
        }

        public Criteria andReviewMessageEqualTo(String value) {
            addCriterion("review_message =", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageNotEqualTo(String value) {
            addCriterion("review_message <>", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageGreaterThan(String value) {
            addCriterion("review_message >", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageGreaterThanOrEqualTo(String value) {
            addCriterion("review_message >=", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageLessThan(String value) {
            addCriterion("review_message <", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageLessThanOrEqualTo(String value) {
            addCriterion("review_message <=", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageLike(String value) {
            addCriterion("review_message like", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageNotLike(String value) {
            addCriterion("review_message not like", value, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageIn(List<String> values) {
            addCriterion("review_message in", values, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageNotIn(List<String> values) {
            addCriterion("review_message not in", values, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageBetween(String value1, String value2) {
            addCriterion("review_message between", value1, value2, "reviewMessage");
            return (Criteria) this;
        }

        public Criteria andReviewMessageNotBetween(String value1, String value2) {
            addCriterion("review_message not between", value1, value2, "reviewMessage");
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