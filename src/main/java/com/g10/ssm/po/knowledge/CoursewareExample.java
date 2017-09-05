package com.g10.ssm.po.knowledge;

import java.util.ArrayList;
import java.util.List;

public class CoursewareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoursewareExample() {
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

        public Criteria andCoursewareIdIsNull() {
            addCriterion("courseware_id is null");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdIsNotNull() {
            addCriterion("courseware_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdEqualTo(Integer value) {
            addCriterion("courseware_id =", value, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdNotEqualTo(Integer value) {
            addCriterion("courseware_id <>", value, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdGreaterThan(Integer value) {
            addCriterion("courseware_id >", value, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseware_id >=", value, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdLessThan(Integer value) {
            addCriterion("courseware_id <", value, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdLessThanOrEqualTo(Integer value) {
            addCriterion("courseware_id <=", value, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdIn(List<Integer> values) {
            addCriterion("courseware_id in", values, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdNotIn(List<Integer> values) {
            addCriterion("courseware_id not in", values, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdBetween(Integer value1, Integer value2) {
            addCriterion("courseware_id between", value1, value2, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCoursewareIdNotBetween(Integer value1, Integer value2) {
            addCriterion("courseware_id not between", value1, value2, "coursewareId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdIsNull() {
            addCriterion("cwcf_id is null");
            return (Criteria) this;
        }

        public Criteria andCwcfIdIsNotNull() {
            addCriterion("cwcf_id is not null");
            return (Criteria) this;
        }

        public Criteria andCwcfIdEqualTo(Integer value) {
            addCriterion("cwcf_id =", value, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdNotEqualTo(Integer value) {
            addCriterion("cwcf_id <>", value, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdGreaterThan(Integer value) {
            addCriterion("cwcf_id >", value, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cwcf_id >=", value, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdLessThan(Integer value) {
            addCriterion("cwcf_id <", value, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdLessThanOrEqualTo(Integer value) {
            addCriterion("cwcf_id <=", value, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdIn(List<Integer> values) {
            addCriterion("cwcf_id in", values, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdNotIn(List<Integer> values) {
            addCriterion("cwcf_id not in", values, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdBetween(Integer value1, Integer value2) {
            addCriterion("cwcf_id between", value1, value2, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCwcfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cwcf_id not between", value1, value2, "cwcfId");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameIsNull() {
            addCriterion("courseware_name is null");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameIsNotNull() {
            addCriterion("courseware_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameEqualTo(String value) {
            addCriterion("courseware_name =", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameNotEqualTo(String value) {
            addCriterion("courseware_name <>", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameGreaterThan(String value) {
            addCriterion("courseware_name >", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameGreaterThanOrEqualTo(String value) {
            addCriterion("courseware_name >=", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameLessThan(String value) {
            addCriterion("courseware_name <", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameLessThanOrEqualTo(String value) {
            addCriterion("courseware_name <=", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameLike(String value) {
            addCriterion("courseware_name like", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameNotLike(String value) {
            addCriterion("courseware_name not like", value, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameIn(List<String> values) {
            addCriterion("courseware_name in", values, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameNotIn(List<String> values) {
            addCriterion("courseware_name not in", values, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameBetween(String value1, String value2) {
            addCriterion("courseware_name between", value1, value2, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andCoursewareNameNotBetween(String value1, String value2) {
            addCriterion("courseware_name not between", value1, value2, "coursewareName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIsNull() {
            addCriterion("speaker_name is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIsNotNull() {
            addCriterion("speaker_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameEqualTo(String value) {
            addCriterion("speaker_name =", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotEqualTo(String value) {
            addCriterion("speaker_name <>", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameGreaterThan(String value) {
            addCriterion("speaker_name >", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_name >=", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLessThan(String value) {
            addCriterion("speaker_name <", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLessThanOrEqualTo(String value) {
            addCriterion("speaker_name <=", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLike(String value) {
            addCriterion("speaker_name like", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotLike(String value) {
            addCriterion("speaker_name not like", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIn(List<String> values) {
            addCriterion("speaker_name in", values, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotIn(List<String> values) {
            addCriterion("speaker_name not in", values, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameBetween(String value1, String value2) {
            addCriterion("speaker_name between", value1, value2, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotBetween(String value1, String value2) {
            addCriterion("speaker_name not between", value1, value2, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoIsNull() {
            addCriterion("speaker_info is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoIsNotNull() {
            addCriterion("speaker_info is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoEqualTo(String value) {
            addCriterion("speaker_info =", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoNotEqualTo(String value) {
            addCriterion("speaker_info <>", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoGreaterThan(String value) {
            addCriterion("speaker_info >", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_info >=", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoLessThan(String value) {
            addCriterion("speaker_info <", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoLessThanOrEqualTo(String value) {
            addCriterion("speaker_info <=", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoLike(String value) {
            addCriterion("speaker_info like", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoNotLike(String value) {
            addCriterion("speaker_info not like", value, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoIn(List<String> values) {
            addCriterion("speaker_info in", values, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoNotIn(List<String> values) {
            addCriterion("speaker_info not in", values, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoBetween(String value1, String value2) {
            addCriterion("speaker_info between", value1, value2, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andSpeakerInfoNotBetween(String value1, String value2) {
            addCriterion("speaker_info not between", value1, value2, "speakerInfo");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationIsNull() {
            addCriterion("courseware_duration is null");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationIsNotNull() {
            addCriterion("courseware_duration is not null");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationEqualTo(Float value) {
            addCriterion("courseware_duration =", value, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationNotEqualTo(Float value) {
            addCriterion("courseware_duration <>", value, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationGreaterThan(Float value) {
            addCriterion("courseware_duration >", value, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationGreaterThanOrEqualTo(Float value) {
            addCriterion("courseware_duration >=", value, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationLessThan(Float value) {
            addCriterion("courseware_duration <", value, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationLessThanOrEqualTo(Float value) {
            addCriterion("courseware_duration <=", value, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationIn(List<Float> values) {
            addCriterion("courseware_duration in", values, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationNotIn(List<Float> values) {
            addCriterion("courseware_duration not in", values, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationBetween(Float value1, Float value2) {
            addCriterion("courseware_duration between", value1, value2, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCoursewareDurationNotBetween(Float value1, Float value2) {
            addCriterion("courseware_duration not between", value1, value2, "coursewareDuration");
            return (Criteria) this;
        }

        public Criteria andCommendLevelIsNull() {
            addCriterion("commend_level is null");
            return (Criteria) this;
        }

        public Criteria andCommendLevelIsNotNull() {
            addCriterion("commend_level is not null");
            return (Criteria) this;
        }

        public Criteria andCommendLevelEqualTo(Integer value) {
            addCriterion("commend_level =", value, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelNotEqualTo(Integer value) {
            addCriterion("commend_level <>", value, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelGreaterThan(Integer value) {
            addCriterion("commend_level >", value, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("commend_level >=", value, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelLessThan(Integer value) {
            addCriterion("commend_level <", value, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelLessThanOrEqualTo(Integer value) {
            addCriterion("commend_level <=", value, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelIn(List<Integer> values) {
            addCriterion("commend_level in", values, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelNotIn(List<Integer> values) {
            addCriterion("commend_level not in", values, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelBetween(Integer value1, Integer value2) {
            addCriterion("commend_level between", value1, value2, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andCommendLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("commend_level not between", value1, value2, "commendLevel");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeIsNull() {
            addCriterion("cpurseware_type is null");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeIsNotNull() {
            addCriterion("cpurseware_type is not null");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeEqualTo(String value) {
            addCriterion("cpurseware_type =", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeNotEqualTo(String value) {
            addCriterion("cpurseware_type <>", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeGreaterThan(String value) {
            addCriterion("cpurseware_type >", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cpurseware_type >=", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeLessThan(String value) {
            addCriterion("cpurseware_type <", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeLessThanOrEqualTo(String value) {
            addCriterion("cpurseware_type <=", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeLike(String value) {
            addCriterion("cpurseware_type like", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeNotLike(String value) {
            addCriterion("cpurseware_type not like", value, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeIn(List<String> values) {
            addCriterion("cpurseware_type in", values, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeNotIn(List<String> values) {
            addCriterion("cpurseware_type not in", values, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeBetween(String value1, String value2) {
            addCriterion("cpurseware_type between", value1, value2, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andCpursewareTypeNotBetween(String value1, String value2) {
            addCriterion("cpurseware_type not between", value1, value2, "cpursewareType");
            return (Criteria) this;
        }

        public Criteria andContentUrlIsNull() {
            addCriterion("content_url is null");
            return (Criteria) this;
        }

        public Criteria andContentUrlIsNotNull() {
            addCriterion("content_url is not null");
            return (Criteria) this;
        }

        public Criteria andContentUrlEqualTo(String value) {
            addCriterion("content_url =", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotEqualTo(String value) {
            addCriterion("content_url <>", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlGreaterThan(String value) {
            addCriterion("content_url >", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("content_url >=", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLessThan(String value) {
            addCriterion("content_url <", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLessThanOrEqualTo(String value) {
            addCriterion("content_url <=", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlLike(String value) {
            addCriterion("content_url like", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotLike(String value) {
            addCriterion("content_url not like", value, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlIn(List<String> values) {
            addCriterion("content_url in", values, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotIn(List<String> values) {
            addCriterion("content_url not in", values, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlBetween(String value1, String value2) {
            addCriterion("content_url between", value1, value2, "contentUrl");
            return (Criteria) this;
        }

        public Criteria andContentUrlNotBetween(String value1, String value2) {
            addCriterion("content_url not between", value1, value2, "contentUrl");
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