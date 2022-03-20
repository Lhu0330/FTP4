package com.bitc.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitc.team5.service.shopping.ReplyService;


@Controller
public class MainController {

	@Autowired
	private ReplyService replyService;
	


	@RequestMapping("/main")
	public String test() throws Exception{
		return "main";
	}


	@RequestMapping("/mypage")
	public String mypage() throws Exception{
		return "/mypage/mypage";
	}
	
	
	@RequestMapping("/detail")
	public String test1() throws Exception{
		return "detail";
	}
	

	@RequestMapping("/detail2")
	public String test2() throws Exception{
		return "detail2";
	}
	
	@RequestMapping("/test3")
	public String test3() throws Exception{
		return "shop/detailCalender";
	}
	
	@RequestMapping("/test4")
	public String test4() throws Exception{
		return "shop/detailCalender2";
	}
	
	@RequestMapping("/test5")
	public String test5() throws Exception{
		return "shop/detailCalender3";
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

