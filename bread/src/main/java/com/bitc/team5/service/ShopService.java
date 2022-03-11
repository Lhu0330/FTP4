package com.bitc.team5.service;

import com.bitc.team5.dto.ShopDto;
import com.github.pagehelper.Page;


public interface ShopService {

	 // 메뉴별 화면 
	Page<ShopDto> selectProductList(int pageNum, int productCateId) throws Exception;
	
	
 // 상품상세 화면 
	ShopDto selectProductDetail( long productId) throws Exception;
	
//	 //메인화면 	
//		List<ProjectDto> selectJrList() throws Exception;
//		
////		List<ProjectDto> selectList() throws Exception;
//		
//	
//		//List<ProjectDto> selectMenuList(int productCategoryIdx) throws Exception;
//		Page<ProjectDto> selectMenuList(int pageNum, int productCategoryIdx) throws Exception;
//		
//		
//	// 상세화면
//		ProjectDto selectBoardDetail(int productIdx) throws Exception;
//		
//		
//		ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;

	
}
