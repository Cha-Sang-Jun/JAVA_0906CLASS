package day0909;
// 우리가 만든 숫자 맞추기 게임에서 사용자가
// 컴퓨터 숫자보다 큰 값을 입력하면 DOWN, 
// 작은 값을 입력하면 UP 이 출력되게 프로그램을 업그레이드 하시오

import java.util.Scanner; 
import java.util.Random;
public class Ex15RandomGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // 상수
        // 가능한 최소 값
        final int MIN = 1;
        // 가능한 최대 값
        final int MAX = 10;
        
        int bestScore = 0;
        
        while(true) {
            System.out.println("1. 플레이 2. 최고 기록 보기 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();
            
            if(userChoice == 1) {
                
                // 1. 컴퓨터 숫자 지정
                int computerNum = random.nextInt(MAX) + 1;
                
                // 2. 사용자의 현재 점수를 저장할 변수 선언 및 초기화
                int currentScore = 1;
                
                // 3. 사용자로부터 숫자 입력 받기
                System.out.println("숫자를 입력해주세요.");
                System.out.print("> ");
                int userNum = scanner.nextInt();
                
                while(userNum > computerNum) {
                    System.out.println("틀렸습니다.");
                    System.out.println("숫자 DOWN.");
                    System.out.print("> ");
                    userNum = scanner.nextInt();
                    currentScore++;
                } 
                while(userNum < computerNum) {
                    System.out.println("틀렸습니다.");
                    System.out.println("숫자 UP");
                    System.out.print("> ");
                    userNum = scanner.nextInt();
                    currentScore++;
                }
                
                // 4. 현재 점수를 토대로 해서 결과 결정 및 보여주기
                System.out.println("이번 플레이 기록: " + currentScore);
                
                if(currentScore < bestScore) {
                    bestScore = currentScore;
                    System.out.println("신기록입니다!");
                } else if(bestScore == 0) {
                    bestScore = currentScore;
                    
                }
                
                // 플레이 코드 마지막 줄
            } else if(userChoice == 2) {
                
                if(bestScore != 0) {
                    
                    System.out.printf("현재 최고 기록: [%d]회\n", bestScore);
                } else {
                    System.out.println();
                    System.out.println("아직 플레이 기록이 없습니다.");
                    System.out.println();
                }
                // 기록 보기 코드 마지막 
            } else if(userChoice == 3) {
                System.out.println("게임종료");
                break;
                // 종료 코드 마지막 줄
            }
        }

        
        
        scanner.close();
    }

}
