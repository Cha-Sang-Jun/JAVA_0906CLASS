package ver06;


// 2. 연락처 이름 이력 시에 공백에 대한 예외처리와 영문자와 한글만 허용하는 예외 처리를 해봅시다. 
// 3. 전화번호 형식에 맞지 않을 때 예외처리를 하고 중복될 때 예외 상황이 발생하도록 하고 예외 처리를 합시다. 

import java.util.Scanner;
import java.util.regex.Pattern;

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
			phoneNum[i].showData();
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
			phoneNum[index].showData();
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
			String callNum = getNum();

			System.out.println("새로운 이메일을 입력해주세요.");
			String email = sc.nextLine();

			System.out.println("새로운 주소를 입력해주세요.");
			String address = sc.nextLine();

			System.out.println("새로운 생일을 입력해주세요.");
			String birth = sc.nextLine();

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
				contact.setBirth(birth);
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
				contact.setBirth(birth);
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
		String name = getString();

		System.out.println("전화번호를 입력해주세요.");
		System.out.println("> ");
		String callNum = getNum();

		System.out.println("이메일을 입력해주세요.");
		System.out.println("> ");
		String email = getString();

		System.out.println("주소를 입력해주세요.");
		System.out.println("> ");
		String address = getString();

		System.out.println("생일을 입력해주세요.");
		System.out.println("> ");
		String birth = getString();

		System.out.println("그룹이름을 입력해주세요.");
		System.out.println("> ");
		String group = getString();

		if (userChoice == 1) {
			System.out.println("회사이름을 입력해주세요.");
			System.out.println("> ");
			String companyName = getString();

			System.out.println("부서이름을 입력해주세요.");
			System.out.println("> ");
			String departName = getString();

			System.out.println("직급을 입력해주세요.");
			System.out.println("> ");
			String rank = getString();

			addList(new CompanyContact(name, callNum, email, address, birth, group, companyName, departName, rank));

		} else {
			System.out.println("거래처 회사명을 입력해주세요.");
			System.out.println("> ");
			String customerName = getString();

			System.out.println("거래품목을 입력해주세요.");
			System.out.println("> ");
			String product = getString();

			System.out.println("직급을 입력해주세요.");
			System.out.println("> ");
			String rank = getString();

			addList(new CustomerContact(name, callNum, email, address, birth, group, customerName, product, rank));
		}
		System.out.println("연락처 정보가 입력되었습니다.");

	}

	// 특수문자와 공백 입력은 다시 입력받는 메소드
	public static String getString() {
		String result = null;

		String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$";

		while (true) {
			result = sc.nextLine();
			if (!Pattern.matches(pattern, result)) {
				System.out.println("특수문자와 공백은 입력 할 수 없습니다.");
				System.out.println("다시 입력해주세요.");

			} else {
				break;
			}
		}

		return result;
	}

	// 이미 같은 전화번호가 들어왔는지 확인 후 결과 반환
	public boolean getNum(String number) {
		boolean check = false;
		for (int i = 0; i < numOfContact; i++) {
			if (phoneNum[i].getCallNum().equals(number)) {
				check = true;
				break;
			}

		}

		return check;
	}

	public String getNum() {
		String number = null;

		while (true) {
			number = sc.nextLine();

			boolean check = false;

			if (number.length() > 0) {
				for (int i = 0; i < numOfContact; i++) {
					if (phoneNum[i].getCallNum().contentEquals(number)) {
						check = true;
						System.out.println("같은번호가 존재합니다. 다시 입력해주세요.");
						break;
					}
				}
				if (!check) {
					break;
				}
			}
		}
		return number;
	}

}
