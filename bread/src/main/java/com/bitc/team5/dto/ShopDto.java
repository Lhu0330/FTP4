package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class ShopDto {
	
	private int idx; // 게시글번호 
	private long productId; //상품코드
	private int productCateId;
	private int storeId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int productStockCnt;
	
	
	private String storeName;
	private String storeDescription;
	private String storeMaster;
	
	
	
	private List<AdminProductFileDto> fileList;
	private List<AdminProductFileDto> fileList2;


}
