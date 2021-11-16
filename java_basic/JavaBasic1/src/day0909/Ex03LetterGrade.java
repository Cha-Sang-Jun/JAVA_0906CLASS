package day0909;
// 사용자로부터 점수를 입력받아

// A,B,C,D,F 가 알맞게 출력되는 프로그램을 작성
// 단, 사용자가 잘못된 점수를 입력할 경우, 올바른 점수가 입력될 때까지
// 다시 입력을 받도록 작성

import java.util.Scanner;

public class Ex03LetterGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력해주세요");
        System.out.print("> ");

        int grade = scanner.nextInt();

        while (grade > 100 || grade < 0) {
            System.out.println("잘못된 입력입니다.");

            System.out.println("점수를 입력해주세요");
            System.out.print("> ");

            grade = scanner.nextInt();
        }
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if (grade >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        
        scanner.close();
    }

}
