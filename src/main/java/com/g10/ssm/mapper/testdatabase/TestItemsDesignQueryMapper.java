package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.TestItemsDesign;

public interface TestItemsDesignQueryMapper {
	List<TestItemsDesign> selectAllTestItemsDesign();

	int selectId();
}
