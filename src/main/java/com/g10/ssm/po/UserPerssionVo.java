package com.g10.ssm.po;

import java.util.List;

public class UserPerssionVo {

	private int permissionId;
	
	private List<String> userNameList;

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public List<String> getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}
}
