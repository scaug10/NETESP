package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.ExamMapper;
import com.g10.ssm.mapper.testdatabase.ExamQueryMapper;
import com.g10.ssm.po.testdatabase.Exam;
import com.g10.ssm.service.testdatabase.ExamService;

@Service("examService")
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamMapper examDao;
	@Autowired
	private ExamQueryMapper examQueryDao;

	@Override
	public List<Exam> queryExam() throws Exception {
		List<Exam> list = examQueryDao.selectAllExam();
		return list;
	}

	@Override
	public int updateExam(Exam exam) throws Exception {
		int result = examDao.updateByPrimaryKeySelective(exam);
		return result;
	}

	@Override
	public int saveExam(Exam exam) throws Exception {
		int result = examDao.insertSelective(exam);
		return result;
	}

	@Override
	public int deleteExamByPrimaryKey(int examId) throws Exception {
		int result = examDao.deleteByPrimaryKey(examId);
		return result;
	}

	@Override
	public Exam queryExamById(Integer examId) throws Exception {
		Exam record = examDao.selectByPrimaryKey(examId);
		return record;
	}

}
