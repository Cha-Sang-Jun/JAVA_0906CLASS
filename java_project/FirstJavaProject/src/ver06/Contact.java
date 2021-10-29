package ver06;


import java.util.Scanner;

public abstract class Contact implements ShowData {
	
	// 연락처 데이터 인스턴스 생성
	private String name; // 이름
	private String callNum; // 전화번호
	private String email; // 이메일
	private String address; // 주소
	private String birth; // 생일
	private String group; // 그룹

	// 변수의 값을 저장 / 호출 할 수있는 getter setter 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCallNum() {
		return callNum;
	}

	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Contact() {
	}

	// 데이터를 초기화 할 수 있는 생성자
	public Contact(String name, String callNum, String email, String adress, String birth, String group) {
		this.name = name;
		this.callNum = callNum;
		this.email = email;
		this.address = adress;
		this.birth = birth;
		this.group = group;
	}

	public Contact(String name, String callNum) {
		this.name = name;
		this.callNum = callNum;
	}

	// 출력 메소드
	@Override
	public void showData() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + callNum);
		System.out.println("이메일: " + email);
		System.out.println("주소: " + address);
		System.out.println("생일: " + birth);
		System.out.println("그룹: " + group);
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", callNum=" + callNum + ", email=" + email + ", address=" + address
				+ ", birth=" + birth + ", group=" + group + "]";
	}

}
