package com.studywithme.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.studywithme.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.swmproject.mappers.userMapper";
	
	@Override
	public void signupUser(UserDTO dto) throws Exception {
		// 회원가입 메서드
		sqlSession.insert(namespace + ".signupUser", dto);
	}
}
