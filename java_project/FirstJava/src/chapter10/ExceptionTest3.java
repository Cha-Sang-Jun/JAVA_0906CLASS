package chapter10;

import java.util.Scanner;

public class ExceptionTest3 {

	public static void main(String[] args) {

		int[] arr = new int[3];
		Object o = new String("abc");
		String str = null;
		
		String number = "50";

		try {
			// 배열 인덱스를 잘못 처리한 경우
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생!!!");
			System.out.println(e.getMessage());
		}
		System.out.println("------------------------------");

		try {
			Integer i = (Integer) o;
		} catch (ClassCastException e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage());
		}

		System.out.println("------------------------------");
		
		int size = -10;
		try {
			int[] arr1 = new int[size];
		} catch (NegativeArraySizeException e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage()); // NegativeArraySizeException 의 경우 메세지가 따로 없어서 null로 출력
		}

		System.out.println("------------------------------");

		try {
			System.out.println(str.toUpperCase());
		} catch (NullPointerException e) {
			System.out.println("예외발생!");
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		// String -> int
		try {
		int temp = Integer.parseInt(number);
			System.out.println(temp);
		} catch(NumberFormatException e) {
			System.out.println("예외발생!!");
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램을 종료합니다."); // 정상적으로 밑으로 온 경우
	}
}
