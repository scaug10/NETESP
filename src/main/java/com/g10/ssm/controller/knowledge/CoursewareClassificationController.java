package com.g10.ssm.controller.knowledge;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.knowledge.CoursewareClassification;
import com.g10.ssm.service.knowledge.CoursewareClassificationService;

@Controller
public class CoursewareClassificationController {
	@Autowired
	private CoursewareClassificationService coursewareClassificationService;

	@RequestMapping("/queryCoursewareClassification")
	public Model queryCoursewareClassification(@Param("cwcfId") int cwcfId, Model model) throws Exception {
		CoursewareClassification record = coursewareClassificationService.queryCoursewareClassificationById(cwcfId);
		model.addAttribute("CWCF", record);
		return model;
	}

	@RequestMapping("/jumpToCourseware")
	public String jump() throws Exception {
		return "Courseware/courseware";
	}

	@RequestMapping("/getParentId")
	@ResponseBody
	public int getParentId(@Param("cwcfId") int cwcfId) throws Exception {
		return coursewareClassificationService.queryCoursewareClassificationById(cwcfId).getParentId();
	}

	// 获取上级目录，并将是否有子目录（0/1）设在parentId中返回
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

	@RequestMapping("/checkCoursewareClassification")
	@ResponseBody
	public int checkCoursewareClassification(@Param("classificationName") String classificationName) throws Exception {
		int result = coursewareClassificationService.checkCoursewareClassification(classificationName);
		return result;
	}

	@RequestMapping("/editCoursewareClassification")
	@ResponseBody
	public int editCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception {
		int result = coursewareClassificationService
				.checkCoursewareClassification(coursewareClassification.getClassificationName());
		if (result == 1) {
			result = 2;
			return result;
		} else {
			result = coursewareClassificationService.updateCoursewareClassification(coursewareClassification);
			return result;
		}
	}

	@RequestMapping("/saveCoursewareClassification")
	@ResponseBody
	public int saveCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception {
		int result = coursewareClassificationService
				.checkCoursewareClassification(coursewareClassification.getClassificationName());
		if (result == 1) {
			result = 2;
			return result;
		}
		result = coursewareClassificationService.saveCoursewareClassification(coursewareClassification);
		return result;
	}

	@RequestMapping("/deleteCoursewareClassification")
	@ResponseBody
	public int deleteCoursewareClassification(@Param("cwcfId") int cwcfId) throws Exception {
		int parentId = coursewareClassificationService.queryCoursewareClassificationById(cwcfId).getParentId();
		int result = coursewareClassificationService.deleteCoursewareClassificationByPrimaryKey(cwcfId);
		if (result == 0) {
			return result;
		}
		return parentId;
	}

	@RequestMapping("/getAllCoursewareClassification")
	@ResponseBody
	public List<CoursewareClassification> getAllCoursewareClassification() throws Exception {
		List<CoursewareClassification> list = coursewareClassificationService.queryCoursewareClassification();
		return list;
	}
}
