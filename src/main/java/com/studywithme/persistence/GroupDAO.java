package com.studywithme.persistence;

import java.util.List;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.GroupMemberCountVO;
import com.studywithme.domain.GroupVO;
import com.studywithme.domain.MemberDTO;
import com.studywithme.domain.MemberVO;

public interface GroupDAO {
	
	public void createGroup(GroupDTO groupDTO) throws Exception;
	public void createMember(List<MemberDTO> memberList) throws Exception;
	public List<GroupVO> myGroupList(String userId) throws Exception;
	public List<GroupMemberCountVO> myGroupMemeberCountList(String userId) throws Exception;
	public GroupVO readGroupInfo(int groupNo) throws Exception;
	public List<MemberVO> readGroupMemberList(int groupNo) throws Exception;
}
