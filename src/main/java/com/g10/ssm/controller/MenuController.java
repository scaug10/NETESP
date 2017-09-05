package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Menu;
import com.g10.ssm.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping("/queryMenu")
	public ModelAndView queryMenu(@Param("menuId") int menuId, ModelAndView modelAndView) throws Exception {
		Menu record = menuService.queryMenuById(menuId);
		modelAndView.addObject("Menu", record);
		return modelAndView;
	}

	@RequestMapping("/editMenu")
	@ResponseBody
	public int editMenu(Menu menu) throws Exception {
		int result = menuService.updateMenu(menu);
		return result;
	}

	@RequestMapping("/saveMenu")
	@ResponseBody
	public int saveMenu(Menu menu) throws Exception {
		int result = menuService.saveMenu(menu);
		return result;
	}

	@RequestMapping("/deleteMenu")
	@ResponseBody
	public int deleteMenu(@Param("menuId") int menuId) throws Exception {
		int result = menuService.deleteMenuByPrimaryKey(menuId);
		return result;
	}

	@RequestMapping("/getAllMenu")
	public ModelAndView getAllMenu(ModelAndView modelAndView) throws Exception {
		List<Menu> list = menuService.queryMenu();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
