package exam;

import java.util.Calendar;

public class Person {
//	1. Person 이라는 클래스를 정의해봅시다. 
//	① 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다. 
	String name;
	String juminNum;
	
//	② 인사하는 메소드를 정의해봅시다. - “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 
	// 문자열이 출력하도록 정의합시다. 
	public void sayHello() {
		System.out.println("안녕하세요. 저는 " + this.name + "입니다. 나이는" + age() + "세 입니다.");
	}
	 
	
//	④ Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.
	public Person(String name, String juminNum) {
		super();
		this.name = name;
		this.juminNum = juminNum;
	}
	
	public int genderCheck() {
		return Integer.parseInt(juminNum.substring(7,8));
	}
	
	public int age() {
		int birth = Integer.parseInt(juminNum.substring(0,2)) + 1900;
		return Calendar.getInstance().get(Calendar.YEAR) - birth;
	}
}
