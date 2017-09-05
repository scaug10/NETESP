package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase;

public interface ClassificationOfTestdatabaseService {
	public int updateClassificationOfTestdatabase(ClassificationOfTestdatabase classificationOfTestdatabase)
			throws Exception;

	public int saveClassificationOfTestdatabase(ClassificationOfTestdatabase classificationOfTestdatabase)
			throws Exception;

	public int deleteClassificationOfTestdatabase(int testDatabaseId) throws Exception;

	public ClassificationOfTestdatabase queryClassificationOfTestdatabaseById(Integer testDatabaseId) throws Exception;

	public List<ClassificationOfTestdatabase> selectAllClassification() throws Exception;

	public List<ClassificationOfTestdatabase> selectAllClassificationOfTestdatabase() throws Exception;
}
