package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.TestItemsDesign;
import com.g10.ssm.service.testdatabase.TestItemsDesignService;

@Controller
public class TestItemsDesignController {
	@Autowired
	private TestItemsDesignService testItemsDesignService;

	@RequestMapping("/queryTestItemsDesign")
	public ModelAndView queryTestItemsDesign(@Param("testItemsDesignId") int testItemsDesignId,
			ModelAndView modelAndView) throws Exception {
		TestItemsDesign record = testItemsDesignService.queryTestItemsDesignById(testItemsDesignId);
		modelAndView.addObject("TestItemsDesign", record);
		return modelAndView;
	}

	@RequestMapping("/editTestItemsDesign")
	public int editTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception {
		int result = testItemsDesignService.updateTestItemsDesign(testItemsDesign);
		return result;
	}

	@RequestMapping("/saveTestItemsDesign")
	public int saveTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception {
		int result = testItemsDesignService.saveTestItemsDesign(testItemsDesign);
		return result;
	}

	@RequestMapping("/deleteTestItemsDesign")
	public int deleteTestItemsDesign(@Param("testItemsDesignId") int testItemsDesignId) throws Exception {
		int result = testItemsDesignService.deleteTestItemsDesignByPrimaryKey(testItemsDesignId);
		return result;
	}

	@RequestMapping("/getAllTestItemsDesign")
	public ModelAndView getAllTestItemsDesign(ModelAndView modelAndView) throws Exception {
		List<TestItemsDesign> list = testItemsDesignService.queryTestItemsDesign();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
