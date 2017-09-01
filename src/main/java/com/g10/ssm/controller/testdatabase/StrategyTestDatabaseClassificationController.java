package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;
import com.g10.ssm.service.testdatabase.StrategyTestDatabaseClassificationService;

@Controller
public class StrategyTestDatabaseClassificationController {
	@Autowired
	private StrategyTestDatabaseClassificationService strategyTestDatabaseClassificationService;

	@RequestMapping("/saveStrategyTestDatabaseClassification")
	@ResponseBody
	public int saveStrategyTestDatabaseClassification(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception {
		int result = strategyTestDatabaseClassificationService
				.saveStrategyTestDatabaseClassification(strategyTestDatabaseClassification);
		return result;
	}

	@RequestMapping("/editStrategyTestDatabaseClassification")
	@ResponseBody
	public int editStrategyTestDatabaseClassification(int strategyId, Integer[] testDatabaseId) throws Exception {
		int result = strategyTestDatabaseClassificationService.deleteStrategyTestDatabaseClassification(strategyId);
		StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification = new StrategyTestDatabaseClassificationKey();
		strategyTestDatabaseClassification.setStrategyId(strategyId);
		for (int i = 0; i < testDatabaseId.length; i++) {
			strategyTestDatabaseClassification.setTestDatabaseId(testDatabaseId[i]);
			result = strategyTestDatabaseClassificationService
					.saveStrategyTestDatabaseClassification(strategyTestDatabaseClassification);
		}
		return result;
	}

	@RequestMapping("/deleteStrategyTestDatabaseClassification")
	@ResponseBody
	public int deleteStrategyTestDatabaseClassification(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception {
		int result = strategyTestDatabaseClassificationService
				.deleteStrategyTestDatabaseClassificationByPrimaryKey(strategyTestDatabaseClassification);
		return result;
	}

	@RequestMapping("/getAllStrategyTestDatabaseClassification")
	public ModelAndView getAllStrategyTestDatabaseClassification(@Param("strategyId") int strategyId,
			ModelAndView modelAndView) throws Exception {
		List<StrategyTestDatabaseClassificationKey> list = strategyTestDatabaseClassificationService
				.queryAllTestDatabaseClaasification(strategyId);
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
