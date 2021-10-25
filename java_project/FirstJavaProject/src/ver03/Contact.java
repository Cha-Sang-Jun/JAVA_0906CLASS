package ver03;

public class Contact {
//	프로젝트-2 에서 정의한 Contact 클래스를 상속의 구조로 만들어 봅니다. 
//	 
//	1. Contact 클래스는 기본정보를 저장하고 기본 정보를 출력하는 메소드를 정의합니다. 
	// - 생성자를 통해 기본 정보들을 초기화 합니다. 
//	 

//	② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. - 거래처회사이름, 거래품목, 직급 변수 추가 - 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력 
//	 
//	3. SmartPhone 클래스의 배열을 다형성의 특징을 이용해서 상위 타입의 배열을 생성해서 하위 클래스의 인스턴스를 저장하는 형태로 프로그 램은 작성해봅시다
	
	
	// 저장 정보
	// 이름, 전화번호, 이메일, 주소, 생일, 그룹
	// 캡슐화 : 외부(다른 인스턴스)에서 변수를 직접 참조하지 못하도록 하는 것
	private String name; // 이름
	private String phoneNumber; // 전화번호 : 000-0000-0000
	private String email; // 이메일
	private String address; // 주소
	private String birthday; // 생일 : 20211022
	private String group; // 그룹
	
	// 생성자 : 변수들을 초기화 할 때 사용
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	public Contact(String name, String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, null, null, null, null);
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	// 기능 : 위 데이터를 출력하는 기능
	public void printContact() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("이메일: " + email);
		System.out.println("주소: " + address);
		System.out.println("생일: " + birthday);
		System.out.println("그룹: " + group);
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}
	
	
}
