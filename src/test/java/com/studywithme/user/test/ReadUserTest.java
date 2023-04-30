package com.studywithme.user.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReadUserTest {
	
	@Inject
	private UserDAO userDAO;
	
	@Test
	public void readUserTest() {
		try {
			System.out.println(userDAO.readUser("test1"));
			
		} catch (Exception e) {
			System.out.println("½ÇÆÐ");
		}
	}
}
