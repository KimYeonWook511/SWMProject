package com.studywithme.domain;

public class StudyDTO {

	private int studyNo;
	private String studyTitle;
	private String studyContent;
	private String studyWriter;
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

	public int getStudyViewCount() {
		return studyViewCount;
	}

	public void setStudyViewCount(int studyViewCount) {
		this.studyViewCount = studyViewCount;
	}
}
