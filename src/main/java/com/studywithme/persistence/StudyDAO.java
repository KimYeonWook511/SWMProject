package com.studywithme.persistence;

import java.util.List;

import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;

public interface StudyDAO {
	
	public void createStudy(StudyDTO dto) throws Exception;
	public StudyVO readStudy(int studyNo) throws Exception;
	public List<StudyVO> listStudy() throws Exception; 
	public void deleteStudy(int studyNo) throws Exception;
	public void updateStudy(StudyDTO dto) throws Exception;
	public void viewCountStudy(int studyNo) throws Exception;
	public void applyStudy(ApplyDTO dto) throws Exception;
}
