package com.studywithme.domain;

public class MemberDTO {

	private int memberNo;
	private int groupNo;
	private String userId;
	private String userName;
	private String userGender;
	private String userCallNumber;

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserCallNumber() {
		return userCallNumber;
	}

	public void setUserCallNumber(String userCallNumber) {
		this.userCallNumber = userCallNumber;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", groupNo=" + groupNo + ", userId=" + userId + ", userName="
				+ userName + ", userGender=" + userGender + ", userCallNumber=" + userCallNumber + "]";
	}

}
