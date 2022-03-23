package com.bitc.team5.mapper.shoppinig;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.classDto;
import com.github.pagehelper.Page;

@Mapper
public interface ShopMapper {

	// 상품리스트
		Page<ShopDto> selectProductList(int productCateId) throws Exception;

		// 상품상세화면
		public ShopDto selectProductDetail(long productId) throws Exception;
		
		//  사진썸넬 
		List<AdminProductFileDto> selectBoardFileList(long productId);
		// 상세화면 이미지
		List<AdminProductFileDto> selectBoardFileList2(long productId);
		 // 메뉴별 화면 
		List<AdminProductFileDto> selectMenuFileList(int productCateId);
		
	//
////		DB�� �����Ͽ� �Խñ��� ÷������ ������ DB�� �����ϴ� �޼���
//		void insertBoardFileList(List<ProductFileDto> list) throws Exception;
	//	
////		DB�� �����Ͽ� �Խñ��� ÷������ ������ �������� �޼���
//		List<ProjectDto> selectBoardFileList(int productIdx) throws Exception;	
	//	
	//	
//		ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;
// 클래스 
			//강좌 가져오기 
		Page<classDto> selectClass() throws Exception;
		
		// 랭킹가져오기
		List<ShopDto> selectRankingList(int productCateId);
		
		
			 //강좌 상세화면
		classDto selectClassDetail(long classId);
		
		List<AdminProductFileDto> selectclassFileList(long classId);

		List<AdminProductFileDto> selectclassFileList2(long classId);
		

// 마켓폼
		// 마켓 폼 list
		Page<MarketDto> selectdformList();

				// 폼 a마켓정보가져오기 
		MarketDto selectformDetail(long formId);
			
		
		// input 상품가져오기
		List<ShopDto> selectformDetail2(long formId);
		
		// 상품사진 상세보기

		List<AdminProductFileDto> selectformFileList(long formId);

		List<AdminProductFileDto> selectformFileList2(long formId);
		
		// 일반상품 조회수 올리기
		void updateHitCnt(long productId);
		
		// 마켓랭킹
		List<MarketDto> selectRankingformList();
			// 마켓 조회수 
		void updateHitCnt2(long formId);

		
	
				
//  -------		마켓 끝 ----------- 
		
		
// 달력
		
	
		
		
		
		

		
		
		

}
