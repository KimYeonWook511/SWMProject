package com.studywithme.study.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.StudyDTO;
import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UpdateStudyTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void updateStudyTest() {
		try {
			StudyDTO dto = new StudyDTO();
			dto.setStudyNo(4);
			dto.setStudyTitle("수정 제목");
			dto.setStudyContent("수정 내용");
			dao.updateStudy(dto);
			
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
}
