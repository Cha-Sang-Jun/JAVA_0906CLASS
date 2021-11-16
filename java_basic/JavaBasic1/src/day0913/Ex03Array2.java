package day0913;
// 사용자로부터 5개의 숫자를 입력받아서  
// 사용자가 입력한 순서대로 출력하는 프로그램을 작성하시오.
// 단, 5개의 변수를 따로 만드는 것이 아니라
// 배열을 사용하여 처리하도록 하시오

import java.util.Scanner;
public class Ex03Array2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = 5;
		int [] array = new int[size];
		
		// 입력을 받아보자
		for(int i = 0; i < array.length; i++) {
			System.out.println(i+1 + "번째 숫자를 입력해주세요.");
			System.out.print("> ");
			array[i] = scanner.nextInt();
		}
		
		// 출력을 해보자
		for(int i = 0; i < array.length; i++) {
			System.out.printf("array[%d]: %d\n", i, array[i]);
		}
		
		scanner.close();
	}

}
