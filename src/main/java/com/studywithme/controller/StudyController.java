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
		logger.info("writeGET 실행");
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(@ModelAttribute StudyDTO dto, RedirectAttributes rttr, HttpServletRequest request) {
		logger.info("writePOST 실행");
		
		// HttpServletRequest에서 getSession과 바로 HttpSession으로 session받아오는 것의 차이 알아보기
		HttpSession session = request.getSession();
		dto.setStudyWriter(((UserVO)session.getAttribute("loginVO")).getUserId());
		
		try {
			studyService.createStudy(dto);
			rttr.addFlashAttribute("message", "스터디 모집글이 등록되었습니다.");
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// 스터디 공고 등록중 오류
			logger.info("createStudy중 오류");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void viewGET(int studyNo, HttpServletRequest request, Model model) {
		logger.info("viewGET 실행");
		
		try {
			UserVO vo = (UserVO)request.getSession().getAttribute("loginVO");
			
			if (vo != null && !vo.getUserId().equals(studyService.readStudy(studyNo).getStudyWriter())) 
				studyService.viewCountStudy(studyNo);
			
			StudyVO studyVO = studyService.readStudy(studyNo);
			
			model.addAttribute("studyVO", studyVO);
			
//			// 쿠키를 활용한 조회수
//			Cookie cookies[] = request.getCookies();
//			
//			if (cookies == null) {
//				// 쿠기 존재하지 않음
//				Cookie cookie = new Cookie("viewStudyNo", "[" + studyNo + "]");
//				cookie.setMaxAge(60 * 60 * 2); // 쿠키 시간
//				response.addCookie(cookie);
//				
//				studyService.viewCountStudy(studyNo);
//				
//			} else {
//				for (Cookie cookie : cookies) {
//					System.out.println(cookie.getValue());
//					if (cookie.getName().equals("viewStudyNo") && !cookie.getValue().contains("[" + studyNo + "]")) {
//						// 스터디 조회한 내역 없음
//						cookie.setValue(cookie.getValue() + "_[" + studyNo + "]");
//						cookie.setMaxAge(60 * 60 * 2); // 쿠키 시간
//						response.addCookie(cookie);
//						
//						studyService.viewCountStudy(studyNo);
//					}
//				}
//			}
			
		} catch (Exception e) {
			logger.info("viewGET중 오류");
			// model에 오류내용 담고선 해당 jsp에서 주소이동하기?
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model) {
		logger.info("listGET 실행");
		
		try {
			List<StudyVO> studyList = studyService.listStudy();
			
			model.addAttribute("studyList", studyList);
			
		} catch (Exception e) {
			logger.info("listStudy중 오류");
			// 오류
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(int studyNo, RedirectAttributes rttr) {
		logger.info("deletePOST 실행");
		
		try {
			studyService.deleteStudy(studyNo);
			studyService.deleteStudyApply(studyNo);
			
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// 스터디 공고 삭제중 오류
			logger.info("deleteStudy중 오류");
			return "redirect:/오류페이지로";
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int studyNo, Model model) {
		logger.info("modifyGET 실행");
		
		try {
			model.addAttribute("studyVO", studyService.readStudy(studyNo));
			
		} catch (Exception e) {
			// 스터디 공고 내용 조회 중 오류
			logger.info("readStudy중 오류");
			//처리
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(StudyDTO dto, RedirectAttributes rttr) {
		logger.info("modifyPOST 실행");
		
		try {
			studyService.updateStudy(dto);
			
			return "redirect:/study/list";
			
		} catch (Exception e) {
			// 스터디 공고 수정 중 오류
			logger.info("updateStudy 오류");
			
			return "redirect:/오류페이지로";
		}
	}
	
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public void applyPOST(int studyNo, Model model) {
		logger.info("applyPOST 실행");
		
		model.addAttribute("studyNo", studyNo);
	}
	
	@RequestMapping(value = "/apply.do", method = RequestMethod.POST)
	public void applyDoPOST(ApplyDTO dto, HttpServletRequest request, HttpServletResponse response) {
		logger.info("applyDoPOST 실행");
		
		HttpSession session = request.getSession();
		dto.setApplyWriter(((UserVO)session.getAttribute("loginVO")).getUserId());
		
		try {
			studyService.applyStudy(dto);
			
		} catch (Exception e) {
			// 스터디 지원 중 오류
			logger.info("studyService 오류");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();</script>");
			out.flush();
			
		} catch (Exception e) {
			// 스크립트 오류
			logger.info("PrintWriter 오류");
		}
	}
	
	@RequestMapping(value = "/myStudyList", method = RequestMethod.GET)
	public void myListGET(Model model, HttpSession session) {
		logger.info("myStudyListGET 실행");
		
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
			// myList관련 오류
			logger.info("studyService myList관련 오류");
		}
	}
	
	@RequestMapping(value = "/applyList", method = RequestMethod.GET)
	public void applyListGET(int studyNo, Model model, HttpSession session) {
		logger.info("applyListGET 실행");
		
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
			// applyList관련 오류
			logger.info("studyService applyList관련 오류");
		}
	}
	
	@RequestMapping(value = "/applyView", method = RequestMethod.GET)
	public void applyViewGET(int applyNo, Model model) {
		logger.info("applyViewGET 실행");
		
		try {
			ApplyVO applyVO = studyService.readApply(applyNo);
			ApplyAccessVO applyAccessVO = studyService.applyAccess(applyNo);
			
			model.addAttribute("applyVO", applyVO);
			model.addAttribute("applyAccessVO", applyAccessVO);
			
		} catch (Exception e) {
			// readApply 오류
			logger.info("readApply중 오류");
		}
	}
	
	@RequestMapping(value = "/applyPass", method = RequestMethod.POST)
	public void applyPassPOST(int applyNo, HttpServletResponse response) {
		logger.info("applyPassPOST 실행");
		
		try {
			studyService.applyPass(applyNo);
			
		} catch (Exception e) {
			// 스터디 합격 중 오류
			logger.info("applyPass 오류");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();opener.parent.location.reload();</script>");
			out.flush();
			
		} catch (Exception e) {
			// 스크립트 오류
			logger.info("PrintWriter 오류");
		}
	}
	
	@RequestMapping(value = "/applyFail", method = RequestMethod.POST)
	public void applyFailPOST(int applyNo, HttpServletResponse response) {
		logger.info("applyPassPOST 실행");
		
		try {
			studyService.applyFail(applyNo);
			
		} catch (Exception e) {
			// 스터디 불합격 중 오류
			logger.info("applyFail 오류");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();opener.parent.location.reload();</script>");
			out.flush();
			
		} catch (Exception e) {
			// 스크립트 오류
			logger.info("PrintWriter 오류");
		}
	}
	

	@RequestMapping(value = "/applyDelete", method = RequestMethod.POST)
	public void applyDeletePOST(int applyNo, HttpServletResponse response) {
		logger.info("applyDeletePOST 실행");
		
		try {
			studyService.applyDelete(applyNo);
			
		} catch (Exception e) {
			// 스터디 지원서 삭제 중 오류
			logger.info("applyDelete 오류");
		}
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>window.close();opener.parent.location.reload();</script>");
			out.flush();
			
		} catch (Exception e) {
			// 스크립트 오류
			logger.info("PrintWriter 오류");
		}
	}
	
	@RequestMapping(value = "/myApplyList", method = RequestMethod.GET)
	public void myApplyListGET(Model model, HttpSession session) {
		logger.info("myApplyListGET 실행");
		
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
			// 나의 지원서 리스트 조회 오류
			logger.info("myApplyList 중 오류");
		}
	}
}
