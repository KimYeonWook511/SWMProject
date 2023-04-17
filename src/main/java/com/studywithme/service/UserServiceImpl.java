package com.studywithme.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.UserDTO;
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
}
