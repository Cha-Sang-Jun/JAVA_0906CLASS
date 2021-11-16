package day0909;

import java.util.Scanner;

public class Ex11GradeBook2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SUB = 3;

        int id = 0;
        String name = "";
        int korean = 0;
        int english = 0;
        int math = 0;

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 입력 코드
                int temp;

                // 번호
                System.out.println("번호를 입력해주세요");
                System.out.print("> ");
                id = scanner.nextInt();

                // 이름
                System.out.println("이름");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                // 국어
                System.out.println("국어 점수");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= 0 && temp <= 100)) {
                    System.out.println("잘못 입력하셨습니다");

                    System.out.println("국어점수");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                korean = temp;

                // 영어
                System.out.println("영어 점수");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= 0 && temp <= 100)) {
                    System.out.println("잘못 입력하셨습니다");

                    System.out.println("영어점수");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                english = temp;

                // 수학
                System.out.println("수학 점수");
                System.out.print("> ");
                temp = scanner.nextInt();

                while (!(temp >= 0 && temp <= 100)) {
                    System.out.println("잘못 입력하셨습니다");

                    System.out.println("수학점수");
                    System.out.print("> ");
                    temp = scanner.nextInt();
                }

                math = temp;
            } else if (userChoice == 2) {
                // 총점
                int sum = korean + english + math;

                // 평균
                double average = (double) sum / SUB;

                // 결과 출력
                System.out.printf("번호: %d번 이름: %s\n", id, name);
                System.out.printf("국어: %03d점 영어: %03d점 수학:%03d점\n", korean, english, math);
                System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

            } else if (userChoice == 3) {
                // 종료
                System.out.println("감사합니다.");
                break;
            }
        }

        scanner.close();

    }

}
