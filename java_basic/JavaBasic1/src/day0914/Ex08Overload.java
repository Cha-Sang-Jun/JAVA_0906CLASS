package day0914;
// 메소드 오버로드

// 오버로드란, 똑같은 목적을 가지고 있을 경우
// 메소드의 이름을 통일 시켜서 코드의 가독성을 높여주는 방법이다.
// 하지만 똑같은 이름의 메소드를 만들 때 주의할 점이 있는데,
// 반드시 파라미터의 내용이 달라야 한다는 것이다.

public class Ex08Overload {
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static double add(double a, double b) {
		return a+b;
	}
	
	public static double add(int a, double b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println(add(3,4));
		System.out.println(add(3.0, 4.0));
		System.out.println(add(3,4.9));
		System.out.println(add(4.2,3));
		
	}
}
