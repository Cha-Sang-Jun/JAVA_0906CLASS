package day0913;
// 로또 시뮬레이터 2번

// 중복을 제거한 버전

import java.util.Random;

public class LottoGame02 {
	public static void main(String[] args) {
		Random random = new Random();
		final int SIZE = 6;
		final int NUMBER_MAX = 45;

		int[] numbers = new int[SIZE];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(NUMBER_MAX) + 1;
		}

		System.out.println("---------------------");
		System.out.println("중복제거전");
		System.out.println("---------------------");

		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("numbers[%d]: %d\n", i, numbers[i]);
		}

		System.out.println("========================\n");

		for (int i = 0; i < numbers.length; i++) {

			for (int j = 0; j < numbers.length; j++) {
				if (i != j && numbers[i] == numbers[j]) {

					System.out.println("------------------");
					System.out.printf("%d번 칸과 %d번 칸이 중복\n", i, j);
					System.out.println("-------------------");

					numbers[i] = random.nextInt(NUMBER_MAX) + 1;

					j = -1;

				}
			}
		}
		System.out.println("---------------------");
		System.out.println("중복제거후");
		System.out.println("---------------------");

		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("numbers[%d]: %d\n", i, numbers[i]);
		}

	}

}
