package com.bitc.team5.service.seller;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.SheduleDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;
import com.bitc.team5.dto.classDto;

public interface SellerService {


	 // 사용자가져오기
		public List<UsersDto> getUsers() throws Exception;

	 // 상품가져오기 	

		public List<ShopDto> selectProductList() throws Exception;



	 // // 일반상품등록 
		public void insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles ,String storeId) throws Exception;

		 // 상세화면 
		public ShopDto selectAdminProductDetail(int idx) throws Exception;

		// 상세화면이미지 가져오기
		AdminProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;


		
		// 마켓 폼 관련 
		
		// 마켓 폼 등록하기  
		//public void insertMarketStock(List<ShopDto> marketList) throws Exception;
		
		// 마켓폼 중 마켓 정보 등록 
		public void insertForm(MarketDto market, MultipartHttpServletRequest multiFiles,String storeId, long formId) throws Exception;
		public void insertForm2(List<ShopDto> formProduct, String storeId,  long formId);
		
		//폼  상세보기
		public MarketDto selectformDetail(long formId) throws Exception;
		 // 폼 상세 화면 
			public List<ShopDto> selectformDetail2(long formId) throws Exception;

		
		
		//  쿠킹클래스 등록 하기
		public void insertClass(classDto restBoard, MultipartHttpServletRequest multiFiles, String storeId)  throws Exception;

		// 쿠킹클래스 리스트 불러오기
		public List<classDto> selectclassList() throws Exception;
		
		// 클래스 디테일
		public classDto selectclassDetail(int idx) throws Exception;

				//클래스 리스트 가져오기
		public List<MarketDto> selectformList() throws Exception;

			// 스케쥴
		public void addSchedule(SheduleDto dto)  throws Exception;


		public List<MarketDto> formDateList();
		public List<classDto> classDateList();
		

		


}
