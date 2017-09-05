package com.g10.ssm.po;

import java.util.Date;

public class LearningTask {
    private Integer learningTaskId;

    private String taskName;

    private String content;

    private Date startTime;

    private Date endTime;

    private Float totalLearningTime;

    private Integer learningProgress;

    private Boolean isComplete;

    public Integer getLearningTaskId() {
        return learningTaskId;
    }

    public void setLearningTaskId(Integer learningTaskId) {
        this.learningTaskId = learningTaskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getTotalLearningTime() {
        return totalLearningTime;
    }

    public void setTotalLearningTime(Float totalLearningTime) {
        this.totalLearningTime = totalLearningTime;
    }

    public Integer getLearningProgress() {
        return learningProgress;
    }

    public void setLearningProgress(Integer learningProgress) {
        this.learningProgress = learningProgress;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }
}