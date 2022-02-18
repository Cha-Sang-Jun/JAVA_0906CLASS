package com.bitcamp.hgs.member.domain;

public class Logger {
	private String idx;
	private String email;
	private int snsType;
	private String name;
	private String profile;

	public Logger() {}

	public Logger(String idx, String email, int snsType, String name, String profile) {
		this.idx = idx;
		this.email = email;ncode(rawPassword)
		this.snsType = snsType;
		this.name = name;
		this.profile = profile;
	}

	public String getIdx() {
		return idx;
	}

	public String getEmail() {
		return email;
	}

	public int getSnsType() {
		return snsType;
	}

	public String getName() {
		return name;
	}

	public String getProfile() {
		return profile;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSnsType(int snsType) {
		this.snsType = snsType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Logger [idx=" + idx + ", email=" + email + ", snsType=" + snsType + ", name=" + name + ", profile="
				+ profile + "]";
	}
	
	
	
}
