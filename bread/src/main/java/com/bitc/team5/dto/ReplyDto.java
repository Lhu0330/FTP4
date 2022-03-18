package com.bitc.team5.dto;

import lombok.Data;

@Data
public class ReplyDto {


	private int rno;
	private int no; // �Խñ� ��ȣ board_idx
	private String userId;
//	private String pw;
	private String content;
	
	//private String date;

	//�Է��Ҷ��� �Է� ������ �������ش�. ����Ҷ��� �ʿ���� 
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	// private char deletedYn;

	
}
