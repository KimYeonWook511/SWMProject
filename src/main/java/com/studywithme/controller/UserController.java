package com.studywithme.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	public String signupPOST(@RequestParam String confirmUserPassword, @ModelAttribute UserDTO dto,
								RedirectAttributes rttr, HttpServletRequest request) {
		logger.info("signupPOST 실행");
		
		if (dto.getUserId().isEmpty()) {
			logger.info("아이디 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_userId");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserPassword().isEmpty()) {
			logger.info("비밀번호 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_userPassword");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserId().isEmpty()) {
			logger.info("이름 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_userName");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
			
		} else if (dto.getUserCallNumber().isEmpty()) {
			logger.info("전화번호 입력란 공백");
			rttr.addFlashAttribute("signupResult", "empty_userCallNumber");
			rttr.addFlashAttribute("dto", dto);
			return "redirect:/user/signup";
		}
		
		if (!confirmUserPassword.equals(dto.getUserPassword())) {
			logger.info("비밀번호 불일치");
			rttr.addFlashAttribute("signupResult", "fail_password");
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
			session.setAttribute("loginVO", userService.readUser(dto.getUserId()));
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
	public String loginPOST(@ModelAttribute UserDTO dto, RedirectAttributes rttr, HttpSession session, 
			String redirectURL, String studyNo, String applyNo) throws Exception {
		logger.info("loginPOST 실행");
		
		UserVO vo = userService.loginUser(dto); 
		
		if (vo == null) {
			// 아이디가 존재하지 않을때
			rttr.addFlashAttribute("loginResult", -2);
			rttr.addFlashAttribute("redirectURL", redirectURL);
			return "redirect:/user/login";
			
		} else if (!vo.getUserPassword().equals(dto.getUserPassword())) {
			// 비밀번호 불일치
			rttr.addFlashAttribute("loginResult", -1);
			rttr.addFlashAttribute("redirectURL", redirectURL);
			rttr.addFlashAttribute("userId", dto.getUserId());
			return "redirect:/user/login";
			
		} else {
			// 로그인 성공
			session.setAttribute("loginVO", vo);
			
			rttr.addFlashAttribute("loginResult", 1);
			return "redirect:/";
			
//			if (redirectURL.equals("")) {
//				// 메인 화면으로 리다이렉트
//				rttr.addFlashAttribute("loginResult", 1);
//				return "redirect:/";
//				
//			} else {
//				 이전 주소로 리다이렉트
//				return "redirect:" + redirectURL;
//			}
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request, RedirectAttributes rttr) {
		logger.info("logoutGET 실행");
		
		UserVO vo = (UserVO)request.getSession().getAttribute("loginVO");
		int result = 1;
		
		if (vo == null) {
			// 현재 로그인 상태가 아님
			result = -1;
			
		} else {
			// 로그아웃
			request.getSession().invalidate();
			result = 1;
		}
		
		rttr.addFlashAttribute("logoutResult", result);
		return "redirect:/";
	}
}
