package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.ExamQuestionMapper;
import com.g10.ssm.mapper.testdatabase.ExamQuestionQueryMapper;
import com.g10.ssm.po.testdatabase.ExamQuestionKey;
import com.g10.ssm.service.testdatabase.ExamQuestionService;

@Service("examQuestionService")
public class ExamQuestionServiceImpl implements ExamQuestionService {

	@Autowired
	private ExamQuestionMapper examQuestionDao;
	@Autowired
	private ExamQuestionQueryMapper examQuestionQueryDao;

	@Override
	public List<ExamQuestionKey> queryExamQuestion() throws Exception {
		List<ExamQuestionKey> list = examQuestionQueryDao.selectAllExamQuestion();
		return list;
	}

	/*
	 * @Override public int updateExamQuestion(ExamQuestionKey examQuestion)
	 * throws Exception { int result = examQuestionDao.update return 0; }
	 */

	@Override
	public int saveExamQuestion(ExamQuestionKey examQuestion) throws Exception {
		int result = examQuestionDao.insertSelective(examQuestion);
		return result;
	}

	@Override
	public int deleteExamQuestionByPrimaryKey(ExamQuestionKey examQuestion) throws Exception {
		int result = examQuestionDao.deleteByPrimaryKey(examQuestion);
		return result;
	}

	@Override
	public List<ExamQuestionKey> queryAllQuestion(int examId) throws Exception {
		List<ExamQuestionKey> list = examQuestionQueryDao.selectAllQuestion(examId);
		return list;
	}

}
