//package day0909;
//// 가위바위보 게임을 만드세요 
//
//// 1. 플레이 하기
//// 사용자가 선택한 것과
//// 컴퓨터가 선택한 것을 
//// 각각 보여주고
//// 승리, 무승부, 패배 중 하나를 결과로 출력합니다.
////
//// 2. 결과 보기
//// 사용자의 승리, 무승부, 패배 그리고 승률을 출력합니다.
//// 단, 사용자가 한번도 하지 않은 경우에는 
//// 아직 플레이 기록이 없습니다 가 출력됩니다.
//
//import java.util.Scanner;
//import java.util.Random;
//
//public class Ex16RandomGame3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//
//        final int MIN = 1;
//        final int MAX = 2;
//        int gamecount = 0;
//        int win = 0;
//        int lose = 0;
//        int draw = 0;
//
//        while (true) {
//            System.out.println("1.플레이 2.결과보기 3.종료");
//            System.out.print("> ");
//            int userChoice = scanner.nextInt();
//            gamecount++;
//
//            if (userChoice == 1) {
//
//                System.out.println("1.가위 2.바위 3.보");
//                System.out.print("> ");
//                int pick = scanner.nextInt();
//                int computer = random.nextInt(MAX) + 1;
//
//                while (pick == 1 && computer == 1) {
//                    System.out.println("플레이어:가위  상대:가위");
//                    System.out.println("무승부입니다.");
//                    System.out.println("1.가위 2.바위 3.보");
//                    System.out.print("> ");
//                    pick = scanner.nextInt();
//                    draw++;
//                }
//                while (pick == 1 && computer == 2) {
//                    System.out.println("플레이어:가위  상대:바위");
//                    System.out.println("졌습니다.");
//                    System.out.println("1.가위 2.바위 3.보");
//                    System.out.print("> ");
//                    pick = scanner.nextInt();
//                    lose++;
//                }
//                while (pick == 1 && computer == 3) {
//                    System.out.println("플레이어:가위  상대:보");
//                    System.out.println("이겼습니다.");
//                    pick = scanner.nextInt();
//                    win++;
//                }
//
//                while (pick == 2 && computer == 1) {
//                    System.out.println("플레이어:바위  상대:가위");
//                    System.out.println("이겼습니다.");
//                    pick = scanner.nextInt();
//                    win++;
//                }
//                while (pick == 2 && computer == 2) {
//                    System.out.println("플레이어:바위  상대:바위");
//                    System.out.println("무승부입니다.");
//                    System.out.println("1.가위 2.바위 3.보");
//                    System.out.print("> ");
//                    pick = scanner.nextInt();
//                    draw++;
//                }
//                while (pick == 2 && computer == 3) {
//                    System.out.println("플레이어:바위  상대:보");
//                    System.out.println("졌습니다");
//                    System.out.println("1.가위 2.바위 3.보");
//                    System.out.print("> ");
//                    pick = scanner.nextInt();
//                    lose++;
//                }
//
//                while (pick == 3 && computer == 2) {
//                    System.out.println("플레이어:보  상대:바위");
//                    System.out.println("이겼습니다.");
//                    pick = scanner.nextInt();
//                    win++;
//                }
//                while (pick == 3 && computer == 1) {
//                    System.out.println("플레이어:보  상대:가위");
//                    System.out.println("졌습니다");
//                    System.out.println("1.가위 2.바위 3.보");
//                    System.out.print("> ");
//                    pick = scanner.nextInt();
//                    lose++;
//                }
//                while (pick == 3 && computer == 3) {
//                    System.out.println("플레이어:보   상대:보");
//                    System.out.println("무승부입니다.");
//                    System.out.println("1.가위 2.바위 3.보");
//                    System.out.print("> ");
//                    pick = scanner.nextInt();
//                    draw++;
//                }
//
//            } else if (userChoice == 2) {
//                System.out.printf();
//            }
//            else if (userChoice == 3) {
//                System.out.println("종료");
//                break;
//            }
//        }
//
//        scanner.close();
//    }
//}
