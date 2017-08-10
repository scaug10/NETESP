package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.Department;;

public interface DepartmentService {
	public List<Department> queryDepartment() throws Exception;

	public int updateDepartment(Department department ) throws Exception;

	public int saveDepartment(Department department ) throws Exception;

	public int deleteDepartmentByPrimaryKey(int departmentId) throws Exception;

	public Department queryDepartmentById(Integer departmentId) throws Exception;
}
