package com.g10.ssm.po.testdatabase;

import java.util.ArrayList;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
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

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("subject_type is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(String value) {
            addCriterion("subject_type =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(String value) {
            addCriterion("subject_type <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(String value) {
            addCriterion("subject_type >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("subject_type >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(String value) {
            addCriterion("subject_type <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(String value) {
            addCriterion("subject_type <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLike(String value) {
            addCriterion("subject_type like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotLike(String value) {
            addCriterion("subject_type not like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<String> values) {
            addCriterion("subject_type in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<String> values) {
            addCriterion("subject_type not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(String value1, String value2) {
            addCriterion("subject_type between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(String value1, String value2) {
            addCriterion("subject_type not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternIsNull() {
            addCriterion("subject_pattern is null");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternIsNotNull() {
            addCriterion("subject_pattern is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternEqualTo(String value) {
            addCriterion("subject_pattern =", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternNotEqualTo(String value) {
            addCriterion("subject_pattern <>", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternGreaterThan(String value) {
            addCriterion("subject_pattern >", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternGreaterThanOrEqualTo(String value) {
            addCriterion("subject_pattern >=", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternLessThan(String value) {
            addCriterion("subject_pattern <", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternLessThanOrEqualTo(String value) {
            addCriterion("subject_pattern <=", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternLike(String value) {
            addCriterion("subject_pattern like", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternNotLike(String value) {
            addCriterion("subject_pattern not like", value, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternIn(List<String> values) {
            addCriterion("subject_pattern in", values, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternNotIn(List<String> values) {
            addCriterion("subject_pattern not in", values, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternBetween(String value1, String value2) {
            addCriterion("subject_pattern between", value1, value2, "subjectPattern");
            return (Criteria) this;
        }

        public Criteria andSubjectPatternNotBetween(String value1, String value2) {
            addCriterion("subject_pattern not between", value1, value2, "subjectPattern");
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

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointIsNull() {
            addCriterion("knowlege_point is null");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointIsNotNull() {
            addCriterion("knowlege_point is not null");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointEqualTo(String value) {
            addCriterion("knowlege_point =", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointNotEqualTo(String value) {
            addCriterion("knowlege_point <>", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointGreaterThan(String value) {
            addCriterion("knowlege_point >", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointGreaterThanOrEqualTo(String value) {
            addCriterion("knowlege_point >=", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointLessThan(String value) {
            addCriterion("knowlege_point <", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointLessThanOrEqualTo(String value) {
            addCriterion("knowlege_point <=", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointLike(String value) {
            addCriterion("knowlege_point like", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointNotLike(String value) {
            addCriterion("knowlege_point not like", value, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointIn(List<String> values) {
            addCriterion("knowlege_point in", values, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointNotIn(List<String> values) {
            addCriterion("knowlege_point not in", values, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointBetween(String value1, String value2) {
            addCriterion("knowlege_point between", value1, value2, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andKnowlegePointNotBetween(String value1, String value2) {
            addCriterion("knowlege_point not between", value1, value2, "knowlegePoint");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterIsNull() {
            addCriterion("subject_matter is null");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterIsNotNull() {
            addCriterion("subject_matter is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterEqualTo(String value) {
            addCriterion("subject_matter =", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterNotEqualTo(String value) {
            addCriterion("subject_matter <>", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterGreaterThan(String value) {
            addCriterion("subject_matter >", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterGreaterThanOrEqualTo(String value) {
            addCriterion("subject_matter >=", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterLessThan(String value) {
            addCriterion("subject_matter <", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterLessThanOrEqualTo(String value) {
            addCriterion("subject_matter <=", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterLike(String value) {
            addCriterion("subject_matter like", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterNotLike(String value) {
            addCriterion("subject_matter not like", value, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterIn(List<String> values) {
            addCriterion("subject_matter in", values, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterNotIn(List<String> values) {
            addCriterion("subject_matter not in", values, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterBetween(String value1, String value2) {
            addCriterion("subject_matter between", value1, value2, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andSubjectMatterNotBetween(String value1, String value2) {
            addCriterion("subject_matter not between", value1, value2, "subjectMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterIsNull() {
            addCriterion("test_database_matter is null");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterIsNotNull() {
            addCriterion("test_database_matter is not null");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterEqualTo(String value) {
            addCriterion("test_database_matter =", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterNotEqualTo(String value) {
            addCriterion("test_database_matter <>", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterGreaterThan(String value) {
            addCriterion("test_database_matter >", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterGreaterThanOrEqualTo(String value) {
            addCriterion("test_database_matter >=", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterLessThan(String value) {
            addCriterion("test_database_matter <", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterLessThanOrEqualTo(String value) {
            addCriterion("test_database_matter <=", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterLike(String value) {
            addCriterion("test_database_matter like", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterNotLike(String value) {
            addCriterion("test_database_matter not like", value, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterIn(List<String> values) {
            addCriterion("test_database_matter in", values, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterNotIn(List<String> values) {
            addCriterion("test_database_matter not in", values, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterBetween(String value1, String value2) {
            addCriterion("test_database_matter between", value1, value2, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseMatterNotBetween(String value1, String value2) {
            addCriterion("test_database_matter not between", value1, value2, "testDatabaseMatter");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdIsNull() {
            addCriterion("test_database_id is null");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdIsNotNull() {
            addCriterion("test_database_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdEqualTo(Long value) {
            addCriterion("test_database_id =", value, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdNotEqualTo(Long value) {
            addCriterion("test_database_id <>", value, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdGreaterThan(Long value) {
            addCriterion("test_database_id >", value, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("test_database_id >=", value, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdLessThan(Long value) {
            addCriterion("test_database_id <", value, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdLessThanOrEqualTo(Long value) {
            addCriterion("test_database_id <=", value, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdIn(List<Long> values) {
            addCriterion("test_database_id in", values, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdNotIn(List<Long> values) {
            addCriterion("test_database_id not in", values, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdBetween(Long value1, Long value2) {
            addCriterion("test_database_id between", value1, value2, "testDatabaseId");
            return (Criteria) this;
        }

        public Criteria andTestDatabaseIdNotBetween(Long value1, Long value2) {
            addCriterion("test_database_id not between", value1, value2, "testDatabaseId");
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

        public Criteria andNameEqualTo(Integer value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(Integer value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(Integer value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(Integer value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(Integer value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<Integer> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<Integer> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(Integer value1, Integer value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(Integer value1, Integer value2) {
            addCriterion("name not between", value1, value2, "name");
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