package day0915;
// Call By Reference 를 사용하여  

// 학생의 정보를 입력하는 코드를
// 메소드로 분리하세요.

// Call By Value를 사용하여
// 메뉴를 출력하는 코드를
// 메소드로 분리하세요
// 힌트 : 사용자가 선택한 값을 어떻게 메인으로 넘겨주어야 할까?

// 즉, 해당 프로그램에는 
// 1. 메뉴를 출력하고 사용자의 선택을 메인으로 넘겨주는 메소드
// 2. 학생의 정보를 입력하는 메소드
// 3. 학생의 정보를 출력하는 메소드
// 3개의 메소드가 있어야 한다.

import java.util.Scanner;

public class Ex02GradeBook01 {
	public static void main(String[] args) {
		// 상수
		final int SUBJECT_SIZE = 3;
		final int STUDENT_SIZE = 5;

		// 변수
		Scanner scanner = new Scanner(System.in);
		int[] idArray = new int[STUDENT_SIZE];
		String[] nameArray = new String[STUDENT_SIZE];
		int[][] scoreArray = new int[STUDENT_SIZE][SUBJECT_SIZE];
		int curIndex = 0;

		while (true) {
			// 메뉴 출력 및 사용자 선택을 결정하는 메소드 호출
			int userChoice = showMenu(scanner);

			if (userChoice == 1) {
				// 입력 담당 코드 구현
				if (curIndex < STUDENT_SIZE) {
					// 입력 가능하므로 입력 메소드 실행
					insertInfo(scanner, idArray, nameArray, scoreArray, curIndex);
					// 다음 위치를 1 증가시킨다.
					curIndex++;
					
				} else {
					// 더 이상 입력할 수 없으므로 경고메시지 출력
					System.out.println("더 이상 입력할수 없습니다.");
				}

			} else if (userChoice == 2) {
				// 출력 코드 구현

				if (curIndex == 0) {
					System.out.println("아직 입력된 학생이 존재하지 않습니다.");
				} else {
					// 출력 메소드 실행
					printAll(idArray, nameArray, scoreArray, curIndex, SUBJECT_SIZE);
				}

			} else if (userChoice == 3) {
				// 종료
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}

		scanner.close();
	}

	public static int showMenu(Scanner scanner) {
		System.out.println("1. 입력 2. 출력 3. 종료");
		System.out.print("> ");
		int userChoice = scanner.nextInt();

		return userChoice;
	}

	public static void insertInfo(Scanner scanner, int[] idArray, String[] nameArray, int[][] scoreArray,
			int curIndex) {

		System.out.println("번호를 입력해주세요.");
		System.out.print("> ");
		idArray[curIndex] = scanner.nextInt();

		System.out.println("이름을 입력해주세요.");
		System.out.print("> ");
		scanner.nextLine();
		nameArray[curIndex] = scanner.nextLine();

		// 국어 입력
		System.out.println("국어점수를 입력해주세요.");
		System.out.print("> ");
		scoreArray[curIndex][0] = scanner.nextInt();

		// 영어 입력
		System.out.println("영어점수를 입력해주세요.");
		System.out.print("> ");
		scoreArray[curIndex][1] = scanner.nextInt();

		// 수학 입력
		System.out.println("수학점수를 입력해주세요.");
		System.out.print("> ");
		scoreArray[curIndex][2] = scanner.nextInt();

	}

	public static void printAll(int[] idArray, String[] nameArray, int[][] scoreArray, int curIndex, int SUBJECT_SIZE) {

		for (int i = 0; i < curIndex; i++) {
			System.out.println("----------------------------");
			System.out.println(nameArray[i] + " 학생의 정보");
			System.out.println("----------------------------");
			int id = idArray[i];
			String name = nameArray[i];
			int korean = scoreArray[i][0];
			int english = scoreArray[i][1];
			int math = scoreArray[i][2];

			int sum = korean + english + math;

			double average = (double) sum / SUBJECT_SIZE;

			System.out.printf("번호: %d번 이름: %s\n", id, name);
			System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
			System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

			System.out.println("============================\n");
		}

	}
}
