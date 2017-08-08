package com.g10.ssm.service.testdatabase;

import com.g10.ssm.po.testdatabase.Strategy;

public interface StrategyService {
	/*
	 * public List<Strategy> queryStrategy(Strategy strategy) throws Exception;
	 */

	public int updateStrategy(Strategy strategy) throws Exception;

	public int saveStrategy(Strategy strategy) throws Exception;

	public int deleteStrategyByPrimaryKey(int strategyId) throws Exception;

	public Strategy queryStrategyById(Integer strategyId) throws Exception;
}
