package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.TestItemsDesignWeightInfo;

public interface TestItemsDesignWeightInfoService {
	public List<TestItemsDesignWeightInfo> queryTestItemsDesignWeightInfo() throws Exception;

	public int updateTestItemsDesignWeightInfo(TestItemsDesignWeightInfo testItemsDesignWeightInfo) throws Exception;

	public int saveTestItemsDesignWeightInfo(TestItemsDesignWeightInfo testItemsDesignWeightInfo) throws Exception;

	public int deleteTestItemsDesignWeightInfoByPrimaryKey(int weightId) throws Exception;

	public TestItemsDesignWeightInfo queryTestItemsDesignWeightInfoById(Integer weightId) throws Exception;
}
