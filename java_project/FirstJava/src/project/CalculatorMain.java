package project;

//3.다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해 봅시다.

public class CalculatorMain extends CalculatorClass implements Calculator{
	public static void main(String[] args) {
		CalculatorClass cal = new CalculatorClass();
		long n1 = 5;
		long n2 = 2;
		
		System.out.println(cal.add(n1, n2));
		System.out.println(cal.substract(n1, n2));
		System.out.println(cal.multiply(n1, n2));
		System.out.println(cal.divide(n1, n2));
		
	}
}
