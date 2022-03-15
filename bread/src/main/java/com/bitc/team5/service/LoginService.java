package com.bitc.team5.service;

import java.util.List;

import com.bitc.team5.dto.LoginDto;

public interface LoginService {

	int selectMemberInfoYn(String userId, String userPw) throws Exception;

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

	String selectMemberUserAuth(String userId, String userPw) throws Exception;
}
