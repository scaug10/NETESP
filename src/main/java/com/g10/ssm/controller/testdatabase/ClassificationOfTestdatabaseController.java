package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase;
import com.g10.ssm.service.testdatabase.ClassificationOfTestdatabaseService;

@Controller
public class ClassificationOfTestdatabaseController {
	@Autowired
	private ClassificationOfTestdatabaseService classificationOfTestdatabaseService;

	@RequestMapping("/queryClassificationOfTestdatabase")
	public ModelAndView queryClassificationOfTestdatabase(@Param("testDatabaseId") int testDatabaseId,
			ModelAndView modelAndView) throws Exception {
		ClassificationOfTestdatabase record = classificationOfTestdatabaseService
				.queryClassificationOfTestdatabaseById(testDatabaseId);
		modelAndView.addObject("COT", record);
		return modelAndView;
	}

	@RequestMapping("/saveClassificationOfTestdatabase")
	@ResponseBody
	public int saveClassificationOfTestdatabase(ClassificationOfTestdatabase classificationOfTestdatabase)
			throws Exception {
		int result = classificationOfTestdatabaseService.saveClassificationOfTestdatabase(classificationOfTestdatabase);
		return result;
	}

	@RequestMapping("/editClassificationOfTestdatabase")
	@ResponseBody
	public int editClassificationOfTestdatabase(ClassificationOfTestdatabase classificationOfTestdatabase)
			throws Exception {
		int result = classificationOfTestdatabaseService
				.updateClassificationOfTestdatabase(classificationOfTestdatabase);
		return result;
	}

	@RequestMapping("/deleteClassificationOfTestdatabase")
	@ResponseBody
	public int deleteClassificationOfTestdatabase(@Param("testDatabaseId") int testDatabaseId) throws Exception {
		int result = classificationOfTestdatabaseService.deleteClassificationOfTestdatabase(testDatabaseId);
		return result;
	}

	@RequestMapping("/getAllClassificationOfTestdatabase")
	public ModelAndView getAllClassificationOfTestdatabase(ModelAndView modelAndView) throws Exception {
		List<ClassificationOfTestdatabase> list = classificationOfTestdatabaseService.selectAllClassification();
		modelAndView.addObject("COTlist", list);
		return modelAndView;
	}
}