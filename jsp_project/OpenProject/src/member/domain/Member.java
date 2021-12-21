package member.domain;

import java.sql.Timestamp;

/*
 *  사진 파일 경로 저장하는 변수 추가 21/12/21 Tue
 */


public class Member {
	
	private int idx;
	private String userid;
	private String password;
	private String username;
	// private Timestamp regdate;  java.sql.TimeStamp -> java.util.Date
	// 받을 때 날짜 계산을 하지 않을거라면 String 으로 받아도 된다. 
	private String regdate;
	private String photo;
	
	public Member() {}
	
	public Member(int idx, String userid, String password, String username, String regdate, String photo) {
		this.idx = idx;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.regdate = regdate;
		this.photo = photo;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getPhoto(	) {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", userid=" + userid + ", password=" + password + ", username=" + username
				+ ", regdate=" + regdate + ", photo=" + photo + "]";
	}
	
	public LoginInfo getLoginInfo() {
		
		return new LoginInfo(this.userid, this.username, this.photo);
	}
	
	
	
}
