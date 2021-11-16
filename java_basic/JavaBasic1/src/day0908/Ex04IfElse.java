package day0908;
// if - else 문
// if - else 구조는
// 만약 if문의 조건식이 false가 나오면
// 무조건 else가 실행되는 구조이다.
// 반대로, if문의 조건식이 true가 나오면 if문의 코드 블락만 실행된다.

// if else 구조는 다음과 같이 이루어져 있다.
// if(조건식) {
//    조건식이 true일 때 실행할 코드 블락
// } else {
//    조건식이 false 일 때 실행할 코드 블락
// }

public class Ex04IfElse {
    public static void main(String[] args) {
        int num = -5;
        
        if(num > 0) {
            System.out.println("자연수입니다.");
        } else {
            System.out.println("자연수가 아닙니다.");
        }
        

        System.out.println("프로그램 종료");
    }

}
