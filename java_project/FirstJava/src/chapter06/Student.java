package chapter06;

public class Student {
	
	//2.Student 클래스를 정의해봅시다.
	//  ① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
	//  ② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	//  ③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	
	//3.main()메소드에 아래 내용을 정의해봅시다.
	//  ① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
	//  ② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
	//  ③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
	

	private String name;
	
	private int korScore;
	private int engScore;
	private int mathScore;

	public Student(String name, int korScore, int engScore, int mathScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public Student() {
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	// 총점을 구하는 메소드
	public int getSum() {
		return this.korScore+this.engScore+this.mathScore;
	}
	
	// 평균을 구하는 메소드
	public float getAvg() {
		return getSum()/3.0f;
	}

	@Override
	public String toString() {
		return name+"\t"+korScore+"\t"+engScore+"\t"+mathScore+"\t"+getSum()+"\t"+getAvg();
	}
	
	

}
