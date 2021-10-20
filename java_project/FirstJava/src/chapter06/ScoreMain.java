package chapter06;

public class ScoreMain {

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
