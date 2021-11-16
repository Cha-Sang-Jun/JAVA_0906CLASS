package classEx;
// 학생의 정보를 저장하고 관리한 Student 클래스
 
public class Student {
	// 필드
	public int id;
	public String name;
	public int korean;
	public int english;
	public int math;
	public final int SUBJECT_SIZE = 3;
	
	// 메소드
	// 1. 학생의 총점을 계산하는 calculateSum()
	public int calculateSum() {
		return korean + english + math;
	}
	
	// 2. 학생의 평균을 계산하는 calculateAverage()
	public double calculateAverage() {
		return (double)calculateSum() / SUBJECT_SIZE;
	}
	
	// 3. 학생의 정보를 출력하는 printiInfo()
	public void printInfo() {
		System.out.printf("번호: %d번 이름: %s\n", id, name);
		System.out.printf("국어: %03d점 영어: %03d점 수학:%03d점\n", korean, english, math);
		System.out.printf("총점: %03d점 평균: %06.2f점\n", calculateSum(), calculateAverage());

	}
	
	// 4. 파라미터가 있는 생성자
	public Student(int id, String name, int korean, int english, int math) {
		id = id;
		// 위의 id = id를 풀어서 쓰면?
		// 파라미터로 들어온 int 변수 id에 파라미터로 들어온 int 변수 id의 현재값을 저장해라
		// 만약 파라미터와 필드의 이름이 같을 경우에는
		// 필드를 지칭할때 앞에 this. 를 붙여서
		// "이 메소드를 실행시키는 객체 자신" 이란 것을 명시해준다.
		this.id = id;
		// 위의 this.id = id; 는
		// 이 Student(int, String, int, int, int) 메소드를 실행시키는 객체의 필드 id에 
		// 파라미터로 들어온 int id의 현재 값을 저장해라 라는 의미가 된다.
		
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		
	}
	
	// 5. 파라미터 없는 생성자
	public Student() {
		id = -1;
		name = new String("아직 없음");
		korean = -1;
		english = -1;
		math = -1;
	}
	
	// 6. equals()
	//    단, equals() 메소드의 파라미터는 어떤 클래스던간에
	//    반드시 Object 타입의 변수로 해야한다.
	public boolean equals(Object o) {
		// 1. 파라미터로 들어온 object 변수 o가
		//    Student 클래스의 객체가 맞는지 확인
		// 2. 명시적 형변환을 통해 o의 값을 student 클래스 객체로
		//    임시로 바꿔준다.
		// 3. 이 메소드를 실행하는 객체의 id와 위의 2번에서 생성된 임시객체의 id가
		//    같으면 true를 리턴한다.
		
		if(o instanceof Student) {
			Student s = (Student)o;
			if(id == s.id) {
				return true;
			}
		}
		
		return false;

	}
	
	public String toString() {
		return "학생 번호: " + id + ", 학생 이름: " +name+ ", 국어점수: " + korean + ", 영어점수: " + english + ", 수학점수: " + math  ;
	}
}
