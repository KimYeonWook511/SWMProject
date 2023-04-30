package com.studywithme.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.UserDTO;
import com.studywithme.domain.UserVO;
import com.studywithme.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userDAO;
	
	@Override
	public void signupUser(UserDTO dto) throws Exception {
		// 회원가입 서비스
		userDAO.signupUser(dto);
	}
	
	@Override
	public UserVO readUser(String userId) throws Exception {
		// 유저 정보 불러오는 서비스
		return userDAO.readUser(userId);
	}
	
	@Override
	public UserVO loginUser(UserDTO dto) throws Exception {
		// 로그인 서비스
		return userDAO.readUser(dto.getUserId());
	}
}
