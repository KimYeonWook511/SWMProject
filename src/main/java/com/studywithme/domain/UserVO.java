package com.studywithme.domain;

import java.util.Date;

public class UserVO {

	private String userId;
	private String userPassword;
	private String userName;
	private String userAddress;
	private String userGender;
	private String userCallNumber;
	private Date userSignDate;
	private String userAuthority;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
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

	public Date getUserSignDate() {
		return userSignDate;
	}

	public void setUserSignDate(Date userSignDate) {
		this.userSignDate = userSignDate;
	}

	public String getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userGender=" + userGender + ", userCallNumber=" + userCallNumber
				+ ", userSignDate=" + userSignDate + ", userAuthority=" + userAuthority + "]";
	}
}
