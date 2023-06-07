package com.studywithme.service;

import java.util.List;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.MemberDTO;

public interface GroupService {

	public void createGroup(GroupDTO groupDTO) throws Exception;
	public void createMember(List<MemberDTO> memberList) throws Exception;
}
