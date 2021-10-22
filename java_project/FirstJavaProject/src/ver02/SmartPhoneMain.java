package ver02;

public class SmartPhoneMain {
	public static void main(String[] args) {
		// SmartPhone 클래스의 인스턴스를 생성합니다.
		SmartPhone phone = new SmartPhone(10);

		while (true) {
			System.out.println("### 전화번호부 관리 프로그램 ####");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 검색(이름으로 검색)");
			System.out.println("3. 전화번호 삭제 (이름으로 검색)");
			System.out.println("4. 전화번호 수정 (이름으로 검색)");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 프로그램 종료");
			System.out.println("메뉴 >>>>>>>>>>>");

			int select = Integer.parseInt(SmartPhone.sc.nextLine());

			switch (select) {
			case 1:
				phone.insertContact();
				break;
			case 2:
				phone.searchPrint();
				break;
			case 3:
				phone.deleteContact();
				break;
			case 4:
				phone.editContact();
				break;
			case 5:
				phone.printAllData();
				break;
			case 6:
				System.out.println("프로그램 종료");
				// return;
				System.exit(0);

			}
		}

		// 사용자로부터 입력을 받아 Contact 인스턴스를 생성해서 SmartPhone 클래스의 인스턴스가 가지고 있는 배열에 추가
		// 10번 반복해서 배열에 추가

//		for (int i = 0; i < 3; i++) {
//			phone.insertContact();
//		}
//
//		// 배열의 모든 요소를 출력합니다.
//		phone.printAllData();
//
//		// 배열의 모든 요소를 검색합니다.
//		phone.searchPrint();
//
//		// 배열의 요소를 삭제해 봅시다.
//		phone.deleteContact();
//
//		// 배열의 요소를 수정해봅시다.
//		phone.editContact();
//
//		// 삭제와 변경 여부 확인
//		phone.printAllData();
	}
}
