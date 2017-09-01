package com.g10.ssm.service.imple.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.knowledge.CoursewareQueryMapper;
import com.g10.ssm.mapper.knowledge.CoursewareMapper;
import com.g10.ssm.po.knowledge.Courseware;
import com.g10.ssm.service.knowledge.CoursewareService;

@Service("coursewareService")
public class CoursewareServiceImpl implements CoursewareService {

	@Autowired
	private CoursewareMapper coursewareDao;
	@Autowired
	private CoursewareQueryMapper coursewareQueryDao;

	@Override
	public List<Courseware> queryCourseware() throws Exception {
		List<Courseware> list = coursewareQueryDao.selectAllCourseware();
		return list;
	}

	@Override
	public int updateCourseware(Courseware courseware) throws Exception {
		int result = coursewareDao.updateByPrimaryKeySelective(courseware);
		return result;
	}

	@Override
	public int saveCourseware(Courseware courseware) throws Exception {
		int result = coursewareDao.insertSelective(courseware);
		return result;
	}

	@Override
	public int deleteCoursewareByPrimaryKey(int coursewareId) throws Exception {
		int result = coursewareDao.deleteByPrimaryKey(coursewareId);
		return result;
	}

	@Override
	public Courseware queryCoursewareById(Integer coursewareId) throws Exception {
		Courseware record = coursewareDao.selectByPrimaryKey(coursewareId);
		return record;
	}

	@Override
	public List<Courseware> getCoursewareByCategoryId(int cwcfId) throws Exception {
		List<Courseware> list = coursewareQueryDao.selectByCategoryId(cwcfId);
		return list;
	}

	@Override
	public List<Courseware> getCoursewareByName(String coursewareName) throws Exception {
		List<Courseware> list = coursewareQueryDao.selectByName(coursewareName);
		return list;
	}

	@Override
	public int deleteCourseware(ArrayList<Integer> list) throws Exception {
		int result = coursewareQueryDao.deleteCourseware(list);
		return result;
	}

}
