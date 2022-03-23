package com.bitc.team5.controller.master;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.bitc.team5.dto.login.LoginDto;
import com.bitc.team5.service.login.LoginService;



@Controller
@RequestMapping("/master")
public class MasterController {
	
	@Autowired
	private LoginService loginService;
	

	
	@GetMapping
	public RedirectView viewAdmin(Model model) throws Exception{
		return new RedirectView("master/index");
	}
	

	@GetMapping("/index")
	public String viewCategory(Model model) {
		// View attribute
		model.addAttribute("template", "master/dashboard");
		return "master/index";
	}
			
	@GetMapping("/users")
	public String viewUsers(Model model) throws Exception {
		
		List<LoginDto> userList = loginService.selectMemberList();
		
		model.addAttribute(userList);
		
		model.addAttribute("template", "master/users");
		
	
		return "master/index";
	}
	
		
	@GetMapping("/sellers")
	public String viewSellers(Model model) throws Exception {
		
		List<LoginDto> sellerList = loginService.selectSellerList();
		
		model.addAttribute(sellerList);
		
		model.addAttribute("template", "master/sellers");
		
	
		return "master/index";
	}
	
	
//	@GetMapping("/productStockList")
//	public String viewStock(Model model) throws Exception {
//		
//		List<ShopDto> stockList = sellerService.selectProductList();
//		model.addAttribute(stockList);
//		
//		model.addAttribute("template", "master/productStockList");
//		return "master/index";
//	}
//	
//	
//	@GetMapping("/marketForm")
//	public String viewForm(Model model) {
//		// View attribute
//		model.addAttribute("template", "master/marketForm");
//		return "master/index";
//	}
	
	
	
	
}