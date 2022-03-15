package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.ShopDto;
import com.github.pagehelper.Page;

@Mapper
public interface ShopMapper {

	// �޴��� ��ǰ ����Ʈ
		Page<ShopDto> selectProductList(int productCateId) throws Exception;

			//�󼼺��� 
		public ShopDto selectProductDetail(long productId) throws Exception;
		
		//������ �ҷ�����
		List<AdminProductFileDto> selectBoardFileList(long productId);
		
		List<AdminProductFileDto> selectBoardFileList2(long productId);
		
	//
////		DB�� �����Ͽ� �Խñ��� ÷������ ������ DB�� �����ϴ� �޼���
//		void insertBoardFileList(List<ProductFileDto> list) throws Exception;
	//	
////		DB�� �����Ͽ� �Խñ��� ÷������ ������ �������� �޼���
//		List<ProjectDto> selectBoardFileList(int productIdx) throws Exception;	
	//	
	//	
//		ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;


}
