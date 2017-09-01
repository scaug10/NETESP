package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.Practice;

public interface PracticeService {
	public List<Practice> queryPractice() throws Exception;

	public int updatePractice(Practice practice) throws Exception;

	public int savePractice(Practice practice) throws Exception;

	public int deletePracticeByPrimaryKey(int practiceId) throws Exception;

	public Practice queryPracticeById(Integer practiceId) throws Exception;
}
