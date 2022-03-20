package com.bitc.team5.dto;

import lombok.Data;


@Data
public class AdminProductFileDto {

	private int fileIdx; // �ø����Ϲ�ȣ seq
	private int boardIdx; //�Խñ۹�ȣ 
	private long productId;
	private String originalFileName;
	private String storedFilePath;
	private String fileSize;
	private String fileType;
	private String deletedYn;
	
	
	//class 관련 
	private long classId;
	
	// 마켓 관력 
	private long formId;
	private String storeId;
	
	
}
