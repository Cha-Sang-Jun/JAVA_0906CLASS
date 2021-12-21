package member.domain;

public class RegRequest {
	
	private String userid;
	private String password;
	private String username;
	private String fileName;
	
	public RegRequest() {}
	
	public RegRequest(String userid, String password, String username, String fileName) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.fileName = fileName;
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
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "RegRequest [userid=" + userid + ", password=" + password + ", username=" + username + ", fileName="
				+ fileName + "]";
	}

	// RegRequest -> Member
	public Member getMember() {
		return new Member(0, this.userid, this.password, this.username, null, null);
	}
	
	
	
	

}
