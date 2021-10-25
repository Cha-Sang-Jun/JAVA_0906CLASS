package ver04;

import java.util.Scanner;

public class SmartPhoneMain {
//	2. main()메소드를 아래의 요구조건을 정의해봅니다. 
//	① SmartPhone 클래스의 인스턴스를 생성합니다. 
//	② 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가합니다. 
//	③ 10번 반복해서 배열에 추가합니다. 
//	④ 배열의 모든 요소를 출력합니다. 
//	⑤ 배열의 모든 요소를 검색합니다. 
//	⑥ 배열의 요소를 삭제해 봅시다. 
//	⑦ 배열의 요소를 수정해 봅시다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SmartPhone phone = new SmartPhone(10);

		while (true) {

			showMenu();

			int userChoice = Integer.parseInt(SmartPhone.sc.nextLine());

			switch (userChoice) {
			case 1: case 2:
				System.out.println("연락처 정보를 입력합니다.");
				phone.insertContact(userChoice);
				break;
				
			case 3:
				System.out.println("연락처 데이터를 출력합니다.");
				phone.showAllData();
				break;
				
			case 4:
				System.out.println("연락처 정보를 검색합니다.");
				phone.searchList();
				System.out.println("연락처 정보를 수정하시겠습니까 y/n");
				String yesNo = sc.nextLine();
				if (yesNo.equalsIgnoreCase("y")) {
					phone.update();
				}
				break;
				
			case 5:
				System.out.println("연락처 정보를 삭제합니다.");
				phone.delete();
				break;
				
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public static void showMenu() {
		System.out.println("연락처 정보 관리 프로그램");
		System.out.println("-------------------");
		System.out.println("1. 사내 연락처 정보 입력");
		System.out.println("2. 거래처 연락처 정보 입력");
		System.out.println("3. 연락처 정보 출력");
		System.out.println("4. 연락처 정보 검색");
		System.out.println("5. 연락처 정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println("원하시는 메뉴 번호를 입력해주세요. >>>");
	}
}
