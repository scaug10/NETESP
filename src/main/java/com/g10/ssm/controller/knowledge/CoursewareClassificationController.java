package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.knowledge.CoursewareClassification;
import com.g10.ssm.service.knowledge.CoursewareClassificationService;

@Controller
public class CoursewareClassificationController {
	@Autowired
	private CoursewareClassificationService coursewareClassificationService;

	@RequestMapping("/queryCoursewareClassification")
	public ModelAndView queryCoursewareClassification(@Param("cwcfId") int cwcfId, ModelAndView modelAndView)
			throws Exception {
		CoursewareClassification record = coursewareClassificationService.queryCoursewareClassificationById(cwcfId);
		modelAndView.addObject("CWCF", record);
		return modelAndView;
	}

	@RequestMapping("/jumpToCourseware")
	public String jump() throws Exception {
		return "Courseware/courseware";
	}

	@RequestMapping("/getParentId")
	@ResponseBody
	public int getParentId(@Param("cwcfId") int cwcfId) throws Exception {
		/*
		 * CoursewareClassification record =
		 * coursewareClassificationService.queryCoursewareClassificationById(
		 * cwcfId); int parentId = record.getParentId(); return parentId;
		 */
		return coursewareClassificationService.queryCoursewareClassificationById(cwcfId).getParentId();
	}

	@RequestMapping("/getNode")
	@ResponseBody
	public List<CoursewareClassification> getNode(@Param("cwcfId") int cwcfId) throws Exception {
		int parentId = cwcfId;
		// System.out.println(parentId);
		List<CoursewareClassification> list = coursewareClassificationService.getNode(parentId);
		for (int i = 0; i < list.size(); i++) {
			List<CoursewareClassification> list1 = coursewareClassificationService.getNode(list.get(i).getCwcfId());
			// System.out.println(" !!!!! " + list1.isEmpty());
			if (list1.isEmpty()) {
				list.get(i).setParentId(0);
			} else {
				list.get(i).setParentId(1);
			}
		}
		return list;
	}

	@RequestMapping("/editCoursewareClassification")
	@ResponseBody
	public int editCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception {
		int result = coursewareClassificationService.updateCoursewareClassification(coursewareClassification);
		return result;
	}

	@RequestMapping("/saveCoursewareClassification")
	@ResponseBody
	public int saveCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception {
		int result = coursewareClassificationService.saveCoursewareClassification(coursewareClassification);
		return result;
	}

	@RequestMapping("/deleteCoursewareClassification")
	@ResponseBody
	public int deleteCoursewareClassification(@Param("cwcfId") int cwcfId) throws Exception {
		int result = coursewareClassificationService.deleteCoursewareClassificationByPrimaryKey(cwcfId);
		return result;
	}

	@RequestMapping("/getAllCoursewareClassification")
	public ModelAndView getAllCoursewareClassification(ModelAndView modelAndView) throws Exception {
		List<CoursewareClassification> list = coursewareClassificationService.queryCoursewareClassification();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
