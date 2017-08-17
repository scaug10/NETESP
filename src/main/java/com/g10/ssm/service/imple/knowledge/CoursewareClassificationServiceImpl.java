package com.g10.ssm.service.imple.knowledge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.knowledge.CoursewareClassificationMapper;
import com.g10.ssm.mapper.knowledge.CoursewareClassificationQueryMapper;
import com.g10.ssm.po.knowledge.CoursewareClassification;
import com.g10.ssm.service.knowledge.CoursewareClassificationService;

@Service("coursewareClassificationService")
public class CoursewareClassificationServiceImpl implements CoursewareClassificationService {

	@Autowired
	private CoursewareClassificationMapper coursewareClassificationDao;
	@Autowired
	private CoursewareClassificationQueryMapper coursewareClassificationQueryDao;

	@Override
	public List<CoursewareClassification> queryCoursewareClassification() throws Exception {
		List<CoursewareClassification> list = coursewareClassificationQueryDao.selectAllCoursewareClassification();
		return list;
	}

	@Override
	public int updateCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception {
		int result = coursewareClassificationDao.updateByPrimaryKeySelective(coursewareClassification);
		return result;
	}

	@Override
	public int saveCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception {
		int result = coursewareClassificationDao.insertSelective(coursewareClassification);
		return result;
	}

	@Override
	public int deleteCoursewareClassificationByPrimaryKey(int cwcfId) throws Exception {
		int result = coursewareClassificationDao.deleteByPrimaryKey(cwcfId);
		return result;
	}

	@Override
	public CoursewareClassification queryCoursewareClassificationById(Integer cwcfId) throws Exception {
		CoursewareClassification record = coursewareClassificationDao.selectByPrimaryKey(cwcfId);
		return record;
	}

	@Override
	public List<CoursewareClassification> getNode(int parentId) throws Exception {
		List<CoursewareClassification> list = coursewareClassificationQueryDao.selectNode(parentId);
		return list;
	}

}
