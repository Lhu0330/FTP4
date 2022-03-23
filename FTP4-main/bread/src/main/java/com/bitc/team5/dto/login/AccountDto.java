package com.bitc.team5.dto.login;

import lombok.Data;

@Data
public class AccountDto {

	private int idx;
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddr;
	
	private String userAuth;
}
