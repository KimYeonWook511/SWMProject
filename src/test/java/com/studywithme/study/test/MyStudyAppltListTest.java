package com.studywithme.study.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.ApplyVO;
import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyStudyAppltListTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void applyStudyTest() {
		try {
			List<ApplyVO> list = dao.myStudyApplyList(4);
			
			for (ApplyVO vo : list) {
				System.out.println(vo.toString());
			}
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
