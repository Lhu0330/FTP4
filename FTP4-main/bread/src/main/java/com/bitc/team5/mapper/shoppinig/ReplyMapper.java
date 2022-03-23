package com.bitc.team5.mapper.shoppinig;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.ReplyDto;

@Mapper
public interface ReplyMapper {

	      // 1. list
 // pageObject�� no�� ���Ե� Map(pageInfo)�� �Ѱ��� ���̴�
	public List<ReplyDto> list(Map<String, Object> pageInfo);
	// ��� �����̰����ϹǷ� ����Ʈ�� ������ �� ǥ���ϱ� ������ ��ۺ��Ⱑ �ʿ����
	// �۹�ȣ�� �ش��ϴ� ����Ѱ���
	public int getRow(int no);
	
	//���
	public Integer write(ReplyDto vo);
	 //����
	public int update(ReplyDto vo);
	// ����
	public Integer delete(int rno);
		

	

}
