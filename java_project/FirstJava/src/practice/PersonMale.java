package practice;

public class PersonMale extends Person {
//	2. Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다. 
//	① 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
//	② 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다. 
	String gender;
	
	private String Gender() {
		if(genderCheck() == 1 || genderCheck() == 3) {
			gender = "남자";
		}
		
		if(genderCheck() == 2 || genderCheck() == 4) {
			gender = "여자";
		}
		return gender;
	}

	public PersonMale(String name, String juminNum) {
		super(name, juminNum);
	}

	// ③ Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
	@Override
	public void sayHello() {
		super.sayHello();
		System.out.println("저는" + Gender() +"입니다.");
	}
}
