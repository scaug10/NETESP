package com.g10.ssm.po.testdatabase;

public class Subject {
    private Integer subjectId;

    private Integer testDatabaseId;

    private Integer difficultyId;

    private String subjectType;

    private String subjectPattern;

    private String content;

    private String answer;

    private String knowlegePoint;

    private String subjectMatter;

    private String testDatabaseMatter;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTestDatabaseId() {
        return testDatabaseId;
    }

    public void setTestDatabaseId(Integer testDatabaseId) {
        this.testDatabaseId = testDatabaseId;
    }

    public Integer getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(Integer difficultyId) {
        this.difficultyId = difficultyId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public String getSubjectPattern() {
        return subjectPattern;
    }

    public void setSubjectPattern(String subjectPattern) {
        this.subjectPattern = subjectPattern == null ? null : subjectPattern.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getKnowlegePoint() {
        return knowlegePoint;
    }

    public void setKnowlegePoint(String knowlegePoint) {
        this.knowlegePoint = knowlegePoint == null ? null : knowlegePoint.trim();
    }

    public String getSubjectMatter() {
        return subjectMatter;
    }

    public void setSubjectMatter(String subjectMatter) {
        this.subjectMatter = subjectMatter == null ? null : subjectMatter.trim();
    }

    public String getTestDatabaseMatter() {
        return testDatabaseMatter;
    }

    public void setTestDatabaseMatter(String testDatabaseMatter) {
        this.testDatabaseMatter = testDatabaseMatter == null ? null : testDatabaseMatter.trim();
    }
}