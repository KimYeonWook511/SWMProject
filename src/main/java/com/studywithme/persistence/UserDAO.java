package com.studywithme.persistence;

import com.studywithme.domain.UserDTO;

public interface UserDAO {
	
	public void signupUser(UserDTO dto) throws Exception;
}
