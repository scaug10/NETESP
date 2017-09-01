package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Log;
import com.g10.ssm.service.LogService;

@Controller
public class LogController {
	@Autowired
	private LogService logService;

	@RequestMapping("/queryLog")
	public ModelAndView queryLog(@Param("logId") int logId, ModelAndView modelAndView) throws Exception {
		Log record = logService.queryLogById(logId);
		modelAndView.addObject("Log", record);
		return modelAndView;
	}

	@RequestMapping("/editLog")
	@ResponseBody
	public int editLog(Log log) throws Exception {
		int result = logService.updateTestTable(log);
		return result;
	}

	@RequestMapping("/saveLog")
	@ResponseBody
	public int saveLog(Log log) throws Exception {
		int result = logService.saveLog(log);
		return result;
	}

	@RequestMapping("/deleteLog")
	@ResponseBody
	public int deleteLog(@Param("logId") int logId) throws Exception {
		int result = logService.deleteLogByPrimaryKey(logId);
		return result;
	}

	@RequestMapping("/getAllLog")
	public ModelAndView getAllLog(ModelAndView modelAndView) throws Exception {
		List<Log> list = logService.queryLog();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
