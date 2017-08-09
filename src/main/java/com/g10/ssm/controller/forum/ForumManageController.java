package com.g10.ssm.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g10.ssm.service.forum.BoardService;

/**
 * 
 * @ClassName: FormManageController
 * @Description: 论坛管理控制器
 * @author 	FYW
 * @date 	2017年8月7日 上午10:04:59
 */
@Controller
@RequestMapping("")
public class ForumManageController {
	
	@Autowired
	private BoardService boardService;
	
}
