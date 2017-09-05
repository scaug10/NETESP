package com.g10.ssm.po.testdatabase;

public class ClassificationOfTestdatabase {
    private Integer testDatabaseId;

    private String name;

    private Long parentId;

    public Integer getTestDatabaseId() {
        return testDatabaseId;
    }

    public void setTestDatabaseId(Integer testDatabaseId) {
        this.testDatabaseId = testDatabaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}