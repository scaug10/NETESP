package com.g10.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartLoadingController {
	
	@RequestMapping("/index")
	public String intoNetesp(){
		return "index3";
	}
	
}
