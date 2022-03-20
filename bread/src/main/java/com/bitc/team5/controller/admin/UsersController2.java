package com.bitc.team5.controller.admin;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.service.seller.SellerService;

@Controller
public class UsersController2 {
	
	@Autowired
	private SellerService productService;
	
	
	
	
	
	
	
	// 폼 상세화면 
//	@RequestMapping(value="/formDetail/{storeId}", method=RequestMethod.GET)
//	public String selectAdminFormDetail(@PathVariable("storeId") String storeId, Model model) throws Exception {
//		
//			
//		MarketDto AdminForm = productService.selectformDetail(storeId);
//		model.addAttribute(AdminForm);
//		
//		ShopDto AdminForm2 = productService.selectformDetail2(storeId);
//		model.addAttribute(AdminForm2);
//		
//		model.addAttribute("template", "admin/formDetail");
//		
//		return "admin/index";
//		
//	}		
//		
	// 폼읽어오기
	
	@RequestMapping(value="/formDetail/{formId}", method=RequestMethod.GET)
	public String selectAdminFormDetail(@PathVariable("formId") long formId, Model model) throws Exception {
		
			
		MarketDto AdminForm = productService.selectformDetail(formId);
		model.addAttribute(AdminForm);
		
		List<ShopDto> AdminForm2 = productService.selectformDetail2(formId);
		model.addAttribute(AdminForm2);
		
		model.addAttribute("template", "admin/formDetail");
		
		return "admin/index";
		
	}		
		
	

	
	// 마켓폼 작성 화면 
	@GetMapping("/insertForm")
	public String viewCategory(Model model) {
		// View attribute
		model.addAttribute("template", "admin/insertProductMar2");
		return "admin/index";
	}
	
	

	

	// 폼 등록  상품(폼 idx, 상품명,가격,배고) 리스트로 하나씩 받고 //  폼 idx,  제목, 기간, 계좌정보 받고 
		
	// 마켓정보 등록 
	
		@RequestMapping(value="/admin/maketInserting", method=RequestMethod.POST)
	   public String inputTest5(
			 MarketDto market,
	         @RequestParam ArrayList<String> productName,
	         @RequestParam ArrayList<String> productPrice,
	         @RequestParam ArrayList<String> productStockCnt,
	         MultipartHttpServletRequest multiFiles,
	         HttpSession session
	         
	         ) throws Exception {
			
			
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
			String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
			String subNum = "";
			 
			for(int i = 1; i <= 5; i ++) {
				subNum += (int)(Math.random() * 10);
			}
			
			String orderCodeS = ymd + subNum;
			
			// long orderCode = Long.parseLong(orderCodeS);
			
			long formId = Long.parseLong(orderCodeS);
			
			
			
			String storeId = (String) session.getAttribute("userId");
			market.setStoreId(storeId);

			
			System.out.println("sendForm.getArray");
//			      
//			      System.out.println(market);
//			      
      		productService.insertForm(market, multiFiles, storeId, formId);
//			      
//			      // 상품여러개 보내기
      	//	List<CartDto> cartList = cartService.cartList(userId);
      		
      		List<ShopDto> formProduct = new ArrayList<>();
      		
      		for (int i = 0; i < productName.size(); i++) {
      			String name = productName.get(i);
      			int price = Integer.parseInt(productPrice.get(i));
      			int stock = Integer.parseInt(productStockCnt.get(i));
      			
      			ShopDto item = new ShopDto();
      			item.setProductName(name);
      			item.setProductPrice(price);
      			item.setProductStockCnt(stock);
      				      			
      			item.setProductCateId(2);
      			item.setStoreId(storeId);
      			item.setFormId(formId);
      			
      			formProduct.add(item);
      			
      		}
      		System.out.println(formProduct);
      		
      	productService.insertForm2(formProduct, storeId, formId);
			   
			//    formProduct.add(new ShopDto("productName", productName.get((1))));
	      
			      
			      return "redirect:/admin/marketForm";
	   }
		
		
		

	
	
	
//
//@RequestMapping(value="/jr41/adminProductUpdate/{productIdx}", method=RequestMethod.POST)
//public String updateAdminproduct(AdminProductDto adnot) throws Exception {
//	adminProductService.updateAdminProduct(adnot);
//	return "redirect:/jr41/adminProduct";
//}
//
//@RequestMapping(value="/jr41/adminProductDelete/{productIdx}", method=RequestMethod.POST)
//public String deleteBlog(@PathVariable("productIdx") int productIdx) throws Exception {
//	adminProductService.deleteAdminProduct(productIdx);
//	return "redirect:/jr41/adminProduct";
//}





	
	
	
}
