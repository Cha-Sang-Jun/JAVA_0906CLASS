package day0923;
// 상속(Inheritance)  
// 상속이란, 부모 클래스의 메소드 또는 필드를 자식 클래스가
// 또 적어주지 않더라도 그대로 받아서 쓸 수 있게 만들어 주는 것을 상속이라고 한다.

import classEx.Animal; 
import classEx.Gorilla;
import classEx.Monkey;
import classEx.Student;

// 상속은 사실 클래스 상속과 인터페이스 상속으로 나뉘는데
// 클래스 상속의 목적은 코드의 재사용성을 높이기 위함이고
// 인터페이스 상속의 목적은 다형성(Polymorphism)을 위한 것이다.

// 상속을 하는 방법:
// public class 자식클래스 extends 부모클래스 {
// 
// }

// 자식 클래스의 객체를 초기화할 때에는
// 부모 클래스의 생성자가 먼저 호출 되고 그 다음에 자식 클래스의 생성자가 호출이 된다.

// 오버라이드(Override)
// 오버라이드란 부모클래스로부터 상속받은 메소드가
// 자식 클래스가 사용하기 부적절한 경우,
// 자식 클래스에서 재정의를 하여, 자식 클래스가 적절하게 사용할 수 있도록
// 상속받은 메소드를 "덮어씌우는것" 을 오버라이드라고 한다.
// 단, 오버라이드를 할 시에 주의할 점은
// 부모클래스가 선언한대로 똑같이 선언해주어야 한다는 것이다.

// java.lang.Object
// Object란? 객체를 뜻한다(Object Oriented Programming -> 객체 지향 프로그래밍)
// 자바의 모든 클래스는 java.lang.Object를 직접적으로나 간접적으로나 상속을 받는다.
// 이 java.lang.Object는 말 그대로 클래스들의 원본이라고 할 수 잇는데
// 이 Object라는 클래스 안에는 객체를 사용하는데 필요한 몇 가지 메소드들이 만들어져 있다.
// 대표적으로 기본형 데이터타입 필드는 0으로, 참조형 데이터타입 필드는 null로 초기화해주는 기본생성자
// 두 객체가 같은지 비교해주는 equals() 메소드
// 객체의 정보를 String 으로 변환해주는 toString() 메소드 등이 있다.
// 하지만 java.lang.Object의 메소드들은
// 매우 두루뭉실하게 구현이 되어있다.
// 예를 들어, equals() 메소드 같은 경우에는 어떤 객체의 특정 필드 값을 비교하여 결과를 보여주는 것이 아니라
// 단순하게 주소값 비교를 하게 구현이 되어있다.
// toString()을 포함한 다른 메소드들도 우리가 직접 쓰기에는 불편하게 구현이 되어 있으므로
// 만약 equals()나 toString()과 같은 메소드를 우리 객체에 맞춰서 쓸려면
// 우리가 직접 오버라이드를 해야한다.

// 다형성(Polymorphism)
// 다형성이란 "다양한 모습을 지닌 성격" 을 다형성이라고 한다.
// 자바의 경우, 리턴 타입, 생성자, 파라미터에 부모 클래스를 타입으로 적어주면
// 자식 클래스도 그 자리에 들어갈 수 있다.
// 단, 자식 클래스의 자리에는 부모 클래스가 들어갈 수 없다.

public class Ex03Inheritance {
	public static void main(String[] args) {
		Monkey a = new Monkey();
		a.setType("원숭이");
		a.makeSound();
		a.move();
		a.showInfo();
		
		Gorilla g = new Gorilla();
		g.setType("고릴라");
		g.makeSound();
		g.move();
		g.showInfo();
		
		Gorilla g2 = new Gorilla();
		
		System.out.println("g.equals(g2): " + g.equals(g2));
		String abc = new String("abc");
		System.out.println("g.equals(abc): " + g.equals(abc));
		
		Animal g3 = new Gorilla();
		
		// 객체를 println()에 넣으면 어떻게 될까?
		// println()에 파라미터로 String 클래스가 아닌 객체가 들어가게 된다면
		// 그 클래스 객체의 toString() 메소드가 실행되서 리턴된
		// String 값이 화면에 출력이 된다.
		
		// 만약 별다른 toString() 오버라이드를 하지 않았을 경우
		// 패키지.객체 클래스 @ 힙 메모리 주소값
		// 이 리턴되서 출력된다.
		
		System.out.println(a);
		System.out.println(g3);
		
		Student s1 = new Student();
		s1.id = 1;
		s1.name = "차상준";
		s1.korean = 80;
		s1.english = 98;
		s1.math = 78;
		
		System.out.println(s1);
	}

}
