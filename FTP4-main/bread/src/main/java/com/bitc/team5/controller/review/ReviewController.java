package com.bitc.team5.controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.dto.ReviewDto;
import com.bitc.team5.service.review.ReviewService;


@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reivewService;
	
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public ModelAndView reviewmap() throws Exception  {
		
		ModelAndView mv = new ModelAndView("review/map");
		
		
		  
		  return mv;
		}
	
	
	@RequestMapping(value="/map2", method=RequestMethod.GET)
	public ModelAndView reviewmap1() throws Exception  {
		
		ModelAndView mv = new ModelAndView("review/store");
		
		
		  
		  return mv;
		}
	
	@RequestMapping(value="/map3", method=RequestMethod.GET)
	public ModelAndView reviewmap3() throws Exception  {
		
		ModelAndView mv = new ModelAndView("review/map2");
		
		
		  
		  return mv;
		}
	
//	
//	@RequestMapping(value="store/storeRegister") 
//	 public void storeRegister(ReviewDto userreview) throws Exception {
//		
//		
//		reivewService.storeinsert(userreview);
//	 
//		
//		//메뉴(대분류) 페이지 주소 넣어
//		
//		
//	 }
	
	
//	@RequestMapping(value="/store/storeRegister", method=RequestMethod.POST ) 
//	 public String storeRegister(ReviewDto userreview) throws Exception {
//		
//		reivewService.storeinsert(userreview);
//	
//		return "redirect:/map"; //메뉴(대분류) 페이지 주소 넣어
//	 }
//	
	@ResponseBody
	@RequestMapping(value="/store/storeRegister", method=RequestMethod.POST) 
	public String storeName(ReviewDto userreview , HttpSession session ) throws Exception {
		
		 String userId = (String) session.getAttribute("userId");
		 
		// 사용자 id, 가게 이름를 매개변수로 가져가서 db 업데이트
		// orderService.updateStore(userId, storeName);
		 reivewService.storeinsert(userreview, userId);
		/*
		 * ReviewDto userreview1 = reivewService.storeinsert(userreview, storeId);
		 */
		/*
		 * model.addAttribute("userreview1", userreview1 );
		 */		
		return "map2"; 
	}
	
	
	// 리뷰 등록
	
	@RequestMapping(value="/review/writeReview", method=RequestMethod.POST)
	public String writeReview(HttpServletRequest request, Model model, ReviewDto review, MultipartHttpServletRequest multiFiles, String reviewCode) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		model.addAttribute("userId", userId);		
			
		reivewService.writeReview(review, multiFiles, reviewCode, userId);
				
				
		return "redirect:/review/reviewList";
	}
	
	@RequestMapping(value="/review/writeReview", method=RequestMethod.GET)
	public String writeReview() throws Exception {
		return "/review/writeReview";
	}
	
//	리뷰 리스트
	
	@RequestMapping("/review/reviewList")
	public ModelAndView openReviewList() throws Exception {
		ModelAndView mv = new ModelAndView("/review/reviewList");
		
		List<ReviewDto> reviewList = reivewService.selectReviewList();
		mv.addObject("reviewList", reviewList);
		
		return mv;
	}
	
	
	// 리뷰자세히 보기
	@RequestMapping(value="/review/reviewDetail/{idx}", method=RequestMethod.GET)
	public ModelAndView openReviewDetail(@PathVariable("idx") int idx  ) throws Exception {
		
		ModelAndView mv = new ModelAndView("/review/reviewDetail");
		
		
		ReviewDto review = reivewService.selectReview(idx);
		mv.addObject("review", review);
		
		return mv;
	}
	
//	내 리뷰
	@RequestMapping("/mypage/myReview")
	public ModelAndView myReviewList(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/mypage/myReview");
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
					
		List<BoardDto> myReviewList = reivewService.selectMyReview(userId);
		mv.addObject("myReviewList", myReviewList);
		
		return mv;
	}
	
//	리뷰 수정
	@RequestMapping(value="/review/reviewDetail/{idx}", method=RequestMethod.PUT)
	public String updateReview(ReviewDto review) throws Exception {
		reivewService.updateReview(review);
		return "redirect:/review/reviewList";
	}
	
//	리뷰 삭제
	@RequestMapping(value="/review/reviewDetail/{idx}", method=RequestMethod.DELETE)
	public String deleteReview(@PathVariable("idx") int idx) throws Exception {
		reivewService.deleteReview(idx);
		return "redirect:/review/reviewList";
	}				




	
