package com.g10.ssm.controller;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.TestTable;
import com.g10.ssm.service.TestTableService;

@Controller
public class TestController {
	
	@Autowired
	private TestTableService testTableService;
	
	@RequestMapping("/queryTestTables")
	public ModelAndView queryTestTables() throws Exception{
		
		List<TestTable> testTables = testTableService.queryTestTable(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("testTables", testTables);
		modelAndView.setViewName("testTableList");
		
		return modelAndView;
	}
	
	@RequestMapping("/saveTestTable")
	public String saveTestTable(TestTable testTable) throws Exception{
		
		int res = testTableService.saveTestTable(testTable);
		
		if(res == 1) return "redirect:queryTestTables";
		else return "forward:insertTestTable";
	}
	
	@RequestMapping("/updateTestTable")
	public ModelAndView updateTestTable(@Param("testId")Integer id) throws Exception{
		
		TestTable testTable = testTableService.queryTestTableById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("testTable", testTable);
		modelAndView.setViewName("editTestTable");
		
		return modelAndView;
	}
	
	@RequestMapping("/editTestTable")
	public String editTestTable(@Param("testTable") TestTable testTable) throws Exception{
		
		testTableService.updateTestTable(testTable);
		
		return "redirect:queryTestTables";
	}
	
	@RequestMapping("deleteTestTable")
	public String deleteTestTable(@Param("testId")Integer id) throws Exception{
		
		testTableService.deleteTestTableByPrimaryKey(id);
		
		return "redirect:queryTestTables";
	}
	
	
}
