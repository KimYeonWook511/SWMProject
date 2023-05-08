package com.studywithme.service;

import java.util.List;

import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;

public interface StudyService {
	
	public void createStudy(StudyDTO dto) throws Exception;
	public StudyVO readStudy(int studyNo) throws Exception;
	public List<StudyVO> listStudy() throws Exception;
	public void deleteStudy(int studyNo) throws Exception;
}
