package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReviewDto {
	
	
//	private int idx;
//	private String userId;
//	private String userPw;
////	private String userName;
//	private String userAddr;
//	private String userPhone;
	//private String userAddrDetail;
	//private String userStore;
	
	
	private int idx;
	private String userId;
	private String reviewCode;	
	private String content;	
	private String storeName;
	private String storeAddr;
	private String userAuth;
	private String placeName;
	private String addressName;
	private String roadAddressName;
	private String x;
	private String y;
	private String title;
	private String contents;
	private List<AdminProductFileDto> fileList;




}
