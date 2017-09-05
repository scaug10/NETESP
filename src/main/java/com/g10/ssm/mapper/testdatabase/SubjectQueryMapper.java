package com.g10.ssm.mapper.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.po.testdatabase.SubjectCustom;

public interface SubjectQueryMapper {
	List<Subject> selectAllSubject();
	
	public Integer selectLastInsertId(String content);
	
	public List<Integer> selectIdsByExample(SubjectCustom subjectCustom) throws Exception;
	
	
}
