package exam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
//	2. Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다. 
//	이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다.
	public static void main(String[] args) {
		System.out.println("태어난 년도를 입력해주세요.");
		System.out.println("> ");

		while (true) {

			try {
				Scanner sc = new Scanner(System.in);
				int birthYear = sc.nextInt();
				System.out.println("태어난 년도는" + birthYear + "입니다.");
				break;
				
			} catch (InputMismatchException e) {
				System.out.println("태어난 년도를 다시 입력해주세요");
//				System.out.println(e.getMessage());
//				e.printStackTrace();

			} catch (Exception e) {
				System.out.println("태어난 년도를 다시 입력해주세요.");
//				System.out.println(e.getMessage());
//				e.printStackTrace();
			}

		}
	}
}
