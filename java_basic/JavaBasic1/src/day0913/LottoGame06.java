package day0913;
// 컴퓨터의 숫자 6개를 랜덤으로 뽑고, 

// 사용자의 숫자 6개는 수동 혹은 자동으로 할지 입력 받아서
// 사용자의 선택에 맞추어 6개의 숫자를 뽑아서
// 컴퓨터 숫자 6개와 사용자 숫자 6개중
// 일치하는 숫자가 총 몇개인지 구하여 출력하는 프로그램.

import java.util.Scanner;
import java.util.Random;

public class LottoGame06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// 상수
		final int NUMBER_MIN = 1;
		final int NUMBER_MAX = 45;
		final int LENGTH = 6;

		// 변수
		// 사용자의 숫자 배열
		int[] userNumbers = new int[LENGTH];
		// 컴퓨터의 숫자 배열
		int[] computerNumbers = new int[LENGTH];

		// 1. 컴퓨터 숫자 입력
		for (int i = 0; i < computerNumbers.length; i++) {
			int num = random.nextInt(NUMBER_MAX) + 1;

			boolean saveSwitch = true;

			for (int j = 0; j < computerNumbers.length; j++) {
				if (num == computerNumbers[j]) {
					saveSwitch = false;
				}
			}

			if (saveSwitch) {
				computerNumbers[i] = num;
			} else {
				i--;
			}
		}

		for (int i = 0; i < computerNumbers.length - 1; i++) {
			if (computerNumbers[i] > computerNumbers[i + 1]) {
				int temp = computerNumbers[i];
				computerNumbers[i] = computerNumbers[i + 1];
				computerNumbers[i + 1] = temp;

				i = -1;
			}
		}

		// 2. 사용자 숫자 입력
		System.out.println("1.자동  2.수동");
		System.out.print("> ");
		int userChoice = scanner.nextInt();

		for (int i = 0; i < userNumbers.length; i++) {
			int num = random.nextInt(NUMBER_MAX) + 1;
			if (userChoice == 2) {
				System.out.printf("%d번째 숫자\n", i + 1);
				System.out.println("1~45사이의 숫자를 입력해주세요.");
				System.out.print("> ");
				num = scanner.nextInt();
			}

			boolean saveSwitch = saveSwitch = num >= NUMBER_MIN && num <= NUMBER_MAX;

			for (int j = 0; j < userNumbers.length; j++) {
				if (num == userNumbers[j]) {
					saveSwitch = false;
				}
			}

			if (saveSwitch) {
				userNumbers[i] = num;
			} else {
				if (userChoice == 2) {
					System.out.println("잘못 입력하셨습니다.");
				}

				i--;
			}
		}

		for (int i = 0; i < userNumbers.length - 1; i++) {
			if (userNumbers[i] > userNumbers[i + 1]) {
				int temp = userNumbers[i];
				userNumbers[i] = userNumbers[i + 1];
				userNumbers[i + 1] = temp;
				i = -1;
			}
		}

		// 3. 컴퓨터와 사용자 숫자 비교 후 결과 출력

		System.out.println("------------------");
		System.out.println("사용자 숫자");
		System.out.println("------------------");
		for (int i = 0; i < userNumbers.length; i++) {
			System.out.printf("[%2d]", userNumbers[i]);
		}

		System.out.println("\n------------------");
		System.out.println("컴퓨터 숫자");
		System.out.println("--------------------");
		for (int i = 0; i < computerNumbers.length; i++) {
			System.out.printf("[%2d]", computerNumbers[i]);
		}

		// 두 배열의 같은 숫자의 갯수를 저장할 int count
		int count = 0;
		for (int i = 0; i < userNumbers.length; i++) {
			for (int j = 0; j < computerNumbers.length; j++) {
				if (userNumbers[i] == computerNumbers[j]) {
					count++;
				}
			}
		}

		System.out.println("\n총 일지하는 숫자의 갯수: " + count);

		scanner.close();
	}

}
