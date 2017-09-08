package com.g10.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.Department;
import com.g10.ssm.po.LearningTask;
import com.g10.ssm.po.LearningTaskCoursewareKey;
import com.g10.ssm.po.LearningTaskExt;
import com.g10.ssm.po.UserLearningTaskKey;
import com.g10.ssm.po.knowledge.Courseware;
import com.g10.ssm.service.DepartmentService;
import com.g10.ssm.service.LearningTaskCoursewareService;
import com.g10.ssm.service.LearningTaskService;
import com.g10.ssm.service.UserLearningTaskService;
import com.g10.ssm.service.knowledge.CoursewareService;

@Controller
public class LearningTaskController {
	@Autowired
	private LearningTaskService learningTaskService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CoursewareService coursewareService;
	@Autowired
	private LearningTaskCoursewareService learningTaskCoursewareService;
	@Autowired
	private UserLearningTaskService userLearningTaskService;

	@RequestMapping("/queryLearningTask")
	@ResponseBody
	public LearningTaskExt queryLearningTask(@Param("learningTaskId") int learningTaskId) throws Exception {
		LearningTaskExt record = learningTaskService.queryLearningTaskByLearningTaskId(learningTaskId);
		Integer[] departmentId = userLearningTaskService.getAllDepartmentId(learningTaskId);
		record.setDepartmentId(departmentId);
		Integer[] coursewareId = learningTaskCoursewareService.getAllCoursewareId(learningTaskId);
		record.setCoursewareId(coursewareId);
		return record;
	}

	@RequestMapping("/editLearningTask")
	@ResponseBody
	public int editLearningTask(LearningTask learningTask, Integer[] departmentId, Integer[] coursewareId)
			throws Exception {
		int result = learningTaskService.updateLearningTask(learningTask);
		if (result == 1) {
			int learningTaskId = learningTask.getLearningTaskId();
			result = userLearningTaskService.deleteUserLearningTask(learningTaskId);
			UserLearningTaskKey userLearningTask = new UserLearningTaskKey();
			userLearningTask.setLearningTaskId(learningTaskId);
			for (int i = 0; i < departmentId.length; i++) {
				String[] userName = userLearningTaskService.getAllUserName(departmentId[i]);
				for (int j = 0; j < userName.length; j++) {
					userLearningTask.setUserName(userName[j]);
					result = userLearningTaskService.saveUserLearningTask(userLearningTask);
				}
			}
			result = learningTaskCoursewareService.deleteLearningTaskCourseware(learningTaskId);
			LearningTaskCoursewareKey record = new LearningTaskCoursewareKey();
			record.setLearningTaskId(learningTaskId);
			for (int i = 0; i < coursewareId.length; i++) {
				record.setCoursewareId(coursewareId[i]);
				result = learningTaskCoursewareService.saveLearningTaskCourseware(record);
			}
			if (result != 1)
				return result;
		}
		return result;
	}

	@RequestMapping("/saveLearningTask")
	@ResponseBody
	public int saveLearningTask(LearningTask learningTask, Integer[] departmentId, Integer[] coursewareId)
			throws Exception {
		int result = learningTaskService.saveLearningTask(learningTask);
		int learningTaskId = learningTaskService.selectId();
		if (result == 1 && learningTaskId > 0) {
			UserLearningTaskKey userLearningTask = new UserLearningTaskKey();
			userLearningTask.setLearningTaskId(learningTaskId);
			for (int i = 0; i < departmentId.length; i++) {
				String[] userName = userLearningTaskService.getAllUserName(departmentId[i]);
				for (int j = 0; j < userName.length; j++) {
					userLearningTask.setUserName(userName[j]);
					result = userLearningTaskService.saveUserLearningTask(userLearningTask);
				}
			}
			LearningTaskCoursewareKey record = new LearningTaskCoursewareKey();
			record.setLearningTaskId(learningTaskId);
			for (int i = 0; i < coursewareId.length; i++) {
				record.setCoursewareId(coursewareId[i]);
				result = learningTaskCoursewareService.saveLearningTaskCourseware(record);
			}
			if (result != 1)
				return result;
		}
		return result;
	}

