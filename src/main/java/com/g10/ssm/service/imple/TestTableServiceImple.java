package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.TestTableMapper;
import com.g10.ssm.mapper.TestTableQueryMapper;
import com.g10.ssm.po.TestTable;
import com.g10.ssm.service.TestTableService;

@Service
public class TestTableServiceImple implements TestTableService{

	@Autowired
	private TestTableMapper testTableMapper;
	
	@Autowired
	private TestTableQueryMapper testTableQueryMapper;
	
	@Override
	public List<TestTable> queryTestTable(TestTable testTable) throws Exception {
		List<TestTable> list = testTableQueryMapper.selectByTestTable(testTable);
		return list;
	}

	@Override
	public int updateTestTable(TestTable testTable) throws Exception {
		int res = testTableMapper.updateByPrimaryKeySelective(testTable);
		return res;
	}

	@Override
	public int saveTestTable(TestTable testTable) throws Exception {
		int res = testTableMapper.insertSelective(testTable);
		return res;
	}

	@Override
	public int deleteTestTableByPrimaryKey(int id) throws Exception {
		int res = testTableMapper.deleteByPrimaryKey(id);
		return res;
	}

	@Override
	public TestTable queryTestTableById(Integer id) throws Exception {
		TestTable testTable = testTableMapper.selectByPrimaryKey(id);
		return testTable;
	}

}
