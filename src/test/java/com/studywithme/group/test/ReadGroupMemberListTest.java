package com.studywithme.group.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.MemberVO;
import com.studywithme.persistence.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReadGroupMemberListTest {
	
	@Inject
	private GroupDAO dao;
	
	@Test
	public void readGrouprMemberListTest() {
		try {
			int groupNo = 9;
			List<MemberVO> list = dao.readGroupMemberList(groupNo);
			
			for (MemberVO vo : list) {
				System.out.println(vo.toString());
			}
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
