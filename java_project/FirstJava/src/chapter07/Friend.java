package chapter07;

public class Friend {

	// 개인 정보 관리 프로그램
	// 정보를 저장하는 변수
	String name;
	String phoneNumber;
	String address;

	// 저장 데이터의 초기화: 생성자
	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// 데이터 출력 메소드: 상속을 하면 오버라이딩해서 하위 클래스 멤버도 출력하도록 해야함
	public void showData() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("주소: " + this.address);
	}

	// 오바리이딩을 목적으로 하는 메소드
	public void showBasicInfo() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("주소: " + address);
	}
}
