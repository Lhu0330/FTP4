package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class ShopDto {
	
	private int idx;
	private int productId;
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



}
