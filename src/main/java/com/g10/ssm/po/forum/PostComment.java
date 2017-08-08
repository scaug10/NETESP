package com.g10.ssm.po.forum;

import java.util.Date;

public class PostComment {
    private Integer postCommentId;

    private Integer postId;

    private String publisher;

    private String content;

    private Date createTime;

    private Integer reviewType;

    private String reviewMessage;

    public Integer getPostCommentId() {
        return postCommentId;
    }

    public void setPostCommentId(Integer postCommentId) {
        this.postCommentId = postCommentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
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