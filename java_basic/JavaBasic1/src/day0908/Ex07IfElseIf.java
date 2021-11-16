package day0908;
// if - else if 구조
// if - else if 구조에서는
// if의 조건식이 false가 나오면
// 그 다음 else if 조건식을 체크하는 식으로 하는 구조로써
// 최종적으로 여러 조건을 체크할 수 있게 되는 구조이다.
// if - else 때와 마찬가지로, 오직 한개의 코드 블락만이 실행 된다.

// if - else if 구조
// if(조건식1) {
//    조건식1이 true 일 떄 실행할 코드 블락
// } else if(조건식2) {
//    조건식2가 true 일 때 실행할 코드 블락
// } else if ....
//
// } else {
//      위 조건식이 모두 false 일 때 실행할 코드 블락
// }

public class Ex07IfElseIf {
    public static void main (String[] args) {
        int num = 0;
        
        if(num > 0) {
            System.out.println("자연수입니다.");
        } else if (num < 0) {
            System.out.println("음의 정수입니다.");
        } else {
            System.out.println("0입니다.");
        }
    }

}
