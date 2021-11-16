package day0914;
// 국어 영어 수학을  

// 개별의 1차원 배열이 아니라
// scoreArray 라는 2차원 배열을 만들어서
// 해당 2차원 배열의 각 배열의 0번 인덱스에는 국어 점수가.
// 1번 인덱스에는 영어 점수가
// 2번 인덱스에는 수학 점수가 들어가게 프로그램을 만들어라
// 단, 점수가 올바른지 체크하거나 입력/출력/종료 따로 구분하지 않고 차례대로 입력되게

import java.util.Scanner;

public class Ex05GradeBook03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 상수
		final int SUBJECT_SIZE = 3;
		final int STUDENT_SIZE = 5;
		// 변수
		int[] idArray = new int[STUDENT_SIZE];
		String[] nameArray = new String[STUDENT_SIZE];
		
		// 국어, 영어, 수학 점수를
		// 한번에 관리할 2차원 배열
		int[][] scoreArray = new int[STUDENT_SIZE][SUBJECT_SIZE];

		// 각 배열에 차례대로 입력을 받는다.
		for (int i = 0; i < STUDENT_SIZE; i++) {
			System.out.println("-----------------");
			System.out.printf("%d번째 학생\n", i + 1);
			System.out.println("------------------");
			// 번호 입력
			System.out.println("번호를 입력해주세요.");
			System.out.print("> ");
			idArray[i] = scanner.nextInt();

			// 이름 입력
			System.out.println("이름을 입력해주세요.");
			System.out.print("> ");
			scanner.nextLine();
			nameArray[i] = scanner.nextLine();
			
			// 2차원 배열 scoreArray의
			// i번째 배열에
			// 0번 칸에는 국어
			// 1번 칸에는 영어
			// 2번 칸에는 수학을 저장한다.

			// 국어 입력
			System.out.println("국어점수를 입력해주세요.");
			System.out.print("> ");
			scoreArray[i][0] = scanner.nextInt();

			// 영어 입력
			System.out.println("영어점수를 입력해주세요.");
			System.out.print("> ");
			scoreArray[i][1] = scanner.nextInt();

			// 수학 입력
			System.out.println("수학점수를 입력해주세요.");
			System.out.print("> ");
			scoreArray[i][2] = scanner.nextInt();

		}

		// 각 배열에 차례대로 출력한다.
		for (int i = 0; i < STUDENT_SIZE; i++) {
			System.out.println("------------------");
			System.out.println(nameArray[i] + "학생의 정보");
			System.out.println("-----------------");


			int id = idArray[i];
			String name = nameArray[i];
			int korean = scoreArray[i][0];
			int english = scoreArray[i][1];
			int math = scoreArray[i][2];

			// 총점
			int sum = korean + english + math;

			// 평균
			double average = (double) sum / SUBJECT_SIZE;

			System.out.printf("번호: %d번 이름: %s\n", id, name);
			System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
			System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);

			System.out.println("=================\n");
		}

		scanner.close();

	}

}
