package com.bitc.team5.service.shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.ReplyDto;
import com.bitc.team5.mapper.shoppinig.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.webjjang.util.PageObject;

@Service
@Qualifier("replyServiceImpl")
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	

	private ReplyMapper mapper;
	
	@Override
	public List<ReplyDto> list(PageObject pageObject, int no) {
		// 전체 데이터를 가져오기위해서 getrROW 필요 PageObject에 셋팅해야만 한다
		pageObject.setTotalRow(mapper.getRow(no));
	//	log.info(pageObject);
		// mybatis에서는 데이터를 한개만 받도록 설계되어져있다.
		// 넘겨야할것은  pageObject와 no를 넘겨야한다 -> 하나로 맏르어준다 class 나 map
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
