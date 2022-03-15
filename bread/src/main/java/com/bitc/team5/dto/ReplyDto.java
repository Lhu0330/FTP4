package com.bitc.team5.dto;

import lombok.Data;

@Data
public class ReplyDto {


	private int rno;
	private int no; // 게시글 번호 board_idx
	private String userId;
//	private String pw;
	private String content;
	
	//private String date;

	//입력할때만 입력 패턴을 지정해준다. 출력할때는 필요없음 
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	private char deletedYn;

	
}
