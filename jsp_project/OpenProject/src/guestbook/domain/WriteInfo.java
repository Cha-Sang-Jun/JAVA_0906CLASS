package guestbook.domain;

public class WriteInfo {
	
	private String subject;
	private String content;
	private int memberidx;

	
	public WriteInfo() {}
	
	
	public WriteInfo(String subject, String content, int memberidx) {
		this.subject = subject;
		this.content = content;
		this.memberidx = memberidx;
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


	public int getMemberidx() {
		return memberidx;
	}


	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}


	@Override
	public String toString() {
		return "Write [subject=" + subject + ", content=" + content + ", memberidx=" + memberidx + "]";
	}
	
	
	
	
}
