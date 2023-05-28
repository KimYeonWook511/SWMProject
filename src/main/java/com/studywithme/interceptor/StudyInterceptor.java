package com.studywithme.interceptor;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.studywithme.domain.StudyVO;
import com.studywithme.domain.UserVO;
import com.studywithme.service.StudyService;

public class StudyInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(StudyInterceptor.class);
	
	@Inject
	private StudyService studyService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		logger.info("Study preHandle ����");
		
		HttpSession session = request.getSession();			
		UserVO loginVO = (UserVO)session.getAttribute("loginVO");
		int studyNo = Integer.parseInt(request.getParameter("studyNo"));
		
		if (loginVO.getUserAuthority().equals("member")) {
			// ȸ�� �α���
			if (loginVO.getUserId().equals(((StudyVO)studyService.readStudy(studyNo)).getStudyWriter()))
				return true;
			
		} else if (loginVO.getUserAuthority().equals("admin")) {
			// ������ �α���
			return true;
			
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('������ ���� �����Դϴ�.'); location.href='/';</script>");
		out.flush();
		out.close();
		
		return false;
	}
	
}
