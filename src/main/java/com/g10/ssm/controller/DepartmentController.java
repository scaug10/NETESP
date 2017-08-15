package com.g10.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.Department;
import com.g10.ssm.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/queryDepartment")
	public String queryDepartment(@Param("departmentId") int departmentId, Model model) throws Exception {
		Department record = departmentService.queryDepartmentById(departmentId);
		model.addAttribute("Department", record);
		return "Department/department";
	}

	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) throws Exception {
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		String name = request.getParameter("name");
		Department department = new Department();
		department.setDepartmentId(departmentId);
		department.setName(name);
		System.out.println(department.getName() + " /" + department.getDepartmentId());
		model.addAttribute("Department", department);
		return "Department/editDepartment";
	}

	@RequestMapping("/editDepartment")
	public String editDepartment(Department department, Model model) throws Exception {
		int result = departmentService.updateDepartment(department);
		if (result == 1) {
			List<Department> list = departmentService.queryDepartment();
			model.addAttribute("list", list);
			return "Department/department";
		} else {
			return "error";
		}
	}

	@RequestMapping("/add")
	public String add(Department department, Model model) throws Exception {
		return "Department/addDepartment";
	}

	@RequestMapping("/checkDepartment")
	@ResponseBody
	public int checkDepartment(Department department) throws Exception {
		System.out.println(department.getName());
		int result = departmentService.checkDepartment(department);
		return result;
	}

	@RequestMapping("/saveDepartment")
	public String saveDepartment(Department department, Model model) throws Exception {
		System.out.println(department.getName() + " /" + department.getDepartmentId());
		int result = departmentService.saveDepartment(department);
		if (result == 1) {
			List<Department> list = departmentService.queryDepartment();
			model.addAttribute("list", list);
			return "Department/department";
		} else {
			return "error";
		}
	}

	@RequestMapping("/deleteDepartment")
	public String deleteDepartment(@Param("departmentId") int departmentId, Model model) throws Exception {
		int result = departmentService.deleteDepartmentByPrimaryKey(departmentId);
		if (result == 1) {
			List<Department> list = departmentService.queryDepartment();
			model.addAttribute("list", list);
			return "Department/department";
		} else {
			return "error";
		}
	}

	@RequestMapping("/getAllDepartment")
	public String getAllDepartment(Model model) throws Exception {
		List<Department> list = departmentService.queryDepartment();
		model.addAttribute("list", list);
		return "Department/department";
	}
}
