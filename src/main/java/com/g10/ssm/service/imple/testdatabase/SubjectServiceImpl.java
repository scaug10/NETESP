package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.SubjectMapper;
import com.g10.ssm.mapper.testdatabase.SubjectQueryMapper;
import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.po.testdatabase.SubjectCustom;
import com.g10.ssm.service.testdatabase.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectDao;
	@Autowired
	private SubjectQueryMapper subjectQueryDao;

	@Override
	public List<Subject> querySubject(String test) throws Exception {
		List<Subject> list = subjectQueryDao.selectAllSubject(test);
		return list;
	}

	@Override
	public int updateSubject(Subject subject) throws Exception {
		int result = subjectDao.updateByPrimaryKeySelective(subject);
		return result;
	}

	@Override
	public int saveSubject(Subject subject) throws Exception {
		int result = subjectDao.insertSelective(subject);
		return result;
	}

	@Override
	public int deleteSubjectByPrimaryKey(int subjectId) throws Exception {
		int result = subjectDao.deleteByPrimaryKey(subjectId);
		return result;
	}

	@Override
	public Subject querySubjectById(int subjectId) throws Exception {
		Subject record = subjectDao.selectByPrimaryKey(subjectId);
		return record;
	}

	@Override
	public Integer selectLastSubjectId(String content) throws Exception {
		if(content != null){
			Integer id = subjectQueryDao.selectLastInsertId(content);
			return id;
		}
		return null;
	}

	@Override
	public List<Integer> selectIdsByExample(SubjectCustom subjectCustom)
			throws Exception {
		List<Integer> ids = subjectQueryDao.selectIdsByExample(subjectCustom);
		return ids;
	}

	@Override
	public Integer deleteSubjectByIds(Integer[] ids) throws Exception {
		if(ids != null){
			Integer result = subjectQueryDao.deleteSubjectsByIds(ids);
			return result;
		}
		return null;
	}

	@Override
	public List<Subject> selectSubjectBySelective(Subject subject)
			throws Exception {
		if(subject != null){
			List<Subject> list = subjectQueryDao.selectSubjectsBySubject(subject);
			return list;
		}
		return null;
	}

}
