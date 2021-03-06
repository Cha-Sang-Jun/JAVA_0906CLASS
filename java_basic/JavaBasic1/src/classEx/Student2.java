package classEx;
// 캡슐화가 적용된 학생관리 프로그램 작성

public class Student2 {
	// 필드
	private int id;
	private String name;
	private int korean;
	private int english;
	private int math;
	private final int SUBJECT_SIZE = 3; // 과목의 숫자는 외부에서 알 필요가 없으므로 캡슐화하지 않음

	// 메소드
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getKorean() {
		return korean;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getEnglish() {
		return english;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getMath() {
		return math;
	}

	public boolean equals(Object o) {
		if (o instanceof Student2) {
			Student2 s = (Student2) o;
			if (id == s.id) {
				return true;
			}
		}

		return false;
	}

	private int calculateSum() {
		return korean + english + math;
	}

	private double calculateAverage() {
		return (double) calculateSum() / SUBJECT_SIZE;
	}

	public void printInfo() {
		System.out.println("--------------------------------");
		System.out.printf("번호: %d번 이름: %s\n", id, name);
		System.out.printf("국어: %03d점 영어: %03d점 수학:%03d점\n", korean, english, math);
		System.out.printf("총점: %03d점 평균:%06.2f점\n", calculateSum(), calculateAverage());
		System.out.println("--------------------------------");
	}
}
