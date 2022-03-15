package com.bitc.team5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.team5.dto.LoginDto;

@Mapper
public interface LoginMapper {

	int selectMemberInfoYn(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

	void registerMember(LoginDto register) throws Exception;

	void editMember(LoginDto member) throws Exception;

	LoginDto selectMemberDetail(String userId) throws Exception;

	void deleteMember(String userId) throws Exception;

	List<LoginDto> selectMemberList() throws Exception;

	void registerUser(LoginDto register) throws Exception;

	void registerSeller(LoginDto register) throws Exception;

	LoginDto selectSellerDetail(String userId) throws Exception;

	void editSeller(LoginDto member) throws Exception;

	void deleteSeller(String userId) throws Exception;

	List<LoginDto> selectSellerList() throws Exception;

	String selectMemberUserAuth(@Param("userId") String userId,@Param("userPw") String userPw) throws Exception;
}
