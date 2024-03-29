package com.studywithme.study.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ListStudyTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void listStudyTest() {
		try {
			System.out.println(dao.listStudy());
			
		} catch (Exception e) {
			System.out.println("����");
		}
	}
}
