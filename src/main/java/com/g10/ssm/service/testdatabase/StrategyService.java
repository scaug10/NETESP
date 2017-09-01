package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Strategy;

public interface StrategyService {

	public List<Strategy> queryStrategy() throws Exception;

	public int updateStrategy(Strategy strategy) throws Exception;

	public int saveStrategy(Strategy strategy) throws Exception;

	public int deleteStrategyByPrimaryKey(int strategyId) throws Exception;

	public int deleteStrategy(Integer[] strategyId) throws Exception;

	public Strategy queryStrategyById(Integer strategyId) throws Exception;

	public int selectStrategyId() throws Exception;

	public List<Strategy> queryStrategyByName(String strategyName) throws Exception;

	public List<Strategy> queryStrategyByNameAndStatus(String strategyName, int status) throws Exception;
}
