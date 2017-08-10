package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;

public interface StrategyTestDatabaseClassificationService {

	/*
	 * public int updateStrategyTestDatabaseClassification(
	 * StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification)
	 * throws Exception;
	 */

	public int saveStrategyTestDatabaseClassification(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception;

	public int deleteStrategyTestDatabaseClassificationByPrimaryKey(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception;

	public List<StrategyTestDatabaseClassificationKey> queryAllTestDatabaseClaasification(int strategyId);

}
