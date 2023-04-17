package com.studywithme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studywithme.domain.UserDTO;
import com.studywithme.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void signupGET() {
		logger.info("signupGET ����");
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPOST(@RequestParam String confirmuserpw, @ModelAttribute UserDTO dto,
								RedirectAttributes rttr, HttpServletRequest request) {
		logger.info("signupPOST ����");
		
		if (dto.getUserid().isEmpty()) {
			logger.info("���̵� �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_userid");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserpw().isEmpty()) {
			logger.info("��й�ȣ �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_userpw");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserid().isEmpty()) {
			logger.info("�̸� �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_username");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserid().isEmpty()) {
			logger.info("��ȭ��ȣ �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_callnumber");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		if (!confirmuserpw.equals(dto.getUserpw())) {
			logger.info("��й�ȣ ����ġ");
			rttr.addFlashAttribute("signResult", "fail_pw");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		try {
			// ȸ������ ����
			userService.signupUser(dto);
			
		} catch (Exception e){
			// ���̵� �ߺ�
			rttr.addFlashAttribute("joinResult", "fail_id");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		return "redirect:/";
	}
}
