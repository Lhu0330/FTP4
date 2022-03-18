package com.bitc.team5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.SBDto;
import com.bitc.team5.mapper.SBMapper;

@Service
public class SBServiceImpl implements SBService {

	@Autowired
	private SBMapper SBMapper;

	@Override
	public List<SBDto> selectCartList(String userId) throws Exception {
		return SBMapper.selectCartList(userId);
	}
	
	@Override
	public List<SBDto> selectPayList(String userId) throws Exception {
		return SBMapper.selectPayList(userId);
	}
	
	@Override
	public List<SBDto> selectSuccessList(String userId) throws Exception {
		return SBMapper.selectSuccessList(userId);
	}
	
	@Override
	public SBDto selectCostCalculate(SBDto cart) throws Exception {
		return SBMapper.selectCostCalculate(cart);
	}

	@Override
	public void insertCart(SBDto cart) throws Exception {
		SBMapper.insertCart(cart);
	}

	@Override
	public void deleteCart(int productIdx) throws Exception {
		SBMapper.deleteCart(productIdx);
	}
	
	@Override
	public void checkedCart(int[] productIdx) throws Exception {
		for (int i = 0; i < productIdx.length; i++) {
			SBMapper.checkedCart(productIdx[i]);
		}
	}

	
	@Override
	public void checkedNotCart() throws Exception {
		SBMapper.checkedNotCart();
	}

	@Override
	public void increaseCart(int productIdx) throws Exception {
		SBMapper.increaseCart(productIdx);
	}
	
	@Override
	public void decreaseCart(int productIdx) throws Exception {
		SBMapper.decreaseCart(productIdx);
	}
	
	@Override
	public void updateSuccess(SBDto success) throws Exception {
		SBMapper.updateSuccess(success);
	}
	
	@Override
	public void addCart(SBDto cart) throws Exception {
		SBMapper.addCart(cart);
	}
	
	@Override
	public void addCart1(String userId) throws Exception {
		SBMapper.addCart1(userId);
	}

}
