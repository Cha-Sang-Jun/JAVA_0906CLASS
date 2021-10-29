package ver06;

// 1. 메뉴 입력 시 발생할 수 있는 예외에 대하여 예외 처리합시다. 

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SmartPhone phone = new SmartPhone(10);

		while (true) {

			showMenu();
			int userChoice = Integer.parseInt(SmartPhone.sc.nextLine());

			if (userChoice <= 0 && userChoice > 6) {
				System.out.println("잘못된 입력입니다.");
			}

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
