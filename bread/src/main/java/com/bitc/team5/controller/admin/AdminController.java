package com.bitc.team5.controller.admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;
import com.bitc.team5.dto.classDto;
import com.bitc.team5.service.seller.SellerService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private SellerService sellerService;
	

	
	@GetMapping
	public RedirectView viewAdmin(Model model) throws Exception{
		return new RedirectView("admin/index");
	}
	

	@GetMapping("/index")
	public String viewCategory(Model model) {
		// View attribute
		model.addAttribute("template", "admin/dashboard");
		return "admin/index";
	}
	
	
	@GetMapping("/users")
	public String viewAccount(Model model) throws Exception {
		
		List<UsersDto> usersList = sellerService.getUsers();
		
		model.addAttribute(usersList);
		
		model.addAttribute("template", "admin/users");
		
	
		return "admin/index";
	}
	
	
	@GetMapping("/productStockList")
	public String viewStock(Model model) throws Exception {
		
		List<ShopDto> stockList = sellerService.selectProductList();
		model.addAttribute(stockList);
		
		model.addAttribute("template", "admin/productStockList");
		return "admin/index";
	}
	
	
	@GetMapping("/marketForm")
	public String viewForm(Model model) throws Exception {

		List<MarketDto> formList = sellerService.selectformList();
		model.addAttribute(formList);
	
		
		model.addAttribute("template", "admin/marketForm");
		return "admin/index";
	}
	
	
	@GetMapping("/classList")
	public String viewClass(Model model) throws Exception {
	
		List<classDto> classList = sellerService.selectclassList();
		model.addAttribute(classList);
	

		
		model.addAttribute("template", "admin/classList");
		return "admin/index";
	}
	
	@GetMapping("/event")
	public String viewEvent(Model model) {
		// View attribute
		model.addAttribute("template", "admin/classList2");
		return "admin/index";
	}
	
	
	@GetMapping("/analystics")
	public String viewAnalystics(Model model) {
		// View attribute
		model.addAttribute("template", "admin/classList3");
		return "admin/index";
	}
	
	
	
	
	
	
	
}