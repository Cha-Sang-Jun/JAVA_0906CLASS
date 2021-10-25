package project3;

// 3. SmartPhone 클래스의 배열을 다형성의 특징을 이용해서 상위 타입의 배열을 생성해서 
// 하위 클래스의 인스턴스를 저장하는 형태로 프로그 램은 작성해봅시다

import java.util.Scanner;

public class SmartPhone {

	public static final Scanner sc = new Scanner(System.in);

	private Contact[] phoneNum;
	private int numOfContact;

	public SmartPhone(int size) {
		phoneNum = new Contact[size];
		numOfContact = 0;
	}

	// 연락처 정보 전체 출력
	public void showAllData() {
		System.out.println("연락처 전체 정보 출력");
		for (int i = 0; i < numOfContact; i++) {
			phoneNum[i].printData();
			System.out.println("==========================");
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
			phoneNum[index].printData();
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
				phoneNum[index] = phoneNum[index + 1];
				numOfContact--;
			}
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
			String callNum = sc.nextLine();

			System.out.println("새로운 이메일을 입력해주세요.");
			String email = sc.nextLine();

			System.out.println("새로운 주소를 입력해주세요.");
			String address = sc.nextLine();

			System.out.println("새로운 생일을 입력해주세요.");
			int birthDay = Integer.parseInt(sc.nextLine());

			System.out.println("새로운 그룹을 입력해주세요.");
			String group = sc.nextLine();

			System.out.println("연락처 정보가 수정되었습니다.");

			if (phoneNum[index] instanceof CompanyContact) {
				CompanyContact contact = (CompanyContact) phoneNum[index];

				System.out.println("새로운 회사이름을 입력해주세요.");
				System.out.println("> ");
				String companyName = sc.nextLine();

				System.out.println("새로운 부서이름을 입력해주세요.");
				System.out.println("> ");
				String departName = sc.nextLine();

				System.out.println("새로운 직급을 입력해주세요.");
				System.out.println("> ");
				String rank = sc.nextLine();

				contact.setCallNum(callNum);
				contact.setEmail(email);
				contact.setAddress(address);
				contact.setBirthDay(birthDay);
				contact.setGroup(group);
				contact.setCompanyName(companyName);
				contact.setDepartName(departName);
				contact.setRank(rank);

			} else {

				CustomerContact contact = (CustomerContact) phoneNum[index];

				System.out.println("새로운 거래처 회사명을 입력해주세요.");
				System.out.println("> ");
				String customerName = sc.nextLine();

				System.out.println("새로운 거래 품목을 입력해주세요.");
				System.out.println("> ");
				String product = sc.nextLine();

				System.out.println("새로운 직급을 입력해주세요.");
				System.out.println("> ");
				String rank = sc.nextLine();

				contact.setCallNum(callNum);
				contact.setEmail(email);
				contact.setAddress(address);
				contact.setBirthDay(birthDay);
				contact.setGroup(group);
				contact.setCustomerName(customerName);
				contact.setProduct(product);
				contact.setRank(rank);
			}

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
	public void insertContact(int userChoice) {
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

		if (userChoice == 1) { // 같은 회사 동료일 경우
			System.out.println("회사이름을 입력해주세요.");
			System.out.println("> ");
			String companyName = sc.nextLine();

			System.out.println("부서이름을 입력해주세요.");
			System.out.println("> ");
			String departName = sc.nextLine();

			System.out.println("직급을 입력해주세요.");
			System.out.println("> ");
			String rank = sc.nextLine();

			addList(new CompanyContact(name, callNum, email, address, birthDay, group, companyName, departName, rank));

		} else { // 거래처 직원일 경우
			System.out.println("거래처 회사명을 입력해주세요.");
			System.out.println("> ");
			String customerName = sc.nextLine();

			System.out.println("거래품목을 입력해주세요.");
			System.out.println("> ");
			String product = sc.nextLine();

			System.out.println("직급을 입력해주세요.");
			System.out.println("> ");
			String rank = sc.nextLine();

			addList(new CustomerContact(name, callNum, email, address, birthDay, group, customerName, product, rank));
		}

		System.out.println("연락처 정보가 입력되었습니다.");

	}

}
