package ver04;
//4. SmartPhone클래스에 있는 배열의 타입이 추상클래스로 되어도 문제가 없는 것을 확인 

import java.util.Scanner;

public class SmartPhone {
	private Contact[] contacts;
	private int cnt;

	public static Scanner sc = new Scanner(System.in);

	public SmartPhone(int size) {
		contacts = new Contact[size];
		cnt = 0;
	}

	public void addContact(Contact contact) {
		contacts[cnt++] = contact;
		System.out.println("데이터가 저장되었습니다.");
	}

	public void insertContact(int userChoice) {
		System.out.println("연락처 등록을 시작합니다.");
		System.out.println("이름 >>");
		String name = sc.nextLine();

		System.out.println("전화번호 >>");
		String phoneNumber = sc.nextLine();

		System.out.println("이메일 >>");
		String email = sc.nextLine();

		System.out.println("주소 >>");
		String address = sc.nextLine();

		System.out.println("생일 >>");
		String birthday = sc.nextLine();

		System.out.println("그룹 >>");
		String group = sc.nextLine();

		if (userChoice == 1) {
			System.out.println("회사이름 >>");
			String companyName = sc.nextLine();

			System.out.println("부서이름 >>");
			String divName = sc.nextLine();

			System.out.println("직급>>");
			String job = sc.nextLine();

			addContact(
					new CompanyContact(name, phoneNumber, email, address, birthday, group, companyName, divName, job));
		
		} else {
			System.out.println("거래처  회사명>>");
			String customerName = sc.nextLine();

			System.out.println("거래품목>>");
			String product = sc.nextLine();

			System.out.println("직급>>");
			String job = sc.nextLine();

			addContact(new CustomerContact(name, phoneNumber, email, address, birthday, group, customerName, product,
					job));
		}

	}

	public void printAllData() {

		System.out.println("리스트를 출력합니다.(" + cnt + "명)");
		System.out.println("===========================");

		for (int i = 0; i < cnt; i++) {
			contacts[i].showData();
			System.out.println("----------------------");
		}
	}

	private int searchIndex(String name) {
		int index = -1;

		for (int i = 0; i < cnt; i++) {
			if (contacts[i].getName().equals(name)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public void searchPrint() {

		System.out.println("검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력하세요. >>");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			// 찾는 데이터가 없다
			System.out.println("찾으시는 이름" + name + "의 정보가 존재하지 않습니다.");
		} else {
			// 데이터 출력
			System.out.println("검색결과 입니다.");
			System.out.println("--------------------");
			contacts[index].showData();
			System.out.println("-----------------------");
		}
	}

	// 이름으로 검색 -> 해당 데이터 삭제
	public void deleteContact() {
		System.out.println("데이터를 삭제합니다.");
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");

		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("삭제하고자 하는 이름" + name + "의 데이터가 존재하지 않습니다.");
		} else {
			// 삭제처리 : index 위치의 참조값을 index + 1 위치의 값으로 치환, 시프트
			for (int i = index; i < cnt - 1; i++) {
				contacts[index] = contacts[index + 1];
				cnt--;
			}

			System.out.println(name + "의 데이터가 삭제되었습니다.");
		}
	}

	// 이름으로 검색 -> 데이터 수정 : 사용자에게 수정할 데이터를 받아서 처리
	public void editContact() {
		System.out.println("데이터 수정을 시작합니다.");
		System.out.println("변경을 원하는 정보의 이름을 입력하세요. >>");
		String name = sc.nextLine();

		int index = searchIndex(name);

		if (index < 0) {
			System.out.println("찾으시는 이름" + name + "의 정보가 존재하지 않습니다.");
		} else {
			System.out.println("데이터 수정을 위해 각각의 데이터를 입력하세요.");

			System.out.println("연락처 등록을 시작합니다.");
			System.out.println("이름 >>");
			String ename = sc.nextLine();

			System.out.println("전화번호 >>");
			String phoneNumber = sc.nextLine();

			System.out.println("이메일 >>");
			String email = sc.nextLine();

			System.out.println("주소 >>");
			String address = sc.nextLine();

			System.out.println("생일 >>");
			String birthday = sc.nextLine();

			System.out.println("그룹 >>");
			String group = sc.nextLine();

			if (contacts[index] instanceof CompanyContact) { // CompanyContact
				CompanyContact contact = (CompanyContact) contacts[index];

				System.out.println("회사이름을 새로 입력>>");
				String companyName = sc.nextLine();

				System.out.println("부서이름을 새로 입력>>");
				String divName = sc.nextLine();

				System.out.println("직급을 새로 입력>>");
				String job = sc.nextLine();

				contact.setName(ename);
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				contact.setAddress(address);
				contact.setBirthday(birthday);
				contact.setGroup(group);
				contact.setCompanyName(companyName);
				contact.setDivName(divName);
				contact.setJob(job);

			} else { // CustomerContact
				CustomerContact contact = (CustomerContact) contacts[index];

				System.out.println("거래처 회사명을 새로 입력>>");
				String customerName = sc.nextLine();

				System.out.println("거래품목을 새로 입력>>");
				String product = sc.nextLine();

				System.out.println("직급을 새로 입력>>");
				String job = sc.nextLine();

				// Contact c
				contact.setName(ename);
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				contact.setAddress(address);
				contact.setBirthday(birthday);
				contact.setGroup(group);
				contact.setCustomerName(customerName);
				contact.setProduct(product);
				contact.setJob(job);

			}

			System.out.println(name + " 의 정보가 수정되었습니다.");
		}
	}

}
