package com.studywithme.domain;

public class ApplyAccessVO {

	private String studyWriter;
	private String applyWriter;

	public String getStudyWriter() {
		return studyWriter;
	}

	public void setStudyWriter(String studyWriter) {
		this.studyWriter = studyWriter;
	}

	public String getApplyWriter() {
		return applyWriter;
	}

	public void setApplyWriter(String applyWriter) {
		this.applyWriter = applyWriter;
	}

	@Override
	public String toString() {
		return "ApplyAccessVO [studyWriter=" + studyWriter + ", applyWriter=" + applyWriter + "]";
	}
}
