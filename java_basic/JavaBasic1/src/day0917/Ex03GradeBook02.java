package day0917;
// 구조체가 아닌 클래스   

// Student를 사용한 학생관리 프로그램

import java.util.Scanner;   

import classEx.Student;
import util.ScannerUtil;
import util.ArrayUtil;

public class Ex03GradeBook02 {
	// 상수
	final static int STUDENT_MAX = 5;
	final static int SCORE_MIN = 0;
	final static int SCORE_MAX = 100;

	// 변수
	static Scanner scanner = new Scanner(System.in);
	static Student[] arr = new Student[0];
	// 다음 입력할 학생의 번호를 저장한 변수
	static int nextId = 1;

	// 메인 메소드
	public static void main(String[] args) {
		showMenu();
	}

	// 메뉴를 담당하는 showMenu()
	public static void showMenu() {
		while (true) {
			System.out.println("---------------------------\n");
			System.out.println("학생 관리 프로그램");
			System.out.println("\n--------------------------\n");

			String message = "1.입력 2.출력 3.종료";
			int userChoice = ScannerUtil.nextInt(scanner, message);

			if (userChoice == 1) {
				// 입력 메소드 호출
				insert();
			} else if (userChoice == 2) {
				// 목록 출력 메소드 호출
				printAll();
			} else if (userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}
		}
	}

	// 입력을 담당하는 insert()
	public static void insert() {
		if (ArrayUtil.size(arr) < STUDENT_MAX) {
			// 입력 받은 정보를 임시로 저장할 Student 변수
			Student s = new Student();

			// 입력 시 출력할 메시지즐 담은 String 변수
			String message;

			// 번호 입력
			s.id = nextId++; // 학생들 정보가 입력 될때마다 nextId가 올라야 한다

			// 이름 입력
			message = "학생의 이름을 입력해주세요";
			s.name = ScannerUtil.nextLine(scanner, message);

			// 국어 입력
			message = "학생의 국어점수를 입력해주세요";
			s.korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

			// 영어 입력
			message = "학생의 영어점수를 입력해주세요";
			s.english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

			// 수학 입력
			message = "학생의 수학점수를 입력해주세요";
			s.math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

			// 배열에 s 추가
			arr = ArrayUtil.add(arr, s);

		} else {
			System.out.println("----------------------------------\n");
			System.out.println("더 이상 입력 할 수 없습니다.");
			System.out.println("\n----------------------------------\n");
		}

	}

	// 학생 목록 출력을 담당하는 printAll()
	public static void printAll() {
		if (ArrayUtil.isEmpty(arr)) {
			System.out.println("----------------------------------\n");
			System.out.println("아직 입력된 학생이 존재하지 않습니다.");
			System.out.println("----------------------------------\n");
		} else {
			System.out.println("----------------------------------\n");
			for (int i = 0; i < ArrayUtil.size(arr); i++) {
				System.out.printf("%d. %s\n", i + 1, ArrayUtil.get(arr, i).name);
			}

			System.out.println("\n----------------------------\n");
			String message = "개별 보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요.";
			int userChoice = ScannerUtil.nextInt(scanner, message, 0, ArrayUtil.size(arr)) - 1;

			if (userChoice != -1) {
				printOne(userChoice);
			}

		}
	}

	// 학생 개별 출력을 담당하는 printOne()
	public static void printOne(int index) {
		Student s = ArrayUtil.get(arr, index);

		System.out.println("----------------------------\n");
		System.out.println(s.name + "학생의 정보");
		System.out.println("\n----------------------------\n");
		
		s.printInfo();

		String message = "1.수정 2.삭제 3.뒤로가기";
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
		if (userChoice == 1) {
			// 수정 메소드 호출
			update(index);
		} else if (userChoice == 2) {
			// 삭제 메소드 호출
			delete(index);
		} else if (userChoice == 3) {
			// 목록 출력 메소드 호출
			printAll();
		}
	}

	// 학생 정보 수정을 담당하는 update()
	public static void update(int index) {
		Student s = ArrayUtil.get(arr, index);
		String message;

		message = "새로운 국어 점수를 입력해주세요.";
		s.korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

		message = "새로운 영어 점수를 입력해주세요.";
		s.english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

		message = "새로운 수학 점수를 입력해주세요.";
		s.math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

		printOne(index);
	}

	// 학생 정보 삭제를 담당하는 delete()
	public static void delete(int index) {
		String message = "정말로 삭제하시겠습니까? Y/N";
		String yesNo = ScannerUtil.nextLine(scanner, message);

		if (yesNo.equalsIgnoreCase("Y")) {
			arr = ArrayUtil.remove(arr, index);
			printAll(); 
		} else {
			printOne(index);
		}

	}
}
