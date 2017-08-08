package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.TestTable;

public interface TestTableQueryMapper {

	public List<TestTable> selectByTestTable(TestTable testTable) throws Exception;
	
}
