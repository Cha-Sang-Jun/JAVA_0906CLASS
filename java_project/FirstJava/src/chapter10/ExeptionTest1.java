package chapter10;

import java.util.Scanner;

public class ExeptionTest1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("피제수를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("제수를 입력해주세요.");
		int num2 = sc.nextInt();
		
		System.out.println(num1/num2);
	}
}
