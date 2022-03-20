package com.bitc.team5.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.login.LoginDto;
import com.bitc.team5.mapper.login.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public int selectMemberInfoYn(String userId, String userPw) throws Exception {
		return loginMapper.selectMemberInfoYn(userId, userPw);
	}

	@Override
	public void registerMember(LoginDto register) throws Exception {
		loginMapper.registerMember(register);
	}

	@Override
	public void editMember(LoginDto member) throws Exception {
		loginMapper.editMember(member);
	}

	@Override
	public LoginDto selectMemberDetail(String userId) throws Exception {
		return loginMapper.selectMemberDetail(userId);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		loginMapper.deleteMember(userId);
	}

	@Override
	public List<LoginDto> selectMemberList() throws Exception {
		return loginMapper.selectMemberList();
	}

	@Override
	public void registerUser(LoginDto register) throws Exception {
		loginMapper.registerUser(register);
	}

	@Override
	public void registerSeller(LoginDto register) throws Exception {
		loginMapper.registerSeller(register);
	}

	@Override
	public LoginDto selectSellerDetail(String userId) throws Exception {
		return loginMapper.selectSellerDetail(userId);
	}

	@Override
	public void editSeller(LoginDto member) throws Exception {
		loginMapper.editSeller(member);
	}

	@Override
	public void deleteSeller(String userId) throws Exception {
		loginMapper.deleteSeller(userId);
	}

	@Override
	public List<LoginDto> selectSellerList() throws Exception {
		return loginMapper.selectSellerList();
	}

	@Override
	public String selectMemberUserAuth(String userId, String userPw) throws Exception {
		return loginMapper.selectMemberUserAuth(userId, userPw);
	}
}
