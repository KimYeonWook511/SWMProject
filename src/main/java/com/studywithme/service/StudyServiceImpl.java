package com.studywithme.service;

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
		// ���͵� ���� ���
		studyDAO.createStudy(dto);
	}
	
	@Override
	public StudyVO readStudy(int studyNo) throws Exception {
		// ���͵� ���� ��ȸ
		return studyDAO.readStudy(studyNo);
	}
}
