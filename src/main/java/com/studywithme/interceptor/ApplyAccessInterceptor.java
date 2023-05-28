package com.studywithme.interceptor;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.studywithme.domain.ApplyAccessVO;
import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.UserVO;
import com.studywithme.service.StudyService;

public class ApplyAccessInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplyAccessInterceptor.class);
	
	@Inject
	private StudyService studyService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		logger.info("ApplyAccess preHandle 실행");
		
		UserVO loginVO = (UserVO)request.getSession().getAttribute("loginVO");			
		
		if (loginVO.getUserAuthority().equals("admin")) {
			// 관리자 로그인
			return true;
		}
		
		ApplyAccessVO applyAccessVO = studyService.applyAccess(Integer.parseInt(request.getParameter("applyNo")));
		String userId = loginVO.getUserId();
		
		if (userId.equals(applyAccessVO.getApplyWriter()) || userId.equals(applyAccessVO.getStudyWriter())) {
			// 스터디 지원서 접근 가능
			return true;
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('허용되지 않은 접근입니다.'); location.href='/';</script>");
		out.flush();
		out.close();
		
		return false;
	}
	
}
