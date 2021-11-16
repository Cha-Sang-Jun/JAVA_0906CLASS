package day0910;

import java.util.Scanner;

public class Ex13Star6easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력해주세요");
        System.out.print("> ");

        int userNum = scanner.nextInt();

        for (int i = userNum; i >= 1; i--) {
            String stars = "";
            
            // 공백을 담당하는 j for 문
            for(int j = 1; j <= userNum - i; j++) {
                stars += " ";
            }
            
            // 별을 담당하는 j for 문
            for(int j =1; j <= 2*i -1; j++) {
                stars += "*";
            }
            
            System.out.println(stars);            
        }
        scanner.close();
    }

}
