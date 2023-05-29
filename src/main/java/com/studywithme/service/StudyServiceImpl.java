package com.studywithme.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.ApplyAccessVO;
import com.studywithme.domain.ApplyCountVO;
import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;
import com.studywithme.domain.UserVO;
import com.studywithme.persistence.StudyDAO;

@Service
public class StudyServiceImpl implements StudyService {
	
	@Inject
	private StudyDAO studyDAO;
	
	@Override
	public void createStudy(StudyDTO dto) throws Exception {
		// 스터디 공고 등록
		studyDAO.createStudy(dto);
	}
	
	@Override
	public StudyVO readStudy(int studyNo) throws Exception {
		// 스터디 내용 조회
		return studyDAO.readStudy(studyNo);
	}
	
	@Override
	public List<StudyVO> listStudy() throws Exception {
		// 스터디 공고 조회 (리스트)
		return studyDAO.listStudy();
	}
	
	@Override
	public void deleteStudy(int studyNo) throws Exception {
		// 스터디 공고 삭제
		studyDAO.deleteStudy(studyNo);
	}
	
	@Override
	public void updateStudy(StudyDTO dto) throws Exception {
		// 스터디 공고 수정
		studyDAO.updateStudy(dto);
	}
	
	@Override
	public void viewCountStudy(int studyNo) throws Exception {
		// 스터디 조회수 증가
		studyDAO.viewCountStudy(studyNo);
	}
	
	@Override
	public void applyStudy(ApplyDTO dto) throws Exception {
		// 스터디 지원
		studyDAO.applyStudy(dto);
	}
	
	@Override
	public ApplyVO readApply(int applyNo) throws Exception {
		// 스터디 지원서 조회
		return studyDAO.readApply(applyNo);
	}
	
	@Override
	public List<StudyVO> myListStudy(String studyWriter) throws Exception {
		// 나의 스터디 리스트 조회
		return studyDAO.myListStudy(studyWriter);
	}
	
	@Override
	public List<ApplyCountVO> myListStudyCountApply(String studyWriter) throws Exception {
		// 나의 스터디 리스트 지원자 수 조회
		return studyDAO.myListStudyCountApply(studyWriter);
	}
	
	@Override
	public List<ApplyVO> myStudyApplyList(int studyNo) throws Exception {
		// 나의 스터디 지원자 리스트 조회
		return studyDAO.myStudyApplyList(studyNo);
	}
	
	@Override
	public List<UserVO> myStudyApplyUserList(int studyNo) throws Exception {
		// 나의 스터디 지원자 정보 리스트 조회
		return studyDAO.myStudyApplyUserList(studyNo);
	}
	
	@Override
	public ApplyVO applyCheck(ApplyDTO applyDTO) throws Exception {
		// 스터디 지원 이력 조회
		return studyDAO.applyCheck(applyDTO);
	}
	
	@Override
	public void applyPass(int applyNo) throws Exception {
		// 스터디 지원서 통과(합격)
		studyDAO.applyPass(applyNo);
	}
	
	@Override
	public void applyFail(int applyNo) throws Exception {
		// 스터디 지원서 탈락(불합격)
		studyDAO.applyFail(applyNo);
	}
	
	@Override
	public ApplyAccessVO applyAccess(int applyNo) throws Exception {
		// 스터디 지원서 접근 회원 조회
		return studyDAO.applyAccess(applyNo);
	}
	
	@Override
	public void applyDelete(int applyNo) throws Exception {
		// 스터디 지원서 삭제
		studyDAO.applyDelete(applyNo);
	}
	
	@Override
	public List<ApplyVO> myListApply(String applyWriter) throws Exception {
		// 나의 지원서 리스트 조회
		return studyDAO.myListApply(applyWriter);
	}
	
	@Override
	public List<StudyVO> myApplyStudyList(String applyWriter) throws Exception {
		// 지원한 스터디 정보 조회
		return studyDAO.myApplyStudyList(applyWriter);
	}
	
	@Override
	public void deleteStudyApply(int studyNo) throws Exception {
		// 스터디 공고 삭제시 지원서까지 삭제
		studyDAO.deleteStudyApply(studyNo);
	}
	
	@Override
	public List<UserVO> passMemberList(int studyNo) throws Exception {
		// 합격자 유저(멤버) 정보 리스트
		return studyDAO.passMemberList(studyNo);
	}
}
