package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;

@Mapper
public interface SellerMapper {

	//UserDto selectUserDetail(int seq) throws Exception;

		List<UsersDto> getUsers() throws Exception;

		List<ShopDto> selectProductList() throws Exception;

		


		// ��ǰ��� 
		public void insertBoard(ShopDto restBoard) throws Exception;
		
		// �̹�������
		void insertBoardFileList(List<AdminProductFileDto> list) throws Exception;

		 // ��ȭ�� 
		public ShopDto selectBoardDetail(int idx);

		List<AdminProductFileDto> selectBoardFileList(int idx) throws Exception;	

		AdminProductFileDto selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx) throws Exception;

		
	
}
