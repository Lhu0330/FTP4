package com.bitc.team5.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.ShopDto;
import com.github.pagehelper.Page;

@Mapper
public interface ShopMapper {

	// 메뉴별 상품 리스트
	Page<ShopDto> selectProductList(int productCateId) throws Exception;

	public ShopDto selectProductDetail(int productId) throws Exception;
	
//
////	DB에 연결하여 게시글의 첨부파일 정보를 DB에 저장하는 메서드
//	void insertBoardFileList(List<ProductFileDto> list) throws Exception;
//	
////	DB에 연결하여 게시글의 첨부파일 정보를 가져오는 메서드
//	List<ProjectDto> selectBoardFileList(int productIdx) throws Exception;	
//	
//	
//	ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;




	

}
