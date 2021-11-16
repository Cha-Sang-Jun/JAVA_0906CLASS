package day0906;
// 변수(Variable)
// 변수란 공간안의 저장된 값이 변경될 수 있는 공간을 변수라고 한다.

// 변수의 경우, 사용하기 위해선 반드시 선언과 초기화를 해야한다.
// 변수의 선언방법
// 데이터타입 변수이름;
// 변수의 초기화방법
// 변수이름 = 데이터타입과 일치하는 값;


public class Ex03Variable {
    public static void main(String[] args) {
       // int 데이터타입을 가진 변수 number를 선언해보자
        int number;
        
        // int 데이터타입 변수 number에 20을 초기화해보자
        number = 20;
        
        // 화면에 number에 현재 저장된 값을 출력해보자
        System.out.println(number);
        
        // int 데이터타입 변수 number에 30을 저장해보자
        // 저장과 초기화 모두 = 를 사용하면된다.
        number = 30;
        
        // 화면에 number에 현재 저장된 값을 출력해보자
        System.out.println(number);
    }

}
