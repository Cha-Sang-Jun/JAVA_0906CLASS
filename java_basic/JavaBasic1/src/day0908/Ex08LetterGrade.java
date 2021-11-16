package day0908;
// 사용자로부터 점수를 입력받아서
// 90 ~ : A
// 80~: B
// 70~: C
// 60~: D
// 그 외 : F
// 가 출력되는 프로그램 작성

import java.util.Scanner;
public class Ex08LetterGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력해주세요.");
        System.out.print("> ");
        int grade = scanner.nextInt();
        
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if (grade >= 60 ) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        
        
        scanner.close();
    }

}
