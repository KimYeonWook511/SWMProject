package com.studywithme.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;

@Repository
public class StudyDAOImpl implements StudyDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.studywithme.mappers.studyMapper";
	
	@Override
	public void createStudy(StudyDTO dto) throws Exception {
		// ���͵� ���� ���
		sqlSession.insert(NAMESPACE + ".createStudy", dto);
	}
	
	@Override
	public StudyVO readStudy(int studyNo) throws Exception {
		// ���͵� ���� ���� ��ȸ
		return (StudyVO)sqlSession.selectOne(NAMESPACE + ".readStudy", studyNo);
	}
}
