package com.g10.ssm.service;

import com.g10.ssm.po.User;

public interface LoginService {
	/*
	 * 新增注册用户
	 */
	public int saveUser(User user)throws Exception;
	
	/*
	 * 验证用户登录密码是否与数据库一致
	 */
	public int checkUserPassword(int userId,String password)throws Exception;
	
}
