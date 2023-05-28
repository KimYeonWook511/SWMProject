package com.studywithme.interceptor;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
import com.studywithme.domain.UserVO;
import com.studywithme.service.StudyService;

public class ApplyCheckInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplyCheckInterceptor.class);
	
	@Inject
	private StudyService studyService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		logger.info("ApplyCheck preHandle ����");
		
		UserVO loginVO = (UserVO)request.getSession().getAttribute("loginVO");			
		
		if (loginVO.getUserAuthority().equals("admin")) {
			// ������ �α���
			return true;
		}
		
		ApplyDTO applyDTO = new ApplyDTO();
		applyDTO.setStudyNo(Integer.parseInt(request.getParameter("studyNo")));
		applyDTO.setApplyWriter(loginVO.getUserId());
		ApplyVO applyVO = studyService.applyCheck(applyDTO);
		
		if (applyVO == null) {
			// �ش� ���͵� ������ ���� ���� ���� 
			return true;
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('������ ������ �����մϴ�.'); location.href='/study/applyView?applyNo=" + applyVO.getApplyNo() + "';</script>");
		out.flush();
		out.close();
		
		return false;
	}
	
}
