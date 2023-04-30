package com.studywithme.user.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.UserDTO;
import com.studywithme.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SignupUserTest {
	
	@Inject
	private UserDAO userDAO;
	
	@Test
	public void signupUserTest() {
		try {
			UserDTO dto = new UserDTO();
			dto.setUserid("abcd1234");
			dto.setUserpw("abcd1234pw");
			dto.setUsername("7주차테스트");
			dto.setAddress("7주차주소테스트");
			dto.setUsergender("남자");
			dto.setCallnumber("01077777777");
			userDAO.signupUser(dto);
			
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
}
