package com.bitcamp.mvc.domain;

public class LoginRequest {

	// lgoinform.jsp 에서 받는 값과 이름 일치시킨다
	private String uid;
	private String pw;
	
	// 디폴트 생성자는 만들지 않는다.
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", pw=" + pw + "]";
	}
	
	
	

}
