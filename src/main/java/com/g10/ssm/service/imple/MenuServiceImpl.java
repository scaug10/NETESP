package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.MenuMapper;
import com.g10.ssm.mapper.MenuQueryMapper;
import com.g10.ssm.po.Menu;
import com.g10.ssm.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuDao;
	@Autowired
	private MenuQueryMapper menuQueryDao;

	@Override
	public List<Menu> queryMenu() throws Exception {
		List<Menu> list = menuQueryDao.selectAllMenu();
		return list;
	}

	@Override
	public int updateMenu(Menu menu) throws Exception {
		int result = menuDao.updateByPrimaryKeySelective(menu);
		return result;
	}

	@Override
	public int saveMenu(Menu menu) throws Exception {
		int result = menuDao.insertSelective(menu);
		return result;
	}

	@Override
	public int deleteMenuByPrimaryKey(int menuId) throws Exception {
		int result = menuDao.deleteByPrimaryKey(menuId);
		return result;
	}

	@Override
	public Menu queryMenuById(Integer menuId) throws Exception {
		Menu record = menuDao.selectByPrimaryKey(menuId);
		return record;
	}

}
