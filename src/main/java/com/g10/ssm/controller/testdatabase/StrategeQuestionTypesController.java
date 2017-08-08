package com.g10.ssm.controller.testdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;
import com.g10.ssm.service.testdatabase.StrategyQuestionTypesService;

@Controller
public class StrategeQuestionTypesController {
	@Autowired
	private StrategyQuestionTypesService strategyQuestionTypesService;

	@RequestMapping("/saveStrategyQuestionTypes")
	public int saveStrategyQuestionTypes(StrategyQuestionTypesKey strategyQuestionTypes) throws Exception {
		int result = strategyQuestionTypesService.saveStrategyQuestionTypes(strategyQuestionTypes);
		return result;
	}

	@RequestMapping("/deleteStrategyQuestionTypes")
	public int deleteStrategyQuestionTypes(StrategyQuestionTypesKey strategyQuestionTypes) throws Exception {
		int result = strategyQuestionTypesService.deleteStrategyQuestionTypesByPrimaryKey(strategyQuestionTypes);
		return result;
	}
}
