package com.studywithme.group.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.GroupMemberCountVO;
import com.studywithme.persistence.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyGroupMemberCountListTest {
	
	@Inject
	private GroupDAO dao;
	
	@Test
	public void myGroupMemberCountListTest() {
		try {
			String userId = "test1";
			List<GroupMemberCountVO> list = dao.myGroupMemeberCountList(userId);
					
			for (GroupMemberCountVO vo : list) {
				System.out.println(vo.toString());
			}
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
