package com.g10.ssm.po.knowledge;

public class Courseware {
    private Integer coursewareId;

    private Integer cwcfId;

    private String coursewareName;

    private String speakerName;

    private String speakerInfo;

    private Float coursewareDuration;

    private Integer commendLevel;

    private String description;

    private String cpursewareType;

    private String contentUrl;

    public Integer getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(Integer coursewareId) {
        this.coursewareId = coursewareId;
    }

    public Integer getCwcfId() {
        return cwcfId;
    }

    public void setCwcfId(Integer cwcfId) {
        this.cwcfId = cwcfId;
    }

    public String getCoursewareName() {
        return coursewareName;
    }

    public void setCoursewareName(String coursewareName) {
        this.coursewareName = coursewareName == null ? null : coursewareName.trim();
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName == null ? null : speakerName.trim();
    }

    public String getSpeakerInfo() {
        return speakerInfo;
    }

    public void setSpeakerInfo(String speakerInfo) {
        this.speakerInfo = speakerInfo == null ? null : speakerInfo.trim();
    }

    public Float getCoursewareDuration() {
        return coursewareDuration;
    }

    public void setCoursewareDuration(Float coursewareDuration) {
        this.coursewareDuration = coursewareDuration;
    }

    public Integer getCommendLevel() {
        return commendLevel;
    }

    public void setCommendLevel(Integer commendLevel) {
        this.commendLevel = commendLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCpursewareType() {
        return cpursewareType;
    }

    public void setCpursewareType(String cpursewareType) {
        this.cpursewareType = cpursewareType == null ? null : cpursewareType.trim();
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl == null ? null : contentUrl.trim();
    }
}