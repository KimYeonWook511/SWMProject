package com.studywithme.service;

import java.util.List;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.UserVO;

public interface GroupService {

	public void createGroup(GroupDTO groupDTO) throws Exception;
	public void createMember(List<UserVO> userList) throws Exception;
}
