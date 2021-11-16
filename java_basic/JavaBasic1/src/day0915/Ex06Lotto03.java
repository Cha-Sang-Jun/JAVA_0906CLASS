package day0915;

// 사용자로부터 총 몇게임할지 입력 받아서  
// 각각 게임을 수동 혹은 자동으로 할지 입력 받고
// 최종적으로 각 게임의 결과를 보여주는 로또 게임

import java.util.Scanner;   
import util.ScannerUtil;
import java.util.Random;

public class Ex06Lotto03 {
	// 전역 상수
	static final int SIZE = 6;
	static final int NUMBER_MIN = 1;
	static final int NUMBER_MAX = 45;

	// 전역 변수
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// 사용자로부터 총 몇게임을 할지 입력 받는다.
		String message = "총 몇게임 하시겠습니까?";
		int gameNum = ScannerUtil.nextInt(scanner, message);

		int[][] userNumbers = new int[gameNum][SIZE];

		int[] computerNumbers = new int[SIZE];

		setRandomNum(computerNumbers);

		for (int i = 0; i < userNumbers.length; i++) {
			System.out.println("-----------------------");
			System.out.printf("\t[%d] 번 게임\n", i + 1);
			System.out.println("-----------------------");
			message = "1. 자동  2. 수동";
			int userChoice = ScannerUtil.nextInt(scanner, message);
			if (userChoice == 1) {
				setRandomNum(userNumbers[i]);
			} else {
				setManualNum(userNumbers[i]);
			}

		}

		System.out.println("컴퓨터");
		printArray(computerNumbers);
		System.out.println("-------------\n");
		System.out.println("사용자");
		for (int i = 0; i < userNumbers.length; i++) {
			System.out.println("-----------------------");
			System.out.printf("\t[%d] 번 게임\n", i + 1);
			System.out.println("-----------------------");

			printArray(userNumbers[i]);

			System.out.println("-----------------\n");
			System.out.println("총 맞은 갯수: " + findSameNum(computerNumbers, userNumbers[i]));
		}

		scanner.close();
	}

	public static void setRandomNum(int[] arr) {
		Random random = new Random();

		for (int i = 0; i < arr.length;) {
			int randomNum = random.nextInt(NUMBER_MAX) + 1;
			if (!contains(arr, randomNum)) {
				arr[i] = randomNum;
				i++;
			}
		}

		sort(arr);
	}

	public static void setManualNum(int[] arr) {
		for (int i = 0; i < arr.length;) {
			String message = (i + 1) + "번째 숫자";
			int num = ScannerUtil.nextInt(scanner, message, NUMBER_MIN, NUMBER_MAX);
			if (!contains(arr, num)) {
				arr[i] = num;
				i++;
			} else {
				System.out.println("중복된 숫자입니다.");
			}
		}

		sort(arr);
	}

	public static boolean contains(int[] arr, int e) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == e) {
				return true;
			}
		}

		return false;
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				i = -1;

			}
		}
	}

	public static int findSameNum(int[] arr1, int[] arr2) {
		int count = 0;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					count++;
				}
			}
		}

		return count;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("[%d] ", arr[i]);
		}

		System.out.println();
	}
}
