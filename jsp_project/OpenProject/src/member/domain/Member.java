package member.domain;

import java.sql.Timestamp;

public class Member {
	
	private int idx;
	private String userid;
	private String password;
	private String username;
	private Timestamp regdate; // java.sql.TimeStamp -> java.util.Date
	// 받을 때 날짜 계산을 하지 않을거라면 String 으로 받아도 된다. 
	
	public Member() {}
	
	public Member(int idx, String userid, String password, String username, Timestamp regdate) {
		this.idx = idx;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.regdate = regdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
