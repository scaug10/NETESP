package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.po.testdatabase.SubjectCustom;

public interface SubjectService {
	public List<Subject> querySubject() throws Exception;

	public int updateSubject(Subject subject) throws Exception;

	public int saveSubject(Subject subject) throws Exception;

	public int deleteSubjectByPrimaryKey(int subjectId) throws Exception;

	public Subject querySubjectById(int subjectId) throws Exception;
	
	public Integer selectLastSubjectId(String content) throws Exception;
	
//	public List<Subject> selectSubjectBySelective(Subject subject) throws Exception;
	
	public List<Integer> selectIdsByExample(SubjectCustom subjectCustom) throws Exception;
	
}
