package com.bitc.team5.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.login.StoreDto;
import com.bitc.team5.mapper.login.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreMapper storeMapper;
	
	@Override
	public void registerSeller(StoreDto store) throws Exception {
		storeMapper.registerSeller(store);
	}

	@Override
	public StoreDto selectSellerDetail(String userId) throws Exception {
		return selectSellerDetail(userId);
	}
}
