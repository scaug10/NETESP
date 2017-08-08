package com.g10.ssm.controller.testdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;
import com.g10.ssm.service.testdatabase.StrategyTestDatabaseClassificationService;

@Controller
public class StrategyTestDatabaseClassificationController {
	@Autowired
	private StrategyTestDatabaseClassificationService strategyTestDatabaseClassificationService;

	@RequestMapping("/saveStrategyTestDatabaseClassification")
	public int saveStrategyTestDatabaseClassification(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception {
		int result = strategyTestDatabaseClassificationService
				.saveStrategyTestDatabaseClassification(strategyTestDatabaseClassification);
		return result;
	}

	@RequestMapping("/deleteStrategyTestDatabaseClassification")
	public int deleteStrategyTestDatabaseClassification(
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification) throws Exception {
		int result = strategyTestDatabaseClassificationService
				.deleteStrategyTestDatabaseClassificationByPrimaryKey(strategyTestDatabaseClassification);
		return result;
	}
}
