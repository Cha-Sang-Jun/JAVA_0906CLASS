package day0908;
// 제어문(Control Statement)

// "제어하는 코드"
// 제어문이란 코드의 실행 혹은 반복 여부를 결정하는 특수한 코드이다.
// 제어문에는 크게 조건문과 반복문이 있다.

// 조건문: 특정 조건을 만족시 코드 블락을 실행
// 반복문: 특정 조건을 만족하는동안 코드 블락을 반복

// 코드 블락(Code Block)
// 코드 블락이란, 한 개의 {} 를 코드 블락이라고 한다.
// 코드 블락이 중요한 이유는 변수의 유효범위(scope)와 연결이 되기 때문이다.
// 어떤 변수의 유효범위는 선언된 이후부터 그 변수가 선언된 코드 블락이 종료될 때 까지이다.

// 어떤 변수의 유효범위 안에서는 똑같은 이름의 다른 변수는 선언할 수 없다.
// 또한, 유효범위가 끝나면 해당 변수는 삭제되므로 호출할 수 없는 대신,
// 같은 이름의 다른 변수는 선언할 수 있다.

// 조건문 01
// if 조건문
// if 조건문은 true/false가 결과값으로 나오는 코드, 즉 조건식을 실행시켜서
// true가 나오면 코드 블락을 실행시키고
// false가 나오면 실행시키지 않는다.

// if문은 기본적으로 다음과 같은 구조를 가진다.
// if(조건식) {
//    실행할 코드 블락
// }

public class Ex02If {
    public static void main(String[] args) {
        int num = 2;

        if (num > 0) {
            System.out.println("num은 1이상입니다.");
            int num2 = 14;

            System.out.println("num2: " + num2);
        }

        // System.out.println("num2: " + num2); -> if문이 끝나면서 num2는 삭제됨.
        // code가 들여쓰기가 뒤죽박죽되서 엉망일 때 -> ctrl + shift + f (단, 에러가 없어야함)

        System.out.println(num);

        System.out.println("프로그램 종료");
    }
}
