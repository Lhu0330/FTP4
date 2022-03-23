package com.bitc.team5.service.login;

import com.bitc.team5.dto.login.StoreDto;

public interface StoreService {

	void registerSeller(StoreDto store) throws Exception;

	StoreDto selectSellerDetail(String userId) throws Exception;
}
