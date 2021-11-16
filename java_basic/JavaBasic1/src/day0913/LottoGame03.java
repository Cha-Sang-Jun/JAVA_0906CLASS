package day0913;
// 로또 시뮬레이터 3번 
// 결과를 오름차순 정렬한 버전

import java.util.Random;

public class LottoGame03 {
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

		for(int i = 0; i < numbers.length - 1; i++) {
			if(numbers[i] > numbers[i+1]) {
				int temp = numbers[i];
				numbers[i] = numbers[i+1];
				numbers[i+1] = temp;
				
				i = -1;
			}
		}
	
	System.out.println("---------------------");
	System.out.println("정렬 후");
	System.out.println("---------------------");

	for (int i = 0; i < numbers.length; i++) {
		System.out.printf("numbers[%d]: %d\n", i, numbers[i]);
	
	}
	}

}
