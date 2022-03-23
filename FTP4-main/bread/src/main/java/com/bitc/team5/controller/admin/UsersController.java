package com.bitc.team5.controller.admin;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.classDto;
import com.bitc.team5.service.seller.SellerService;

@Controller
public class UsersController {
	
	@Autowired
	private SellerService productService;
	
	
	// sotck 등록 화면
//		@RequestMapping(value="/admin/adminInsertProduct", method=RequestMethod.GET)
//		public ModelAndView writeAdminproduct() throws Exception {
//			ModelAndView mv = new ModelAndView("/admin/insertProduct");
//			
//			return mv;
//		}
	// sotck 등록 화면
		@GetMapping("/admin/adminInsertProduct")
		public String viewProduct(Model model) {
			// View attribute
			model.addAttribute("template", "admin/insertProduct");
			return "admin/index";
		}
		
		
		
		// 물풍등록
			
			@RequestMapping(value="/jr41/ProductInserting", method=RequestMethod.POST)
			public String insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles,  HttpSession session) throws Exception {
				
				String storeId = (String) session.getAttribute("userId");
				
				productService.insertBoard(restBoard, multiFiles, storeId);
				
				
				return "redirect:/admin/productStockList";
			}
			
		
		
		// 클래스폼 작성 화면 
		@GetMapping("/insertClass")
		public String viewClass(Model model) {
			// View attribute
			model.addAttribute("template", "admin/insertClass");
			return "admin/index";
		}
		
		
		
		// 클래스등록하는작업
		
		@RequestMapping(value="/admin/classInserting", method=RequestMethod.POST)
		public String insertClass( classDto restBoard, MultipartHttpServletRequest multiFiles, HttpSession session) throws Exception {
			
			String storeId = (String) session.getAttribute("userId");
			
			productService.insertClass(restBoard, multiFiles, storeId);
			
			
			return "redirect:/admin/classList";
		}
		
		
		
		// 폼 상세화면 
//		@RequestMapping(value="/formDetail/{storeId}", method=RequestMethod.GET)
//		public String selectAdminFormDetail(@PathVariable("storeId") String storeId, Model model) throws Exception {
//			
//				
//			MarketDto AdminForm = productService.selectformDetail(storeId);
//			model.addAttribute(AdminForm);
//			
//			ShopDto AdminForm2 = productService.selectformDetail2(storeId);
//			model.addAttribute(AdminForm2);
//			
//			model.addAttribute("template", "admin/formDetail");
//			
//			return "admin/index";
//			
//		}		
//			
		
		
	
		
		// 믈픔상세 화면 
		
		
		@RequestMapping(value="/jr41/adminProductDetail/{idx}", method=RequestMethod.GET)
		public ModelAndView selectAdminProductDetail(@PathVariable("idx") int idx) throws Exception {
			ModelAndView mv = new ModelAndView("admin/AdminproductDetail");
				
			ShopDto AdminProduct = productService.selectAdminProductDetail(idx);
			mv.addObject("AdminProductList", AdminProduct);
			
			return mv;
		}
		
		
	
				
		// 클래스 디테일
			@RequestMapping(value="/classDetail/{idx}", method=RequestMethod.GET)
			public String selectAdminClassDetail(@PathVariable("idx") int idx, Model model) throws Exception {
				
					
				classDto AdminClass = productService.selectclassDetail(idx);
				model.addAttribute(AdminClass);
				
				model.addAttribute("template", "admin/ClassDetail");
				
				return "admin/index";
				
			}		
			
			// 게시판 글등록
			
			@RequestMapping(value="/board/writeBoard", method=RequestMethod.POST)
			public String writeBoard(HttpServletRequest request, Model model, BoardDto board, MultipartHttpServletRequest multiFiles) throws Exception {
				HttpSession session = request.getSession();
				String userId = (String)session.getAttribute("userId");
				model.addAttribute("userId", userId);
					
				productService.writeBoard(board, multiFiles);
						
						
				return "redirect:/board/boardList";
			}
			
			@RequestMapping(value="/board/writeBoard", method=RequestMethod.GET)
			public String writeBoard() throws Exception {
				return "/board/writeBoard";
			}
			
//			게시판 리스트
			
			@RequestMapping("/board/boardList")
			public ModelAndView openBoardList() throws Exception {
				ModelAndView mv = new ModelAndView("/board/boardList");
				
				List<BoardDto> boardList = productService.selectBoardList();
				mv.addObject("boardList", boardList);
				
				return mv;
			}
			
//			내 게시물
			@RequestMapping("/mypage/myBoard")
			public ModelAndView myBoardList(HttpServletRequest request) throws Exception {
				ModelAndView mv = new ModelAndView("/mypage/myBoard");
				
				HttpSession session = request.getSession();
				String userId = (String)session.getAttribute("userId");
							
				List<BoardDto> myBoardList = productService.selectMyBoard(userId);
				mv.addObject("myBoardList", myBoardList);
				
				return mv;
			}
			
			@RequestMapping(value="/board/boardDetail/{idx}", method=RequestMethod.GET)
			public ModelAndView openBoardDetail(@PathVariable("idx") int idx) throws Exception {
				ModelAndView mv = new ModelAndView("/board/boardDetail");
				
				
				BoardDto board = productService.selectDetailBoard(idx);
				mv.addObject("board", board);
				
				return mv;
			}
			
//			게시글 수정
			@RequestMapping(value="/board/boardDetail/{idx}", method=RequestMethod.PUT)
			public String updateBoard(BoardDto board) throws Exception {
				productService.updateBoard(board);
				return "redirect:/board/boardList";
			}
			
//			게시글 삭제
			@RequestMapping(value="/board/boardDetail/{idx}", method=RequestMethod.DELETE)
			public String deleteBoard(@PathVariable("idx") int idx) throws Exception {
				productService.deleteBoard(idx);
				return "redirect:/board/boardList";
			}
			


			
	
		
		
		
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
	
	

	
//	사진 정보
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
