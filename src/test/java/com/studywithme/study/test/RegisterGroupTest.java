package com.studywithme.study.test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.studywithme.domain.GroupDTO;
import com.studywithme.domain.MemberDTO;
import com.studywithme.domain.StudyDTO;
import com.studywithme.domain.UserVO;
import com.studywithme.persistence.GroupDAO;
import com.studywithme.persistence.StudyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class RegisterGroupTest {
	
	@Inject
	private StudyDAO studyDAO;
	@Inject
	private GroupDAO groupDAO;
	
	@Test
	public void registerGroupTest() {
		try {
			StudyDTO studyDTO = new StudyDTO();
			studyDTO.setStudyNo(9);
			
			GroupDTO groupDTO = new GroupDTO();
			groupDTO.setGroupName("그룹등록 테스트");
			groupDTO.setGroupExplain("그룹등록 설명 테스트");
			groupDTO.setGroupLeader("test");
			
			groupDAO.createGroup(groupDTO);
			List<UserVO> passList = studyDAO.passMemberList(studyDTO.getStudyNo());
			List<MemberDTO> memberList = new ArrayList<MemberDTO>(); 
			
			for (UserVO vo : passList) {
				MemberDTO dto = new MemberDTO();
				dto.setGroupNo(groupDTO.getGroupNo());
				dto.setUserId(vo.getUserId());
				dto.setUserName(vo.getUserName());
				dto.setUserGender(vo.getUserGender());
				dto.setUserCallNumber(vo.getUserCallNumber());
				
				memberList.add(dto);
			}
			
			groupDAO.createMember(memberList);
			
			// 스터디 공고와 지원서 삭제
			studyDAO.deleteStudy(studyDTO.getStudyNo());
			studyDAO.deleteStudyApply(studyDTO.getStudyNo());
			
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
}
