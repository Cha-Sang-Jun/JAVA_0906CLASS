package viewer;

import model.StudentDTO;
import controller.StudentController;

import java.util.Scanner;

import util.ScannerUtil;
import java.util.ArrayList;

public class StudentViewer {
	// 우리는 서버가 따로 존재하지 않으므로
	// 한개의 컨트롤러만 사용되어야 한다.
	// 따라서 StudentViewer 의 필드로
	// StudentController 객체가 하나 있어야 하고
	// 데이터를 CRUD 할 때 반드시 그 StudentController 객체를 통해서만
	// 해야 정상적으로 입력, 수정, 삭제 등이 반영될 수 있다.
	private StudentController studentController;
	private Scanner scanner;

	private final int SUBJECT_SIZE = 3;
	private final int SCORE_MIN = 0;
	private final int SCORE_MAX = 100;

	public StudentViewer() { 
		studentController = new StudentController();
		studentController.makeConnection();

		scanner = new Scanner(System.in);
	}

	// 메뉴 출력을 담당하는 showMenu()
	public void showMenu() {
		String message = new String("1. 새로운 학생 입력 2. 학생 목록 출력 3. 종료");
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("비트고등학교 학생관리 프로그램");
			System.out.println("----------------------------------");
			System.out.println();
			int userChoice = ScannerUtil.nextInt(scanner, message);

			if (userChoice == 1) {
				// 학생 입력 메소드 호출
				add();
			} else if (userChoice == 2) {
				// 학생 목록 출력 메소드 호출
				printAll();
			} else if (userChoice == 3) {
				// 경고 메시지 후 프로그램 종료
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}
		}
	}

	// 학생 입력을 담당하는 메소드
	private void add() {
		StudentDTO s = new StudentDTO();

		String message;

		message = new String("학생의 이름을 입력해주세요.");
		s.setName(ScannerUtil.nextLine(scanner, message));

		message = new String("학생의 국어점수를 입력해주세요.");
		s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

		message = new String("학생의 영어점수를 입력해주세요.");
		s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

		message = new String("학생의 수학점수를 입력해주세요.");
		s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

		studentController.insert(s); // 컨트롤러에게 정보를 넘겨준다
	}

	// 학생 목록 출력 메소드
	private void printAll() {
		ArrayList<StudentDTO> temp = studentController.selectALL();

		if (temp.isEmpty()) {
			System.out.println("------------------------------");
			System.out.println("아직 입력된 학생이 존재하지 않습니다.");
			System.out.println("-------------------------------");
			System.out.println();
		} else {
			for (StudentDTO s : temp) {
				System.out.printf("%d. %s\n", s.getId(), s.getName());
			}
			System.out.println("-----------------------------");
			String message = new String("상세보기할 학생의 번호나 뒤로가시려면 0을 입력해주세요.");

			int userChoice = ScannerUtil.nextInt(scanner, message);

			while (userChoice != 0 && studentController.selectOne(userChoice) == null) {
				System.out.println("해당 번호를 가진 학생은 존재하지 않습니다.");
				userChoice = ScannerUtil.nextInt(scanner, message);
			}

			if (userChoice != 0) {
				// 개별 출력 메소드 호출
				printOne(userChoice);
			}
		}

	}

	private void printOne(int id) {
		StudentDTO s = studentController.selectOne(id);

		System.out.println("----------------------------");
		System.out.println(s.getName() + "학생 정보");
		System.out.println("---------------------------");
		System.out.printf("번호: %d번, 이름: %s\n", s.getId(), s.getName());
		System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
		int sum = s.getKorean() + s.getEnglish() + s.getMath();
		double average = (double) sum / SUBJECT_SIZE;
		System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
		System.out.println("--------------------------------");
		String message = new String("1.수정 2.삭제 3.목록으로");
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
		if (userChoice == 1) {
			// 수정 메소드 호출
			update(id);
		} else if (userChoice == 2) {
			// 삭제 메소드 호출
			delete(id);
		} else if (userChoice == 3) {
			printAll();
		}
	}

	private void update(int id) {
		StudentDTO s = studentController.selectOne(id);

		String message;

		message = new String("새로운 국어점수를 입력해주세요.");
		s.setKorean(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

		message = new String("새로운 영어점수를 입력해주세요.");
		s.setEnglish(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

		message = new String("새로운 수학점수를 입력해주세요.");
		s.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));

		studentController.update(s);
		printOne(id);
	}

	private void delete(int id) {
		String message = new String("해당 학생을 정말로 삭제하시겠습니까? y/n");
		String yesNo = ScannerUtil.nextLine(scanner, message);

		if (yesNo.equalsIgnoreCase("y")) {
			studentController.delete(id);
			printAll();
		} else {
			printOne(id);
		}
	}
}
