package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/getAllQuestionTypes")
	public ModelAndView getAllQuestionTypes(@Param("strategyId") int strategyId, ModelAndView modelAndView)
			throws Exception {
		List<StrategyQuestionTypesKey> list = strategyQuestionTypesService.queryStrategyQuestionTypes(strategyId);
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
