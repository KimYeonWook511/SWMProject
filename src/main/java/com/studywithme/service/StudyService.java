package com.studywithme.service;

import java.util.List;

import com.studywithme.domain.ApplyCountVO;
import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;
import com.studywithme.domain.UserVO;

public interface StudyService {
	
	public void createStudy(StudyDTO dto) throws Exception;
	public StudyVO readStudy(int studyNo) throws Exception;
	public List<StudyVO> listStudy() throws Exception;
	public void deleteStudy(int studyNo) throws Exception;
	public void updateStudy(StudyDTO dto) throws Exception;
	public void viewCountStudy(int studyNo) throws Exception;
	public void applyStudy(ApplyDTO dto) throws Exception;
	public ApplyVO readApply(int applyNo) throws Exception;
	public List<StudyVO> myListStudy(String studyWriter) throws Exception;
	public List<ApplyCountVO> myListStudyCountApply(String studyWriter) throws Exception;
	public List<ApplyVO> myStudyApplyList(int studyNo) throws Exception;
	public List<UserVO> myStudyApplyUserList(int studyNo) throws Exception;
}
