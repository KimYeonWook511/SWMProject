package com.studywithme.domain;

import java.util.Date;

public class GroupVO {

	private int groupNo;
	private String groupName;
	private String groupLeader;
	private String groupExplain;
	private Date groupCreateDate;

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupLeader() {
		return groupLeader;
	}

	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}

	public String getGroupExplain() {
		return groupExplain;
	}

	public void setGroupExplain(String groupExplain) {
		this.groupExplain = groupExplain;
	}

	public Date getGroupCreateDate() {
		return groupCreateDate;
	}

	public void setGroupCreateDate(Date groupCreateDate) {
		this.groupCreateDate = groupCreateDate;
	}

	@Override
	public String toString() {
		return "GroupDTO [groupNo=" + groupNo + ", groupName=" + groupName + ", groupLeader=" + groupLeader
				+ ", groupExplain=" + groupExplain + ", groupCreateDate=" + groupCreateDate + "]";
	}
}
