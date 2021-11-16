package day0916;

// 동적 할당을 사용한 학생 관리프로그램2 
// 다양한 메소드를 적용시킨 버젼
import java.util.Scanner; 
import util.ArrayUtil;
import util.ScannerUtil;

public class Ex02GradeBook02 {
	// 상수
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

		showMenu(scanner, idArray, nameArray, koreanArray, englishArray, mathArray);

		scanner.close();
	}

	// 1. 메뉴 출력을 담당하는 메소드
	public static void showMenu(Scanner scanner, int[] idArray, String[] nameArray, int[] koreanArray,
			int[] englishArray, int[] mathArray) {

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
				// 출력 메소드 호출
				printAll(idArray, nameArray, koreanArray, englishArray, mathArray);
			} else if (userChoice == 3) {
				// 종료 코드 구현
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}

	// 2. 학생 전체 출력을 담당하는 메소드
	public static void printAll(int[] idArray, String[] nameArray, int[] koreanArray, int[] englishArray,
			int[] mathArray) {
		if (ArrayUtil.isEmpty(idArray)) {
			System.out.println("아직 입력된 학생이 존재하지 않습니다.");
		} else {
			for (int i = 0; i < ArrayUtil.size(idArray); i++) {
				int id = ArrayUtil.get(idArray, i);
				String name = ArrayUtil.get(nameArray, i);
				int korean = ArrayUtil.get(koreanArray, i);
				int english = ArrayUtil.get(englishArray, i);
				int math = ArrayUtil.get(mathArray, i);

				System.out.println("---------------------------------------");

				printOne(id, name, korean, english, math);

				System.out.println("---------------------------------------\n");
			}
		}
	}

	public static void printOne(int id, String name, int korean, int english, int math) {
		int sum = korean + english + math;
		double average = (double) sum / SUBJECT_SIZE;

		System.out.printf("번호: %d번 이름: %s\n", id, name);
		System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
		System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
	}
}
