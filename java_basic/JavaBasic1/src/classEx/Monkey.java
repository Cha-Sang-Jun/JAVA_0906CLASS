package classEx;

public class Monkey extends Animal {
	public Monkey() {
		System.out.println("-------------------------");
		System.out.println("Monkey 클래스 생성자 호출");
		System.out.println("-------------------------");
	}
	
	// makeSounde() 오버라이드
	public void makeSound() {
		System.out.println("우끼끼!!!");
	}
	
	// move() 오버라이드
	public void move() {
		System.out.println("나무사이를 점프하면서 움직입니다.");
	}

}
