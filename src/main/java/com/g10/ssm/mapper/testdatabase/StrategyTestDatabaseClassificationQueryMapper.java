package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;

public interface StrategyTestDatabaseClassificationQueryMapper {
	List<StrategyTestDatabaseClassificationKey> selectAllTestDatabaseClassification(int strategyId);
}
