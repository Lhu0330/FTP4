package com.bitc.team5.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;

public interface SellerService {
	 // ������
		public List<UsersDto> getUsers() throws Exception;

	 //��ǰ��� 	

		public List<ShopDto> selectProductList() throws Exception;



	 // ��ǰ ��� 
		public void insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles ) throws Exception;

		 //��ȭ��
		public ShopDto selectAdminProductDetail(int idx) throws Exception;

		AdminProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;


	

}
