 package com.bitcamp.op.guestbook.domain;

public class ReplyRegRequest {
	
	// 1번
	private int idx; // 사용자에게 받지는 않지만 DB에 갔다와서 UPDATE된 이 값을 반환해야함
	private int memberIdx;
	private int guestbookIdx; // 컬럼 이름과 맞춰야 자동으로 binding 되어 mapping 된다
	private String message;
	
	public ReplyRegRequest() {}
	
	public ReplyRegRequest(int idx, int memberIdx, int guestbookIdx, String message) {
		this.idx = idx;
		this.memberIdx = memberIdx;
		this.guestbookIdx = guestbookIdx;
		this.message = message;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getGuestbookIdx() {
		return guestbookIdx;
	}
	public void setGuestbookIdx(int guestbookIdx) {
		this.guestbookIdx = guestbookIdx;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
