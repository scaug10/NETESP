package com.g10.ssm.po.testdatabase;

public class TestItemsDesign {
    private Integer testItemsDesignId;

    private String examType;

    private Integer lowerlimitDifficultyId;

    private Integer toplimitDifficultyId;

    private Integer number;

    private Integer score;

    private Integer itemsOrder;

    public Integer getTestItemsDesignId() {
        return testItemsDesignId;
    }

    public void setTestItemsDesignId(Integer testItemsDesignId) {
        this.testItemsDesignId = testItemsDesignId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    public Integer getLowerlimitDifficultyId() {
        return lowerlimitDifficultyId;
    }

    public void setLowerlimitDifficultyId(Integer lowerlimitDifficultyId) {
        this.lowerlimitDifficultyId = lowerlimitDifficultyId;
    }

    public Integer getToplimitDifficultyId() {
        return toplimitDifficultyId;
    }

    public void setToplimitDifficultyId(Integer toplimitDifficultyId) {
        this.toplimitDifficultyId = toplimitDifficultyId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getItemsOrder() {
        return itemsOrder;
    }

    public void setItemsOrder(Integer itemsOrder) {
        this.itemsOrder = itemsOrder;
    }
}