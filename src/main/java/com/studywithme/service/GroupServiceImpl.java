package com.studywithme.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.GroupMemberCountVO;
import com.studywithme.domain.GroupVO;
import com.studywithme.domain.MemberDTO;
import com.studywithme.domain.MemberVO;
import com.studywithme.domain.UserVO;
import com.studywithme.persistence.GroupDAO;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Inject
	private GroupDAO groupDAO;
	
	@Override
	public void createGroup(GroupDTO groupDTO) throws Exception {
		// ���͵� �׷� ����
		groupDAO.createGroup(groupDTO);
	}
	
	@Override
	public void createMember(List<MemberDTO> memberList) throws Exception {
		// ���͵� �׷�� ����
		groupDAO.createMember(memberList);
	}
	
	@Override
	public List<GroupVO> myGroupList(String userId) throws Exception {
		// ���� ���͵� �׷� ����Ʈ ��ȸ
		return groupDAO.myGroupList(userId);
	}
	
	@Override
	public List<GroupMemberCountVO> myGroupMemeberCount(String userId) throws Exception {
		// ���� ���͵� �׷� ��� �� ��ȸ
		return groupDAO.myGroupMemeberCountList(userId);
	}
	
	@Override
	public GroupVO readGroupInfo(int groupNo) throws Exception {
		// ���͵� �׷� ���� ��ȸ
		return groupDAO.readGroupInfo(groupNo);
	}
	
	@Override
	public List<MemberVO> readGroupMemberList(int groupNo) throws Exception {
		// ���͵� �׷� ��� ����Ʈ ��ȸ
		return groupDAO.readGroupMemberList(groupNo);
	}
	
	@Override
	public UserVO readLeaderInfo(String leaderId) throws Exception {
		// ���͵� �׷� ���� ���� ��ȸ
		return groupDAO.readLeaderInfo(leaderId);
	}
}
