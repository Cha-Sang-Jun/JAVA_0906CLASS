package project2;

import java.util.Scanner;

public class SmartPhone {
//	1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다. 
//	① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다. 
//	② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다. 

	public static final Scanner sc = new Scanner(System.in);

	private Contact[] phoneNum;
	private int numOfContact;

	public SmartPhone(int size) {
		phoneNum = new Contact[size];
		numOfContact = 0;
	}

	// 연락처 정보 전체 출력
	public void showAllData() {
		System.out.println("연락처 정보 출력");
		for (int i = 0; i < numOfContact; i++) {
			phoneNum[i].printData();
		}

		System.out.println("-------------------------");
	}

	// 배열에 요소를 추가
	public void addList(Contact c) {
		phoneNum[numOfContact++] = c;
	}

	// 검색 메소드
	public void searchList() {
		System.out.println("찾는 친구의 이름을 입력해주세요.");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			for (int i = 0; i < numOfContact; i++) {
				phoneNum[i].printData();
			}
			
		} else {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		}

	}

	// 삭제 메소드
	public void delete() {
		System.out.println("삭제하려는 친구의 이름을 입력해주세요.");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index > -1) {
			for (int i = index; i < numOfContact - 1; i++) {
				phoneNum[i] = phoneNum[i + 1];
			}

			numOfContact--;
			System.out.println("정보가 삭제되었습니다.");
		} else {
			System.out.println("검색하신 이름의 정보가 존재하지 않습니다.");
		}
	}

	// 수정 메소드
	public void update() {
		System.out.println("수정하고 싶은 친구의 이름을 입력해주세요.");
		String name = sc.nextLine();

		int index = searchIndex(name);
		if (index > -1) {
			System.out.println(name + "의 연락처 정보를 수정합니다.");
			System.out.println("새로운 전화번호를 입력해주세요.");
			phoneNum[index].setCallNum(sc.nextLine());

			System.out.println("새로운 이메일을 입력해주세요.");
			phoneNum[index].setEmail(sc.nextLine());

			System.out.println("새로운 주소를 입력해주세요.");
			phoneNum[index].setAddress(sc.nextLine());

			System.out.println("새로운 생일을 입력해주세요.");
			phoneNum[index].setBirthDay(Integer.parseInt(sc.nextLine()));

			System.out.println("새로운 그룹을 입력해주세요.");
			phoneNum[index].setGroup(sc.nextLine());

			System.out.println("연락처 정보가 수정되었습니다.");

		} else {
			System.out.println("입력하신 이름의 연락처 정보가 존재하지 않습니다.");
		}

	}

	// 이름을 전달받아 배열의 각 요소와 비교, 같은 요소가 있을시 return index
	private int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < numOfContact; i++) {
			if (phoneNum[i].getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	// 연락처 정보 입력
	public void insertContact() {
		System.out.println("새 연락처 정보를 입력합니다.");

		System.out.println("이름을 입력해주세요");
		System.out.println("> ");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력해주세요.");
		System.out.println("> ");
		String callNum = sc.nextLine();

		System.out.println("이메일을 입력해주세요.");
		System.out.println("> ");
		String email = sc.nextLine();

		System.out.println("주소를 입력해주세요.");
		System.out.println("> ");
		String address = sc.nextLine();

		System.out.println("생일을 입력해주세요.");
		System.out.println("> ");
		int birthDay = Integer.parseInt(sc.nextLine());

		System.out.println("그룹이름을 입력해주세요.");
		System.out.println("> ");
		String group = sc.nextLine();

		addList(new Contact(name, callNum, email, address, birthDay, group));
		System.out.println("연락처 정보가 입력되었습니다.");

	}

}
