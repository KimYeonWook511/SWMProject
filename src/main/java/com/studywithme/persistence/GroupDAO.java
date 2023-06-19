package com.studywithme.persistence;

import java.util.List;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.GroupVO;
import com.studywithme.domain.MemberDTO;

public interface GroupDAO {
	
	public void createGroup(GroupDTO groupDTO) throws Exception;
	public void createMember(List<MemberDTO> memberList) throws Exception;
	public List<GroupVO> myGroupList(String userId) throws Exception;
}
