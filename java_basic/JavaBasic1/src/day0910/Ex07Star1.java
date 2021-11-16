package day0910;

import java.util.Scanner;
public class Ex07Star1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력하세요.");
        System.out.print("> ");
        
        int userNum = scanner.nextInt();
        
//        for(int i = 1; i <= userNum; i++) {
//            for(int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//            
//        }
        
        for(int i = 1; i <= userNum; i++) {
            String stars = "";
            
            for(int j = 1; j <= i; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
        
    
    scanner.close();
    }
}
