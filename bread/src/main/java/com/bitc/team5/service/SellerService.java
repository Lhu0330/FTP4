package com.bitc.team5.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;

public interface SellerService {

	 // 유저목럭
	public List<UsersDto> getUsers() throws Exception;

 //상품목록 	

	public List<ShopDto> selectProductList() throws Exception;



 // 상품 등록 
	public void insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles ) throws Exception;

	 //상세화면
	public ShopDto selectAdminProductDetail(int idx) throws Exception;

	AdminProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;


	

}
