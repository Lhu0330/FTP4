package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class BoardDto {

	private int idx;	
	private String userId;;
	private String title;
	private String Contents;
	
	private List<AdminProductFileDto> fileList;
}
