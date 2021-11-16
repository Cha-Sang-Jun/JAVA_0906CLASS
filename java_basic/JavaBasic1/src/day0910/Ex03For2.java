package day0910;
// for문에 대한 기본 예제

// 1. 1부터 5까지 출력
// 2. 10부터 7까지 출력
// 3. 7부터 11까지의 짝수 출력
// 4. 사용자로부터 숫자를 입력받아서 1부터 그 수까지 출력
// 5. 사용자로부터 숫자를 2개 입력받아서 더 작은수부터 더 큰수까지 출력
// 6. 사용자로부터 숫자를 1개 입력받아서 1부터 그 수까지의 합을 구하여 출력
// 7. 사용자로부터 숫자를 1개 입력받아서 1부터 그 수까지의 곱을 구하여 출력

import java.util.Scanner;
public class Ex03For2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1번
        for(int i = 1; i <= 5; i++) {
            System.out.println("i의 현재값: " + i);
        }
        
        System.out.println("=================\n");
        
        // 2번
        for(int i = 10; i >= 7; i--) {
            System.out.println("i의 현재값: " + i);
        }
        System.out.println("=======================\n");
        
        // 3번
        for(int i = 8; i <= 11 && i %2 == 0; i += 2) {
            System.out.println("i의 현재값: " + i);
        }
        System.out.println("======================\n");
        
        // 4번
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        int num = scanner.nextInt();
        for(int i = 1; i <= num; i++) {
            System.out.println("i의 현재값: " + i);
        }
        
        System.out.println("======================\n");
        
        // 5번
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        int num1 = scanner.nextInt();
        System.out.println("더 큰숫자를 입력해주세요.");
        System.out.print("> ");
        int num2 = scanner.nextInt();
        for(int i = num1; i <= num2; i++) {
            System.out.println("i의 현재값: " + i);
        }
        
        System.out.println("========================\n");
        
        // 6번
        System.out.println("숫자를 입력해주세요.");
        System.out.print("> ");
        int number = scanner.nextInt();
        int sum;
        for(int i = 1; i <= number; i++) {
         sum = i += i;
         System.out.println("i의 현재값: " + i);
            
        }
        
        
    }

}
