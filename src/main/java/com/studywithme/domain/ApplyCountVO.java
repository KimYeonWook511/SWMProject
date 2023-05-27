package com.studywithme.domain;

public class ApplyCountVO {

	private int studyNo;
	private int applyCount;

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public int getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(int applyCount) {
		this.applyCount = applyCount;
	}

	@Override
	public String toString() {
		return "ApplyCountVO [studyNo=" + studyNo + ", applyCount=" + applyCount + "]";
	}
}
