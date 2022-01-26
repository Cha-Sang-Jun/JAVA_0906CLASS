package com.bitcamp.op.guestbook.domain;

public class WriteRequest {

	private int idx;
	private int memberIdx;
	private String subject;
	private String content;
	
	public WriteRequest() {}

	public WriteRequest(int idx, int memberIdx, String subject, String content) {
		this.idx = idx;
		this.memberIdx = memberIdx;
		this.subject = subject;
		this.content = content;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "WriteRequest [idx=" + idx + ", memberIdx=" + memberIdx + ", subject=" + subject + ", content=" + content
				+ "]";
	}

	

}
