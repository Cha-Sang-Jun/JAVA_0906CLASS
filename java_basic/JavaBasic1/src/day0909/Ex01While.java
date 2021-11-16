package day0909;
// 반복문
// 반복문이란, 특정 코드 블락을 조건식이 true가 나오는 동안 계속 반복하여 실행시키는
// 특수한 코드를 반복문이라고 한다.

// while 반복문
// while 반복문은 if문과 구조가 비슷한데
// if문의 경우 ()의 조건식이 true가 나오면 코드 블락을 실행시켰지만
// while문은 ()의 조건식이 true가 나오는 동안 코드 블락을 실행시킨다.

// while문의 구조
// while(조건식) {
//    조건식이 true 일 때 실행할 코드
// }

public class Ex01While {
    public static void main(String[] args) {
        int num = 3;
        while(num <= 5) {
            System.out.println("while문 반복");
            System.out.println("num의 현재 값: " + num);
            num++;
            
        }
        
        
    }

}
