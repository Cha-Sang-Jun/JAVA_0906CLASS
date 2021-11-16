package day0910;

import java.util.Scanner;
public class Ex12Star6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력해주세요");
        System.out.print("> ");
        
        int userNum = scanner.nextInt();
        
        for(int i=1; i <= userNum; i++) {
            String stars = "";
            
            // 공백을 담당하는 j for문
            for(int j =1; j <= i -1; j++) {
                stars += " ";
            } 
            
            // 별을 담당하는 j for문
            for(int j=1; j <= 2 * userNum + 1 - 2 * i; j++) {
                stars += "*";
            }
            
            
            System.out.println(stars);
        }
        
        
        
        
        
        scanner.close();
    }

}
