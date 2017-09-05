package com.g10.ssm.po.forum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoardExample() {
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

        public Criteria andBoardIdIsNull() {
            addCriterion("board_id is null");
            return (Criteria) this;
        }

        public Criteria andBoardIdIsNotNull() {
            addCriterion("board_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoardIdEqualTo(Integer value) {
            addCriterion("board_id =", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdNotEqualTo(Integer value) {
            addCriterion("board_id <>", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdGreaterThan(Integer value) {
            addCriterion("board_id >", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("board_id >=", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdLessThan(Integer value) {
            addCriterion("board_id <", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdLessThanOrEqualTo(Integer value) {
            addCriterion("board_id <=", value, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdIn(List<Integer> values) {
            addCriterion("board_id in", values, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdNotIn(List<Integer> values) {
            addCriterion("board_id not in", values, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdBetween(Integer value1, Integer value2) {
            addCriterion("board_id between", value1, value2, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("board_id not between", value1, value2, "boardId");
            return (Criteria) this;
        }

        public Criteria andBoardMasterIsNull() {
            addCriterion("board_master is null");
            return (Criteria) this;
        }

        public Criteria andBoardMasterIsNotNull() {
            addCriterion("board_master is not null");
            return (Criteria) this;
        }

        public Criteria andBoardMasterEqualTo(String value) {
            addCriterion("board_master =", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterNotEqualTo(String value) {
            addCriterion("board_master <>", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterGreaterThan(String value) {
            addCriterion("board_master >", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterGreaterThanOrEqualTo(String value) {
            addCriterion("board_master >=", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterLessThan(String value) {
            addCriterion("board_master <", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterLessThanOrEqualTo(String value) {
            addCriterion("board_master <=", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterLike(String value) {
            addCriterion("board_master like", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterNotLike(String value) {
            addCriterion("board_master not like", value, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterIn(List<String> values) {
            addCriterion("board_master in", values, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterNotIn(List<String> values) {
            addCriterion("board_master not in", values, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterBetween(String value1, String value2) {
            addCriterion("board_master between", value1, value2, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardMasterNotBetween(String value1, String value2) {
            addCriterion("board_master not between", value1, value2, "boardMaster");
            return (Criteria) this;
        }

        public Criteria andBoardNameIsNull() {
            addCriterion("board_name is null");
            return (Criteria) this;
        }

        public Criteria andBoardNameIsNotNull() {
            addCriterion("board_name is not null");
            return (Criteria) this;
        }

        public Criteria andBoardNameEqualTo(String value) {
            addCriterion("board_name =", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameNotEqualTo(String value) {
            addCriterion("board_name <>", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameGreaterThan(String value) {
            addCriterion("board_name >", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameGreaterThanOrEqualTo(String value) {
            addCriterion("board_name >=", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameLessThan(String value) {
            addCriterion("board_name <", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameLessThanOrEqualTo(String value) {
            addCriterion("board_name <=", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameLike(String value) {
            addCriterion("board_name like", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameNotLike(String value) {
            addCriterion("board_name not like", value, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameIn(List<String> values) {
            addCriterion("board_name in", values, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameNotIn(List<String> values) {
            addCriterion("board_name not in", values, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameBetween(String value1, String value2) {
            addCriterion("board_name between", value1, value2, "boardName");
            return (Criteria) this;
        }

        public Criteria andBoardNameNotBetween(String value1, String value2) {
            addCriterion("board_name not between", value1, value2, "boardName");
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

        public Criteria andBoardDescribeIsNull() {
            addCriterion("board_describe is null");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeIsNotNull() {
            addCriterion("board_describe is not null");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeEqualTo(String value) {
            addCriterion("board_describe =", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeNotEqualTo(String value) {
            addCriterion("board_describe <>", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeGreaterThan(String value) {
            addCriterion("board_describe >", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("board_describe >=", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeLessThan(String value) {
            addCriterion("board_describe <", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeLessThanOrEqualTo(String value) {
            addCriterion("board_describe <=", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeLike(String value) {
            addCriterion("board_describe like", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeNotLike(String value) {
            addCriterion("board_describe not like", value, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeIn(List<String> values) {
            addCriterion("board_describe in", values, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeNotIn(List<String> values) {
            addCriterion("board_describe not in", values, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeBetween(String value1, String value2) {
            addCriterion("board_describe between", value1, value2, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardDescribeNotBetween(String value1, String value2) {
            addCriterion("board_describe not between", value1, value2, "boardDescribe");
            return (Criteria) this;
        }

        public Criteria andBoardNumIsNull() {
            addCriterion("board_num is null");
            return (Criteria) this;
        }

        public Criteria andBoardNumIsNotNull() {
            addCriterion("board_num is not null");
            return (Criteria) this;
        }

        public Criteria andBoardNumEqualTo(Integer value) {
            addCriterion("board_num =", value, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumNotEqualTo(Integer value) {
            addCriterion("board_num <>", value, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumGreaterThan(Integer value) {
            addCriterion("board_num >", value, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("board_num >=", value, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumLessThan(Integer value) {
            addCriterion("board_num <", value, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumLessThanOrEqualTo(Integer value) {
            addCriterion("board_num <=", value, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumIn(List<Integer> values) {
            addCriterion("board_num in", values, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumNotIn(List<Integer> values) {
            addCriterion("board_num not in", values, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumBetween(Integer value1, Integer value2) {
            addCriterion("board_num between", value1, value2, "boardNum");
            return (Criteria) this;
        }

        public Criteria andBoardNumNotBetween(Integer value1, Integer value2) {
            addCriterion("board_num not between", value1, value2, "boardNum");
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