//	//메뉴1 화면
//	@RequestMapping(value="/shop/{productCateId}", method=RequestMethod.GET)
//	public ModelAndView product(@RequestParam(required = false, defaultValue= "1", value="pageNum") int pageNum, @PathVariable("productCateId") int productCateId) throws Exception  {
//		
//		ModelAndView mv = new ModelAndView("shop/shop1");
//		
//		PageInfo<ShopDto> ProductList = new PageInfo<> (shopService.selectProductList(pageNum,productCateId),5);
//		  mv.addObject("ProductList", ProductList);
//		  
//		  List <ShopDto> ranking3 = shopService.selectRankingList(productCateId);
//		  mv.addObject("ranking3", ranking3);
//		  
//		  
//		//  List<AdminProductFileDto> fileList = shopService.selectMenuFileList(productCateId);
//		  
//		//  mv.addObject("fileList", fileList);
//		  
//		  if (ProductList.getList().size() > 0) {
//			  mv.addObject("productCateId", ProductList.getList().get(0).getProductCateId());  
//		  }
//		  
//		  
//		  
//		  return mv;
//		}
//	
//	 // 일반상품 상세화면
//	@ResponseBody
//	@RequestMapping(value="/shop/detail/1/{productId}", method=RequestMethod.GET)
//	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
//		ModelAndView mv = new ModelAndView("shop/detail");
//		
//		ShopDto board = shopService.selectProductDetail(productId);
//		mv.addObject("board", board);
//		
//		
//	      
//		return mv;
//	}
//	
//	//마켓 리스트
//	@RequestMapping(value="/shop/market", method=RequestMethod.GET)
//	public ModelAndView product2(@RequestParam(required = false, defaultValue= "1", value="pageNum") int pageNum) throws Exception  {
//		
//		ModelAndView mv = new ModelAndView("shop/shopmf");
//		
//		PageInfo<MarketDto> ProductList = new PageInfo<> (shopService.selectdformList(pageNum),5);
//		  mv.addObject("ProductList", ProductList);
//		  
//		
//		  
//		  return mv;
//		}
//	
//	/// 마켓 폼 상세화면
//		@RequestMapping(value="/shop/detail/{formId}", method=RequestMethod.GET)
//		public ModelAndView openBoardDetail2(@PathVariable("formId") long formId) throws Exception {
//			ModelAndView mv = new ModelAndView("shop/detailmarket");
//			
//			// 마켓정보
//			MarketDto board = shopService.selectclassDetail(formId);
//			// 마켓 물건 가져오기
//			List<ShopDto> formPro = shopService.selectformDetail2(formId);
//			
//			
//			mv.addObject("board", board);
//			//mv.addObject("formDetail", formDetail);
//			mv.addObject("formPro", formPro );
//			System.out.println(board);
//			System.out.println(formPro);
//
//			return mv;
//		} // userCcontroller 보면서 따라 상세화며 만들기!!
//		
//	
//	// 상세화면
////	@RequestMapping(value="/shop/detail/{productId}", method=RequestMethod.GET)
////	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
////		ModelAndView mv = new ModelAndView("shop/detail");
////		
////		ShopDto board = shopService.selectProductDetail(productId);
////		mv.addObject("board", board);
////		
////		return mv;
////	}
//	
//	// 클래스 리스트 
//	@RequestMapping("/class")
//	public ModelAndView paging(@RequestParam(required = false, defaultValue= "1") int pageNum) throws Exception {
//		
//		ModelAndView mv = new ModelAndView("shop/shopclass");
//		 
//		
//		PageInfo<classDto> classList = new PageInfo<>(shopService.selectClass(pageNum), 5); // 두번째 매개변수는 페이징 수
//		mv.addObject("classList", classList );
//		
//		return mv;
//	}
//	
//	
//
//		
//	
//	
//	
//	// 클래스 상세화면
//	// 상세화면
//	@RequestMapping(value="/class/detail/{classId}", method=RequestMethod.GET)
//	public ModelAndView openclassDetail(@PathVariable("classId") long classId) throws Exception {
//		ModelAndView mv = new ModelAndView("shop/detailclass");
//		
//		classDto board = shopService.selectClassDetail(classId);
//		mv.addObject("board", board);
//		
//		return mv;
//	}
//	
//	
////	@ResponseBody
////	@RequestMapping(value="/shop/market/3/{productId}", method=RequestMethod.GET)
////	public ModelAndView openBoardDetail(@PathVariable("productId") long productId) throws Exception {
////		ModelAndView mv = new ModelAndView("shop/detail3");
////		
////		ShopDto board = shopService.selectProductDetail(productId);
////		mv.addObject("board", board);
////		
////		JSONObject resMap = new JSONObject();
////		
////
////	      
////		return mv;
////	}
//	
	
	
	}
	


