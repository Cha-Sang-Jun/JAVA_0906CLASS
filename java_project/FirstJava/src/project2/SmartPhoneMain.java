package project2;

public class SmartPhoneMain {
	public static void main(String[] args) {

		SmartPhone phone = new SmartPhone(10);

		while (true) {
			System.out.println("### 전화번호부 관리 프로그램 ####");
			System.out.println("1. 회사 동료 전화번호 등록");
			System.out.println("2. 거래처 전화번호 등록");
			System.out.println("3. 전화번호 검색(이름으로 검색)");
			System.out.println("4. 전화번호 삭제 (이름으로 검색)");
			System.out.println("5. 전화번호 수정 (이름으로 검색)");
			System.out.println("6. 전화번호 전체 출력");
			System.out.println("7. 프로그램 종료");
			System.out.println("메뉴 >>>>>>>>>>>");

			int userChoice = Integer.parseInt(SmartPhone.sc.nextLine());

			switch (userChoice) {
			case 1: case 2:
				phone.insertContact(userChoice);
				break;
			case 3:
				phone.searchPrint();
				break;
			case 4:
				phone.deleteContact();
				break;
			case 5:
				phone.editContact();
				break;
			case 6:
				phone.printAllData();
				break;
			case 7:
				System.out.println("프로그램 종료");
				System.exit(0);

			}
		}
	}
}
