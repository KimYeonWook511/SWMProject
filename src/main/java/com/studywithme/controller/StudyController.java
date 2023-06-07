package com.studywithme.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studywithme.domain.ApplyAccessVO;
import com.studywithme.domain.ApplyCountVO;
import com.studywithme.domain.ApplyDTO;
import com.studywithme.domain.ApplyVO;
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
	public void viewGET(int studyNo, HttpServletRequest request, Model model) {
		logger.info("viewGET ����");
		
		try {
			UserVO vo = (UserVO)request.getSession().getAttribute("loginVO");
			
			if (vo != null && !vo.getUserId().equals(studyService.readStudy(studyNo).getStudyWriter())) 
				studyService.viewCountStudy(studyNo);
			
			StudyVO studyVO = studyService.readStudy(studyNo);
			
			model.addAttribute("studyVO", studyVO);
			
//			// ��Ű�� Ȱ���� ��ȸ��
//			Cookie cookies[] = request.getCookies();
//			
//			if (cookies == null) {
//				// ��� �������� ����
//				Cookie cookie = new Cookie("viewStudyNo", "[" + studyNo + "]");
//				cookie.setMaxAge(60 * 60 * 2); // ��Ű �ð�
//				response.addCookie(cookie);
//				
//				studyService.viewCountStudy(studyNo);
//				
//			} else {
//				for (Cookie cookie : cookies) {
//					System.out.println(cookie.getValue());
//					if (cookie.getName().equals("viewStudyNo") && !cookie.getValue().contains("[" + studyNo + "]")) {
//						// ���͵� ��ȸ�� ���� ����
//						cookie.setValue(cookie.getValue() + "_[" + studyNo + "]");
//						cookie.setMaxAge(60 * 60 * 2); // ��Ű �ð�
//						response.addCookie(cookie);
//						
//						studyService.viewCountStudy(studyNo);
//					}
//				}
//			}
			
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
			studyService.deleteStudyApply(studyNo);
			
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// ���͵� ���� ������ ����
			logger.info("deleteStudy�� ����");
			return "redirect:/������������";
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int studyNo, Model model) {
		logger.info("modifyGET ����");
		
		try {
			model.addAttribute("studyVO", studyService.readStudy(studyNo));
			
		} catch (Exception e) {
			// ���͵� ���� ���� ��ȸ �� ����
			logger.info("readStudy�� ����");
			//ó��
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(StudyDTO dto, RedirectAttributes rttr) {
		logger.info("modifyPOST ����");
		
		try {
			studyService.updateStudy(dto);
			
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// ���͵� ���� ���� �� ����
			logger.info("updateStudy ����");
			
			return "redirect:/������������";
		}
	}
	
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public void applyPOST(int studyNo, Model model) {
		logger.info("applyPOST ����");
		
		model.addAttribute("studyNo", studyNo);
	}
	
	@RequestMapping(value = "/apply.do", method = RequestMethod.POST)
	public void applyDoPOST(ApplyDTO dto, HttpServletRequest request, HttpServletResponse response) {
		logger.info("applyDoPOST ����");
		
		HttpSession session = request.getSession();
		dto.setApplyWriter(((UserVO)session.getAttribute("loginVO")).getUserId());
		
		try {
			studyService.applyStudy(dto);
			
		} catch (Exception e) {
			// ���͵� ���� �� ����
			logger.info("studyService ����");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();</script>");
			out.flush();
			
		} catch (Exception e) {
			// ��ũ��Ʈ ����
			logger.info("PrintWriter ����");
		}
	}
	
	@RequestMapping(value = "/myStudyList", method = RequestMethod.GET)
	public void myListGET(Model model, HttpSession session) {
		logger.info("myStudyListGET ����");
		
		String studyWriter = ((UserVO)session.getAttribute("loginVO")).getUserId();
		
		try {
			List<StudyVO> studyList = studyService.myListStudy(studyWriter);
			List<ApplyCountVO> applyCountList = studyService.myListStudyCountApply(studyWriter);
			Map<Integer, Integer> applyCountMap = new HashMap<Integer, Integer>(); 
			
			for (ApplyCountVO vo : applyCountList) {
				applyCountMap.put(vo.getStudyNo(), vo.getApplyCount());
			}
			
			model.addAttribute("studyList", studyList);
			model.addAttribute("applyCountMap", applyCountMap);
			
		} catch (Exception e) {
			// myList���� ����
			logger.info("studyService myList���� ����");
		}
	}
	
	@RequestMapping(value = "/applyList", method = RequestMethod.GET)
	public void applyListGET(int studyNo, Model model, HttpSession session) {
		logger.info("applyListGET ����");
		
		try {
			List<ApplyVO> applyList = studyService.myStudyApplyList(studyNo);
			List<ApplyVO> applyPassList = new ArrayList<ApplyVO>();
			List<UserVO> userList = studyService.myStudyApplyUserList(studyNo);
			Map<String, UserVO> userMap = new HashMap<String, UserVO>();
			
			for (UserVO vo : userList) {
				userMap.put(vo.getUserId(), vo);
			}
			
			for (int i = 0; i < applyList.size(); i++) {
				if (applyList.get(i).getApplyState() == 1) applyPassList.add(applyList.remove(i--));
			}
			
			model.addAttribute("applyPassList", applyPassList);
			model.addAttribute("applyFailList", applyList);
			model.addAttribute("userMap", userMap);
			
		} catch (Exception e) {
			// applyList���� ����
			logger.info("studyService applyList���� ����");
		}
	}
	
	@RequestMapping(value = "/applyView", method = RequestMethod.GET)
	public void applyViewGET(int applyNo, Model model) {
		logger.info("applyViewGET ����");
		
		try {
			ApplyVO applyVO = studyService.readApply(applyNo);
			ApplyAccessVO applyAccessVO = studyService.applyAccess(applyNo);
			
			model.addAttribute("applyVO", applyVO);
			model.addAttribute("applyAccessVO", applyAccessVO);
			
		} catch (Exception e) {
			// readApply ����
			logger.info("readApply�� ����");
		}
	}
	
	@RequestMapping(value = "/applyPass", method = RequestMethod.POST)
	public void applyPassPOST(int applyNo, HttpServletResponse response) {
		logger.info("applyPassPOST ����");
		
		try {
			studyService.applyPass(applyNo);
			
		} catch (Exception e) {
			// ���͵� �հ� �� ����
			logger.info("applyPass ����");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();opener.parent.location.reload();</script>");
			out.flush();
			
		} catch (Exception e) {
			// ��ũ��Ʈ ����
			logger.info("PrintWriter ����");
		}
	}
	
	@RequestMapping(value = "/applyFail", method = RequestMethod.POST)
	public void applyFailPOST(int applyNo, HttpServletResponse response) {
		logger.info("applyPassPOST ����");
		
		try {
			studyService.applyFail(applyNo);
			
		} catch (Exception e) {
			// ���͵� ���հ� �� ����
			logger.info("applyFail ����");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();opener.parent.location.reload();</script>");
			out.flush();
			
		} catch (Exception e) {
			// ��ũ��Ʈ ����
			logger.info("PrintWriter ����");
		}
	}
	

	@RequestMapping(value = "/applyDelete", method = RequestMethod.POST)
	public void applyDeletePOST(int applyNo, HttpServletResponse response) {
		logger.info("applyDeletePOST ����");
		
		try {
			studyService.applyDelete(applyNo);
			
		} catch (Exception e) {
			// ���͵� ������ ���� �� ����
			logger.info("applyDelete ����");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();opener.parent.location.reload();</script>");
			out.flush();
			
		} catch (Exception e) {
			// ��ũ��Ʈ ����
			logger.info("PrintWriter ����");
		}
	}
	
	@RequestMapping(value = "/myApplyList", method = RequestMethod.GET)
	public void myApplyListGET(Model model, HttpSession session) {
		logger.info("myApplyListGET ����");
		
		String applyWriter = ((UserVO)session.getAttribute("loginVO")).getUserId();
		
		try {
			List<ApplyVO> applyList = studyService.myListApply(applyWriter);
			List<StudyVO> studyList = studyService.myApplyStudyList(applyWriter);
			Map<Integer, StudyVO> studyMap = new HashMap<Integer, StudyVO>();
			
			for (StudyVO vo : studyList) {
				studyMap.put(vo.getStudyNo(), vo);
			}
			
			model.addAttribute("applyList", applyList);
			model.addAttribute("studyMap", studyMap);
			
		} catch (Exception e) {
			// ���� ������ ����Ʈ ��ȸ ����
			logger.info("myApplyList �� ����");
		}
	}
}
