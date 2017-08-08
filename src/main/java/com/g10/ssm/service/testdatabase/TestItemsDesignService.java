package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.TestItemsDesign;

public interface TestItemsDesignService {
	public List<TestItemsDesign> queryTestItemsDesign() throws Exception;

	public int updateTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception;

	public int saveTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception;

	public int deleteTestItemsDesignByPrimaryKey(int testItemsDesignId) throws Exception;

	public TestItemsDesign queryTestItemsDesignById(Integer testItemsDesignId) throws Exception;
}
