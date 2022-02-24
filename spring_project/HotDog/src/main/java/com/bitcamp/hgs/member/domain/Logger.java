package com.bitcamp.hgs.member.domain;

public class Logger {
	private int memberIdx;
	private String email;
	private int snsType;
	private String name;
	private String profile;

	public Logger() {}

	public Logger(int memberIdx, String email, int snsType, String name, String profile) {
		this.memberIdx = memberIdx;
		this.email = email;
		this.snsType = snsType;
		this.name = name;
		this.profile = profile;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSnsType() {
		return snsType;
	}

	public void setSnsType(int snsType) {
		this.snsType = snsType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Logger [memberIdx=" + memberIdx + ", email=" + email + ", snsType=" + snsType + ", name=" + name
				+ ", profile=" + profile + "]";
	}

	
	
	
	
}
