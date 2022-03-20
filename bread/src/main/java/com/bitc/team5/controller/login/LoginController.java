package com.bitc.team5.controller.login;

import java.util.List;

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
		
//	�α��� ������
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String login() throws Exception {
		return "/login/login";
	}
	
//	����� ����Ȯ�� ������
	@RequestMapping(value="/login/loginCheck", method=RequestMethod.POST)
	public String loginCheck(LoginDto member, HttpServletRequest request) throws Exception {
		int count = loginService.selectMemberInfoYn(member.getUserId(), member.getUserPw());
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		System.out.println(userId);
		System.out.println(userPw);
		String UserAuth = loginService.selectMemberUserAuth(userId,userPw); 
		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", member.getUserId());
			session.setAttribute("userAuth", UserAuth);
			session.setMaxInactiveInterval(300);
			Object userAuth=session.getAttribute("userAuth");
			System.out.println(userAuth);
			return "redirect:/login/loginOK";
		}
		else {
			return "redirect:/login/loginFail";	
		}
	}
	
//	�α��� ������ ����������
	@RequestMapping(value="/login/loginOK", method=RequestMethod.GET)
	public String loginOK(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId") != null) {
			String userAuth = (String)session.getAttribute("userAuth");
			model.addAttribute("userAuth", userAuth);
			String userId = (String)session.getAttribute("userId");
			model.addAttribute("userId", userId);
			return "/login/loginOK";
		}
		else {
			return "/login/loginFail";
		}	
	}
		
//	�α׾ƿ� ������
	@RequestMapping(value="/login/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session =  request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		
		return "/login/logout";
	}
	
//	�α��� ���� ������
	@RequestMapping(value="/login/loginFail", method=RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/login/loginFail";
	}
	
//	ȸ������ ������
	
	@RequestMapping(value="/login/register", method=RequestMethod.GET)
	public String registerMember() throws Exception {
		return "/login/register";
	}
	
//	�Ϲ�ȸ�� ����������
	@RequestMapping(value="/login/registerUser", method=RequestMethod.POST)
	public String registerUser(LoginDto register) throws Exception {
		loginService.registerUser(register);
		
		return "redirect:/login/login";
	}
	
	@RequestMapping(value="/login/registerUser", method=RequestMethod.GET)
	public String registerUser() throws Exception {
		return "/login/registerUser";
	}
	
//	�Ǹ��� ����������
	@RequestMapping(value="/login/registerSeller", method=RequestMethod.POST)
	public String registerSeller(LoginDto register) throws Exception {
		loginService.registerSeller(register);
		
		return "redirect:/login/login";
	}
	
	@RequestMapping(value="/login/registerSeller", method=RequestMethod.GET)
	public String registerSeller() throws Exception {
		return "/login/registerSeller";
	}
		
//	�Ϲ�ȸ�� ��������
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
		
		return "redirect:/login/loginOK";
	}
	
//	�Ϲ�ȸ�� ��������
	@RequestMapping(value="/login/userDetail/{userId}", method=RequestMethod.DELETE)
	public String deleteMember(@PathVariable("userId") String userId) throws Exception {
		loginService.deleteMember(userId);
		return "redirect:/login/login";
	}

//	�Ǹ��� ��������
	@RequestMapping(value="/login/sellerDetail/{userId}", method=RequestMethod.GET)
	public ModelAndView sellerDetail(@PathVariable("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/login/sellerDetail");
		
		LoginDto member = loginService.selectSellerDetail(userId);
		mv.addObject("member", member);
		
		return mv;
	}
		
	@RequestMapping(value="/login/sellerDetail/{userId}", method=RequestMethod.PUT)
	public String editSeller(LoginDto member) throws Exception {
		loginService.editSeller(member);
		
		return "redirect:/login/loginOK";
	}
	
//	�Ǹ��� ��������
	@RequestMapping(value="/login/sellerDetail/{userId}", method=RequestMethod.DELETE)
	public String deleteSeller(@PathVariable("userId") String userId) throws Exception {
		loginService.deleteSeller(userId);
		return "redirect:/login/login";
	}	
	
//	������ ���� ������
	@RequestMapping(value="/login/adminPage", method=RequestMethod.GET)
	public String adminPage(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String isAuth = (String) session.getAttribute("userAuth");
		
		if (isAuth != null && isAuth.equals("Y")) {
			return "/login/adminPage";
		}
		else {
			return "/login/loginFail";
		}
	}
	
//	ȸ������ ��ȸ �� ����(����������)
	@RequestMapping(value="/login/memberList", method=RequestMethod.GET)
	public ModelAndView memberList() throws Exception {
		ModelAndView mv = new ModelAndView("/login/memberList");
		
		List<LoginDto> memberList = loginService.selectMemberList();
		mv.addObject("memberList", memberList);
		
		return mv;
	}
	
//	ȸ������ ��ȸ �� ����(����������)
	@RequestMapping(value="/login/sellerList", method=RequestMethod.GET)
	public ModelAndView sellerList() throws Exception {
		ModelAndView mv = new ModelAndView("/login/sellerList");
		
		List<LoginDto> sellerList = loginService.selectSellerList();
		mv.addObject("sellerList", sellerList);
		
		return mv;
	}
}


