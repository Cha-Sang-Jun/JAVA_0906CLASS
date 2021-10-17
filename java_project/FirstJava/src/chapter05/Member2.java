package chapter05;

public class Member2 {
//	1. Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요. 
//	단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다. 
//	① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소

// private : 클래스 내부의 멤버들만 액세스가 가능하다!
	private String name; // 이름
	private String phoneNumber; // 전화번호
	private String major; // 전공
	private int grade; // 학년
	private String email; // 이메일
	// 20001020, 2000-10-20, 2000/10/20 날짜의 형식
	// 20001020 을 10000으로 나오면 2000 년도가 나옴
	// 10000으로 나눈 나머지 1020에서 100으로 나누면 달 10월과 나머지 20 일이 산출
	private String birthDay; // 생일
	private String address; // 주소

	////////////////////////////////////////////////////
	// 일반적인 코드 작성의 구조 :
	//
	// 기본 생성 클래스
	// ////////////////////
	// 변수
	// ////////////////////
	// 생성자
	// /////////////////////
	// 메소드
	//////////////////////////////////////////////////////

//	② 위에서 정의한 정보를 출력하는 메소드 정의
	public void showData() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("전공: " + this.major);
		System.out.println("학년: " + this.grade);
		System.out.println("이메일: " + this.email);

		// null
		if (this.birthDay == null) {
			System.out.println("생일: 생일정보 없음");
		} else {
			System.out.println("생일:" + this.birthDay);
		}

		if (this.address == null) {
			System.out.println("주소 : 주소정보 없음");
		} else {
			System.out.println("주소: " + this.address);
		}

	}

//	③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의

	public Member2(String name, String phoneNumber, String major, int grade, String email, String birthDay,
			String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthDay = birthDay;
		this.address = address;
	}

	public Member2(String name, String phoneNumber, String major, int grade, String email) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this.major = major;
//		this.grade = grade;
//		this.email = email;
//		this.birthDay = birthDay;
		this(name, phoneNumber, major, grade, email, null, null); // null은 넣어도 되고 안넣어도됨.
		// 출력을 목적으로 할때 null 이 있는 자리에서는 마음대로 처리할 수 있음.
	}

	// 기본 생성자
	public Member2() {

	}



}
