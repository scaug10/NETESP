package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.StrategyQuestionTypesMapper;
import com.g10.ssm.mapper.testdatabase.StrategyQuestionTypesQueryMapper;
import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;
import com.g10.ssm.service.testdatabase.StrategyQuestionTypesService;

@Service("strategyQuestionTypes")
public class StrategyQuestionTypesServiceImpl implements StrategyQuestionTypesService {

	@Autowired
	private StrategyQuestionTypesMapper strategyQuestionTypesDao;
	@Autowired
	private StrategyQuestionTypesQueryMapper strategyQuestionTypesQueryDao;

	@Override
	public List<StrategyQuestionTypesKey> queryStrategyQuestionTypes(int strategyId) throws Exception {
		List<StrategyQuestionTypesKey> list = strategyQuestionTypesQueryDao.selectAllQuestionTypes(strategyId);
		return list;
	}

	/*
	 * @Override public int updateStrategyQuestionTypes(StrategyQuestionTypesKey
	 * strategyQuestionTypes) throws Exception {
	 * 
	 * return 0; }
	 */

	@Override
	public int saveStrategyQuestionTypes(StrategyQuestionTypesKey strategyQuestionTypes) throws Exception {
		int result = strategyQuestionTypesDao.insertSelective(strategyQuestionTypes);
		return result;
	}

	@Override
	public int deleteStrategyQuestionTypesByPrimaryKey(StrategyQuestionTypesKey strategyQuestionTypes)
			throws Exception {
		int result = strategyQuestionTypesDao.deleteByPrimaryKey(strategyQuestionTypes);
		return result;
	}

}
