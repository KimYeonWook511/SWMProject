package com.studywithme.group.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.persistence.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReadGroupInfoTest {
	
	@Inject
	private GroupDAO dao;
	
	@Test
	public void readGroupInfoTest() {
		try {
			int groupNo = 4;
			
			System.out.println(dao.readGroupInfo(groupNo));
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
