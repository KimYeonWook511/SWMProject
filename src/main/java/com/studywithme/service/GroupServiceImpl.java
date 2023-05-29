package com.studywithme.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.GroupDTO;
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
}
