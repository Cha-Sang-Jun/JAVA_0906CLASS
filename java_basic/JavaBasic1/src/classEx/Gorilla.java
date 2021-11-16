package classEx;
// 자바에서는 다중상속이 금지되어 있다.
// 이유: A클래스와 B클래스 두개에서 상속을 받는데
//      만약 두 클래스 모두 똑같은 이름의 메소드가 존재하면
//      자식 클래스 객체가 해당 메소드를 호출할 시 A의 메소드가 호출되어야 할까, B의 메소드가 호출되어야 할지 정할수 없기 때문

// 단, 다른 클래스를 상속받는 부모 클래스를 상속받는 것은 문제가 없다.
// extends animal, monkey 는 안되지만 animal을 상속받는 monkey를 상속받는 것은 가능

public class Gorilla extends Monkey{
	public void move() {
		System.out.println("가슴을 두드리면서 움직입니다.");
	}

	public boolean equals(Object o) {
		if(o instanceof Gorilla) {
			return true;
		}
		return false;
		
	}
}
