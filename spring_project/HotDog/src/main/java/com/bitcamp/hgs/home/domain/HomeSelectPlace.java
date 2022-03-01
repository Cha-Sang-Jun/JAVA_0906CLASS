package com.bitcamp.hgs.home.domain;


public class HomeSelectPlace {
	private int placeIdx;			// idx
	private String title;			// 제목
	private String subjectCategory; // 카테고리
	private String newAddress;		// 주소
	private String Hashtags;
	private String reply;
	private int replyCnt;
	private int scrapMemberIdx;		// 맴버 아이디로 스크랩 유무 확인

	public HomeSelectPlace() {}

	public HomeSelectPlace(int placeIdx, String title, String subjectCategory, String newAddress, String hashtags,
			String reply, int replyCnt, int scrapMemberIdx) {
		this.placeIdx = placeIdx;
		this.title = title;
		this.subjectCategory = subjectCategory;
		this.newAddress = newAddress;
		this.Hashtags = hashtags;
		this.reply = reply;
		this.replyCnt = replyCnt;
		this.scrapMemberIdx = scrapMemberIdx;
	}

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	public String getHashtags() {
		return Hashtags;
	}

	public void setHashtags(String hashtags) {
		Hashtags = hashtags;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public int getScrapMemberIdx() {
		return scrapMemberIdx;
	}

	public void setScrapMemberIdx(int scrapMemberIdx) {
		this.scrapMemberIdx = scrapMemberIdx;
	}

	@Override
	public String toString() {
		return "HomeSelectPlace [placeIdx=" + placeIdx + ", title=" + title + ", subjectCategory=" + subjectCategory
				+ ", newAddress=" + newAddress + ", Hashtags=" + Hashtags + ", reply=" + reply + ", replyCnt="
				+ replyCnt + ", scrapMemberIdx=" + scrapMemberIdx + "]";
	}

}
