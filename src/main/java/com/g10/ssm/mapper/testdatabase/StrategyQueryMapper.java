package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Strategy;

public interface StrategyQueryMapper {
	List<Strategy> selectAllStrategy();

	List<Strategy> selectStrategyByName(String strategyName);

	List<Strategy> selectStrategyByNameAndStatus(String strategyName, int status);

	int deleteStrategy(Integer[] strategyId);

	int selectId();
}
