package project;
//추가 요구 사항 

// 변수들은 직접 참조를 막아 캡슐화 처리를 하도록 해봅시다. 
//변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와
//변수에 값을 저장할 수 있는 메소드(setter)를 정의합니다.
// 인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의해봅시다.
// 저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성해봅시다.

//실행 과정 
// main()메소드를 정의합니다.
// 연락처 데이터를 저장하는 인스턴스를 생성합니다.
// 변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다.
// 생성된 인스턴스의 정보 출력 메소드를 호출합니다.
// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
// 인스턴스의 출력메소드를 다시 실행합니다

import java.util.Scanner;

public class Contact {
	// 연락처 데이터 인스턴스 생성
	private String name;
	private String callNum;
	private String email;
	private String address;
	private String birthDay;
	private String group;

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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	// 데이터를 초기화 할 수 있는 생성자
	public void Contact(String name, String callNum, String email, String adress, String birthDay, String group) {
		this.name = name;
		this.callNum = callNum;
		this.email = email;
		this.address = adress;
		this.birthDay = birthDay;
		this.group = group;
	}
	
	// 사용자로부터 데이터를 입력받는 메소드
	public void insert() {
		Scanner scanner = new Scanner(System.in);
		Contact c = new Contact();

		System.out.println("이름을 입력해주세요.");
		System.out.println("> ");
		c.setName(scanner.nextLine());

		System.out.println("전화번호를 입력해주세요.");
		System.out.println("> ");
		c.setCallNum(scanner.nextLine());

		System.out.println("이메일을 입력해주세요.");
		System.out.println("> ");
		c.setEmail(scanner.nextLine());

		System.out.println("주소를 입력해주세요.");
		System.out.println("> ");
		c.setAddress(scanner.nextLine());

		System.out.println("생일을 입력해주세요.");
		System.out.println("> ");
		c.setBirthDay(scanner.nextLine());

		System.out.println("그룹을 입력해주세요.");
		System.out.println("> ");
		c.setGroup(scanner.nextLine());

		c.printData(c);
		c.update(c);

	}
	
	// 출력 메소드
	public void printData(Contact c) {
		System.out.println("이름: " + c.getName());
		System.out.println("전화번호: " + c.getCallNum());
		System.out.println("이메일: " + c.getEmail());
		System.out.println("주소: " + c.getAddress());
		System.out.println("생일: " + c.getBirthDay());
		System.out.println("그룹: " + c.getGroup());
	}

	// 수정 메소드
	public void update(Contact c) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정보를 수정하시겠습니까? y/n");
		System.out.println("> ");
		String yesNo = scanner.nextLine();
		while (true) {
			if (yesNo.equalsIgnoreCase("y")) {
				c.insert();
			} else {
				c.printData(c);
				scanner.close();
			}

			break;
		}

	}
	
	// 메인 메소드
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Contact contact = new Contact();

		contact.insert();

	}
}
