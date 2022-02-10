package com.example.demo.member.domain;

public class LoginParams {
	
	private String uid;
	private String pw;
	
	public LoginParams() {}
	
	public LoginParams(String uid, String pw) {
		this.uid = uid;
		this.pw = pw;
	}
	
	public String getUid() {
		return uid;
	}

	public String getPw() {
		return pw;
	}
	
	
	
	
}
