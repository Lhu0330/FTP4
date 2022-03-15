package com.bitc.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.StoreDto;
import com.bitc.team5.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
//	판매자 등록
	@RequestMapping(value="/store/seller", method=RequestMethod.POST)
	public String registerSeller(StoreDto store) throws Exception {
		storeService.registerSeller(store);
		
		return "redirect:/store/storeDetail";
	}
	
	@RequestMapping(value="/store/seller/{userId}", method=RequestMethod.GET)
	public ModelAndView storeDetail(@PathVariable("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/store/seller");
		
		mv.addObject("userId", userId);
		return mv;
	}
	
//	판매자 상세정보
	@RequestMapping(value="/store/storeDetail/{userId}", method=RequestMethod.GET)
	public ModelAndView sellerDetail(@PathVariable("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/store/storeDetail");
		
		StoreDto store = storeService.selectSellerDetail(userId);
		mv.addObject("store", store);
		
		return mv;
	}
}
