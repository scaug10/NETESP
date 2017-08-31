package com.g10.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.DepartmentMapper;
import com.g10.ssm.mapper.DepartmentQueryMapper;
import com.g10.ssm.po.Department;
import com.g10.ssm.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentDao;
	@Autowired
	private DepartmentQueryMapper departmentQueryDao;

	@Override
	public List<Department> queryDepartment() throws Exception {
		List<Department> list = departmentQueryDao.selectAllDepartment();
		return list;
	}

	@Override
	public int updateDepartment(Department department) throws Exception {
		int result = departmentDao.updateByPrimaryKeySelective(department);
		return result;
	}

	@Override
	public int saveDepartment(Department department) throws Exception {
		int result = departmentDao.insertSelective(department);
		return result;
	}

	@Override
	public int deleteDepartmentByPrimaryKey(int departmentId) throws Exception {
		int result = departmentDao.deleteByPrimaryKey(departmentId);
		return result;
	}

	@Override
	public Department queryDepartmentById(Integer departmentId) throws Exception {
		Department record = departmentDao.selectByPrimaryKey(departmentId);
		return record;
	}

	@Override
	public int checkDepartment(Department department) throws Exception {
		if (departmentQueryDao.selectByName(department.getName()) != null) {
			return 1;
		}
		return 0;
	}
}
