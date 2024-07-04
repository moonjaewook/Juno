package com.good.juno.dto;

public class QnaDto {
	
	private int qnaId;
	private String userId;
	private String userEmail;
	private String title;
	private String content;
	private int answer;
	
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	
}
