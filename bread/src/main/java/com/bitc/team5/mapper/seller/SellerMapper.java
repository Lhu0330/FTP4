package com.bitc.team5.mapper.seller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.SheduleDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;
import com.bitc.team5.dto.classDto;

@Mapper
public interface SellerMapper {

	//UserDto selectUserDetail(int seq) throws Exception;
 
		List<UsersDto> getUsers() throws Exception;
			
		// 물품리스트 가져오기
				List<ShopDto> selectProductList() throws Exception;
				
					// 폼 가져오기
				List<MarketDto> selectformList() throws Exception;
				
				// 상품등록
				public void insertBoard(ShopDto restBoard) throws Exception;
				
				// 상품이미지 등록 
				void insertBoardFileList(List<AdminProductFileDto> list) throws Exception;

				 // 상품상세정보
				public ShopDto selectBoardDetail(int idx);

					// 상품 사진들고오기 
		 		List<AdminProductFileDto> selectBoardFileList(int idx) throws Exception;	

				AdminProductFileDto selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;

				
				// 마켓 폼 관련 
				
				// 마켓정보 등록 
				void insertForm(MarketDto market) throws Exception;	

				// 폼 리스트 등록 하기 
				void insertForm2(List<ShopDto> formProduct);
						
					// 사진
				void insertBoardFileList3(List<AdminProductFileDto> list) throws Exception;	
				
				
				// 마켓 물품 등록 
				public void insertMarketStock(List<ShopDto> marketList) throws Exception;

					// 클래스 등록
				void insertClass(classDto restBoard) throws Exception;
				
				void insertBoardFileList2(List<AdminProductFileDto> list) throws Exception;
				
				// 클래스 리스트 가져오기
				List<classDto> selectclassList() throws Exception;

					//클래스 상세보기 
				public classDto selectclassDetail(int idx);
					
					// 클래스 사진 가져오기
				List<AdminProductFileDto> selectBoardFileList2(int idx);
					
				//  마켓상세보기 
				MarketDto selectformDetail(long formId) throws Exception;

					// 마켓 사진 가져오기
				List<AdminProductFileDto> selectBoardFileList3(long formId);
				
					// 마켓 상세화면 폼 동적 INPUT 상품 가져오기
				List<ShopDto> selectformDetail2(long formId) throws Exception;

			
				
			void insertshop(ShopDto shop, long orderCode);

			void insertshop(ShopDto restBoard);

			List<SheduleDto> showSchedule() throws Exception;

			void addSchedule(SheduleDto dto) throws Exception;

			List<MarketDto> formDateList();

			List<classDto> classDateList();

	


	

		


		


		
	
}
