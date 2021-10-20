package chapter06.score;

public class Student {
	
	// 데이터 저장 목적

	// ① 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
	// ② 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	private String name;
	private int scoreKor;
	private int scoreEng;
	private int scoreMath;
	
	public Student(String name, int scoreKor, int scoreEng, int scoreMath) {
		this.name = name;
		this.scoreKor = scoreKor;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}
	
	public Student() {}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScoreKor() {
		return scoreKor;
	}

	public void setScoreKor(int scoreKor) {
		this.scoreKor = scoreKor;
	}

	public int getScoreEng() {
		return scoreEng;
	}

	public void setScoreEng(int scoreEng) {
		this.scoreEng = scoreEng;
	}

	public int getScoreMath() {
		return scoreMath;
	}

	public void setScoreMath(int scoreMath) {
		this.scoreMath = scoreMath;
	}

	// ③ 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	public int getSum() {
		return this.scoreKor+this.scoreEng+this.scoreMath;
	}
	
	public float getAvg() {
		return getSum()/3.0f;
	}

	@Override
	public String toString() {
		return name+"\t"+scoreKor+"\t"+scoreEng+"\t"+scoreMath+"\t"+getSum()+"\t"+getAvg() ;
	}
	
	
	
	
	
}
