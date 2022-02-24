package com.bitcamp.hgs.member.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class EditMember {

	private int memberIdx;
	private String email;
	private String password;
	private String petNumber;
	private String name;
	private String oldFile;
	private MultipartFile profile;
	private Date birthday;
	private int sex;
	private String address;
	private int breedIdx;
	private int neutering;
	private String snsId;
	private int snsType;
	private String fileName;
	

	public EditMember(int memberIdx, String petNumber, String address, int breedIdx, int neutering, String fileName) {
		this.memberIdx = memberIdx;
		this.petNumber = petNumber;
		this.address = address;
		this.breedIdx = breedIdx;
		this.neutering = neutering;
		this.fileName = fileName;
	}

	public EditMember() {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOldFile() {
		return oldFile;
	}
	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}
	public MultipartFile getProfile() {
		return profile;
	}
	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNeutering() {
		return neutering;
	}
	public void setNeutering(int neutering) {
		this.neutering = neutering;
	}
	public String getSnsId() {
		return snsId;
	}
	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}
	public int getSnsType() {
		return snsType;
	}
	public void setSnsType(int snsType) {
		this.snsType = snsType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
