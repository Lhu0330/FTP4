package com.bitc.team5.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.ReplyDto;
import com.bitc.team5.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.webjjang.util.PageObject;

@Service
@Log4j2
@Qualifier("replyServiceImpl")
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyDto> list(PageObject pageObject, int no) {
		// ��ü �����͸� �����������ؼ� getrROW �ʿ� PageObject�� �����ؾ߸� �Ѵ�
		pageObject.setTotalRow(mapper.getRow(no));
		log.info(pageObject);
		// mybatis������ �����͸� �Ѱ��� �޵��� ����Ǿ����ִ�.
		// �Ѱܾ��Ұ���  pageObject�� no�� �Ѱܾ��Ѵ� -> �ϳ��� �������ش� class �� map
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		pageInfo.put("pageObject", pageObject);
		pageInfo.put("no", no);
		
		
		return mapper.list(pageInfo);
	}

	@Override
	public Integer write(ReplyDto vo) {
		// TODO Auto-generated method stub
		return mapper.write(vo);
	}

	@Override
	public int update(ReplyDto vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(int rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}

}
