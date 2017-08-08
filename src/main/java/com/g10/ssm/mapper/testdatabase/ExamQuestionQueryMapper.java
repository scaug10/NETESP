package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.ExamQuestionKey;

public interface ExamQuestionQueryMapper {
	List<ExamQuestionKey> selectAllExamQuestion();
}
