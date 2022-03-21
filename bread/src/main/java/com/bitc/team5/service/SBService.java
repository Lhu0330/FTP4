package com.bitc.team5.service;

import java.util.List;

import com.bitc.team5.dto.SBDto;

public interface SBService {
	
	List<SBDto> selectCartList(String userId) throws Exception;
	
	List<SBDto> selectPayList(String userId) throws Exception;
	
	List<SBDto> selectSuccessList(String userId) throws Exception;
	
	SBDto selectCostCalculate(SBDto cart) throws Exception;

	void insertCart(SBDto cart) throws Exception;
	
	void deleteCart(long productIdx) throws Exception;
	
	void checkedCart(long[] productIdx) throws Exception;
	
	void checkedNotCart() throws Exception;
	
	void increaseCart(int productIdx) throws Exception;
	
	void decreaseCart(int productIdx) throws Exception;
	
	void updateSuccess(SBDto success) throws Exception;
	
	void addCart(SBDto cart) throws Exception;
	
	void addCart1(String userId) throws Exception;
	
	void addCart3(SBDto cart) throws Exception;
	
	void addCart4(SBDto cart) throws Exception;
	
}
