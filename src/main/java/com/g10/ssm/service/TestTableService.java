package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.TestTable;

public interface TestTableService {

	public List<TestTable> queryTestTable(TestTable testTable) throws Exception;

	public int updateTestTable(TestTable testTable) throws Exception;

	public int saveTestTable(TestTable testTable) throws Exception;

	public int deleteTestTableByPrimaryKey(int id) throws Exception;

	public TestTable queryTestTableById(Integer id) throws Exception;

}
