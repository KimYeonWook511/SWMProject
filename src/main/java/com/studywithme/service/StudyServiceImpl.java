package com.studywithme.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;
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
}
