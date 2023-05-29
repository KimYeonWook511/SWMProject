package com.studywithme.group.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.GroupDTO;
import com.studywithme.persistence.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CreateGroupTest {
	
	@Inject
	private GroupDAO dao;
	
	@Test
	public void createGroupTest() {
		try {
			GroupDTO dto = new GroupDTO();
			dto.setGroupName("그룹명 테스트");
			dto.setGroupLeader("test");
			dto.setGroupExplain("그룹설명 테스트");
			dao.createGroup(dto);
			
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
}
