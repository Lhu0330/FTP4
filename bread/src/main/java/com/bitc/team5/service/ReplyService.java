package com.bitc.team5.service;

import java.util.List;

import com.bitc.team5.dto.ReplyDto;

import net.webjjang.util.PageObject;

public interface ReplyService {

	public List<ReplyDto> list(PageObject pageObject, int no);
	// ��� �����̰����ϹǷ� ����Ʈ�� ������ �� ǥ���ϱ� ������ ��ۺ��Ⱑ �ʿ����
	public Integer write(ReplyDto vo);
	public int update(ReplyDto vo);
	public int delete(int rno);
		
}