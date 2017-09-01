package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.UserQuestionAnswer;

public interface UserQuestionAnswerService {
	public List<UserQuestionAnswer> queryUserQuestionAnswer(String userName) throws Exception;

	public int updateUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) throws Exception;

	public int saveUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) throws Exception;

	public int deleteUserQuestionAnswerByPrimaryKey(int userAnswerId) throws Exception;

	public UserQuestionAnswer queryUserQuestionAnswerById(Integer userAnswerId) throws Exception;
}
