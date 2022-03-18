package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.SBDto;

@Mapper
public interface SBMapper {

	public List<SBDto> selectCartList(String userId) throws Exception;
	
	public List<SBDto> selectPayList(String userId) throws Exception;
	
	public List<SBDto> selectSuccessList(String userId) throws Exception;
	
	public SBDto selectCostCalculate(SBDto cart) throws Exception;

	public void insertCart(SBDto cart) throws Exception;

	public void deleteCart(int productIdx) throws Exception;

	void checkedCart(int productIdx) throws Exception;
	
	void checkedNotCart() throws Exception;
	
	void increaseCart(int productIdx) throws Exception;
	
	void decreaseCart(int productIdx) throws Exception;
	
	void updateSuccess(SBDto success) throws Exception;
	
	public void addCart(SBDto cart) throws Exception;
	
	public void addCart1(String userId) throws Exception;

}
