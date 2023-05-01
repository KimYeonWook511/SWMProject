package com.studywithme.domain;

import java.util.Date;

public class StudyVO {

	private int studyNo;
	private String studyTitle;
	private String studyContent;
	private String studyWriter;
	private Date studyWriteDate;
	private Date studyUpdateDate;
	private int studyViewCount;

	public int getStudyNo() {
		return studyNo;
	}

	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}

	public String getStudyTitle() {
		return studyTitle;
	}

	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}

	public String getStudyContent() {
		return studyContent;
	}

	public void setStudyContent(String studyContent) {
		this.studyContent = studyContent;
	}

	public String getStudyWriter() {
		return studyWriter;
	}

	public void setStudyWriter(String studyWriter) {
		this.studyWriter = studyWriter;
	}

	public Date getStudyWriteDate() {
		return studyWriteDate;
	}

	public void setStudyWriteDate(Date studyWriteDate) {
		this.studyWriteDate = studyWriteDate;
	}

	public Date getStudyUpdateDate() {
		return studyUpdateDate;
	}

	public void setStudyUpdateDate(Date studyUpdateDate) {
		this.studyUpdateDate = studyUpdateDate;
	}

	public int getStudyViewCount() {
		return studyViewCount;
	}

	public void setStudyViewCount(int studyViewCount) {
		this.studyViewCount = studyViewCount;
	}

	@Override
	public String toString() {
		return "StudyVO [studyNo=" + studyNo + ", studyTitle=" + studyTitle + ", studyContent=" + studyContent
				+ ", studyWriter=" + studyWriter + ", studyWriteDate=" + studyWriteDate + ", studyUpdateDate="
				+ studyUpdateDate + ", studyViewCount=" + studyViewCount + "]";
	}
}
