package com.studywithme.domain;

public class GroupMemberCountVO {

	private int groupNo;
	private int groupMemberCount;

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getGroupMemberCount() {
		return groupMemberCount;
	}

	public void setGroupMemberCount(int groupMemberCount) {
		this.groupMemberCount = groupMemberCount;
	}

	@Override
	public String toString() {
		return "GroupMemberCountVO [groupNo=" + groupNo + ", groupMemberCount=" + groupMemberCount + "]";
	}
}
