package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.TestItemsDesignWeightInfo;
import com.g10.ssm.service.testdatabase.TestItemsDesignWeightInfoService;

@Controller
public class TestItemsDesignWeightInfoController {
	@Autowired
	private TestItemsDesignWeightInfoService testItemsDesignWeightInfoService;

	@RequestMapping("/queryTestItemsDesignWeightInfo")
	public ModelAndView queryTestItemsDesignWeightInfo(@Param("weightId") int weightId, ModelAndView modelAndView)
			throws Exception {
		TestItemsDesignWeightInfo record = testItemsDesignWeightInfoService
				.queryTestItemsDesignWeightInfoById(weightId);
		modelAndView.addObject("TDW", record);
		return modelAndView;
	}

	@RequestMapping("/editTestItemsDesignWeightInfo")
	@ResponseBody
	public int editTestItemsDesignWeightInfo(TestItemsDesignWeightInfo testItemsDesignWeightInfo) throws Exception {
		int result = testItemsDesignWeightInfoService.updateTestItemsDesignWeightInfo(testItemsDesignWeightInfo);
		return result;
	}

	@RequestMapping("/saveTestItemsDesignWeightInfo")
	@ResponseBody
	public int saveTestItemsDesignWeightInfo(TestItemsDesignWeightInfo testItemsDesignWeightInfo) throws Exception {
		int result = testItemsDesignWeightInfoService.saveTestItemsDesignWeightInfo(testItemsDesignWeightInfo);
		return result;
	}

	@RequestMapping("/deleteTestItemsDesignWeightInfo")
	@ResponseBody
	public int deleteTestItemsDesignWeightInfo(@Param("weightId") int weightId) throws Exception {
		int result = testItemsDesignWeightInfoService.deleteTestItemsDesignWeightInfoByPrimaryKey(weightId);
		return result;
	}

	@RequestMapping("/getAllTestItemsDesignWeightInfo")
	public ModelAndView getAllTestItemsDesignWeightInfo(ModelAndView modelAndView) throws Exception {
		List<TestItemsDesignWeightInfo> list = testItemsDesignWeightInfoService.queryTestItemsDesignWeightInfo();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
