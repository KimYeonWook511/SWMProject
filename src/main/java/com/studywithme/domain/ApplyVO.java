package com.studywithme.domain;

import java.util.Date;

public class ApplyVO {

	private int applyNo;
	private int studyNo;
	private String applyContent;
	private String applyWriter;
	private Date applyDate;

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

	public String getReplApplyContent() {
		return applyContent.replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>").replace(" ", "&nbsp;");
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

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Override
	public String toString() {
		return "ApplyVO [applyNo=" + applyNo + ", studyNo=" + studyNo + ", applyContent=" + applyContent
				+ ", applyWriter=" + applyWriter + ", applyDate=" + applyDate + "]";
	}
}
