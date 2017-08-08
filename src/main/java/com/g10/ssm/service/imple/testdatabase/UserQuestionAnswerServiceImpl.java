package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.UserQuestionAnswerMapper;
import com.g10.ssm.mapper.testdatabase.UserQuestionAnswerQueryMapper;
import com.g10.ssm.po.testdatabase.UserQuestionAnswer;
import com.g10.ssm.service.testdatabase.UserQuestionAnswerService;

@Service("userQuestionAnswerService")
public class UserQuestionAnswerServiceImpl implements UserQuestionAnswerService {
	@Autowired
	private UserQuestionAnswerMapper userQuestionAnswerDao;
	@Autowired
	private UserQuestionAnswerQueryMapper userQuestionAnswerQueryDao;

	@Override
	public List<UserQuestionAnswer> queryUserQuestionAnswer() throws Exception {
		List<UserQuestionAnswer> list = userQuestionAnswerQueryDao.selectAllUserQuestionAnswer();
		return list;
	}

	@Override
	public int updateUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) throws Exception {
		int result = userQuestionAnswerDao.updateByPrimaryKeySelective(userQuestionAnswer);
		return result;
	}

	@Override
	public int saveUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) throws Exception {
		int result = userQuestionAnswerDao.insertSelective(userQuestionAnswer);
		return result;
	}

	@Override
	public int deleteUserQuestionAnswerByPrimaryKey(int userAnswerId) throws Exception {
		int result = userQuestionAnswerDao.deleteByPrimaryKey(userAnswerId);
		return result;
	}

	@Override
	public UserQuestionAnswer queryUserQuestionAnswerById(Integer userAnswerId) throws Exception {
		UserQuestionAnswer record = userQuestionAnswerDao.selectByPrimaryKey(userAnswerId);
		return record;
	}
}
