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
	
	@Override
	public void applyStudy(ApplyDTO dto) throws Exception {
		// ���͵� ����
		studyDAO.applyStudy(dto);
	}
	
	@Override
	public ApplyVO readApply(int applyNo) throws Exception {
		// ���͵� ������ ��ȸ
		return studyDAO.readApply(applyNo);
	}
	
	@Override
	public List<StudyVO> myListStudy(String studyWriter) throws Exception {
		// ���� ���͵� ����Ʈ ��ȸ
		return studyDAO.myListStudy(studyWriter);
	}
	
	@Override
	public List<ApplyCountVO> myListStudyCountApply(String studyWriter) throws Exception {
		// ���� ���͵� ����Ʈ ������ �� ��ȸ
		return studyDAO.myListStudyCountApply(studyWriter);
	}
	
	@Override
	public List<ApplyVO> myStudyApplyList(int studyNo) throws Exception {
		// ���� ���͵� ������ ����Ʈ ��ȸ
		return studyDAO.myStudyApplyList(studyNo);
	}
	
	@Override
	public List<UserVO> myStudyApplyUserList(int studyNo) throws Exception {
		// ���� ���͵� ������ ���� ����Ʈ ��ȸ
		return studyDAO.myStudyApplyUserList(studyNo);
	}
	
	@Override
	public ApplyVO applyCheck(ApplyDTO applyDTO) throws Exception {
		// ���͵� ���� �̷� ��ȸ
		return studyDAO.applyCheck(applyDTO);
	}
	
	@Override
	public void applyPass(int applyNo) throws Exception {
		// ���͵� ������ ���(�հ�)
		studyDAO.applyPass(applyNo);
	}
	
	@Override
	public void applyFail(int applyNo) throws Exception {
		// ���͵� ������ Ż��(���հ�)
		studyDAO.applyFail(applyNo);
	}
	
	@Override
	public ApplyAccessVO applyAccess(int applyNo) throws Exception {
		// ���͵� ������ ���� ȸ�� ��ȸ
		return studyDAO.applyAccess(applyNo);
	}
	
	@Override
	public void applyDelete(int applyNo) throws Exception {
		// ���͵� ������ ����
		studyDAO.applyDelete(applyNo);
	}
	
	@Override
	public List<ApplyVO> myListApply(String applyWriter) throws Exception {
		// ���� ������ ����Ʈ ��ȸ
		return studyDAO.myListApply(applyWriter);
	}
	
	@Override
	public List<StudyVO> myApplyStudyList(String applyWriter) throws Exception {
		// ������ ���͵� ���� ��ȸ
		return studyDAO.myApplyStudyList(applyWriter);
	}
	
	@Override
	public void deleteStudyApply(int studyNo) throws Exception {
		// ���͵� ���� ������ ���������� ����
		studyDAO.deleteStudyApply(studyNo);
	}
	
	@Override
	public List<UserVO> passMemberList(int studyNo) throws Exception {
		// �հ��� ����(���) ���� ����Ʈ
		return studyDAO.passMemberList(studyNo);
	}
}
