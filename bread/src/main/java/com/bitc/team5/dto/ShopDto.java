package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class ShopDto {
	
	private int idx; // °Ô½Ã±Û¹øÈ£ 
	private long productId; //»óÇ°ÄÚµå
	private int productCateId;
	private String storeId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int productStockCnt;
	
	
	private String storeName;
	private String storeDescription;
	private String storeMaster;
	
	private String storedFilePath;
	
	private List<AdminProductFileDto> fileList;
	private List<AdminProductFileDto> fileList2;
	
	private int fileIdx; // �ø����Ϲ�ȣ seq
	private int boardIdx; //�Խñ۹�ȣ 
	private String originalFileName;
//	������ long Ÿ������ ����ؾ� ������ sql���� ����ڰ� �˾ƺ��� ������ kb���� Ȯ���ϴ� ���·� �����ϴ� ������ ���鼭 fileSize�� String Ÿ������ ��ȯ�Ǿ� DTO������ String Ÿ������ �����͸� �����
	private String fileSize;
	private String fileType;
	private String deletedYn;
	private long formId;


}
