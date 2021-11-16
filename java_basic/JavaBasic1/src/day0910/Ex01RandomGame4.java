package day0910;

import java.util.Random;
import java.util.Scanner;

public class Ex01RandomGame4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 상수
        // 가위
        final int OPTION_SCISSOR = 1;
        // 바위
        final int OPTION_ROCK = 2;
        // 보
        final int OPTION_PAPER = 3;
        // 최대 선택 가능한 옵션 숫자
        final int OPTION_MAX = 3;

        // 변수
        // 승리 횟수
        int win = 0;
        // 무승부 횟수
        int draw = 0;
        // 패배 횟수
        int lose = 0;

        while (true) {
            System.out.println("1. 플레이 2.기록 보기 3.종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 플레이 코드 구현 시작

                // 1. 컴퓨터 숫자 결정
                int computerNum = random.nextInt(OPTION_MAX) + 1;

                // 2. 사용자 숫자 입력
                System.out.println("1. 가위 2. 바위 3. 보");
                System.out.print("> ");

                int userNum = scanner.nextInt();

                // 사용자가 1,2,3 외 다른 숫자를 입력했을 경우
                while (!(userNum >= OPTION_SCISSOR && userNum <= OPTION_PAPER)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("1. 가위 2. 바위 3. 보");
                    System.out.print("> ");
                    userNum = scanner.nextInt();
                }

                // 3. 결과 계산 및 출력

                // 승리, 무승부, 패배 중 하나를 저장할 String result
                String result = "";

                // 컴퓨터의 선택을 "가위 바위 보" 중 하나로 변환해서 저장할 String compText;
                String compText = "";

                // 사용자의 선택을 "가위 바위 보" 중 하나로 변환해서 저장할 String userText;
                String userText = "";

                if (userNum == computerNum) {
                    // 무승부인 경우
                    result = "무승부";
                    draw++;

                    if (userNum == OPTION_SCISSOR) {
                        userText = compText = "가위";
                    } else if (userNum == OPTION_ROCK) {
                        userText = compText = "바위";
                    } else if (userNum == OPTION_PAPER) {
                        userText = compText = "보";
                    }

                } else {
                    // 무승부가 아닌 경우
                    if (userNum == OPTION_SCISSOR) {
                        userText = "가위";
                        if (computerNum == OPTION_ROCK) {
                            compText = "바위";
                            lose++;
                            result = "패배";
                        } else if (computerNum == OPTION_PAPER) {
                            compText = "보";
                            win++;
                            result = "승리";
                        }

                    } else if (userNum == OPTION_ROCK) {
                        userText = "바위";
                        if (computerNum == OPTION_SCISSOR) {
                            compText = "가위";
                            win++;
                            result = "승리";
                        } else if (computerNum == OPTION_PAPER) {
                            compText = "보";
                            lose++;
                            result = "패배";
                        }

                    } else if (userNum == OPTION_PAPER) {
                        userText = "보";
                        if (computerNum == OPTION_SCISSOR) {
                            compText = "가위";
                            lose++;
                            result = "패배";
                        } else if (computerNum == OPTION_ROCK) {
                            compText = "바위";
                            win++;
                            result = "승리";
                        }

                    }
                }

                System.out.printf("컴퓨터: %s 사용자: %s 결과: %s \n", compText, userText, result);

                // 플레이 코드 구현 끝
            } else if (userChoice == 2) {
                // 기록 보기 코드 구현 시작

                // 총 전적을 계산한다.
                int total = win + draw + lose;

                if (total > 0) {
                    // 사용자가 한번이라도 플레이 하였으므로 전적 출력
                    double rate = (double) win * 100 / total;

                    System.out.printf("\n승리: [%d]회 무승부: [%d]회 패배: [%d]회  승률: [%.2f]%% \n\n", win, draw, lose, rate);

                } else {
                    // 사용자가 한번도 플레이 한적 없으므로 메시지만 출력
                    System.out.println("\n 아직 플레이 기록이 없습니다.");
                }

                // 기록 보기 코드 구현 끝
            } else if (userChoice == 3) {
                // 종료 코드 구현 시작
                System.out.println("플레이 해주셔서 감사합니다.");
                break;

                // 종료 코드 구현 끝
            }
        }

        scanner.close();
    }
}