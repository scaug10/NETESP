package com.g10.ssm.po;

public class UserLearningTaskKey {
    private Integer learningTaskId;

    private String userName;

    public Integer getLearningTaskId() {
        return learningTaskId;
    }

    public void setLearningTaskId(Integer learningTaskId) {
        this.learningTaskId = learningTaskId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}