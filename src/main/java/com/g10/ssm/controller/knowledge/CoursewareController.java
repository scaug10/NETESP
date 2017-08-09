package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.knowledge.Courseware;
import com.g10.ssm.service.knowledge.CoursewareService;

@Controller
public class CoursewareController {
	@Autowired
	private CoursewareService coursewareService;

	@RequestMapping("/queryCourseware")
	public ModelAndView queryCourseware(@Param("coursewareId") int coursewareId, ModelAndView modelAndView)
			throws Exception {
		Courseware record = coursewareService.queryCoursewareById(coursewareId);
		modelAndView.addObject("Courseware", record);
		return modelAndView;
	}

	@RequestMapping("/editCourseware")
	@ResponseBody
	public int editCourseware(Courseware courseware) throws Exception {
		int result = coursewareService.updateCourseware(courseware);
		return result;
	}

	@RequestMapping("/saveCourseware")
	@ResponseBody
	public int saveCourseware(Courseware courseware) throws Exception {
		int result = coursewareService.saveCourseware(courseware);
		return result;
	}

	@RequestMapping("/deleteCourseware")
	@ResponseBody
	public int deleteCourseware(@Param("coursewareId") int coursewareId) throws Exception {
		int result = coursewareService.deleteCoursewareByPrimaryKey(coursewareId);
		return result;
	}

	@RequestMapping("/getAllCourseware")
	public ModelAndView getAllCourseware(ModelAndView modelAndView) throws Exception {
		List<Courseware> list = coursewareService.queryCourseware();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
