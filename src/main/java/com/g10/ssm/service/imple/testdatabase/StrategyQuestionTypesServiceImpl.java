package com.g10.ssm.service.imple.testdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.StrategyQuestionTypesMapper;
import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;
import com.g10.ssm.service.testdatabase.StrategyQuestionTypesService;

@Service("strategyQuestionTypes")
public class StrategyQuestionTypesServiceImpl implements StrategyQuestionTypesService {

	@Autowired
	private StrategyQuestionTypesMapper strategyQuestionTypesDao;

	/*
	 * @Override public List<StrategyQuestionTypesKey>
	 * queryStrategyQuestionTypes(StrategyQuestionTypesKey
	 * strategyQuestionTypes) throws Exception { // TODO 自动生成的方法存根 return null;
	 * }
	 */
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
