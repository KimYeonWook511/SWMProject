package com.studywithme.study.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ViewCountStudyTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void viewCountStudyTest() {
		try {
			System.out.println(dao.readStudy(4).getStudyViewCount());
			dao.viewCountStudy(4);
			System.out.println(dao.readStudy(4).getStudyViewCount());
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
