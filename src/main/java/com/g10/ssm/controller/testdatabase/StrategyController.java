package com.g10.ssm.controller.testdatabase;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.Strategy;
import com.g10.ssm.service.testdatabase.StrategyService;

@Controller
public class StrategyController {
	@Autowired
	private StrategyService strategyService;

	@RequestMapping("/queryStrategy")
	public ModelAndView queryStrategy(@Param("strategyId") int strategyId, ModelAndView modelAndView) throws Exception {
		Strategy record = strategyService.queryStrategyById(strategyId);
		modelAndView.addObject("strategy", record);
		return modelAndView;
	}

	@RequestMapping("/editStrategy")
	public int editStrategy(Strategy strategy) throws Exception {
		int result = strategyService.updateStrategy(strategy);
		return result;
	}

	@RequestMapping("/saveStrategy")
	public int saveStrategy(Strategy strategy) throws Exception {
		int result = strategyService.saveStrategy(strategy);
		return result;
	}

	@RequestMapping("/deleteStrategy")
	public int deleteStrategy(@Param("strategyId") int strategyId) throws Exception {
		int result = strategyService.deleteStrategyByPrimaryKey(strategyId);
		return result;
	}

}
