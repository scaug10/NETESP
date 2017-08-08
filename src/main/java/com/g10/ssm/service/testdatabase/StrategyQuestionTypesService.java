package com.g10.ssm.service.testdatabase;

import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;

public interface StrategyQuestionTypesService {
	/*
	 * public List<StrategyQuestionTypesKey>
	 * queryStrategyQuestionTypes(StrategyQuestionTypesKey
	 * strategyQuestionTypes) throws Exception;
	 */

	/*
	 * public int updateStrategyQuestionTypes(StrategyQuestionTypesKey
	 * strategyQuestionTypes) throws Exception;
	 */

	public int saveStrategyQuestionTypes(StrategyQuestionTypesKey strategyQuestionTypes) throws Exception;

	public int deleteStrategyQuestionTypesByPrimaryKey(StrategyQuestionTypesKey strategyQuestionTypes) throws Exception;

}
