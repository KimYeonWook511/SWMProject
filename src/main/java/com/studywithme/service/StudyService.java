package com.studywithme.service;

import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;

public interface StudyService {
	
	public void createStudy(StudyDTO dto) throws Exception;
	public StudyVO readStudy(int studyNo) throws Exception;
}
