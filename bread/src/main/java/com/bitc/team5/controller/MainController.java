package com.bitc.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitc.team5.service.ReplyService;


@Controller
public class MainController {

	@Autowired
	private ReplyService replyService;
	
	
	@RequestMapping("/main")
	public String test() throws Exception{
		return "main";
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
//
//	
//	  @RequestMapping("/review") public String test10() throws Exception
//	  { return  "review"; }
//	 
//	@RequestMapping("insert.do")
//	public void insert(@ModelAttribute reviewDto review ) {
//		 replyService.create(review);
//		
//		
//	}
	
	
}

