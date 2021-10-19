package chapter08;

// 추상 클래스로 만들기 : 추상 클래스 생성
public abstract class Friend {

	String name;
	String phoneNumber;
	String address;

	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public void showData() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("주소: " + this.address);
	}

	// 추상 메소드: 처리 블록이 없다! 미완성된 메소드로 상속을  통해 완성시켜야 하는 메소드이다.
	public abstract void showBasicInfo();
}
