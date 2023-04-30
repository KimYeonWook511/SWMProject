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
		// ȸ������ ����
		userDAO.signupUser(dto);
	}
	
	@Override
	public UserVO readUser(String userId) throws Exception {
		// ���� ���� �ҷ����� ����
		return userDAO.readUser(userId);
	}
	
	@Override
	public UserVO loginUser(UserDTO dto) throws Exception {
		// �α��� ����
		return userDAO.readUser(dto.getUserId());
	}
}
