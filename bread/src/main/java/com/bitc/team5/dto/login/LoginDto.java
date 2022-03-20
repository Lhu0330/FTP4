package com.bitc.team5.dto.login;

import lombok.Data;

@Data
public class LoginDto {
	
	private int idx;
	private String userId;
	private String userPw;	
	private String userEmail;	
	private String userPhone;	
	private String userAddr;
	private String userAuth;
	private String storeName;
	private String storeDesc;
	private String storeAddr;
}
