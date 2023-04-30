package com.studywithme.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.studywithme.domain.UserDTO;
import com.studywithme.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.studywithme.mappers.userMapper";
	
	@Override
	public void signupUser(UserDTO dto) throws Exception {
		// 회원가입 메서드
		sqlSession.insert(namespace + ".signupUser", dto);
	}
	
	@Override
	public UserVO readUser(String userid) throws Exception {
		// 유저 정보 불러오는 메서드
		return (UserVO)sqlSession.selectOne(namespace + ".readUser", userid);
	}
}
