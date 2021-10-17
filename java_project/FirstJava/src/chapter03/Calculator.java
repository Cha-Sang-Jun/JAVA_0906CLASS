package chapter03;

import java.util.Scanner;

public class Calculator {
	// final 변수 앞에 -> 상수 또는 클래스 앞에 사용 -> 상속의 대상이 아니다(상속을 하여 파생클래스 등을 만들지 못함)
	// java에서 상수: 변수의 최초 초기화된 값을 바꾸지 못한다
	final float PI = 3.1415f;
	final String USER_NAME; // 인스턴스 변수 -> 값이 자동으로 초기화

	// 생성자 : 초기화 메소드, 메소드 구조와 유사하지만 반환 기능은 없다. (따라서 앞에 반환 타입은 쓰지 않음)
	// 클래스이름() {} 의 형식
	// 예시 :
	Calculator(String name) {
		USER_NAME = name;
	}
	// 호출시 : new Calculator("손");

//	① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의 
	public void plus(int num1, int num2) {
		long result = (long) num1 + num2; // long + int -> (자동형변환) long + long 의 계산 결과로 나온다
		System.out.println(num1 + "+" + num2 + "=" + result);
	}

//	② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	public void minus(int num1, int num2) {
		long result = (long) num1 - num2;
		System.out.println(num1 + "-" + num2 + "=" + result);
	}
	// 이항연산의 방향 ----> 방향으로 진행
	// 만약 '문자열 - 숫자' 의 계산이 된다면 오류가 발생하므로() 처리 필요

//	③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의 
	public void multyply(long num1, long num2) {
		long result = (long) num1 * num2;
		System.out.println(num1 + "*" + num2 + "=" + result);
	}

//	④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의 
	public void devide(int num1, int num2) {
		float result = (float) num1 / num2;
		System.out.println((num1 + "/" + num2 + "=" + result));
	}

//	⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
	float circum(float r) {
		return (2 * PI * r); // int * float * float
	}

//	⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의 원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r 
	float cirArea(float r) {
		return (PI * r * r);
	}

//	⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다. 
	public static void main(String[] args) {

		Calculator cal = new Calculator("손흥민");

		// 상수 출력
		System.out.println("PI: " + cal.PI);
		System.out.println("User Name = " + cal.USER_NAME);

//		cal.USER_NAME = "이강인"; // 상수의 값을 변경하는 것은 안된다.

		cal.plus(3, 2);

//	⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드 에 추가해봅시다.
		Scanner scanner = new Scanner(System.in);

		System.out.println("덧셈을 시작합니다. \n 숫자1을 입력해주세요.");
		int num1 = Integer.parseInt(scanner.nextLine()); // integer wrapper 클래스
		// System.out.println(num1);
		System.out.println("숫자2을 입력해주세요.");
		int num2 = Integer.parseInt(scanner.nextLine());
		
		cal.plus(num1, num2);
		
		System.out.println("-----------------------------------");
		System.out.println("원의 둘레와 넓이를 구합니다. \n 반지름을 입력해주세요.");
		float r = Float.parseFloat(scanner.nextLine()); // float 으로 변환하는 메소드
		
		System.out.println("전달받은 반지름" + r);
		System.out.println("원의 둘레" + cal.circum(r));
		System.out.println("원의 넓이" + cal.cirArea(r));
	}
}
