package day0910;

import java.util.Scanner;

public class Ex08Star2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("출력할 줄 수를 입력하세요.");
		System.out.print("> ");

		int userNum = scanner.nextInt();

//            for(int i=1; i <= userNum; i++) {
//                for(int j = userNum; j >= i; j--) {
//                    System.out.print("*");
//                }
//                System.out.println("");
//            }

		for (int i = 1; i <= userNum; i++) {
			String stars = "";

			for (int j = i; j <= userNum; j++) {
				stars += "*";
			}

			System.out.println(stars);
		}

		scanner.close();
	}
}
