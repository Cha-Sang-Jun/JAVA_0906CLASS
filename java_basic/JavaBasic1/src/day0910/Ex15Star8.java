package day0910;

import java.util.Scanner;

public class Ex15Star8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("출력할 행 수를 입력해주세요");
		System.out.print("> ");

		int userNum = scanner.nextInt();

		for (int i = 1; i <= 2 * userNum - 1; i++) {
			String stars = "";

			if (i < userNum) {
				// 윗부분

				// 공백을 담당하는 j for문
				for (int j = 1; j <= userNum - i; j++) {
					stars += " ";
				}

				// 별
				for (int j = 1; j <= i; j++) {
					stars += "*";
				}
				System.out.println(stars);

			} else {
				// i < userNum일때는 위쪽의 코드 실행 i>userNum일때는 
				// else부분 부터 실행 (5입력했을때 5부터)
				// 아랫부분

				// 공백 j for문
				for (int j = 1; j <= (i - userNum + 1) - 1; j++) {
					stars += " ";
				}

				// 별 j for문
				for (int j = (i - userNum + 1); j <= userNum; j++) {
					stars += "*";

				}

				System.out.println(stars);
			}

		}

		scanner.close();

	}

}
