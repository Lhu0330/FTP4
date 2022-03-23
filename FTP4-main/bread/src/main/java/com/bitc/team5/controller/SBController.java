package com.bitc.team5.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.SBDto;
import com.bitc.team5.service.SBService;

@Controller
public class SBController {
	@Autowired
	private SBService SBService;

	@RequestMapping("/cart.do")
	public ModelAndView cartList(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/cart/cartList");
		SBService.checkedNotCart();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		List<SBDto> cartList = SBService.selectCartList(userId);
		mv.addObject("cartList", cartList);
		return mv;
	}

	@RequestMapping("/cart/order.do")
	public ModelAndView orderpage(@RequestParam(value = "flexCheckChecked") long[] flexCheckChecked, SBDto cart, HttpServletRequest request)
			throws Exception {
		ModelAndView mv = new ModelAndView("/cart/order");

		SBService.checkedCart(flexCheckChecked);
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		List<SBDto> PayList = SBService.selectPayList(userId);
		mv.addObject("PayList", PayList);

		SBDto cartsum = SBService.selectCostCalculate(cart);
		mv.addObject("cartsum", cartsum);

		return mv;
	}
	
	@RequestMapping("order.do")
	public ModelAndView orderpage1(SBDto cart, HttpServletRequest request)
			throws Exception {
		ModelAndView mv = new ModelAndView("/cart/order");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		List<SBDto> PayList = SBService.selectPayList(userId);
		mv.addObject("PayList", PayList);

		SBDto cartsum = SBService.selectCostCalculate(cart);
		mv.addObject("cartsum", cartsum);

		return mv;
	}

	@RequestMapping("/cart/delete.do")
	public String cartdelete(@RequestParam("productIdx") int productIdx) throws Exception {
		SBService.deleteCart(productIdx);
		return "redirect:/cart.do";
	}

	@ResponseBody
	@RequestMapping(value = "/cart/cartItemDelete.do")
	public Map<String, String> cartItemDelete(@RequestParam("productIdx") String productIdx) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		
		long pidx = Long.parseLong(productIdx);
		
		
		SBService.deleteCart(pidx);

		result.put("result", "success");

		return result;
	}

	// üũ�ڽ�

	@ResponseBody
	@RequestMapping(value = "/cart/cartItemIncrease.do")
	public Map<String, String> cartItemIncrease(@RequestParam("productIdx") int productIdx) throws Exception {
		Map<String, String> result = new HashMap<String, String>();

		SBService.increaseCart(productIdx);

		result.put("result", "success");

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/cart/cartItemDecrease.do")
	public Map<String, String> cartItemDecrease(@RequestParam("productIdx") int productIdx) throws Exception {
		Map<String, String> result = new HashMap<String, String>();

		SBService.decreaseCart(productIdx);

		result.put("result", "success");

		return result;
	}

	@RequestMapping("/cart/order/success.do")
	public String ordersuccess(SBDto success) throws Exception {
		SBService.updateSuccess(success);
		return "redirect:/history.do";
	}

	@RequestMapping("/history.do")
	public ModelAndView historypage(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/cart/history");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		List<SBDto> successList = SBService.selectSuccessList(userId);
		mv.addObject("successList", successList);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/jr41/addcart", method = RequestMethod.POST)
	public String jangbaguni(SBDto cart, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		SBService.addCart(cart);
		SBService.addCart1(userId);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/jr41/addcart2", method = RequestMethod.POST)
	public String pay(SBDto cart, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		SBService.addCart4(cart);
		SBService.addCart1(userId);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/paypass", method = RequestMethod.POST)
	public String paypass(SBDto cart, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		SBService.addCart3(cart);
		SBService.addCart1(userId);
		return "success";
	}

}
