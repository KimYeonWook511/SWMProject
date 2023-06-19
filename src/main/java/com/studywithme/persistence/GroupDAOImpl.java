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
		// 스터디 그룹 생성
		sqlSession.insert(NAMESPACE + ".createGroup", groupDTO);
	}
	
	@Override
	public void createMember(List<MemberDTO> memberList) throws Exception {
		// 스터디 그룹원 생성
		for (MemberDTO dto : memberList) {
			sqlSession.insert(NAMESPACE + ".createMember", dto);
		}
	}
	
	@Override
	public List<GroupVO> myGroupList(String userId) throws Exception {
		// 나의 스터디 그룹 리스트 조회
		return sqlSession.selectList(NAMESPACE + ".myGroupList", userId);
	}
	
	@Override
	public List<GroupMemberCountVO> myGroupMemeberCountList(String userId) throws Exception {
		// 나의 스터디 그룹 멤버 수 조회
		return sqlSession.selectList(NAMESPACE + ".myGroupMemberCountList", userId);
	}
}
