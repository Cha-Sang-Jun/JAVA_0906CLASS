package chapter06;

public class ScoreMain {
	//3.main()메소드에 아래 내용을 정의해봅시다.
	//  ① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
	//  ② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
	//  ③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
	

	public static void main(String[] args) {
		
		// 배열을 가지고 컨트롤하는 클래스 객체
		ScoreManager manager = new ScoreManager();
		
		// 데이터 입력
		manager.insertScore(new Student("김", 100, 90, 80));
		manager.insertScore(new Student("이", 80, 50, 60));
		manager.insertScore(new Student("박", 70, 60, 70));
		manager.insertScore(new Student("최", 50, 70, 80));
		manager.insertScore(new Student("유", 30, 80, 90));
		manager.insertScore(new Student("홍", 40, 90, 100));
		
		System.out.println("점수 입력됨");
		
		// 전체 데이터 출력
		manager.showAllData();

	}

}
