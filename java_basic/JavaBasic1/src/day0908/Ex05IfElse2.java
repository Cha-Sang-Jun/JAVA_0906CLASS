package day0908;

// 1번부터 6번까지
// 그 반대되는 경우 생각하여 코드 작성

import java.util.Scanner;

public class Ex05IfElse2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------1번-------");
        int num = 6;
        if (num < 5) {
            System.out.println("5보다 작다.");
        } else {
            System.out.println("5보다 크다.");
        }
        System.out.println("--------------------\n");

        System.out.println("------2번-------");
        num = 11;
        if (num % 2 == 0) {
            System.out.println("짝수다");
        } else {
            System.out.println("홀수다");
        }
        System.out.println("------------------------\n");

        System.out.println("-----------3번-------------");
        System.out.println("숫자를 입력해주삼");
        System.out.print("> ");
        num = scanner.nextInt();

        if (num % 6 == 0) {
            System.out.println("6의 배수다");
        } else {
            System.out.println("6의 배수가 아니다");
        }
        System.out.println("--------------------\n");

        System.out.println("-----------4번---------");
        System.out.println("나이를 입력해주삼");
        System.out.print("> ");
        int age = scanner.nextInt();
        if (age < 19) {
            System.out.println("미성년자");
        } else {
            System.out.println("성인");
        }
        System.out.println("----------------------\n");

        System.out.println("------5번------");
        System.out.println("숫자 입력");
        System.out.print("> ");
        num = scanner.nextInt();
        if (num >= 50 && num < 60) {
            System.out.println("50번대 숫자");
        } else {
            System.out.println("50번대 숫자 아님");
        }
        System.out.println("------------------\n");

        System.out.println("----------6번-----------");
        scanner.nextLine();

        System.out.println("아이디를 입력해주세요.");
        System.out.print("> ");
        String username = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요.");
        System.out.println("> ");
        String password = scanner.nextLine();

        if (username.equalsIgnoreCase("admin") && password.equals("111")) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        scanner.close();
    }

}
