package com.g10.ssm.controller.testdatabase;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase;
import com.g10.ssm.po.testdatabase.Strategy;
import com.g10.ssm.po.testdatabase.StrategyQuestionTypesKey;
import com.g10.ssm.po.testdatabase.StrategyTestDatabaseClassificationKey;
import com.g10.ssm.po.testdatabase.TestItemsDesign;
import com.g10.ssm.service.testdatabase.ClassificationOfTestdatabaseService;
import com.g10.ssm.service.testdatabase.StrategyQuestionTypesService;
import com.g10.ssm.service.testdatabase.StrategyService;
import com.g10.ssm.service.testdatabase.StrategyTestDatabaseClassificationService;
import com.g10.ssm.service.testdatabase.TestItemsDesignService;

@Controller
public class StrategyController {
	@Autowired
	private StrategyService strategyService;
	@Autowired
	private StrategyQuestionTypesService strategyQuestionTypesService;
	@Autowired
	private TestItemsDesignService testItemsDesignService;
	@Autowired
	private ClassificationOfTestdatabaseService classificationOfTestdatabaseService;
	@Autowired
	private StrategyTestDatabaseClassificationService strategyTestDatabaseClassificationService;

	@RequestMapping("/queryStrategy")
	public String queryStrategy(@Param("strategyName") String strategyName, @Param("status") int status, Model model)
			throws Exception {
		if (status == 2) {
			List<Strategy> list = strategyService.queryStrategyByName(strategyName);
			model.addAttribute("list", list);
		} else {
			List<Strategy> list = strategyService.queryStrategyByNameAndStatus(strategyName, status);
			model.addAttribute("list", list);
		}
		return "Strategy/strategy";
	}

	@RequestMapping("/queryTestItemsDesignByStrategyId")
	public String queryTestItemsDesign(@Param("strategyId") int strategyId, Model model) throws Exception {
		// 获取策略
		Strategy record = strategyService.queryStrategyById(strategyId);
		model.addAttribute("Strategy", record);
		// 获取策略对应的所有题库分类
		List<StrategyTestDatabaseClassificationKey> STDClist = strategyTestDatabaseClassificationService
				.queryAllTestDatabaseClaasification(strategyId);
		ClassificationOfTestdatabase[] classificationOfTestdatabases = new ClassificationOfTestdatabase[STDClist
				.size()];
		for (int i = 0; i < STDClist.size(); i++) {
			classificationOfTestdatabases[i] = classificationOfTestdatabaseService
					.queryClassificationOfTestdatabaseById(STDClist.get(i).getTestDatabaseId());
		}
		model.addAttribute("COTlist", classificationOfTestdatabases);
		// 获取全部题库分类
		List<ClassificationOfTestdatabase> list = classificationOfTestdatabaseService.selectAllClassification();
		model.addAttribute("cotlist", list);
		// 获取策略对应的所有题型设计
		List<StrategyQuestionTypesKey> SQTlist = strategyQuestionTypesService.queryStrategyQuestionTypes(strategyId);
		TestItemsDesign[] testItemsDesigns = new TestItemsDesign[SQTlist.size()];
		for (int i = 0; i < SQTlist.size(); i++) {
			testItemsDesigns[i] = testItemsDesignService
					.queryTestItemsDesignById(SQTlist.get(i).getTestItemsDesignId());
		}
		model.addAttribute("list", testItemsDesigns);
		return "Strategy/strategyModify";
	}

	@RequestMapping("/editStrategy")
	@ResponseBody
	public int editStrategy(Strategy strategy) throws Exception {
		int result = strategyService.updateStrategy(strategy);
		return result;
	}

	@RequestMapping("/addStrategy")
	public String add(Model model) throws Exception {
		List<ClassificationOfTestdatabase> list = classificationOfTestdatabaseService.selectAllClassification();
		model.addAttribute("list", list);
		return "Strategy/strategyAdd";
	}

	@RequestMapping("/saveStrategy")
	@ResponseBody
	public int saveStrategy(Strategy strategy, Integer[] testDatabaseId, String[] examType,
			Integer[] lowerlimitDifficultyId, Integer[] toplimitDifficultyId, Integer[] number, Integer[] score,
			Integer[] itemsOrder,
			HttpSession session) throws Exception {
		// 获取当前时间
		Date time = new Date(System.currentTimeMillis());
		strategy.setCreateTime(time);
		// 插入新的策略
		String username = (String) session.getAttribute("userName");
		if(username == null || username == "") return 0;
		strategy.setCreaterId(username);
		int result = strategyService.saveStrategy(strategy);
		if (result == 1) {
			// 获取新插入策略ID
			int strategyId = strategyService.selectStrategyId();
			// 将题库分类插入到策略题库分类表
			StrategyTestDatabaseClassificationKey strategyTestDatabaseClassification = new StrategyTestDatabaseClassificationKey();
			strategyTestDatabaseClassification.setStrategyId(strategyId);
			for (int i = 0; i < testDatabaseId.length; i++) {
				strategyTestDatabaseClassification.setTestDatabaseId(testDatabaseId[i]);
				result = strategyTestDatabaseClassificationService
						.saveStrategyTestDatabaseClassification(strategyTestDatabaseClassification);
			}
			if (result == 1) {
				int flag = 0;
				for (int i = 0; i < 6; i++) {
					flag = 0;
					// 为testItemsDesign赋值
					TestItemsDesign testItemsDesign = new TestItemsDesign();
					testItemsDesign.setExamType(examType[i]);
					testItemsDesign.setLowerlimitDifficultyId(lowerlimitDifficultyId[i]);
					testItemsDesign.setToplimitDifficultyId(toplimitDifficultyId[i]);
					testItemsDesign.setNumber(number[i]);
					testItemsDesign.setScore(score[i]);
					testItemsDesign.setItemsOrder(itemsOrder[i]);
					// 数量或分数为0则不插入新题型设计
					if (number[i] <= 0 || score[i] <= 0) {
						flag = 0;
					}
					// 插入新的题型设计
					else {
						flag = 1;
						result = testItemsDesignService.saveTestItemsDesign(testItemsDesign);
					}
					// 数量或分数不为0并且插入新题型设计成功
					if (flag == 1 && result == 1) {
						// 获取新插入题型设计Id
						int testItemsDesignId = testItemsDesignService.selectId();
						// 新建新题型策略对象
						StrategyQuestionTypesKey record = new StrategyQuestionTypesKey();
						record.setStrategyId(strategyId);
						record.setTestItemsDesignId(testItemsDesignId);
						// 插入新的题型策略
						result = strategyQuestionTypesService.saveStrategyQuestionTypes(record);
					}
				}
			}
		}
		return result;
	}

	@RequestMapping("/deleteStrategy")
	@ResponseBody
	public int deleteStrategy(Integer[] strategyId) throws Exception {
		int result = strategyService.deleteStrategy(strategyId);
		return result;
	}

	@RequestMapping("/getAllStrategy")
	public String getAllStrategy(Model model) throws Exception {
		List<Strategy> list = strategyService.queryStrategy();
		model.addAttribute("list", list);
		return "Strategy/strategy";
	}
}
