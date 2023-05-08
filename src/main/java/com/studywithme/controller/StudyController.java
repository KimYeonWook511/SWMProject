package com.studywithme.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.StudyVO;
import com.studywithme.domain.UserVO;
import com.studywithme.service.StudyService;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private StudyService studyService;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writeGET() {
		logger.info("writeGET ����");
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(@ModelAttribute StudyDTO dto, RedirectAttributes rttr, HttpServletRequest request) {
		logger.info("writePOST ����");
		
		// HttpServletRequest���� getSession�� �ٷ� HttpSession���� session�޾ƿ��� ���� ���� �˾ƺ���
		HttpSession session = request.getSession();
		dto.setStudyWriter(((UserVO)session.getAttribute("loginVO")).getUserId());
		
		try {
			studyService.createStudy(dto);
			rttr.addFlashAttribute("message", "���͵� �������� ��ϵǾ����ϴ�.");
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// ���͵� ���� ����� ����
			logger.info("createStudy�� ����");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void viewGET(int studyNo, Model model) {
		logger.info("viewGET ����");
		
		try {
			StudyVO studyVO = studyService.readStudy(studyNo);
			
			model.addAttribute("studyVO", studyVO);
			
		} catch (Exception e) {
			logger.info("viewGET�� ����");
			// model�� �������� ��� �ش� jsp���� �ּ��̵��ϱ�?
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model) {
		logger.info("listGET ����");
		
		try {
			List<StudyVO> studyList = studyService.listStudy();
			
			model.addAttribute("studyList", studyList);
			
		} catch (Exception e) {
			logger.info("listStudy�� ����");
			// ����
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(int studyNo, RedirectAttributes rttr) {
		logger.info("deletePOST ����");
		
		try {
			studyService.deleteStudy(studyNo);
			logger.info("������ ���͵� ��ȣ : " + studyNo);
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// ���͵� ���� ������ ����
			logger.info("deleteStudy�� ����");
			return "redirect:/������������";
		}
	}
}
