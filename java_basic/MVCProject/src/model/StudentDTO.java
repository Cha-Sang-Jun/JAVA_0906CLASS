package model;
// 학생의 정보를 담당할 모델 클래스
// 모델 클래스는 이름의 끝이 주로 DTO 혹은 VO 로 끝난다.

// DTO와 VO의 차이:
// DTO는 데이터베이스로부터 정보를 받아오거나 혹은 사용자가 입력한 정보를 데이터베이스로 보낼때 사용되는 이름으로
// Data Transfer Object의 줄임말이다.
// VO는 데이터베이스로부터 정보를 받아서 객체의 형체로 만들어줄 때 사용되는 이름으로써
// Value Object의 줄임말이다.

// 단, 해당 이름들은 권고의 개념이므로 둘 중 아무거나 써도 상관 없지만 주로 DTO를 쓰는 경우가 많다.

public class StudentDTO {
	// 필드
	private int id;
	private String name;
	private int korean;
	private int english;
	private int math;
	public int getId() {
		return id;
		
	}
	
    // 메소드

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public boolean equals(Object o) {
		if(o instanceof StudentDTO) {
			StudentDTO s = (StudentDTO)o;
			if(id == s.id) {
				return true;
			}
		}
		
		return false;
	}
	
}
