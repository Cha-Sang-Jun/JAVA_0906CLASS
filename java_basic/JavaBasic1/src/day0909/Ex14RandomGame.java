package day0909;
// 랜덤 게임 
// 컴퓨터가 만든 1~100 사이의 숫자를
// 사용자가 맞추는 게임
// 플레이, 최고 점수 보기, 종료 기능이 있다.
// 플레이를 할 시에는
// 컴퓨터가 숫자를 하나 뽑아 놓고
// 사용자는 그 숫자를 맞출 때 까지 입력을 하게 된다.
// 사용자는 최초 입력을 포함하여
// 입력을 할 때마다 1씩 점수가 오르게 된다.
// 만약 필요한 경우, 기존 최고 점수를 현재 점수로 갱신하는 기능도 있어야 한다.

// 최고 점수 보기
// 최고 점수 보기의 경우, 현재 최고 점수를 보여주는데
// 게임의 특성상 입력 횟수가 낮을 수록 높은 점수가 된다.
// 또한 만약 사용자가 플레이한 기록이 없을 시에는
// "아직 플레이 기록이 업습니다!" 라고 출력이 되게 된다.

import java.util.Scanner; 
import java.util.Random;
public class Ex14RandomGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // 상수
        // 가능한 최소 값
        final int MIN = 1;
        // 가능한 최대 값
        final int MAX = 100;
        
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
                
                while(userNum != computerNum) {
                    System.out.println("틀렸습니다.");
                    System.out.println("숫자를 입력해주세요.");
                    System.out.print("> ");
                    userNum = scanner.nextInt();
                    currentScore++;
                }
                
                // 4. 현재 점수를 토대로 해서 결과 결정 및 보여주기
                System.out.println("이번 플레이 기록: " + currentScore);
                
                if(currentScore < bestScore) {
                    bestScore = currentScore;
                    System.out.println("신기록입니다!");
                } else if(bestScore == 0) { // 이거 왜필요하지??
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
