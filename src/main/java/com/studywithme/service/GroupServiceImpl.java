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
		// 스터디 그룹 생성
		groupDAO.createGroup(groupDTO);
	}
	
	@Override
	public void createMember(List<MemberDTO> memberList) throws Exception {
		// 스터디 그룹원 생성
		groupDAO.createMember(memberList);
	}
	
	@Override
	public List<GroupVO> myGroupList(String userId) throws Exception {
		// 나의 스터디 그룹 리스트 조회
		return groupDAO.myGroupList(userId);
	}
	
	@Override
	public List<GroupMemberCountVO> myGroupMemeberCount(String userId) throws Exception {
		// 나의 스터디 그룹 멤버 수 조회
		return groupDAO.myGroupMemeberCountList(userId);
	}
	
	@Override
	public GroupVO readGroupInfo(int groupNo) throws Exception {
		// 스터디 그룹 정보 조회
		return groupDAO.readGroupInfo(groupNo);
	}
	
	@Override
	public List<MemberVO> readGroupMemberList(int groupNo) throws Exception {
		// 스터디 그룹 멤버 리스트 조회
		return groupDAO.readGroupMemberList(groupNo);
	}
	
	@Override
	public UserVO readLeaderInfo(String leaderId) throws Exception {
		// 스터디 그룹 리더 정보 조회
		return groupDAO.readLeaderInfo(leaderId);
	}
}
