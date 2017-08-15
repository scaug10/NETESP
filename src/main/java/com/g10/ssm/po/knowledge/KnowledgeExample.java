package com.g10.ssm.po.knowledge;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeExample() {
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

        public Criteria andKnowledgeIdIsNull() {
            addCriterion("knowledge_id is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIsNotNull() {
            addCriterion("knowledge_id is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdEqualTo(Integer value) {
            addCriterion("knowledge_id =", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotEqualTo(Integer value) {
            addCriterion("knowledge_id <>", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThan(Integer value) {
            addCriterion("knowledge_id >", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("knowledge_id >=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThan(Integer value) {
            addCriterion("knowledge_id <", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThanOrEqualTo(Integer value) {
            addCriterion("knowledge_id <=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIn(List<Integer> values) {
            addCriterion("knowledge_id in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotIn(List<Integer> values) {
            addCriterion("knowledge_id not in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdBetween(Integer value1, Integer value2) {
            addCriterion("knowledge_id between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("knowledge_id not between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
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

        public Criteria andDataUrlIsNull() {
            addCriterion("data_url is null");
            return (Criteria) this;
        }

        public Criteria andDataUrlIsNotNull() {
            addCriterion("data_url is not null");
            return (Criteria) this;
        }

        public Criteria andDataUrlEqualTo(String value) {
            addCriterion("data_url =", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotEqualTo(String value) {
            addCriterion("data_url <>", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlGreaterThan(String value) {
            addCriterion("data_url >", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("data_url >=", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlLessThan(String value) {
            addCriterion("data_url <", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlLessThanOrEqualTo(String value) {
            addCriterion("data_url <=", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlLike(String value) {
            addCriterion("data_url like", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotLike(String value) {
            addCriterion("data_url not like", value, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlIn(List<String> values) {
            addCriterion("data_url in", values, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotIn(List<String> values) {
            addCriterion("data_url not in", values, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlBetween(String value1, String value2) {
            addCriterion("data_url between", value1, value2, "dataUrl");
            return (Criteria) this;
        }

        public Criteria andDataUrlNotBetween(String value1, String value2) {
            addCriterion("data_url not between", value1, value2, "dataUrl");
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