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
		logger.info("signupGET 실행");
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPOST(@RequestParam String confirmuserpw, @ModelAttribute UserDTO dto,
								RedirectAttributes rttr, HttpServletRequest request) {
		logger.info("signupPOST 실행");
		
		if (dto.getUserid().isEmpty()) {
			logger.info("아이디 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_userid");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserpw().isEmpty()) {
			logger.info("비밀번호 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_userpw");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserid().isEmpty()) {
			logger.info("이름 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_username");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserid().isEmpty()) {
			logger.info("전화번호 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_callnumber");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		if (!confirmuserpw.equals(dto.getUserpw())) {
			logger.info("비밀번호 불일치");
			rttr.addFlashAttribute("signupResult", "fail_pw");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		try {
			// 회원가입 성공
			userService.signupUser(dto);
			
		} catch (Exception e){
			// 아이디 중복
			rttr.addFlashAttribute("joinResult", "fail_id");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		try {
			// 세션생성
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", userService.readUser(dto.getUserid()));
			rttr.addFlashAttribute("joinResult", "success");
			
		} catch (Exception e) {
			// 세션 생성 오류
			rttr.addFlashAttribute("joinResult", "session_fail");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("loginGET 실행");
	}
	
	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public String loginPOST(@ModelAttribute UserDTO dto, Model model) throws Exception {
		logger.info("loginPOST 실행");
		
		UserVO vo = userService.loginUser(dto); 
		
		if (vo == null) {
			// 아이디가 존재하지 않을때
			model.addAttribute("loginResult", -2);
			return "/user/login";
			
		} else if (!vo.getUserpw().equals(dto.getUserpw())) {
			// 비밀번호 불일치
			model.addAttribute("loginResult", -1);
			model.addAttribute("userid", dto.getUserid());
			return "/user/login";
			
		} else {
			// 로그인 성공
			model.addAttribute("loginResult", 1);
			model.addAttribute("loginVO", vo);
			return "/main";
		}
	}
}
