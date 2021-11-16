package day0914;
// 사용자가 넘겨주는 int 값 2개를 
// 사칙연산을 예쁘게 출력하고
// 그 결과값을 리턴하는 메소드 5개를 만들고
// 메인 메소드에서 사용자가 키보드 입력을 통해
// 입력한 int 값 2개에 대한 메소드 결과를 실행시키는
// 코드를 작성하시오
// 단, 나눗셈의 경우 결과가 double로 나올 수 있게 작성

import java.util.Scanner;
public class Ex07Calculator {

		// 더하기 담당 메소드
		public static int add(int a, int b) {
			System.out.println("================");
			System.out.println("\t더하기 메소드");
			System.out.println("================");
			System.out.printf("%d + %d = [%d]\n", a, b, a+b);
			System.out.println("----------------------\n");
			
			return a+b;
		}
			
		// 빼기 담당 메소드
		public static int subtract(int a, int b) {
			System.out.println("================");
			System.out.println("\t빼기 메소드");
			System.out.println("================");
			System.out.printf("%d - %d = [%d]\n", a, b, a-b);
			System.out.println("----------------------\n");
			
			return a-b;
		}
		// 곱하기 담당 메소드
		public static int multiply(int a, int b) {
			System.out.println("================");
			System.out.println("\t곱하기 메소드");
			System.out.println("================");
			System.out.printf("%d X %d = [%d]\n", a, b, a*b);
			System.out.println("----------------------\n");
			
			return a*b;
		}
		// 나누기 담당 메소드
		public static double divide(int a, int b) {
			System.out.println("================");
			System.out.println("\t나누기 메소드");
			System.out.println("================");
			System.out.printf("%d / %d = [%.2f]\n", a, b, (double)a/b);
			System.out.println("----------------------\n");
			
			return (double)a/b;
		}
		// 나머지 담당 메소드
		public static int remain(int a, int b) {
			System.out.println("================");
			System.out.println("\t나머지 메소드");
			System.out.println("================");
			System.out.printf("%d %% %d = [%d]\n", a, b, a % b);
			System.out.println("----------------------\n");
			
			return a%b;
		}
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("첫 번째 숫자를 입력해주세요.");
			System.out.print("> ");
			int num1 = scanner.nextInt();
			
			System.out.println("두 번째 숫자를 입력해주세요.");
			System.out.print("> ");
			int num2 = scanner.nextInt();
			
			add(num1,num2);
			subtract(num2,num1);
			multiply(num1,num2);
			divide(num1,num2);
			remain(num1,num2);
			
			// 활용예시
			add(add(2,3), add(4,5));
			subtract(subtract(5,5), subtract(2,4));
			
			scanner.close();
		}
	
}
