package com.g10.ssm.po.testdatabase;

public class SubjectCustom extends Subject{
	private ChoiceQuestion choice;
	
	public SubjectCustom(){};
	public SubjectCustom(Subject subject){
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
	
	
	
}
