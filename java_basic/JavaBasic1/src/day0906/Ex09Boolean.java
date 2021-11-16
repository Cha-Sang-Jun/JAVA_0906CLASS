package day0906;
// 기본형 데이터타입04
// 논리형 기본데이터타입

// 논리형 기본 데이터타입은 boolean 이라고 하는 데이터타입으로써
// true 혹은 false 의 단 두가지 값만 저장 가능하다.

// boolean 데이터타입의 경우, 우리가 직접 변수를 만들어서 쓰기보다는
// 해당 값이 결과값으로 나오는 연산자 혹은 메소드의 결과값을 그대로 쓰는 경우가 많다.

// 또한 boolean 타입의 값은 우리가 나중에 배우게 될
// 제어문이라는 개념에서 매우 중요한 역할을 하게 된다.

public class Ex09Boolean {
    public static void main(String[] args) {
        // boolean 데이터타입 변수 b를 만들고 true를 초기화해보자
        boolean b = true;
        
        // b의 현재 값을 화면에 출력해보자
        System.out.println(b);
        
        // b에 false를 저장해보자
        b = false;
        System.out.println(b);
    }

}
