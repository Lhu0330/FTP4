package com.bitc.team5.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bitc.team5.service.seller.SellerService;

@Controller
public class UsersControllerSchedule {
	
	@Autowired
	private SellerService productService;
	
	
//	// sotck 등록 화면
//		@RequestMapping(value="/saveSchedata.do", method=RequestMethod.POST)
//		public ResponseEntity<List<ReplyDto>>(List<SheduleDto> sd) throws Exception {
//			 System.out.println(sd);
//			ModelAndView mv = new ModelAndView("/main");
//			//List<SheduleDto> sdList = productService.insertSche(sd);
//			return mv;
//		}
//	 sotck 등록 화면
//		@PostMapping(value= "/saveSchedata.do",
//				consumes = "application/json"
//				)
//		public String viewProduct(@RequestBody ResponseEntity<List<SheduleDto>> sd, Model model) {
//		
//			 System.out.println(sd);
//			//List<SheduleDto> sdList = productService.insertSche(sd);
//			model.addAttribute("template", "admin/insertProduct");
//			return "admin/index";
//		}
//		
		
		@PostMapping(value= "/saveSchedata.do",
				consumes = "application/json"
				)
		public ResponseEntity list(@RequestBody Map <String ,Object> map , Model model) {
		
			 System.out.println(" map");
			//List<SheduleDto> sdList = productService.insertSche(sd);
			model.addAttribute("template", "admin/insertProduct");
			
			return new ResponseEntity<>(map, HttpStatus.OK );
		}
		
		
//		
//	@ResponseBody
//	@RequestMapping(value = "/saveSchedata.do", method = RequestMethod.POST)
//	public Map<Object,Object> addSchedule(@RequestBody SheduleDto dto) throws Exception{
//		Map<Object,Object>map = new HashMap<Object,Object>();
//
//	//	productService.addSchedule(dto);
//
//		return map;
//	}
//
//	@RequestMapping(value = "/schedule")
//	public String schedule(Model model)throws Exception {
//
//	//	model.addAttribute("showSchedule" , productService.showSchedule());
//	    
//		return "/schedule";
//	}
	
	
		/*
		 * @GetMapping("/productStockList") public String viewStock(Model model) throws
		 * Exception {
		 * 
		 * List<ShopDto> stockList = sellerService.selectProductList();
		 * model.addAttribute(stockList);
		 * 
		 * model.addAttribute("template", "admin/productStockList"); return
		 * "admin/index"; }
		 * 
		 */
		
		
		
		
	
	
}
