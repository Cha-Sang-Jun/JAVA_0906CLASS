package chapter06;

import java.util.Random;
import java.util.Scanner;

// int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
// 그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
// public static int miniValue(int[] arr) { . . . . } // 최소값 반환
// public static int maxValue(int[] arr) { . . . . } // 최대값 반환

// 위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
// 두 매소드 실행을 확인인하기 위한 main 메소드 정의.
// int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
        int bestScore = 0;
        
        while(true) {
        	System.out.println("랜덤게임");
        	System.out.println("플레이 하시겠습니까? 1 or 2");
        	int userChoice = sc.nextInt();
        	if(userChoice == 1) {
        		int computer = ran.nextInt(100) + 1;
        		int currentScore = 0;
        		System.out.println("숫자를 입력>>");
        		int userNum = sc.nextInt();
        		while(userNum != computer) {
        			System.out.println("틀렸습니다.");
        			System.out.println("숫자를 다시 입력>>");
        		}
        	}
        }
		
	}

}