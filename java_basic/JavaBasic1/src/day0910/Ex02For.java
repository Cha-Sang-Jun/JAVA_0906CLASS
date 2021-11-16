package day0910;
// 반복문 02

// for 반복문
// while 반복문은 횟수에 딱히 구속적인 느낌이 아니지만
// 그에 반해 for문은 비교적 횟수가 명확하게 지정된 반복문이다.

// for 반복문은 다음과 같은 구조를 가진다.
// for(제어변수의 선언과 초기화; 반복 조건식; 반복 후 제어변수의 변화식){
//     반복할 코드
// }

public class Ex02For {

    public static void main(String[] args) {
        // 1. 기본적인 for문
        System.out.println("1. 기본 for문");

        for (int i = 1; i <= 3; i++) {
            System.out.println("i의 현재값: " + i);
        }

        System.out.println("------------------------\n");

        // 2. 전통적으로 for문의 제어변수는 i로 시작하여
        // 중첩되는 레벨에 따라 j, k 순으로 들어가지만
        // 만약 익숙하지 않을 때에는 다른 이름을 사용하더라도 상관 없다.
        System.out.println("2. 제어변수 이름");
        for (int num = 1; num <= 4; num++) {
            System.out.println("num의 현재값: " + num);
        }
        System.out.println("--------------------\n");

        // 3. 우리가 지금은 제어변수의 변화식을 ++을 썼지만
        // 제어변수 안의 값을 변화시킬 수 있는 연산자 혹은 메소드는 모두 가능하다.
        System.out.println("3. 제어변수의 변화식");
        for (int i = 1; i <= 10000; i *= 100) {
            System.out.println("i의 현재값: " + i);
        }

        System.out.println("-----------------------\n");
        
        // 4. 제어변수의 초기화 혹은 반복 조건식에는 다른 변수를 사용할 수 있다.
        int start = 41;
        int end = 45;
        System.out.println("4. 다른 변수 사용하기");
        
        for(int i = start; i <= end; i++) {
            System.out.println("i의 현재값: " + i);
        }
        
        System.out.println("--------------------\n");

        // 5. 만약 반복 조건식이 처음부터 false가 나온다면?
        System.out.println("5. 처음부터 false가 나오면?");
        for(int i = 0; i < 0; i++) {
            System.out.println("i의 현재값: " + i);
        }
        
        System.out.println("-----------------------\n");
    }

}
