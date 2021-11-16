package model;

public class MemberDTO {
	// 필드
	private int id;
	private String username;
	private String password;
	private String nickname;
	
	// 메소드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean equals (Object o) {
		if(o instanceof MemberDTO) {
			MemberDTO m = (MemberDTO)o;
			if(id == m.id) {
				return true;
			}
		}
		
		return false;
	}
	

	
}
