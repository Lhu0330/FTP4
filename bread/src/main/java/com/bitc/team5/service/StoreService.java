package com.bitc.team5.service;

import com.bitc.team5.dto.StoreDto;

public interface StoreService {

	void registerSeller(StoreDto store) throws Exception;

	StoreDto selectSellerDetail(String userId) throws Exception;
}
