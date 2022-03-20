package com.bitc.team5.service.shopping;

import java.util.List;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.classDto;
import com.github.pagehelper.Page;


public interface ShopService {

	 // 메뉴별 화면 
	Page<ShopDto> selectProductList(int pageNum, int productCateId) throws Exception;
	
	
	// 상품상세 화면 
	ShopDto selectProductDetail( long productId) throws Exception;

	//클래스 리스트 불러오기
	Page<classDto> selectClass(int pageNum) throws Exception;

	// 클래스 디테일 화면 
	classDto selectClassDetail(long classId) throws Exception;


		// 마켓
	Page<MarketDto> selectdformList(int pageNum);

	// 마켓폴 정보 상세보기
	MarketDto selectclassDetail(long formId);

	// 마켓폴 물건 상세보기
	List<ShopDto> selectformDetail2(long formId);


	List<AdminProductFileDto> selectMenuFileList(int productCateId);

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
