package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;
import com.g10.ssm.po.testdatabase.TestItemsDesign;
import com.g10.ssm.service.testdatabase.StrategyQuestionTypesService;
import com.g10.ssm.service.testdatabase.TestItemsDesignService;

@Controller
public class TestItemsDesignController {
	@Autowired
	private TestItemsDesignService testItemsDesignService;
	@Autowired
	private StrategyQuestionTypesService strategyQuestionTypesService;

	@RequestMapping("/queryTestItemsDesign")
	public ModelAndView queryTestItemsDesign(@Param("testItemsDesignId") int testItemsDesignId,
			ModelAndView modelAndView) throws Exception {
		TestItemsDesign record = testItemsDesignService.queryTestItemsDesignById(testItemsDesignId);
		modelAndView.addObject("TestItemsDesign", record);
		return modelAndView;
	}

	@RequestMapping("/editTestItemsDesign")
	@ResponseBody
	public int editTestItemsDesign(TestItemsDesign testItemsDesign) throws Exception {
		int result = testItemsDesignService.updateTestItemsDesign(testItemsDesign);
		return result;
	}

	@RequestMapping("/saveTestItemsDesign")
	@ResponseBody
	public int saveTestItemsDesign(TestItemsDesign testItemsDesign, @Param("strategyId") int strategyId)
			throws Exception {
		int result = testItemsDesignService.saveTestItemsDesign(testItemsDesign);
		if (result == 1) {
			int testItemsDesignId = testItemsDesignService.selectId();
			StrategyQuestionTypesKey record = new StrategyQuestionTypesKey();
			record.setStrategyId(strategyId);
			record.setTestItemsDesignId(testItemsDesignId);
			result = strategyQuestionTypesService.saveStrategyQuestionTypes(record);
		}
		return result;
	}

	@RequestMapping("/deleteTestItemsDesign")
	@ResponseBody
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
