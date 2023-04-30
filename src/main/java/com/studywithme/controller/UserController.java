package com.studywithme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studywithme.domain.UserDTO;
import com.studywithme.domain.UserVO;
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
	public String signupPOST(@RequestParam String confirmUserPassword, @ModelAttribute UserDTO dto,
								RedirectAttributes rttr, HttpServletRequest request) {
		logger.info("signupPOST ����");
		
		if (dto.getUserId().isEmpty()) {
			logger.info("���̵� �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_userId");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserPassword().isEmpty()) {
			logger.info("��й�ȣ �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_userPassword");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserId().isEmpty()) {
			logger.info("�̸� �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_userName");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserCallNumber().isEmpty()) {
			logger.info("��ȭ��ȣ �Է¶� ����");
			rttr.addFlashAttribute("signupResult", "empty_userCallNumber");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		if (!confirmUserPassword.equals(dto.getUserPassword())) {
			logger.info("��й�ȣ ����ġ");
			rttr.addFlashAttribute("signupResult", "fail_password");
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
		
		try {
			// ���ǻ���
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", userService.readUser(dto.getUserId()));
			rttr.addFlashAttribute("joinResult", "success");
			
		} catch (Exception e) {
			// ���� ���� ����
			rttr.addFlashAttribute("joinResult", "session_fail");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("loginGET ����");
	}
	
	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public String loginPOST(@ModelAttribute UserDTO dto, Model model) throws Exception {
		logger.info("loginPOST ����");
		
		UserVO vo = userService.loginUser(dto); 
		
		if (vo == null) {
			// ���̵� �������� ������
			model.addAttribute("loginResult", -2);
			return "/user/login";
			
		} else if (!vo.getUserPassword().equals(dto.getUserPassword())) {
			// ��й�ȣ ����ġ
			model.addAttribute("loginResult", -1);
			model.addAttribute("userid", dto.getUserId());
			return "/user/login";
			
		} else {
			// �α��� ����
			model.addAttribute("loginResult", 1);
			model.addAttribute("loginVO", vo);
			return "/main";
		}
	}
}
