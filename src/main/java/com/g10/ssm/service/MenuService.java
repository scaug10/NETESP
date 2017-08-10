package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.Menu;

public interface MenuService {
	public List<Menu> queryMenu() throws Exception;

	public int updateMenu(Menu menu) throws Exception;

	public int saveMenu(Menu menu) throws Exception;

	public int deleteMenuByPrimaryKey(int menuId) throws Exception;

	public Menu queryMenuById(Integer menuId) throws Exception;
}
