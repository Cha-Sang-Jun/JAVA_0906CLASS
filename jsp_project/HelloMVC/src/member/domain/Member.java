package member.domain;

public class Member {

	private String userId; // 회원 아이디
	private String password; // 회원 비밀번호
	private String name; // 회원 이름
	private String signdate; // 가입 일시

	// 생성자
	public Member(String userId, String password, String name, String signdate) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.signdate = signdate;
	}

	// 기본 생성자
	public Member() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", name=" + name + ", signdate=" + signdate
				+ "]";
	}
	
	
}
