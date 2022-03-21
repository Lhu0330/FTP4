package com.bitc.team5.controller.master;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.login.LoginDto;
import com.bitc.team5.service.login.LoginService;



@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
		
//	로그인 페이지
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String login() throws Exception {
		return "/login/login";
	}
	
//	사용자 정보확인 페이지
	@RequestMapping(value="/login/loginCheck", method=RequestMethod.POST)
	public String loginCheck(LoginDto member, HttpServletRequest request) throws Exception {
		int count = loginService.selectMemberInfoYn(member.getUserId(), member.getUserPw());
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		String UserAuth = loginService.selectMemberUserAuth(userId,userPw); 
		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", member.getUserId());
			session.setAttribute("userAuth", UserAuth);
			session.setMaxInactiveInterval(300);
			return "redirect:/login/loginOK";
		}
		else {
			return "redirect:/login/loginFail";	
		}
	}
	
//	로그인 성공시 접속페이지
	@RequestMapping(value="/login/loginOK", method=RequestMethod.GET)
	public String loginOK(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId") != null) {
			String userAuth = (String)session.getAttribute("userAuth");
			model.addAttribute("userAuth", userAuth);
			String userId = (String)session.getAttribute("userId");
			model.addAttribute("userId", userId);
						
			return "redirect:/main";
		}
		else {
			return "/login/loginFail";
		}	
	}
	
	@RequestMapping(value="/login/userLogin", method=RequestMethod.GET)
	public String userLogin() throws Exception {
		return "/login/userLogin";
	}
		
//	로그아웃 페이지
	@RequestMapping(value="/login/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session =  request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		
		return "redirect:/main";
	}
	
//	로그인 실패 페이지
	@RequestMapping(value="/login/loginFail", method=RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/login/loginFail";
	}
	
//	회원가입 페이지
	
	@RequestMapping(value="/login/register", method=RequestMethod.GET)
	public String registerMember() throws Exception {
		return "/login/register";
	}
	
//	일반회원 가입페이지
	@RequestMapping(value="/login/registerUser", method=RequestMethod.POST)
	public String registerUser(LoginDto register) throws Exception {
		loginService.registerUser(register);
		
		return "redirect:/login/login";
	}
	
	@RequestMapping(value="/login/registerUser", method=RequestMethod.GET)
	public String registerUser() throws Exception {
		return "/login/registerUser";
	}
	
//	판매자 가입페이지
	@RequestMapping(value="/login/registerSeller", method=RequestMethod.POST)
	public String registerSeller(LoginDto register) throws Exception {
		loginService.registerSeller(register);
		
		return "redirect:/login/login";
	}
	
	@RequestMapping(value="/login/registerSeller", method=RequestMethod.GET)
	public String registerSeller() throws Exception {
		return "/login/registerSeller";
	}

//	일반회원 상세정보
	@RequestMapping(value="/usersDetail/{userId}", method=RequestMethod.GET)
	public String selectUsersDetail(@PathVariable("userId") String userId, Model model) throws Exception {
			
		LoginDto usersDetail = loginService.selectMemberDetail(userId);
		model.addAttribute(usersDetail);
		
		model.addAttribute("template", "master/usersDetail");
			
		return "master/index";
			
	}
	
//	일반회원 정보수정		
	@RequestMapping(value="/master/usersDetail/{userId}", method=RequestMethod.PUT)
	public String editUsers(LoginDto member) throws Exception {
		loginService.editMember(member);
		
		return "redirect:/master/index";
	}
	
//	일반회원 정보삭제
	@RequestMapping(value="/master/userDetail/{userId}", method=RequestMethod.DELETE)
	public String deleteMember(@PathVariable("userId") String userId) throws Exception {
		loginService.deleteMember(userId);
		return "redirect:/master/index";
	}

//	판매자 상세정보
	@RequestMapping(value="/master/sellersDetail/{userId}", method=RequestMethod.GET)
	public String selectSellerDetail(@PathVariable("userId") String userId, Model model) throws Exception {
			
		LoginDto sellersDetail = loginService.selectSellerDetail(userId);
		model.addAttribute(sellersDetail);
		
		model.addAttribute("template", "master/sellersDetail");
			
		return "master/index";
			
	}
	
//	판매자 정보수정
	@RequestMapping(value="/master/sellersDetail/{userId}", method=RequestMethod.PUT)
	public String editSeller(LoginDto member) throws Exception {
		loginService.editSeller(member);
		
		return "redirect:/master/index";
	}
	
//	판매자 정보삭제
	@RequestMapping(value="/master/sellersDetail/{userId}", method=RequestMethod.DELETE)
	public String deleteSeller(@PathVariable("userId") String userId) throws Exception {
		loginService.deleteSeller(userId);
		return "redirect:/master/index";
	}	
	
//	관리자 전용 페이지
//	@RequestMapping(value="/login/adminPage", method=RequestMethod.GET)
//	public String adminPage(HttpServletRequest request) throws Exception {
//		HttpSession session = request.getSession();
//		String isAuth = (String) session.getAttribute("userAuth");
//		
//		if (isAuth != null && isAuth.equals("Y")) {
//			return "/login/adminPage";
//		}
//		else {
//			return "/login/loginFail";
//		}
//	}
	
//	회원정보 조회 및 삭제(관리자전용)
//	@RequestMapping(value="/login/memberList", method=RequestMethod.GET)
//	public ModelAndView memberList() throws Exception {
//		ModelAndView mv = new ModelAndView("/login/memberList");
//		
//		List<LoginDto> memberList = loginService.selectMemberList();
//		mv.addObject("memberList", memberList);
//		
//		return mv;
//	}
	
//	회원정보 조회 및 삭제(관리자전용)
//	@RequestMapping(value="/login/sellerList", method=RequestMethod.GET)
//	public ModelAndView sellerList() throws Exception {
//		ModelAndView mv = new ModelAndView("/login/sellerList");
//		
//		List<LoginDto> sellerList = loginService.selectSellerList();
//		mv.addObject("sellerList", sellerList);
//		
//		return mv;
//	}
	
//	일반회원 정보수정(일반회원 전용페이지)
	@RequestMapping(value="/login/userDetail/{userId}", method=RequestMethod.GET)
	public ModelAndView memberDetail(@PathVariable("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/login/userDetail");
		
		LoginDto member = loginService.selectMemberDetail(userId);
		mv.addObject("member", member);
		
		return mv;
	}
			
	@RequestMapping(value="/login/userDetail/{userId}", method=RequestMethod.PUT)
	public String editMember(LoginDto member) throws Exception {
		loginService.editMember(member);
		
		return "redirect:/mypage";
	}
	
//	일반회원 정보삭제
	@RequestMapping(value="/login/userDetail/{userId}", method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable("userId") String userId) throws Exception {
		loginService.deleteMember(userId);
		return "redirect:/login/logout";
	}
	
}



