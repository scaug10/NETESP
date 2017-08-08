package com.g10.ssm.service.imple.testdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.StrategyMapper;
import com.g10.ssm.po.testdatabase.Strategy;
import com.g10.ssm.service.testdatabase.StrategyService;

@Service("strategyService")
public class StrategyServiceImpl implements StrategyService {

	@Autowired
	private StrategyMapper strategyDao;

	/*
	 * @Override public List<Strategy> queryStrategy(Strategy strategy) throws
	 * Exception { return null; }
	 */
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

}
