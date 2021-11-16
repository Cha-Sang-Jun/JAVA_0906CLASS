package day0909;
// 사용자로부터  

// 번호, 이름, 국어, 영어, 수학 점수 순으로 입력 받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성

// 결과)))
// 번호: ##번, 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##.##점

import java.util.Scanner;

public class Ex04GradeBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 과목의 갯수를 저장할 상수 (소프트코딩 방식)
        final int SUBJECT_SIZE = 3;

        // 번호 입력
        System.out.println("번호를 입력해주세요.");
        System.out.print("> ");

        // 학생의 번호, 사원의 번호, 회원의 번호 등
        // 한개의 정보에 부여된 고유한 번호는 주로 id 라는 이름을 사용
        int id = scanner.nextInt();

        // 이름 입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        // 버퍼메모리의 엔터키를 없애기 위해
        // scanner.nextLine()을 한번 실행시킨다.
        scanner.nextLine();
        String name = scanner.nextLine();

        // 국어 입력
        System.out.println("국어점수를 입력해주세요.");
        System.out.print("> ");
        int korean = scanner.nextInt();

        while (korean > 100 || korean < 0) {
            System.out.println("잘못된 점수입니다. 점수를 다시 입력해주세요");
            System.out.print("> ");

            korean = scanner.nextInt();
        }

        // 영어 입력
        System.out.println("영어점수를 입력해주세요.");
        System.out.print("> ");
        int english = scanner.nextInt();

        while (english > 100 || english < 0) {
            System.out.println("잘못된 점수입니다. 점수를 다시 입력해주세요");
            System.out.print("> ");

            english = scanner.nextInt();
        }

        // 수학 입력
        System.out.println("수학점수를 입력해주세요.");
        System.out.print("> ");
        int math = scanner.nextInt();

        while (math > 100 || math < 0) {
            System.out.println("잘못된 점수입니다. 점수를 다시 입력해주세요");
            System.out.print("> ");

            math = scanner.nextInt();
        }

        // 총점 계산
        int sum = korean + english + math;

        // 평균 계산
        double average = (double) sum / SUBJECT_SIZE;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학:%03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

        System.out.println("\n--------------------\n");

        // 상수
        final int SUB = 3;

        // 사용자가 입력한 int 값을 임시로 보관할 변수
        int temp;

        // 번호
        System.out.println("번호를 입력해주세요");
        System.out.print("> ");
        int id2 = scanner.nextInt();

        // 이름
        System.out.println("이름");
        System.out.print("> ");
        scanner.nextLine();
        String name2 = scanner.nextLine();

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

        int korean2 = temp;

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

        int english2 = temp;

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

        int math2 = temp;

        // 총점
        int sum2 = korean2 + english2 + math2;
        
        // 평균
        double average2 = (double)sum2 / SUB;
        
        // 결과
        
        scanner.close();

    }

}
