package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Notice;
import com.g10.ssm.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/queryNotice")
	public ModelAndView queryNotice(@Param("noticeId") int noticeId, ModelAndView modelAndView) throws Exception {
		Notice record = noticeService.queryNoticeById(noticeId);
		modelAndView.addObject("Notice", record);
		return modelAndView;
	}

	@RequestMapping("/editNotice")
	@ResponseBody
	public int editNotice(Notice notice) throws Exception {
		int result = noticeService.updateNotice(notice);
		return result;
	}

	@RequestMapping("/saveNotice")
	@ResponseBody
	public int saveNotice(Notice notice) throws Exception {
		int result = noticeService.saveNotice(notice);
		return result;
	}

	@RequestMapping("/deleteNotice")
	@ResponseBody
	public int deleteNotice(@Param("noticeId") int noticeId) throws Exception {
		int result = noticeService.deleteNoticeByPrimaryKey(noticeId);
		return result;
	}

	@RequestMapping("/getAllNotice")
	public ModelAndView getAllNotice(ModelAndView modelAndView) throws Exception {
		List<Notice> list = noticeService.queryNotice();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
