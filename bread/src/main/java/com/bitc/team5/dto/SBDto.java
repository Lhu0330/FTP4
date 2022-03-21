package com.bitc.team5.dto;

import lombok.Data;

@Data
public class SBDto {

	private long productIdx;
	private String productName;
	private int productPrice;
	private int deliveryCost;
	private int cartQty;
	private int successQty;
	private int productStockCnt;
	private char checkedYn;
	private int bsCost;
	private int dsCost;
	private int finalCost;
	private int customerIdx;
	private int orderCnt;
	private String marketName;
	private String userId;
	

}
