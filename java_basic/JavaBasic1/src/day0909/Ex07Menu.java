package day0909;
// 무한 루프를 사용하여 메뉴를 만들어보자

import java.util.Scanner;
public class Ex07Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("1. 1번 기능 실행 2. 2번기능 실행 3. 3번기능 실행 4. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();
            
            if(userChoice == 1) {
                // 1번 기능 코드 구현
            } else if(userChoice == 2) {
                // 2번 기능 코드 구현
            } else if(userChoice == 3) {
                // 3번 기능 코드 구현
            } else if(userChoice == 4) {
                // 4번 기능 코드 구현
                System.out.println("사용해주셔서 갑사합니다.");
                break;
                // break 키워드는 실행되는 순간
                // 해당 반복문 혹은 switch 조건문의 코드 실행을 더 이상 하지 않고
                // 해당 반복문이 반복할 코드 블락 혹은 switch 조건문 코드 블락을 종료시킨다.
            }
        }
        
        scanner.close();
    }

}
