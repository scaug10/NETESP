package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.ExamTypeWeightMapper;
import com.g10.ssm.mapper.testdatabase.ExamTypeWeightQueryMapper;
import com.g10.ssm.po.testdatabase.ExamTypeWeightKey;
import com.g10.ssm.service.testdatabase.ExamTypeWeightService;

@Service("examTypeWeightService")
public class ExamTypeWeightServiceImpl implements ExamTypeWeightService {

	@Autowired
	private ExamTypeWeightMapper examTypeWeightDao;
	@Autowired
	private ExamTypeWeightQueryMapper examTypeWeightQueryDao;

	@Override
	public List<ExamTypeWeightKey> queryExamTypeWeight() throws Exception {
		List<ExamTypeWeightKey> list = examTypeWeightQueryDao.selectAllExamTypeWeight();
		return list;
	}

	@Override
	public int saveExamTypeWeight(ExamTypeWeightKey examTypeWeight) throws Exception {
		int result = examTypeWeightDao.insertSelective(examTypeWeight);
		return result;
	}

	@Override
	public int deleteExamTypeWeightByPrimaryKey(ExamTypeWeightKey examTypeWeight) throws Exception {
		int result = examTypeWeightDao.deleteByPrimaryKey(examTypeWeight);
		return result;
	}

}
