package com.studywithme.persistence;

import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;

public interface StudyDAO {
	
	public void createStudy(StudyDTO dto) throws Exception;
	public StudyVO readStudy(int studyNo) throws Exception;
}
