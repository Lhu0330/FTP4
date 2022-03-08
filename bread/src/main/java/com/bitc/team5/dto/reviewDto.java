package com.bitc.team5.dto;

import lombok.Data;

@Data
public class reviewDto {


	private int idx;
	private String userId;
	private String pw;
	private String content;
	private String date;
	private char deletedYn;
	
	
	
}
