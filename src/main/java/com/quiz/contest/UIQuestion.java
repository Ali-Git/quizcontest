package com.quiz.contest;

public class UIQuestion {
	private int QnID;
	private String Qn;
	private String ImageName;
	private String[] Options;
	private int correctAnswer;

	public int getQnID() {
		return QnID;
	}

	public void setQnID(int qnID) {
		QnID = qnID;
	}

	public String getQn() {
		return Qn;
	}

	public void setQn(String qn) {
		Qn = qn;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

	public String[] getOptions() {
		return Options;
	}

	public void setOptions(String[] options) {
		Options = options;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
