package com.bitc.team5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public String test() throws Exception{
		return "main";
	}
	
	@RequestMapping("/shop2")
	public String test0() throws Exception{
		return "shop2";
	}
	
	
	@RequestMapping("/detail")
	public String test1() throws Exception{
		return "detail";
	}
	

	@RequestMapping("/detail2")
	public String test2() throws Exception{
		return "detail2";
	}
	
	@RequestMapping("/detail3")
	public String test3() throws Exception{
		return "detail3";
	}
	
	
}
