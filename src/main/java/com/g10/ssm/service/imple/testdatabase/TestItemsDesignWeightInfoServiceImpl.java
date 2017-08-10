package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.TestItemsDesignWeightInfoMapper;
import com.g10.ssm.mapper.testdatabase.TestItemsDesignWeightInfoQueryMapper;
import com.g10.ssm.po.testdatabase.TestItemsDesignWeightInfo;
import com.g10.ssm.service.testdatabase.TestItemsDesignWeightInfoService;

@Service("testItemsDesignWeightInfo")
public class TestItemsDesignWeightInfoServiceImpl implements TestItemsDesignWeightInfoService {

	@Autowired
	private TestItemsDesignWeightInfoMapper testItemsDesignWeightInfoDao;
	@Autowired
	private TestItemsDesignWeightInfoQueryMapper testItemsDesignWeightInfoQueryDao;

	@Override
	public List<TestItemsDesignWeightInfo> queryTestItemsDesignWeightInfo() throws Exception {
		List<TestItemsDesignWeightInfo> list = testItemsDesignWeightInfoQueryDao.selectAlllTestItemsDesignWeightInfo();
		return list;
	}

	@Override
	public int updateTestItemsDesignWeightInfo(TestItemsDesignWeightInfo testItemsDesignWeightInfo) throws Exception {
		int result = testItemsDesignWeightInfoDao.updateByPrimaryKeySelective(testItemsDesignWeightInfo);
		return result;
	}

	@Override
	public int saveTestItemsDesignWeightInfo(TestItemsDesignWeightInfo testItemsDesignWeightInfo) throws Exception {
		int result = testItemsDesignWeightInfoDao.insertSelective(testItemsDesignWeightInfo);
		return result;
	}

	@Override
	public int deleteTestItemsDesignWeightInfoByPrimaryKey(int weightId) throws Exception {
		int result = testItemsDesignWeightInfoDao.deleteByPrimaryKey(weightId);
		return result;
	}

	@Override
	public TestItemsDesignWeightInfo queryTestItemsDesignWeightInfoById(Integer weightId) throws Exception {
		TestItemsDesignWeightInfo record = testItemsDesignWeightInfoDao.selectByPrimaryKey(weightId);
		return record;
	}

}
