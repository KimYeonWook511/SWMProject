package com.studywithme.group.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.persistence.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReadLeaderInfoTest {
	
	@Inject
	private GroupDAO dao;
	
	@Test
	public void readLeaderInfoTest() {
		try {
			String leaderId = "test";
			
			System.out.println(dao.readLeaderInfo(leaderId));
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
