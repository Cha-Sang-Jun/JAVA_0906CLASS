package day0913;
// switch 조건문
// switch 조건문의 경우, if 조건문과는 다르게
// 변수를 하나 선택하여
// 그 변수의 값에 대한 코드 처리를 하게 된다.
// 또한, 명확하게 값이 나뉘는 변수들에 대해서만 switch 조건문을 만들어 줄 수 있기 때문에
// 정수형, 문자형 변수 혹은 연산의 결과값에 대해서만 switch 조건문을 만들 수 있다.
// 실수형 데이터타입은 switch 조건문에서 사용할 수 없다.

public class Ex01Switch {
	public static void main(String [] args) {
		int num = 2;
		
		switch(num *= 1) {
		case 1:
			System.out.println("2입니다.");
			break;
		case 2:
			System.out.println("1입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default :
			System.out.println("그 외 입니다.");
			break;
		}
	}

}
