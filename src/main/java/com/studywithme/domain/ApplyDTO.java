package com.studywithme.domain;

public class ApplyDTO {

	private int applyNo;
	private int studyNo;
	private String applyContent;
	private String applyWriter;

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public String getApplyContent() {
		return applyContent;
	}

	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}

	public String getApplyWriter() {
		return applyWriter;
	}

	public void setApplyWriter(String applyWriter) {
		this.applyWriter = applyWriter;
	}
}
