package com.bitc.team5.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId") != null) {
			return "redirect:/main";
		} else {
			return "/account/login";
		}
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId") != null) {
			return "redirect:/main";
		} else {
			return "/account/join";
		}
	}
	
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId") != null) {
			return "/account/myPage";
		} else {
			return "redirect:/login";
		}
	}
}



