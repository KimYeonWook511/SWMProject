package com.studywithme.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studywithme.domain.GroupMemberCountVO;
import com.studywithme.domain.GroupVO;
import com.studywithme.domain.UserVO;
import com.studywithme.service.GroupService;

@Controller
@RequestMapping("/group")
public class GroupController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private GroupService groupService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model, HttpSession session) {
		logger.info("listGET 실행");
		
		try {
			String userId = ((UserVO)session.getAttribute("loginVO")).getUserId();
			List<GroupVO> groupList = groupService.myGroupList(userId);
			List<GroupVO> groupListL = new ArrayList<GroupVO>(); // userId가 Leader인 그룹 리스트
			List<GroupMemberCountVO> countList = groupService.myGroupMemeberCount(userId);
			Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(); 
					
			for (int i = 0; i < groupList.size(); i++) {
				if (groupList.get(i).getGroupLeader().equals(userId)) groupListL.add(groupList.remove(i--));
			}
			
			for (GroupMemberCountVO vo : countList) {
				countMap.put(vo.getGroupNo(), vo.getGroupMemberCount());
			}
			
			model.addAttribute("groupListM", groupList);
			model.addAttribute("groupListL", groupListL);
			model.addAttribute("countMap", countMap);
			
		} catch (Exception e) {
			logger.info("/group/list 오류");
		}
	}
}
