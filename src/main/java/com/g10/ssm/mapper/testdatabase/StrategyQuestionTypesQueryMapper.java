package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;

public interface StrategyQuestionTypesQueryMapper {
	List<StrategyQuestionTypesKey> selectAllQuestionTypes(int strategyId);
	
	List<Integer> selectIdByStrategyId(Integer strategyId) throws Exception;
}
