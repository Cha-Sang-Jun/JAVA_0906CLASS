package chapter05;
//④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력

public class Member2Main {
	public static void main(String[] args) {
		// 회원의 정보를 저장하는 프로그램
		// 데이터를 저장할 수 있는 구조(클래스) 만들었다!
		// Member 클래스로 인스턴스를 생성하면 데이터를 저장하는것과 같다!
		Member2 member1 = new Member2("손흥민", "010-0000-0000", "축구", 1, "ejejej@gmail.com", "2000.02.01", "토트넘");
		
		// 객체의 정보 출력
		member1.showData();
		
		Member2 member2 = new Member2("1", "1", "1", 1, "1");
		member2.showData();
	}

}
