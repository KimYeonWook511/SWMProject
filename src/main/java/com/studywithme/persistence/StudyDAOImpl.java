package com.studywithme.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

import com.studywithme.domain.ApplyAccessVO;
import com.studywithme.domain.ApplyCountVO;
import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;
import com.studywithme.domain.UserVO;

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
	
	@Override
	public void applyStudy(ApplyDTO dto) throws Exception {
		// 스터디 지원
		sqlSession.insert(NAMESPACE + ".applyStudy", dto);
	}
	
	@Override
	public ApplyVO readApply(int applyNo) throws Exception {
		// 스터디 지원서 조회
		return (ApplyVO)sqlSession.selectOne(NAMESPACE + ".readApply", applyNo);
	}
	
	@Override
	public List<StudyVO> myListStudy(String studyWriter) throws Exception {
		// 나의 스터디 리스트 조회
		return sqlSession.selectList(NAMESPACE + ".myListStudy", studyWriter);
	}
	
	@Override
	public List<ApplyCountVO> myListStudyCountApply(String studyWriter) throws Exception {
		// 나의 스터디 리스트 지원자 수 조회
		return sqlSession.selectList(NAMESPACE + ".myListStudyCountApply", studyWriter);
	}
	
	@Override
	public List<ApplyVO> myStudyApplyList(int studyNo) throws Exception {
		// 나의 스터디 지원자 리스트 조회
		return sqlSession.selectList(NAMESPACE + ".myStudyApplyList", studyNo);
	}
	
	@Override
	public List<UserVO> myStudyApplyUserList(int studyNo) throws Exception {
		// 나의 스터디 지원자 정보 리스트 조회
		return sqlSession.selectList(NAMESPACE + ".myStudyApplyUserList", studyNo);
	}
	
	@Override
	public ApplyVO applyCheck(ApplyDTO applyDTO) throws Exception {
		// 스터디 지원 이력 조회
		return (ApplyVO)sqlSession.selectOne(NAMESPACE + ".applyCheck", applyDTO);
	}
	
	@Override
	public void applyPass(int applyNo) throws Exception {
		// 스터디 지원서 통과(합격)
		sqlSession.update(NAMESPACE + ".applyPass", applyNo);
	}
	
	@Override
	public void applyFail(int applyNo) throws Exception {
		// 스터디 지원서 탈락(불합격)
		sqlSession.update(NAMESPACE + ".applyFail", applyNo);
	}
	
	@Override
	public ApplyAccessVO applyAccess(int applyNo) throws Exception {
		// 스터디 지원서 접근 회원 조회
		return (ApplyAccessVO)sqlSession.selectOne(NAMESPACE + ".applyAccess", applyNo);
	}
	
	@Override
	public void applyDelete(int applyNo) throws Exception {
		// 스터디 지원서 삭제
		sqlSession.delete(NAMESPACE + ".applyDelete", applyNo);
	}
	
	@Override
	public List<ApplyVO> myListApply(String applyWriter) throws Exception {
		// 나의 지원서 리스트 조회
		return sqlSession.selectList(NAMESPACE + ".myListApply", applyWriter);
	}
	
	@Override
	public List<StudyVO> myApplyStudyList(String applyWriter) throws Exception {
		// 지원한 스터디 정보 조회 (리스트)
		return sqlSession.selectList(NAMESPACE + ".myApplyStudyList", applyWriter);
	}
	
	@Override
	public void deleteStudyApply(int studyNo) throws Exception {
		// 스터디 공고 삭제시 지원서까지 삭제
		sqlSession.delete(NAMESPACE + ".deleteStudyApply", studyNo);
	}
	
	@Override
	public List<UserVO> passMemberList(int studyNo) throws Exception {
		// 합격자 유저(멤버) 정보 리스트
		return sqlSession.selectList(NAMESPACE + ".passMemberList", studyNo);
	}
}
