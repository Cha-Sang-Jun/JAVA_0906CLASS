package day0916;

// 동적할당을 사용한 배열을 이용하여
// 학생 관리 프로그램을 작성하시오.
// 단 관리 가능한 최대 학생은 5명 입니다.

import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;

public class Ex01GradeBook01 {
	// 전역상수
	static final int MAX_STUDENT = 5;
	static final int SUBJECT_SIZE = 3;
	static final int SCORE_MIN = 0;
	static final int SCORE_MAX = 100;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] idArray = new int[0];
		String[] nameArray = new String[0];
		int[] koreanArray = new int[0];
		int[] englishArray = new int[0];
		int[] mathArray = new int[0];

		while (true) {
			String message = "1. 입력 2. 출력 3. 종료";
			int userChoice = ScannerUtil.nextInt(scanner, message);
			if (userChoice == 1) {
				// 입력 코드 구현
				if (ArrayUtil.size(idArray) < MAX_STUDENT) {
					// 더 입력 가능한 상태
					message = "번호를 입력해주세요.";
					int id = ScannerUtil.nextInt(scanner, message);
					idArray = ArrayUtil.add(idArray, id);

					message = "이름을 입력해주세요.";
					String name = ScannerUtil.nextLine(scanner, message);
					nameArray = ArrayUtil.add(nameArray, name);

					message = "국어 점수를 입력해주세요.";
					int korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
					koreanArray = ArrayUtil.add(koreanArray, korean);

					message = "영어 점수를 입력해주세요.";
					int english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
					englishArray = ArrayUtil.add(englishArray, english);

					message = "수학 점수를 입력해주세요.";
					int math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
					mathArray = ArrayUtil.add(mathArray, math);

				} else {
					// 더이상 입력할 수 없는 상태
					System.out.println("더이상 입력하실 수 없습니다.");
				}

			} else if (userChoice == 2) {
				// 출력 코드 구현
				if (ArrayUtil.isEmpty(idArray)) {
					// 아직 입력된 학생이 없으므로 경고 메시지만 출력
					System.out.println("아직 입력된 학생이 존재하지 않습니다.");
				} else {
					for (int i = 0; i < ArrayUtil.size(idArray); i++) {
						int id = ArrayUtil.get(idArray, i);
						String name = ArrayUtil.get(nameArray, i);
						int korean = ArrayUtil.get(koreanArray, i);
						int english = ArrayUtil.get(englishArray, i);
						int math = ArrayUtil.get(mathArray, i);

						int sum = korean + english + math;
						double average = (double) sum / SUBJECT_SIZE;

						System.out.println("------------------------------------\n");
						System.out.printf("번호: %d번 이름: %s\n", id, name);
						System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
						System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
						System.out.println("------------------------------------\n");

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
