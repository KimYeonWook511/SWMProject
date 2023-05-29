package com.studywithme.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.studywithme.domain.UserVO;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		logger.info("LoginCheck preHandle ����");
		
//		String requestURI = request.getRequestURI();
		
		UserVO vo = (UserVO)request.getSession().getAttribute("loginVO");			
		
		if (vo == null) {
			// �α��� ���� ����
			logger.info("�α��� ���°� �ƴ�");
			
			request.setAttribute("msg", 1);
//			request.setAttribute("redirectURL", requestURI);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login");
			dispatcher.forward(request, response);
			
			return false;
		}
		
		// �α��� ����
		return true;
	}
	
}
