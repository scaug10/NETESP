package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Exam;

public interface ExamQueryMapper {
	List<Exam> selectAllExam();
}
