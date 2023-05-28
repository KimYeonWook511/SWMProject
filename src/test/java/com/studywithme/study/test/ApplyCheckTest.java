package com.studywithme.study.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.ApplyDTO;
import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ApplyCheckTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void applyCheckTest() {
		try {
			ApplyDTO dto = new ApplyDTO();
			dto.setStudyNo(5);
			dto.setApplyWriter("test");
			System.out.println(dao.applyCheck(dto));
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
