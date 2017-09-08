package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.po.testdatabase.SubjectCustom;

public interface SubjectQueryMapper {
	List<Subject> selectAllSubject(String test);
	
	public Integer selectLastInsertId(String content);
	
	public List<Integer> selectIdsByExample(SubjectCustom subjectCustom) throws Exception;
	
	public Integer deleteSubjectsByIds(Integer[] ids) throws Exception;
	
	public List<Subject> selectSubjectsBySubject(Subject subject) throws Exception;
}
