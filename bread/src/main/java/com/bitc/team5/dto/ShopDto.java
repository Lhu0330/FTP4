package com.bitc.team5.dto;

import lombok.Data;

@Data
public class ShopDto {
	
	private int productId;
	private int productCateId;
	private int storeId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private String productStockCnt;
	
	
	private String storeName;
	private String storeDescription;
	private String storeMaster;


}
