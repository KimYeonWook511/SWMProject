package com.studywithme.study.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DeleteStudyApplyTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void deleteStudyApplyTest() {
		try {
			dao.deleteStudy(8);
			dao.deleteStudyApply(8);
			
		} catch (Exception e) {
			System.out.println("����");
		}
	}
}
