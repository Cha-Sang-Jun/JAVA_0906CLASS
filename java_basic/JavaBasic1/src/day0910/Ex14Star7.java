package day0910;

import java.util.Scanner;

public class Ex14Star7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 7번 윗부분과 1번 부분이 똑같음
        System.out.println("출력할 행 수를 입력해주세요.");
        System.out.print("> ");

        int userNum = scanner.nextInt();

        for (int i = 1; i <= userNum; i++) {
            String stars = "";
            // 윗부분
            for (int j = 1; j <= i; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
        // 아랫부분
        for (int i = 2; i <= userNum; i++) {
            String stars = "";

            for (int j = i; j <= userNum; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }

        scanner.close();
    }

}
