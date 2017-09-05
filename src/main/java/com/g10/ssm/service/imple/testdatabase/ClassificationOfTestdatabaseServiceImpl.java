package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.ClassificationOfTestdatabaseMapper;
import com.g10.ssm.mapper.testdatabase.ClassificationOfTestdatabaseQueryMapper;
import com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase;
import com.g10.ssm.service.testdatabase.ClassificationOfTestdatabaseService;

@Service("classificationOfTestdatabase")
public class ClassificationOfTestdatabaseServiceImpl implements ClassificationOfTestdatabaseService {

	@Autowired
	private ClassificationOfTestdatabaseMapper classificationOfTestdatabaseDao;
	@Autowired
	private ClassificationOfTestdatabaseQueryMapper classificationOfTestdatabaseQueryDao;

	@Override
	public List<ClassificationOfTestdatabase> selectAllClassification() throws Exception {
		List<ClassificationOfTestdatabase> list = classificationOfTestdatabaseQueryDao.selectAllClassification();
		return list;
	}

	@Override
	public int updateClassificationOfTestdatabase(ClassificationOfTestdatabase classificationOfTestdatabase)
			throws Exception {
		int result = classificationOfTestdatabaseDao.updateByPrimaryKeySelective(classificationOfTestdatabase);
		return result;
	}

	@Override
	public int saveClassificationOfTestdatabase(ClassificationOfTestdatabase classificationOfTestdatabase)
			throws Exception {
		int result = classificationOfTestdatabaseDao.insertSelective(classificationOfTestdatabase);
		return result;
	}

	@Override
	public int deleteClassificationOfTestdatabase(int testDatabaseId) throws Exception {
		int result = classificationOfTestdatabaseDao.deleteByPrimaryKey(testDatabaseId);
		return result;
	}

	@Override
	public ClassificationOfTestdatabase queryClassificationOfTestdatabaseById(Integer testDatabaseId) throws Exception {
		ClassificationOfTestdatabase record = classificationOfTestdatabaseDao.selectByPrimaryKey(testDatabaseId);
		return record;
	}

	@Override
	public List<ClassificationOfTestdatabase> selectAllClassificationOfTestdatabase() throws Exception {
		List<ClassificationOfTestdatabase> list = classificationOfTestdatabaseQueryDao
				.selectAllClassificationOfTestDatabase();
		return list;
	}

}
