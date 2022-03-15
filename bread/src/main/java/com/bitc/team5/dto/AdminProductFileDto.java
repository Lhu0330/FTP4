package com.bitc.team5.dto;

import lombok.Data;


@Data
public class AdminProductFileDto {

	private int fileIdx; // �ø����Ϲ�ȣ seq
	private int boardIdx; //�Խñ۹�ȣ 
	private long productId;
	private String originalFileName;
	private String storedFilePath;
//	������ long Ÿ������ ����ؾ� ������ sql���� ����ڰ� �˾ƺ��� ������ kb���� Ȯ���ϴ� ���·� �����ϴ� ������ ���鼭 fileSize�� String Ÿ������ ��ȯ�Ǿ� DTO������ String Ÿ������ �����͸� �����
	private String fileSize;
	private String fileType;
	private String deletedYn;
}
