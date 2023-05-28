package com.studywithme.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
}
