package com.bitc.team5.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.team5.dto.StoreDto;

@Mapper
public interface StoreMapper {

	void registerSeller(StoreDto store) throws Exception;

	void selectSellerDetail(String userId) throws Exception;
}