	@RequestMapping("/deleteLearningTask")
	@ResponseBody
	public int deleteLearningTask(Integer[] learningTaskId) throws Exception {
		int result = learningTaskService.deleteLearningTask(learningTaskId);
		return result;
	}

	@RequestMapping("/searchLearningTask")
	@ResponseBody
	public List<LearningTaskExt> searchLearningTask(@Param("taskName") String taskName) throws Exception {
		List<LearningTaskExt> list = learningTaskService.searchLearningTask(taskName);
		for (int i = 0; i < list.size(); i++) {
			String[] departmentName = userLearningTaskService
					.getAllLearningTaskDepartment(list.get(i).getLearningTaskId());
			String[] coursewareUrl = learningTaskCoursewareService
					.queryAllCoursewareUrl(list.get(i).getLearningTaskId());
			list.get(i).setDepartmentName(departmentName);
			list.get(i).setCoursewareUrl(coursewareUrl);
		}
		return list;
	}

	@RequestMapping("/jumpToLearningTask")
	public String jumpToLearningTask(Model model) throws Exception {
		List<Courseware> courseware = coursewareService.queryCourseware();
		model.addAttribute("courseware", courseware);
		List<Department> department = departmentService.queryDepartment();
		model.addAttribute("department", department);
		return "LearningTask/learningtask";
	}

	@RequestMapping("/getAllLearningTask")
	@ResponseBody
	public List<LearningTaskExt> getAllLearningTask() throws Exception {
		List<LearningTaskExt> list = learningTaskService.queryLearningTask();
		for (int i = 0; i < list.size(); i++) {
			String[] departmentName = userLearningTaskService
					.getAllLearningTaskDepartment(list.get(i).getLearningTaskId());
			String[] coursewareUrl = learningTaskCoursewareService
					.queryAllCoursewareUrl(list.get(i).getLearningTaskId());
			list.get(i).setDepartmentName(departmentName);
			list.get(i).setCoursewareUrl(coursewareUrl);
		}
		return list;
	}

	@RequestMapping("/getStudyStatistics")
	public String getStudyStatistics(Model model) throws Exception {
		List<Department> department = departmentService.queryDepartment();
		model.addAttribute("department", department);
		return "LearningTask/studyStatistics";
	}

	@RequestMapping("/getDepartmentLearningTask")
	@ResponseBody
	public LearningTaskExt[] getDepartmentLearningTask(Integer departmentId) throws Exception {
		Integer[] LearningTaskId = userLearningTaskService.getAllLearningTaskByDepartmentId(departmentId);
		LearningTaskExt[] list = new LearningTaskExt[LearningTaskId.length];
		for (int i = 0; i < LearningTaskId.length; i++) {
			list[i] = learningTaskService.queryLearningTaskByLearningTaskId(LearningTaskId[i]);
		}
		for (int i = 0; i < list.length; i++) {
			list[i].setUserName(userLearningTaskService.getLearningTaskById(list[i].getLearningTaskId()));
		}
		return list;
	}

	@RequestMapping("/getStudyTask")
	@ResponseBody
	public List<LearningTaskExt> getStudyTask(HttpServletRequest request) throws Exception {
		String userName = (String) request.getSession().getAttribute("userName");
		List<LearningTaskExt> list = learningTaskService.getAllLearningTaskByUserName(userName);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCoursewareUrl(
					learningTaskCoursewareService.queryAllCoursewareUrl(list.get(i).getLearningTaskId()));
		}
		return list;
	}

	@RequestMapping("/jumpToMyStudyTask")
	public String jumpToMyStudyTask() throws Exception {
		return "LearningTask/checkStudyTask";
	}
}
