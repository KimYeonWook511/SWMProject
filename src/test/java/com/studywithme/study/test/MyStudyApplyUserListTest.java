package com.studywithme.study.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.UserVO;
import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyStudyApplyUserListTest {
	
	@Inject
	private StudyDAO dao;
	
	@Test
	public void myListStudyCountApplyTest() {
		try {
			List<UserVO> list = dao.myStudyApplyUserList(3);
			
			for (UserVO vo : list) {
				System.out.println(vo.toString());
			}
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
