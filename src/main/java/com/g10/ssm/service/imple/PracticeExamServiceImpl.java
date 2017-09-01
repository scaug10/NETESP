package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.PracticeExamMapper;
import com.g10.ssm.mapper.PracticeExamQueryMapper;
import com.g10.ssm.po.PracticeExamKey;
import com.g10.ssm.service.PracticeExamService;

@Service("practiceExamService")
public class PracticeExamServiceImpl implements PracticeExamService {

	@Autowired
	private PracticeExamMapper practiceExamDao;
	@Autowired
	private PracticeExamQueryMapper practiceExamQueryDao;

	@Override
	public List<PracticeExamKey> queryPracticeExam() throws Exception {
		List<PracticeExamKey> list = practiceExamQueryDao.selectAllPracticeExam();
		return list;
	}

	/*
	 * @Override public int updatePracticeExam(PracticeExamKey practiceExam)
	 * throws Exception {
	 * 
	 * return 0; }
	 */

	@Override
	public int savePracticeExam(PracticeExamKey practiceExam) throws Exception {
		int result = practiceExamDao.insertSelective(practiceExam);
		return result;
	}

	@Override
	public int deletePracticeExamByPrimaryKey(PracticeExamKey practiceExam) throws Exception {
		int result = practiceExamDao.deleteByPrimaryKey(practiceExam);
		return result;
	}

	@Override
	public List<PracticeExamKey> queryPracticeExamById(Integer examId) throws Exception {
		List<PracticeExamKey> list = practiceExamQueryDao.selectAllPractice(examId);
		return list;
	}

}
