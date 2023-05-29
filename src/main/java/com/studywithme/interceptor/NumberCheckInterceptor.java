package com.studywithme.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.studywithme.domain.StudyVO;

public class NumberCheckInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(NumberCheckInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("NumberCheck preHandle 실행");
		
		ModelMap modelMap = modelAndView.getModelMap();
		StudyVO studyVO = (StudyVO)modelMap.get("studyVO");
		
		if (studyVO == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('허용되지 않은 접근입니다.'); location.href='/';</script>");
			out.flush();
			out.close();
		}
	}
}
