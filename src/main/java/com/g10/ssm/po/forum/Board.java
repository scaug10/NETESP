package com.g10.ssm.po.forum;

import java.util.Date;

public class Board {
    private Integer boardId;

    private Integer boardMaster;

    private String boardName;

    private Date createTime;

    private String boardDescribe;

    private Integer boardNum;

    private Integer reviewType;

    private String reviewMessage;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getBoardMaster() {
        return boardMaster;
    }

    public void setBoardMaster(Integer boardMaster) {
        this.boardMaster = boardMaster;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName == null ? null : boardName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBoardDescribe() {
        return boardDescribe;
    }

    public void setBoardDescribe(String boardDescribe) {
        this.boardDescribe = boardDescribe == null ? null : boardDescribe.trim();
    }

    public Integer getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Integer boardNum) {
        this.boardNum = boardNum;
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