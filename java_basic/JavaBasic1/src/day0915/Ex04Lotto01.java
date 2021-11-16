package day0915;
// 로또 게임 프로그램을 만드시오 

// 1. ScannerUtil을 사용할것
// 2. 최대한 메소드를 분리할것
// 3. 사용자가 원하는 횟수만큼 여러번 게임을 실행할 수 있도록 할 것(=2차원 배열 사용)
// 4. 컴퓨터의 숫자를 출력하고 나서 사용자의 숫자를 출력할 때, 각 게임마다 맞은 갯수를 옆에 별도로 표시

import java.util.Scanner; 

import util.ScannerUtil;

import java.util.Random;

public class Ex04Lotto01 {
	public static void main(String[] args) {
		// 상수
		final int SIZE = 6;
		final int NUMBER_MIN = 1;
		final int NUMBER_MAX = 45;

		// 변수
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int[] userNumbers = new int[SIZE];
		int[] computerNumbers = new int[SIZE];

		// 컴퓨터 숫자 결정
		setRandomNum(computerNumbers, NUMBER_MAX);

		// 사용자 숫자 결정
		String message = "1. 자동  2. 수동";
		int userChoice = ScannerUtil.nextInt(scanner, message);
		if(userChoice == 1) {
			setRandomNum(userNumbers, NUMBER_MAX);
		} else {
			setManualNum(scanner, userNumbers, NUMBER_MIN, NUMBER_MAX);
		}

		// 결과 출력
		System.out.println("컴퓨터");
		printArray(computerNumbers);
		System.out.println("-------------\n");
		System.out.println("사용자");
		printArray(userNumbers);
		System.out.println("-----------------\n");
		System.out.println("총 맞은 갯수: " + findSameNum(computerNumbers, userNumbers));

		scanner.close();
	}

	// 파라미터로 들어온 배열에 랜덤 숫자를 넣는 메소드
	public static void setRandomNum(int[] arr, int NUMBER_MAX) {
		Random random = new Random();

		for (int i = 0; i < arr.length;) {
			int randomNum = random.nextInt(NUMBER_MAX) + 1;
			if (!contains(arr, randomNum)) {
				arr[i] = randomNum;
				i++; // i가 증가되는 경우는 randomNum이 없을때에만?
			}
		}
		
		sort(arr);
	}

	// 파라미터로 들어온 배열에 사용자가 입력한 숫자를 넣는 메소드
	public static void setManualNum(Scanner scanner, int[] arr, int NUMBER_MIN, int NUMBER_MAX) {
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

	// 파라미터로 들어온 배열에
	// 파라미터로 들어온 int가 존재하면 true
	// 없으면 false가 리턴되는 메소드
	public static boolean contains(int[] arr, int e) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == e) {
				return true;
			}
		}

		return false;
	}

	// 파라미터로 들어온 배열을 오름차순 정렬해주는 메소드
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
	
	// 2개의 배열을 비교하여 같은 숫자의 갯수를 리턴해주는 메소드
	public static int findSameNum(int[] arr1, int[] arr2) {
		int count = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					count++;
				}
			}
		}
		
		return count;
	}
	// 파라미터로 들어온 배열을 예쁘게 출력해주는 메소드
	public static void printArray(int[] arr) {
		for(int i = 0; i< arr.length; i++) {
			System.out.printf("[%d] ", arr[i]);
		}
		
		System.out.println();
	}
}
