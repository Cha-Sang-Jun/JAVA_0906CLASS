package classEx;
// 동물 추살 클래스

public abstract class AnimalA {
	// 추상 메소드의 경우, 우리가 메소드를 선언할 때 abstract만 붙여주고
	// 실제 코드 구현은 하지 않는다.
	public abstract void makeSound();

	public abstract void move();
	// 추상 메소드는 쉽게 표현하자면
	// "이 클래스를 상속 받는 클래스는 반드시 해당 추상 메소드들을 오버라이드하여 가지고 있어야 한다."
	// 라는 의미가 된다.

	public void printInfo() {
		System.out.println("동물입니다.");

	}

}
