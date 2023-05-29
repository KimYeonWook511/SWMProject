package com.studywithme.domain;

public class GroupDTO {

	private int groupNo;
	private String groupName;
	private String groupLeader;
	private String groupExplain;

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

	@Override
	public String toString() {
		return "GroupDTO [groupNo=" + groupNo + ", groupName=" + groupName + ", groupLeader=" + groupLeader
				+ ", groupExplain=" + groupExplain + "]";
	}
}
