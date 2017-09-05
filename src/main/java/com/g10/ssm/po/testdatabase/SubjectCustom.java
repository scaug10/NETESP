package com.g10.ssm.po.testdatabase;

public class SubjectCustom extends Subject {
	private ChoiceQuestion choice;

	private Integer lowerlimitDifficultyId;
	private Integer toplimitDifficultyId;
	private String subjectType;
	private Integer subjectNum;

	public SubjectCustom() {
	};

	public SubjectCustom(Subject subject) {
		this.setAnswer(subject.getAnswer());
		this.setContent(subject.getContent());
		this.setKnowlegePoint(subject.getKnowlegePoint());
		this.setName(subject.getName());
		this.setReviewMessage(subject.getReviewMessage());
		this.setReviewType(subject.getReviewType());
		this.setSubjectId(getSubjectId());
		this.setSubjectMatter(getSubjectMatter());
		this.setSubjectPattern(subject.getSubjectPattern());
		this.setSubjectType(subject.getSubjectType());
		this.setTestDatabaseId(subject.getTestDatabaseId());
		this.setTestDatabaseMatter(subject.getTestDatabaseMatter());
	}

	public ChoiceQuestion getChoice() {
		return choice;
	}

	public void setChoice(ChoiceQuestion choice) {
		this.choice = choice;
	}

	public Integer getLowerlimitDifficultyId() {
		return lowerlimitDifficultyId;
	}

	public void setLowerlimitDifficultyId(Integer lowerlimitDifficultyId) {
		this.lowerlimitDifficultyId = lowerlimitDifficultyId;
	}

	public Integer getToplimitDifficultyId() {
		return toplimitDifficultyId;
	}

	public void setToplimitDifficultyId(Integer toplimitDifficultyId) {
		this.toplimitDifficultyId = toplimitDifficultyId;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public Integer getSubjectNum() {
		return subjectNum;
	}

	public void setSubjectNum(Integer subjectNum) {
		this.subjectNum = subjectNum;
	}

}
