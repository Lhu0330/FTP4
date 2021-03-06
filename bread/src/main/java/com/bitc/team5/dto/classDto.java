package com.bitc.team5.dto;

import java.util.List;

import lombok.Data;

@Data
public class classDto {
	
	private int idx;
	private int classPrice;
	private String classPlace;
	private String classPlan;
	private String classId;
	private String className;
	private String classDetail;
	private String storeId;
	private String allday; 
	
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
	private String time;


}
