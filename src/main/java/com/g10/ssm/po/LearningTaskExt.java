package com.g10.ssm.po;

import com.g10.ssm.po.LearningTask;

public class LearningTaskExt extends LearningTask {
	private String[] userName;

	public String[] getUserName() {
		return userName;
	}

	public void setUserName(String[] userName) {
		this.userName = userName;
	}

	private Integer[] departmentId;
	private String[] departmentName;
	private Integer[] coursewareId;

	public Integer[] getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer[] departmentId) {
		this.departmentId = departmentId;
	}

	public Integer[] getCoursewareId() {
		return coursewareId;
	}

	public void setCoursewareId(Integer[] coursewareId) {
		this.coursewareId = coursewareId;
	}

	private String[] coursewareUrl;

	public String[] getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String[] departmentName) {
		this.departmentName = departmentName;
	}

	public String[] getCoursewareUrl() {
		return coursewareUrl;
	}

	public void setCoursewareUrl(String[] coursewareUrl) {
		this.coursewareUrl = coursewareUrl;
	}

}
