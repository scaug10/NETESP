package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.TestItemsDesignMapper;
import com.g10.ssm.mapper.testdatabase.TestItemsDesignQueryMapper;
import com.g10.ssm.po.testdatabase.TestItemsDesign;
import com.g10.ssm.service.testdatabase.TestItemsDesignService;

@Service("tesstItemsDesign")
public class TestItemsDesignServiceImpl implements TestItemsDesignService {

	@Autowired
	private TestItemsDesignMapper testItemsDesignDao;
	@Autowired
	private TestItemsDesignQueryMapper testItemsDesignQueryDao;

	@Override
	public List<TestItemsDesign> queryTestItemsDesign() throws Exception {
		List<TestItemsDesign> list = testItemsDesignQueryDao.selectAllTestItemsDesign();
		return list;
	}

	@Override
	public int updateTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception {
		int result = testItemsDesignDao.updateByPrimaryKeySelective(testItemsDesign);
		return result;
	}

	@Override
	public int saveTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception {
		int result = testItemsDesignDao.insertSelective(testItemsDesign);
		return result;
	}

	@Override
	public int deleteTestItemsDesignByPrimaryKey(int testItemsDesignId) throws Exception {
		int result = testItemsDesignDao.deleteByPrimaryKey(testItemsDesignId);
		return result;
	}

	@Override
	public TestItemsDesign queryTestItemsDesignById(Integer testItemsDesignId) throws Exception {
		TestItemsDesign record = testItemsDesignDao.selectByPrimaryKey(testItemsDesignId);
		return record;
	}

	@Override
	public int selectId() throws Exception {
		int testItemsDesignId = testItemsDesignQueryDao.selectId();
		return testItemsDesignId;
	}

}
