package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.StrategyMapper;
import com.g10.ssm.mapper.testdatabase.StrategyQueryMapper;
import com.g10.ssm.po.testdatabase.Strategy;
import com.g10.ssm.service.testdatabase.StrategyService;

@Service("strategyService")
public class StrategyServiceImpl implements StrategyService {

	@Autowired
	private StrategyMapper strategyDao;
	@Autowired
	private StrategyQueryMapper strategyQueryDao;

	@Override
	public List<Strategy> queryStrategy() throws Exception {
		List<Strategy> list = strategyQueryDao.selectAllStrategy();
		return list;
	}

	@Override
	public int updateStrategy(Strategy strategy) throws Exception {
		int result = strategyDao.updateByPrimaryKeySelective(strategy);
		return result;
	}

	@Override
	public int saveStrategy(Strategy strategy) throws Exception {
		int result = strategyDao.insertSelective(strategy);
		return result;
	}

	@Override
	public int deleteStrategyByPrimaryKey(int strategyId) throws Exception {
		int result = strategyDao.deleteByPrimaryKey(strategyId);
		return result;
	}

	@Override
	public Strategy queryStrategyById(Integer strategyId) throws Exception {
		Strategy record = strategyDao.selectByPrimaryKey(strategyId);
		return record;
	}

	@Override
	public int selectStrategyId() throws Exception {
		int strategy = strategyQueryDao.selectId();
		return strategy;
	}

	@Override
	public List<Strategy> queryStrategyByName(String strategyName) throws Exception {
		List<Strategy> list = strategyQueryDao.selectStrategyByName(strategyName);
		return list;
	}

	@Override
	public List<Strategy> queryStrategyByNameAndStatus(String strategyName, int status) throws Exception {
		List<Strategy> list = strategyQueryDao.selectStrategyByNameAndStatus(strategyName, status);
		return list;
	}

	@Override
	public int deleteStrategy(Integer[] strategyId) throws Exception {
		int result = strategyQueryDao.deleteStrategy(strategyId);
		return result;
	}

}
