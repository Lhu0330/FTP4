package com.bitc.team5.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.service.shopping.ShopService;


@Controller
public class MainController {

	@Autowired
	private ShopService shopService;
	
//	@RequestMapping("/main")
//	public String test() throws Exception{
//		
//		
//		
//		
//
//		
//		return "main";
//	}

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView openBoardList(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/main");
		
		  
		  List <MarketDto> ranking3 = shopService.selectRankingList();
		  mv.addObject("ranking3", ranking3);
		  
		return mv;
	}
	
//	@RequestMapping(value = "/main", method = RequestMethod.GET)
//	public String myCart(Model model ,HttpSession session) throws Exception {
//		
//
//		
//		String userId = (String) session.getAttribute("userId");

		// 마켓 랭킹 
			
		
		// 레시피 
		
		
				//리뷰 
//        Map<String, Object> map = new HashMap<String, Object>();
//        int sumMoney = cartService.sumMoney(userId); // 장바구니 전체 금액 호출
        
//		CartDto cartsum = cartService.selectCostCalculate(cart);
//		mv.addObject("cartsum", cartsum);
//
//		 
//		 Map<String, Object> map = new HashMap<String, Object>();
//	
//	// 	model.addAttribute("cartList", cartService.cartList(userId) );
//		List<CartDto> cartList = cartService.cartList(userId);
//		model.addAttribute("cartList", cartList);
//		
//		int total = 0;
//
//		for (CartDto shop : cartList) {
//			total += shop.getTotalPrice();
//		}
//		
//		map.put("sumTotal", total);
//		map.put("finalCost", total + 2000);
//		
//		
//		model.addAttribute("priceInfo", map);
//		
		
//		 map.put("sumMoney", sumMoney);        // 장바구니 전체 금액
//	     map.put("allSum", sumMoney+ 2000);    // 주문 상품 전체 금액
		
//		return "main";
//	}
//

	
	
	
//	@RequestMapping("/test3")
//	public String test3() throws Exception{
//		return "shop/detailCalender";
//	}
//	
//	@RequestMapping("/test4")
//	public String test4() throws Exception{
//		return "shop/detailCalenderClass";
//	}
//	
//	@RequestMapping("/test5")
//	public String test5() throws Exception{
//		return "shop/detailCalender4";
//	}
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

