package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.StrategyTestDatabaseClassificationMapper;
import com.g10.ssm.mapper.testdatabase.StrategyTestDatabaseClassificationQueryMapper;
import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;
import com.g10.ssm.service.testdatabase.StrategyTestDatabaseClassificationService;

@Service("strategyTestDatabaseClassification")
public class StrategyTestDatabaseClassificationServiceImpl implements StrategyTestDatabaseClassificationService {

	@Autowired
	private StrategyTestDatabaseClassificationMapper strategyTestDatabaseClassificationDao;

	@Autowired
	private StrategyTestDatabaseClassificationQueryMapper strategyTestDatabaseClassificationQueryDao;

	@Override
	public int saveStrategyTestDatabaseClassification(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception {
		int result = strategyTestDatabaseClassificationDao.insertSelective(strategyTestDatabaseClassification);
		return result;
	}

	@Override
	public int deleteStrategyTestDatabaseClassificationByPrimaryKey(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception {
		int result = strategyTestDatabaseClassificationDao.deleteByPrimaryKey(strategyTestDatabaseClassification);
		return result;
	}

	@Override
	public List<StrategyTestDatabaseClassificationKey> queryAllTestDatabaseClaasification(int strategyId) {
		List<StrategyTestDatabaseClassificationKey> list = strategyTestDatabaseClassificationQueryDao
				.selectAllTestDatabaseClassification(strategyId);
		return list;
	}

	@Override
	public int deleteStrategyTestDatabaseClassification(int strategyId) throws Exception {
		int result = strategyTestDatabaseClassificationQueryDao.deleteStrategyTestDatabaseClassification(strategyId);
		return result;
	}
}
