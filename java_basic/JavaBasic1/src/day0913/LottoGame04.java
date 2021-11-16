package day0913;
// 사용자로부터 1~45까지의 숫자 6개를 입력 받아서 

// 정렬하여 출력하는 프로그램.
// 단, 사용자가 잘못된 숫자나 중복된 숫자를 입력하는 경우, 올바른 숫자가
// 입력되도록 다시 입력 받게 코드 작성

import java.util.Scanner;

public class LottoGame04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 상수
		// 입력가능한 최소 값
		final int NUMBER_MIN = 1;
		// 입력가능한 최대 값
		final int NUMBER_MAX = 45;
		// 배열의 길이
		final int LENGTH_MAX = 6;

		int[] array = new int[LENGTH_MAX];

		// 배열에 각 인덱스에 숫자를 넣는다.
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d번째 숫자\n", i + 1);

			System.out.println("1~45 사이의 숫자를 입력해주세요.");
			System.out.print("> ");
			int num = scanner.nextInt();

			// 만약 문제가 없으면 true,
			// 문제가 있으면 false를 저장할
			// boolean 변수를 만든다.

			boolean inputSwitch = true;

			// 사용자가 입력한 값이 1~45가 아닐 경우에
			// inputSwitch 에 false를 저장하고 그 외 는 true를 저장하자
			inputSwitch = num >= NUMBER_MIN && num <= NUMBER_MAX;

			// array 전체를 확인하여
			// 만약 i번 칸의 저장된 값이
			// num과 같으면, inputSwitch를 false로 저장한다.

			for (int j = 0; j < array.length; j++) {
				if (array[j] == num) {
					inputSwitch = false;
				}
			}

			if (inputSwitch) {
				// 아무런 문제가 없었으므로
				// i 번째 인덱스에 num을 저장한다.
				array[i] = num;
			} else {
				System.out.println("잘못입력하셨습니다.");
				i--; 
			}
		}
		// 배열을 정렬한다
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;

				i = -1;
			}
		}

		// 출력
		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d]: [%d]\n", i, array[i]);
		}

		scanner.close();
	}

}
