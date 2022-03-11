package com.bitc.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//
//	// 상품 상세화면
//	
//		@RequestMapping(value="/jr41/adminProductDetail/{idx}", method=RequestMethod.GET)
//		public ModelAndView selectAdminProductDetail(@PathVariable("idx") int idx) throws Exception {
//			ModelAndView mv = new ModelAndView("admin/AdminproductDetail");
//				
//			ShopDto AdminProduct = productService.selectAdminProductDetail(idx);
//			mv.addObject("AdminProductList", AdminProduct);
//			
//			return mv;
//		}
	
	 //제품 상세 화면
	@RequestMapping(value="/shop/detail/{productId}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
		ModelAndView mv = new ModelAndView("shop/detail");
		
		ShopDto board = shopService.selectProductDetail(productId);
		mv.addObject("board", board);
		
		return mv;
	}
	

}
