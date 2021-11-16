package day0915;
// 스캐너 유틸을 사용한 성적관리 프로그램 

// 단, 1차원 배열만 사용하고 메소드로 분리하는 것은 하지 않는다.

import java.util.Scanner; 

import util.ScannerUtil;

public class Ex03GradeBook02 {
	public static void main(String[] args) {
		// 상수
		final int SUBJECT_SIZE = 3;
		final int STUDENT_SIZE = 5;
		final int SCORE_MIN = 0;
		final int SCORE_MAX = 100;

		// 변수
		Scanner scanner = new Scanner(System.in);
		int[] idArray = new int[STUDENT_SIZE];
		String[] nameArray = new String[STUDENT_SIZE];
		int[] koreanArray = new int[STUDENT_SIZE];
		int[] englishArray = new int[STUDENT_SIZE];
		int[] mathArray = new int[STUDENT_SIZE];
		int curIndex = 0;

		while (true) {
			String message = "1.입력 2. 출력 3. 종료";
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				// 입력 코드 구현
				if (curIndex < STUDENT_SIZE) {
					// 번호 입력
					message = "학생의 번호를 입력해주세요.";
					idArray[curIndex] = ScannerUtil.nextInt(scanner, message);

					// 이름 입력
					message = "학생의 이름을 입력해주세요.";
					nameArray[curIndex] = ScannerUtil.nextLine(scanner, message);

					// 국어 입력
					message = "학생의 국어점수를 입력해주세요.";
					koreanArray[curIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

					// 영어 입력
					message = "학생의 영어점수를 입력해주세요.";
					englishArray[curIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

					// 수학 입력
					message = "학생의 수학점수를 입력해주세요.";
					mathArray[curIndex] = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

					// 다음 입력위치 1 증가
					curIndex++;

				} else {
					System.out.println("더 이상 입력할수 없습니다.");
				}

			} else if (userChoice == 2) {
				// 출력 코드 구현
				if (curIndex == 0) {
					// 아직 입력된 학생이 존재하지 않으므로 경고 메시지만 출력
					System.out.println("아직 입력된 학생이 존재하지 않습니다.");

				} else {
					// 0번 인덱스부터 curIndex 보다 작은 인덱스까지 출력
					for (int i = 0; i < curIndex; i++) {
						System.out.println("------------------");
						System.out.println(nameArray[i] + "학생의 정보");
						System.out.println("-----------------");

						// 이번에 출력할 학생의 번호
						int id = idArray[i];
						// 이번에 출력할 학생의 이름
						String name = nameArray[i];
						// 이번에 출력할 학생의 국어점수
						int korean = koreanArray[i];
						// 이번에 출력할 학생의 영어점수
						int english = englishArray[i];
						// 이번에 출력할 학생의 수학점수
						int math = mathArray[i];

						// 총점
						int sum = korean + english + math;

						// 평균
						double average = (double) sum / SUBJECT_SIZE;

						System.out.printf("번호: %d번 이름: %s\n", id, name);
						System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
						System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

						System.out.println("=================\n");
					}
				}

			} else if (userChoice == 3) {
				// 종료 코드 구현
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}

		scanner.close();
	}

}
