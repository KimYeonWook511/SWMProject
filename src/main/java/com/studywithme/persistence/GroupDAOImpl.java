package com.studywithme.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.GroupMemberCountVO;
import com.studywithme.domain.GroupVO;
import com.studywithme.domain.MemberDTO;

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
	public void createMember(List<MemberDTO> memberList) throws Exception {
		// ���͵� �׷�� ����
		for (MemberDTO dto : memberList) {
			sqlSession.insert(NAMESPACE + ".createMember", dto);
		}
	}
	
	@Override
	public List<GroupVO> myGroupList(String userId) throws Exception {
		// ���� ���͵� �׷� ����Ʈ ��ȸ
		return sqlSession.selectList(NAMESPACE + ".myGroupList", userId);
	}
	
	@Override
	public List<GroupMemberCountVO> myGroupMemeberCountList(String userId) throws Exception {
		// ���� ���͵� �׷� ��� �� ��ȸ
		return sqlSession.selectList(NAMESPACE + ".myGroupMemberCountList", userId);
	}
}
