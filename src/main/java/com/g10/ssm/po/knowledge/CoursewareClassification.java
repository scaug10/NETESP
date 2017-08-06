package com.g10.ssm.po.knowledge;

public class CoursewareClassification {
    private Integer cwcfId;

    private String classificationName;

    private Integer parentId;

    public Integer getCwcfId() {
        return cwcfId;
    }

    public void setCwcfId(Integer cwcfId) {
        this.cwcfId = cwcfId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName == null ? null : classificationName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}