package day0910;

import java.util.Scanner;

public class Ex04For3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 3번.
        for (int i = 7; i <= 11; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // 4번.
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }

        System.out.println("=======================\n");
        // 5번.
        System.out.println("5번.");
        System.out.println("첫번쨰 숫자를 입력해주세요.");
        System.out.print("> ");
        int num1 = scanner.nextInt();

        System.out.println("두번째 숫자를 입력해주세요");
        System.out.print("> ");
        int num2 = scanner.nextInt();

        int start;
        int end;

        if (num1 < num2) {
            start = num1;
            end = num2;
        } else {
            start = num2;
            end = num1;
        }
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }

        System.out.println("======================\n");

        // 6번.
        System.out.println("6번.");

        // 합을 저장할 변수
        int sum = 0;

        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.printf("1부터 %d까지의 합: %d\n", num, sum);

        System.out.println("=======================\n");

        // 7번.
        System.out.println("7번.");

        sum = 1;

        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            sum *= i;
        }
        System.out.printf("1부터 %d까지의 곱: %d\n", num, sum);

        scanner.close();
    }

}
