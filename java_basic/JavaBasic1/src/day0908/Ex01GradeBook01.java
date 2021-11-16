package day0908;
// 사용자로부터 
// 번호, 이름, 국어, 영어, 수학 점수 순으로 입력 받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성

// 결과)))
// 번호: ##번, 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##.##점

import java.util.Scanner;
public class Ex01GradeBook01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("번호를 입력해주세요");
        // System.out.print("> ");
        // int num = scanner.nextInt();
        
        // System.out.println("번호: \n" + num);
        
        // scanner.nextLine();
        // System.out.println("이름을 입력해주세요");
        // System.out.print("> ");
        // String name = scanner.nextLine();
        
        // System.out.printf("이름: [%s]\n", name);
        
        // System.out.println("국어점수를 입력해주세요");
        // System.out.print("> ");
        // int korean = scanner.nextInt();
        
        // System.out.printf("국어: [%03d]점\n", korean);
        
        // System.out.println("영어점수를 입력해주세요");
        // System.out.print("> ");
        // int english = scanner.nextInt();
        
        // System.out.printf("영어: [%03d]점\n", english);
        
        // System.out.println("수학점수를 입력해주세요");
        // System.out.print("> ");
        // int math = scanner.nextInt();
        
        // System.out.println("수학점수: \n" + math);
 
        // int all = korean + english + math;
       
        // System.out.println("총점: \n" + all);
        
        // double avearge = all / 3.0;
        
        System.out.println("----------------------\n");
        
        // 과목의 갯수를 저장할 상수 (소프트코딩 방식)
        final int SUBJECT_SIZE = 3;
        
        // import java.util.Scanner;
        // 키보드 입력에서 사용할 스캐너 클래스 변수 선언 및 초기화
        // Scanner scanner = new Scanner(System.in);
        // 버퍼메모리 해제를 위한 스캐너 클래스 변수의 close() 실행
        
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
        
        // 영어 입력
        System.out.println("영어점수를 입력해주세요.");
        System.out.print("> ");
        int english = scanner.nextInt();
        
        // 수학 입력
        System.out.println("수학점수를 입력해주세요.");
        System.out.print("> ");
        int math = scanner.nextInt();
        
        // 총점 계산
        int sum = korean + english + math;
        
        // 평균 계산
        double average = (double)sum / SUBJECT_SIZE;
        // 하드코딩과 소프트코딩
        // 하드코딩이란? ("경직된 코딩")
        // 코드 안에 매직 넘버 등을 적극적으로 사용해서
        // 유지보수가 어려워지는 코딩 방식
        // 단, 간단한 프로그래밍을 할 경우에는
        // 오히려 하드코딩이 난이도가 낮고 개발 속도가 빨라짐.
        
        // 소프트코딩이란? ("유연한 코딩")
        // 코드 안에 매직 넘버 사용을 절대로 하지 않고
        // 많은 변수와 상수를 만들어서 유지보수 할 때 쉽게 할 수 있게 하는 코딩 방식
        // 단, 간단한 프로그래밍의 경우 오히려 난이도가 높아지고 개발 속도가 느려짐.
        
        // 결과 출력
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학:%03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
        // 버퍼메모리 해제를 위한 스캐너 클래스 변수의 close() 실행
        scanner.close();
        
    }

}
