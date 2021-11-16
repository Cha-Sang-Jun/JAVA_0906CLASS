package day0908;
// 사용자로부터
// 이름 국어 영어 수학 순으로 입력 받아서
// 만약 총점이 210점 미만이거나
// 한 과목이라도 60점 미만일 대는
// '###' 학생은 불합격입니다." 라고 출력되고
// 그 외는 " ### 학생은 합격입니다." 라고 출력되는 프로그램 작성

import java.util.Scanner;
public class Ex06IfElse3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        
        String username = scanner.nextLine();
        
        System.out.println("국어점수를 입력해주세요.");
        System.out.print("> ");
        
        int korean = scanner.nextInt();
        
        System.out.println("영어점수를 입력해주세요.");
        System.out.print("> ");
        
        int english = scanner.nextInt();
        
        System.out.println("수학점수를 입력해주세요.");
        System.out.print("> ");
        
        int math = scanner.nextInt();
        
        int sum = korean + english + math;
        
        if (sum < 210 || korean < 60 || english < 60 || math < 60) {
            System.out.printf("\"'[%s]' 학생은 불합격입니다.\"\n", username);
        } else {
            System.out.printf("\"'[%s]' 학생은 합격입니다.\"\n", username);
        }

        System.out.println("----------------------------\n");
        
        // 총점 기준
        final int SUM_STANDARD = 210;
        
        // 과목별 기준
        final int SUBJECT_STANDARD = 60;
        
        // 이름 입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name = scanner.nextLine();
        
        // 국어 입력
        System.out.println("국어점수를 입력해주세요.");
        System.out.print("> ");
        int korean2 = scanner.nextInt();
        
        // 영어 입력
        System.out.println("영어점수를 입력해주세요.");
        System.out.print("> ");
        int english2 = scanner.nextInt();
        
        // 수학 입력
        System.out.println("수학점수를 입력해주세요.");
        System.out.print("> ");
        int math2 = scanner.nextInt();
        
        // 총점 계산
        int sum2 = korean2 + english2 + math2;
        
        if(sum2 < SUM_STANDARD || korean2 < SUBJECT_STANDARD || english2 < SUBJECT_STANDARD || math2 < SUBJECT_STANDARD) {
            System.out.println(name + "학생은 탈락입니다");
        } else {
            System.out.println(name + "학생은 합격입니다.");
        }
        
        scanner.close();
    }
}
