package exam;

import java.util.Scanner;

public class ExceptionTest {
// 1. 콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
//	① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
//	② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.
	public static void main(String[] args) {

		System.out.println("아이디를 입력해주세요.");
		System.out.println("> ");

		while (true) {

			try {
				String id = getId();
				System.out.println("입력하신 아이디는" + id + "입니다.");
				break;

			} catch (BadInputException e) {
				System.out.println("> ");
				System.out.println(e.getMessage());
//				e.printStackTrace();
			}

			
		}
	}

	public static String getId() throws BadInputException {

		String id = null;

		Scanner sc = new Scanner(System.in);
		id = sc.nextLine();

		boolean result = id.matches("[0-9|a-z|A-Z]*");

		if (result == false) {
			BadInputException e = new BadInputException();

			throw e;
		}

		return id;

	}

}
