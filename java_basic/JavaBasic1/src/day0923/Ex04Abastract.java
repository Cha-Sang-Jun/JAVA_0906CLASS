package day0923;
// 추상 클래스, 추상 메소드, 인터페이스 
// 클래스 상속은 우리가 코드의 재사용성을 높이기 위해 사용한다.
// 그에 반해서 추상 클래스, 추상 메소드, 그리고 인터페이스 상속은
// 코드의 재사용성 보다는 다형성을 부여하기 위해 사용된다.

import classEx.AnimalA;
import classEx.Dog;
import classEx.Cat;

public abstract class Ex04Abastract {
	public static void main(String[] args) {
		// 추상 클래스는 구현되지 않은 메소드가 존재하므로
		// 해당 클래스의 생성자를 우리가 직접 호출할 수 없다.
		// 대신 그 클래스를 상속받는 클래스의 생성자가 필요로 한다.
		
		AnimalA a = new Dog();
		observe(a); 
		// observe("abc") 는 안되는 이유 -> 데이터타입이 안맞음. 스트링에는 makeSound나 move라는 메소드는 없다.
		
		// 인터페이스도 추상 클래스와 매우 유사하지만
		// 달라지는 점은, 실제로 구현되는 메소드가 존재하는 추상 클래스와 다르게
		// 인터페이스는 모든 메소드가 추상 메소드란 것이다.
	}
	
	public static void observe(AnimalA a) {
		a.makeSound();
		a.move();
	}
	
}
