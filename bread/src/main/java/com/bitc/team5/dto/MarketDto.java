package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class MarketDto {
	
	private int id;
	private int idx; //글번호
	private String storeId;
	private String marketName;
	private String banking;
	private String plan;
	private long formId;
	private String marketDetail;
	private String allday; 
//	private long productId; //��ǰ�ڵ�
	private int productCateId;
	private String title; 
	private String time; 

//	private String productName;
//	private int productPrice;
	private String productDescription;
//	private int productStockCnt;
	private List<AdminProductFileDto> fileList;
	private List<AdminProductFileDto> fileList2;
	
	private int fileIdx; // �ø����Ϲ�ȣ seq
	private int boardIdx; //�Խñ۹�ȣ 
	private long productId;
	private String originalFileName;
	private String storedFilePath;
	private String fileSize;
	private String fileType;
	private String deletedYn;
	
	private String startDate;
	private String endDate;
	

}
