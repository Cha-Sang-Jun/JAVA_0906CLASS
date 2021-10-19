package practice;

public class Male extends Person {
//	2. Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다. 
//	① 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//	② 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다. 
	private int height;

	public Male(String name, String juminNum, int age, int height) {
		super(name, juminNum, age);
		this.height = height;
	}

	public Male() {
	}

	// ③ Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
	@Override
	public void sayHello(String name, String juminNum) {
		super.sayHello(name, juminNum);
		System.out.println("키:" + height);
	}

	public void showMale() {
		System.out.println("저는 남자이고 키는: " + height + "cm 입니다.");

	}
}
