package com.studywithme.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.UserVO;

@Repository
public class GroupDAOImpl implements GroupDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.studywithme.mappers.groupMapper";
	
	@Override
	public void createGroup(GroupDTO groupDTO) throws Exception {
		// ���͵� �׷� ����
		sqlSession.insert(NAMESPACE + ".createGroup", groupDTO);
	}
	
	@Override
	public void createMember(List<UserVO> userList) throws Exception {
		// ���͵� �׷�� ����
		for (UserVO vo : userList) {
			sqlSession.insert(NAMESPACE + ".createMember", vo);
		}
	}
}
