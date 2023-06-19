package com.studywithme.group.test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.GroupVO;
import com.studywithme.persistence.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyGroupListTest {
	
	@Inject
	private GroupDAO dao;
	
	@Test
	public void myGroupListTest() {
		try {
			String userId = "test";
			List<GroupVO> list = dao.myGroupList(userId);
			List<GroupVO> listL = new ArrayList<GroupVO>(); // userId가 Leader인 그룹
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getGroupLeader().equals(userId)) listL.add(list.remove(i--));
			}
			
			System.out.println("----------유저가 리더인 리스트");
			for (GroupVO vo : listL) {
				System.out.println(vo.toString());
			}
			
			System.out.println("----------유저가 멤버인 리스트");
			for (GroupVO vo : list) {
				System.out.println(vo.toString());
			}
			
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
}
