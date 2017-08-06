package com.g10.ssm.po.forum;

import java.util.Date;

public class Post {
    private Integer postId;

    private Integer userId;

    private Integer topicId;

    private String content;

    private Date createTime;

    private Boolean isCream;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsCream() {
        return isCream;
    }

    public void setIsCream(Boolean isCream) {
        this.isCream = isCream;
    }
}