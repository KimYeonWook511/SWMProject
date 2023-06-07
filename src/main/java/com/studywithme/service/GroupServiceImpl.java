package com.studywithme.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.GroupDTO;
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
	public void createMember(List<UserVO> userList) throws Exception {
		// 스터디 그룹원 생성
		groupDAO.createMember(userList);
	}
}
