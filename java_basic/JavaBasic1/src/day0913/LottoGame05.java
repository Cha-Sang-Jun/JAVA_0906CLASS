package day0913;
// 사용자로부터 자동으로 할지 수동으로 할지 입력을 받아서 

// 자동으로 한다고 하면 자동으로 숫자 6개를 뽑고
// 수동으로 한다고 하면 수동으로 숫자 6개를 뽑아
// 정렬하여 출력하는 로또 프로그램을 작성하시오

import java.util.Scanner;
import java.util.Random;

public class LottoGame05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		final int NUMBER_MIN = 1;
		final int NUMBER_MAX = 45;
		final int LENGTH = 6;

		int[] array = new int[LENGTH];

		System.out.println("1.자동 2.수동");
		System.out.print("> ");
		int userChoice = scanner.nextInt();

		for (int i = 0; i < array.length; i++) {
			int num;

			if (userChoice == 2) {
				System.out.println("-------------------");
				System.out.printf("%d번째 숫자\n", i + 1);
				System.out.println("------------------\n");
				System.out.println("1~45사이의 숫자를 입력해주세요.");
				System.out.print("> ");
				num = scanner.nextInt();

			} else {
				// 사용자가 자동을 골랐을 경우
				num = random.nextInt(NUMBER_MAX) + 1;
			}

			// num이 올바른 값이면 true가 저장되고
			// 올바르지 않을 경우엔 false가 저장되는
			// boolean 변수
			boolean inputSwitch = true;

			// 만약 num이 1~45이면 true가 저장되고
			// 그 외엔 false를 저장
			inputSwitch = num >= NUMBER_MIN && num <= NUMBER_MAX;

			// j for문을 사용하여
			// 만약 int[] array에
			// num과 같은 값을 가진 인덱스가 있을경우
			// inputSwitch에 false를 저장한다.

			for (int j = 0; j < array.length; j++) {
				if (array[j] == num) {
					inputSwitch = false;
				}
			}

			// 만약 inputSwitch의 값이 true이면
			// array의 i번 인덱스에 num을 저장한다.
			// 만약 false면
			// 수동인지 자동인지에 따라 메시지를 출력할지 말지 정하고
			// i의 값을 1 감소 시킨다.
			if (inputSwitch) {
				array[i] = num;
			} else {
				if (userChoice == 2) {
					System.out.println("잘못 입력하셨습니다.");
				}
				i--;

			}
		}

		// 배열을 정렬

		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i];
			array[i] = array[i + 1];
			array[i + 1] = temp;

			i = -1;
		}
	
		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d]: %d\n", i, array[i]);
		}
	
		scanner.close();
	}

}
