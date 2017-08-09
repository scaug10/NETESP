package com.g10.ssm.service;

import com.g10.ssm.po.User;

public interface LoginService {
	/*
	 * 新增注册用户,并为用户赋予一个权限
	 */
	public int saveUser(User user)throws Exception;
	
	/*
	 * 查询登录名是否已经存在
	 */
	public boolean isUserIdExist(String userName)throws Exception;
	
	/*
	 * 验证用户登录密码是否与数据库一致
	 */
	public int checkUserPassword(String userName,String password)throws Exception;
	
	/*
	 * 找回密码
	 */
	public int findPassword(String userName)throws Exception;
	
}
