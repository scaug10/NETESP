package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.PracticeExamKey;

public interface PracticeExamQueryMapper {
	List<PracticeExamKey> selectAllPracticeExam();

	List<PracticeExamKey> selectAllPractice(int examId);
}
