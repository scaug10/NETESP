package com.g10.ssm.po.knowledge;

import com.g10.ssm.po.knowledge.RepositoryCategory;

public class RepositoryCategoryExt extends RepositoryCategory {
	public String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
