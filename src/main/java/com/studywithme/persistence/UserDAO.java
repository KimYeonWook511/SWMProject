package com.studywithme.persistence;

import com.studywithme.domain.UserDTO;
import com.studywithme.domain.UserVO;

public interface UserDAO {
	
	public void signupUser(UserDTO dto) throws Exception;
	public UserVO readUser(String userId) throws Exception;
}
