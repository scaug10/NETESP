package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Department;
import com.g10.ssm.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/queryDepartment")
	public ModelAndView queryDepartment(@Param("departmentId") int departmentId, ModelAndView modelAndView)
			throws Exception {
		Department record = departmentService.queryDepartmentById(departmentId);
		modelAndView.addObject("Department", record);
		return modelAndView;
	}

	@RequestMapping("/editDepartment")
	@ResponseBody
	public int editDepartment(Department department) throws Exception {
		int result = departmentService.updateDepartment(department);
		return result;
	}

	@RequestMapping("/saveDepartment")
	@ResponseBody
	public int saveDepartment(Department department) throws Exception {
		int result = departmentService.saveDepartment(department);
		return result;
	}

	@RequestMapping("/deleteDepartment")
	@ResponseBody
	public int deleteDepartment(@Param("departmentId") int departmentId) throws Exception {
		int result = departmentService.deleteDepartmentByPrimaryKey(departmentId);
		return result;
	}

	@RequestMapping("/getAllDepartment")
	public ModelAndView getAllDepartment(ModelAndView modelAndView) throws Exception {
		List<Department> list = departmentService.queryDepartment();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
