package com.g10.ssm.po.knowledge;

public class Knowledge {
    private Integer knowledgeId;

    private Integer categoryId;

    private Integer creator;

    private String name;

    private String dataUrl;

    private Integer reviewType;

    private String reviewMessage;

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl == null ? null : dataUrl.trim();
    }

    public Integer getReviewType() {
        return reviewType;
    }

    public void setReviewType(Integer reviewType) {
        this.reviewType = reviewType;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage == null ? null : reviewMessage.trim();
    }
}