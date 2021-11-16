package day0916;
// 구조체(Struct) 

// 구조체란, 여러 가지 자료형을 조합해서
// 내가 필요한 나만의 자료형을 만드는 방법이다.
// 단, 구조체는 2세대 언어의 개념이므로 자바에서는 지원 안함.

import struct.Student;

// 대신, 우리는 구조체 역할을 할 클래스를 만들어서 
// 해당 클래스 변수를 사용하게 될 것이다.
public class Ex05Struct {
	public static void main(String[] args) {
		// 우리가 struct 패키지에 만들어놓은 Student 클래스는
		// 하나의 "데이터타입" 이다.
		// 우리가 스트링 변수를 만들어서 값을 저장했듯,
		// 우리가 필요할 때 Student 클래스 데이터타입을 가진 변수를 만들고,
		// 그 안에 id, name, korean, english, math 라는 공간에
		// 따로 값을 집어넣게 된다.

		// Student 클래스 데이터타입을 가진 변수 s를 선언과 초기화해보자
		Student s = new Student();

		// 우리가 s 안에 번호, 이름, 국어, 영어, 수학 점수의 공간을 접근할 때에는
		// 변수이름.공간이름 으로 접근하게 된다.

		s.id = 3;
		s.name = "차상준";
		s.korean = 80;
		s.english = 81;
		s.math = 81;

		// 만약 우리가 필요하다면
		// 또 다른 Student 클래스 변수를 만들어서
		// 다른 값을 넣어줄 수도 있다.

		Student s2 = new Student();
		s2.id = 4;
		s2.name = "김철수";
		s2.korean = 90;
		s2.english = 91;
		s2.math = 91;

		Student[] arr = new Student[3];
		arr[0].id = 40;
		arr[1].id = 50;
		arr[2].id = 60;

	}
}
