package com.bitc.team5.controller.admin;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.service.SellerService;

@Controller
public class UsersController {
	
	@Autowired
	private SellerService productService;
	
	
	@RequestMapping(value="/jr41/adminInsertProduct", method=RequestMethod.GET)
	public ModelAndView writeAdminproduct() throws Exception {
		ModelAndView mv = new ModelAndView("/admin/insertProduct");
		
		return mv;
	}
	
	// ��ǰ ��ȭ��
	
	@RequestMapping(value="/jr41/adminProductDetail/{idx}", method=RequestMethod.GET)
	public ModelAndView selectAdminProductDetail(@PathVariable("idx") int idx) throws Exception {
		ModelAndView mv = new ModelAndView("admin/AdminproductDetail");
			
		ShopDto AdminProduct = productService.selectAdminProductDetail(idx);
		mv.addObject("AdminProductList", AdminProduct);
		
		return mv;
	}
	
	
//	
//	@RequestMapping(value="/jr41/ProductInserting", method=RequestMethod.POST)
//	public String insertAdminProduct(ShopDto adnot, MultipartHttpServletRequest multiFiles) throws Exception {
//		productService.insertProduct(adnot, multiFiles);
//		
//		return "redirect:/productStockList";
//	}
	
	// ��ǰ��� 
	@RequestMapping(value="/jr41/ProductInserting", method=RequestMethod.POST)
	public String insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles) throws Exception {
		
		
		//productId �����
//		Calendar cal = Calendar.getInstance();
//		int year = cal.get(Calendar.YEAR);
//		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
//		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
//		String subNum = "";
//		 
//		for(int i = 1; i <= 3; i ++) {
//			subNum += (int)(Math.random() * 10);
//		}
//		
//		String orderCode = ymd + "_" + subNum;
//		
//		restBoard.setProductId(orderCode);
////		Gson gson = new Gson();
////		CartDto[] cartArray = gson.fromJson(data, CartDto[].class);
////		List<CartDto> cartList = new ArrayList<CartDto>();
////		
////		for (CartDto item : cartArray) {
////			item.setOrderCode(orderCode);
////			cartList.add(item);
////		}
////		
//		
		productService.insertBoard(restBoard, multiFiles);
		
		
		return "redirect:/admin/productStockList";
	}
	
	
	

	
//	@RequestMapping(value="/jr41/adminProductCategory/list", method=RequestMethod.GET)
//	@ResponseBody
//	public List<CategoryProductDto> CategoryProduct() throws Exception {
//		List<CategoryProductDto> CategoryList = adminProductService.selectCategoryList();
//		return CategoryList;
//	}
//	
//	@RequestMapping(value="/jr41/adminProductUpdate/{productIdx}", method=RequestMethod.POST)
//	public String updateAdminproduct(AdminProductDto adnot) throws Exception {
//		adminProductService.updateAdminProduct(adnot);
//		return "redirect:/jr41/adminProduct";
//	}
//	
//	@RequestMapping(value="/jr41/adminProductDelete/{productIdx}", method=RequestMethod.POST)
//	public String deleteBlog(@PathVariable("productIdx") int productIdx) throws Exception {
//		adminProductService.deleteAdminProduct(productIdx);
//		return "redirect:/jr41/adminProduct";
//	}
	
	

	
//	���� �ٿ�ε� �κ�
//
	@RequestMapping("/board/downloadProductFile.do")
	public void downloadBoardFile(@RequestParam("fileIdx") int fileIdx, @RequestParam("boardIdx") int boardIdx, HttpServletResponse response) throws Exception {

		AdminProductFileDto boardFile = productService.selectBoardFileInfo(fileIdx, boardIdx);
		
		if (ObjectUtils.isEmpty(boardFile) == false) {
			String fileName = boardFile.getOriginalFileName();
			

			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));
			

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);

			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			

			response.getOutputStream().write(files);

			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
	
	
}
