package com.bitc.team5.service.shopping;

import java.util.List;

import com.bitc.team5.dto.ReplyDto;

import net.webjjang.util.PageObject;

public interface ReplyService {

	public List<ReplyDto> list(PageObject pageObject, int no);
	// 댓글 내용이간단하므로 리스트에 내용을 다 표시하기 때문에 댓글보기가 필요없단
	public Integer write(ReplyDto vo);
	public int update(ReplyDto vo);
	public int delete(int rno);
		
}