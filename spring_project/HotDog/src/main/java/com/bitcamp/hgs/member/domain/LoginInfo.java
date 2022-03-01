package com.bitcamp.hgs.member.domain;

public class LoginInfo {

	private int memberIdx;
	private String email;
	private String name;
	private String profile;
	
	public LoginInfo(int memberIdx, String email, String name, String profile) {
		this.memberIdx = memberIdx;
		this.email = email;
		this.name = name;
		this.profile = profile;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getProfile() {
		return profile;
	}

	
	
}
	
