package com.studywithme.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

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
		// 스터디 공고 등록
		sqlSession.insert(NAMESPACE + ".createStudy", dto);
	}
	
	@Override
	public StudyVO readStudy(int studyNo) throws Exception {
		// 스터디 공고 내용 조회
		return (StudyVO)sqlSession.selectOne(NAMESPACE + ".readStudy", studyNo);
	}
	
	@Override
	public List<StudyVO> listStudy() throws Exception {
		// 스터디 공고 조회 (리스트)
		return sqlSession.selectList(NAMESPACE + ".listStudy");
	}
	
	@Override
	public void deleteStudy(int studyNo) throws Exception {
		// 스터디 공고 삭제
		sqlSession.delete(NAMESPACE + ".deleteStudy", studyNo);
	}
	
	@Override
	public void updateStudy(StudyDTO dto) throws Exception {
		// 스터디 공고 수정
		sqlSession.update(NAMESPACE + ".updateStudy", dto);
	}
	
	@Override
	public void viewCountStudy(int studyNo) throws Exception {
		// 스터디 조회수 증가
		sqlSession.update(NAMESPACE + ".viewCountStudy", studyNo);
	}
}
