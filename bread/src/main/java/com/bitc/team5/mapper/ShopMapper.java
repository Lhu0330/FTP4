package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.ShopDto;
import com.github.pagehelper.Page;

@Mapper
public interface ShopMapper {

	// 메뉴별 상품 리스트
	Page<ShopDto> selectProductList(int productCateId) throws Exception;

		//상세보기 
	public ShopDto selectProductDetail(long productId) throws Exception;
		//이지미 불러오기
	List<AdminProductFileDto> selectBoardFileList(long productId);
	
	// List<AdminProductFileDto> selectBoardFileList2(long productId);
	
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
