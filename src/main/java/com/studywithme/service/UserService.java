package com.studywithme.service;

import com.studywithme.domain.UserDTO;
import com.studywithme.domain.UserVO;

public interface UserService {
	
	public void signupUser(UserDTO dto) throws Exception;
	public UserVO readUser(String userid) throws Exception;
	public UserVO loginUser(UserDTO dto) throws Exception;
	
}
