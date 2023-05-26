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
		// ���͵� ���� ���
		studyDAO.createStudy(dto);
	}
	
	@Override
	public StudyVO readStudy(int studyNo) throws Exception {
		// ���͵� ���� ��ȸ
		return studyDAO.readStudy(studyNo);
	}
	
	@Override
	public List<StudyVO> listStudy() throws Exception {
		// ���͵� ���� ��ȸ (����Ʈ)
		return studyDAO.listStudy();
	}
	
	@Override
	public void deleteStudy(int studyNo) throws Exception {
		// ���͵� ���� ����
		studyDAO.deleteStudy(studyNo);
	}
	
	@Override
	public void updateStudy(StudyDTO dto) throws Exception {
		// ���͵� ���� ����
		studyDAO.updateStudy(dto);
	}
	
	@Override
	public void viewCountStudy(int studyNo) throws Exception {
		// ���͵� ��ȸ�� ����
		studyDAO.viewCountStudy(studyNo);
	}
}
