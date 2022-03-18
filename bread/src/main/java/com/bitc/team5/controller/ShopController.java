package com.bitc.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.service.ShopService;
import com.github.pagehelper.PageInfo;


@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	
	@RequestMapping(value="/shop/{productCateId}", method=RequestMethod.GET)
	public ModelAndView product(@RequestParam(required = false, defaultValue= "1", value="pageNum") int pageNum, @PathVariable("productCateId") int productCateId) throws Exception  {
		
		ModelAndView mv = new ModelAndView("shop/shop3");
		
		PageInfo<ShopDto> ProductList = new PageInfo<> (shopService.selectProductList(pageNum,productCateId),5);
		  mv.addObject("ProductList", ProductList);
		  
		  if (ProductList.getList().size() > 0) {
			  mv.addObject("productCateId", ProductList.getList().get(0).getProductCateId());  
		  }
		  
		  return mv;
		}
	
	
	 // 판매상세화면
//	@RequestMapping(value="/shop/detail/{productId}", method=RequestMethod.GET)
//	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
//		ModelAndView mv = new ModelAndView("shop/detail");
//		
//		ShopDto board = shopService.selectProductDetail(productId);
//		mv.addObject("board", board);
//		
//		return mv;
//	}
	
	
	 //판매1 상세 화면
	@ResponseBody
	@RequestMapping(value="/shop/detail/1/{productId}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
		ModelAndView mv = new ModelAndView("shop/detail");
		
		ShopDto board = shopService.selectProductDetail(productId);
		mv.addObject("board", board);
		
		
	      
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/shop/detail/2/{productId}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail2(@PathVariable("productId") long productId) throws Exception {
		ModelAndView mv = new ModelAndView("shop/detail2");
		
		ShopDto board = shopService.selectProductDetail(productId);
		mv.addObject("board", board);
		

	      
		return mv;
	}
	
	
	
//	@ResponseBody
//	@RequestMapping(value="/shop/market/3/{productId}", method=RequestMethod.GET)
//	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
//		ModelAndView mv = new ModelAndView("shop/detail3");
//		
//		ShopDto board = shopService.selectProductDetail(productId);
//		mv.addObject("board", board);
//		
//		JSONObject resMap = new JSONObject();
//		
//
//	      
//		return mv;
//	}
	
	
	
	
	
	
	

}
