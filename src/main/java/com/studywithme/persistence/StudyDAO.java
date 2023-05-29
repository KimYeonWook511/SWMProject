package com.studywithme.persistence;

import java.util.List;

import com.studywithme.domain.ApplyAccessVO;
import com.studywithme.domain.ApplyCountVO;
import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;
import com.studywithme.domain.UserVO;

public interface StudyDAO {
	
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
	public ApplyVO applyCheck(ApplyDTO applyDTO) throws Exception;
	public void applyPass(int applyNo) throws Exception;
	public void applyFail(int applyNo) throws Exception;
	public ApplyAccessVO applyAccess(int applyNo) throws Exception;
	public void applyDelete(int applyNo) throws Exception;
	public List<ApplyVO> myListApply(String applyWriter) throws Exception;
	public List<StudyVO> myApplyStudyList(String applyWriter) throws Exception;
	public void deleteStudyApply(int studyNo) throws Exception;
	public List<UserVO> passMemberList(int studyNo) throws Exception;
}
