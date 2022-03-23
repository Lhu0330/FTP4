package com.bitc.team5.mapper.shoppinig;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.ReplyDto;

@Mapper
public interface ReplyMapper {

	      // 1. list
 // pageObject와 no가 포함된 Map(pageInfo)을 넘겨줄 것이다
	public List<ReplyDto> list(Map<String, Object> pageInfo);
	// 댓글 내용이간단하므로 리스트에 내용을 다 표시하기 때문에 댓글보기가 필요없단
	// 글번호에 해당하는 댓글총개수
	public int getRow(int no);
	
	//등록
	public Integer write(ReplyDto vo);
	 //업뎃
	public int update(ReplyDto vo);
	// 삭제
	public Integer delete(int rno);
		

	

}
