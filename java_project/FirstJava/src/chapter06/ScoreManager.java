package chapter06;

public class ScoreManager {
	
	private Student[] score;
	private int numOfStudent; // 입력시 index로 사용!, 입력한 데이터의 개수
	
	public ScoreManager(int size) {
		score = new Student[size];
		numOfStudent = 0;
	}

	public ScoreManager() {
		this(10);
	}
	
	// 배열의 모든 요소를 출력하는 메소드
	public void showAllData() {
		System.out.println("평가 점수 리스트");
		System.out.println("----------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("----------------------------------------------");
		for(Student s : score) {
			if(s != null) {
				System.out.println(s); // s.toString()
			}
		}
		System.out.println("----------------------------------------------");
		
	}
	
	
	// 배열에 요소를 입력하는 메소드
	public void insertScore(Student student) {
		score[numOfStudent] = student;
		numOfStudent++; // 입력 요소 개수를 추가! 이후 입력시 index 값으로 사용됨!
	}
	

}
