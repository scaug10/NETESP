package com.g10.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.TestTable;
import com.g10.ssm.service.TestTableService;

@Controller
public class TestController {

	@Autowired
	private TestTableService testTableService;
	
	@RequestMapping("/testTableList")
	public String intoTestTableList(){
		return "testTableList";
	}

	@RequestMapping("/queryTestTables")
	@ResponseBody
	public List<TestTable> queryTestTables(
			HttpServletResponse response, Model model, String name) throws Exception {

		List<TestTable> testTables = testTableService.queryTestTable(null);
		return testTables;
	}

	@RequestMapping("/saveTestTable")
	public String saveTestTable(TestTable testTable) throws Exception {

		int res = testTableService.saveTestTable(testTable);

		if (res == 1)
			return "redirect:queryTestTables";
		else
			return "forward:insertTestTable";
	}
	
	@RequestMapping("/testAjax")
	public String testAjax(Model mde){
		//mde.addAttribute("id", 1);
		return "testTableDetail";
	}
	
	@RequestMapping("/testTableDetail")
	@ResponseBody
	public ModelAndView queryTestTable(Model model) throws Exception{
		TestTable testTable = testTableService.queryTestTableById(1);
//		model.addAttribute(testTable);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("testTableDetail");
		modelAndView.addObject("testTable", testTable);
		return modelAndView;
	}

	@RequestMapping("/updateTestTable")
	public ModelAndView updateTestTable(@Param("testId") Integer id)
			throws Exception {

		TestTable testTable = testTableService.queryTestTableById(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("testTable", testTable);
		modelAndView.setViewName("editTestTable");

		return modelAndView;
	}

	@RequestMapping("/editTestTable")
	public String editTestTable(@Param("testTable") TestTable testTable)
			throws Exception {

		testTableService.updateTestTable(testTable);

		return "redirect:testTableList";
	}

	@RequestMapping("deleteTestTable")
	public String deleteTestTable(@Param("testId") Integer id) throws Exception {

		testTableService.deleteTestTableByPrimaryKey(id);

		return "redirect:testTableList";
	}

}
