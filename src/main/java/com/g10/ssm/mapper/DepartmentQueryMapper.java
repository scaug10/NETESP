package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.Department;

public interface DepartmentQueryMapper {
	List<Department> selectAllDepartment();

	Department selectByName(String name);
}
