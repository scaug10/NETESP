package com.g10.ssm.po.forum;

import java.util.Date;

public class ForumVist {
    private Integer forumVisitId;

    private Long userId;

    private String userIp;

    private Date visitTime;

    public Integer getForumVisitId() {
        return forumVisitId;
    }

    public void setForumVisitId(Integer forumVisitId) {
        this.forumVisitId = forumVisitId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}