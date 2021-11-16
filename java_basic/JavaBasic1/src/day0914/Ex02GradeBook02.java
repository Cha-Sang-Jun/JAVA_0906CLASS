package day0914;
// 배열을 사용하되  

// 입력과 출력을 메뉴로 분리시켜서
// 사용자가 개별 기능을 따로 입력 시키는
// 학생관리 프로그램을 만들어 보시오

import java.util.Scanner;

public class Ex02GradeBook02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 상수
		// 1. 과목 숫자
		final int SUBJECT_SIZE = 3;
		// 2. 학생 숫자
		final int STUDENT_SIZE = 5;

		// 변수
		// 번호
		int[] idArray = new int[STUDENT_SIZE];
		// 이름
		String[] nameArray = new String[STUDENT_SIZE];
		// 국어 점수
		int[] koreanArray = new int[STUDENT_SIZE];
		// 영어 점수
		int[] englishArray = new int[STUDENT_SIZE];
		// 수학 점수
		int[] mathArray = new int[STUDENT_SIZE];
		// 다음에 입력할 인덱스를 저장한 int 변수
		int curIndex = 0;
		// 위의 curIndex를 사용하면
		// 한명도 입력이 안된 상태에서 출력을 할 시에는
		// "아직 입력된 학생의 정보가 없습니다"를 출력하거나
		// 혹은 5명을 초과하여 입력할 시에는
		// "더 이상 입력하실 수 없습니다" 라고 출력해 줄수도 있고
		// 출력 시에는 현재 입력된 학생들만 출력이 가능하다.

		while (true) {
			System.out.println("1.입력 2.출력 3.종료");
			System.out.print("> ");
			int userChoice = scanner.nextInt();

			if (userChoice == 1) {
				// 입력 코드 구현

				if (curIndex < STUDENT_SIZE) {
					// 각 배열의 curIndex번 인덱스에
					// 정보를 입력한다.

					// 번호 입력
					System.out.println("번호를 입력해주세요.");
					System.out.print("> ");
					idArray[curIndex] = scanner.nextInt();

					// 이름 입력
					System.out.println("이름을 입력해주세요.");
					System.out.print("> ");
					scanner.nextLine();
					nameArray[curIndex] = scanner.nextLine();

					// 국어 입력
					System.out.println("국어점수를 입력해주세요.");
					System.out.print("> ");
					koreanArray[curIndex] = scanner.nextInt();

					while (!(koreanArray[curIndex] >= 0 && koreanArray[curIndex] <= 100)) {
						System.out.println("잘못 입력하셨습니다.");
						koreanArray[curIndex] = scanner.nextInt();
					}

					// 영어 입력
					System.out.println("영어점수를 입력해주세요.");
					System.out.print("> ");
					englishArray[curIndex] = scanner.nextInt();

					while (!(englishArray[curIndex] >= 0 && englishArray[curIndex] <= 100)) {
						System.out.println("잘못 입력하셨습니다.");
						englishArray[curIndex] = scanner.nextInt();
					}

					// 수학 입력
					System.out.println("수학점수를 입력해주세요.");
					System.out.print("> ");
					mathArray[curIndex] = scanner.nextInt();

					while (!(mathArray[curIndex] >= 0 && mathArray[curIndex] <= 100)) {
						System.out.println("잘못 입력하셨습니다.");
						mathArray[curIndex] = scanner.nextInt();
					}

					curIndex++;

				} else {
					// 더이상 입력할 수 없음을 알린다.
					System.out.println("5명을 초과한 학생의 정보는 더이상 입력하실 수 없습니다.");
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
				// 종료
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}

		}

		scanner.close();
	}

}
