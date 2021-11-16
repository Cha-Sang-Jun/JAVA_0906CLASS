package day0910;

import java.util.Scanner;

public class Ex16Star9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요");
        System.out.print("> ");

        int userNum = scanner.nextInt();

//        for (int i = 1; i <= 2 * userNum - 1; i++ ) {
//        	String stars = "";
//        	
//        	if (i < userNum) {
//        		
//        		for (int j = 1; j <= userNum -i; j++) {
//        			stars += " ";
//        		}
//        		
//        		for (int j =1; j <=2*i - 1; j++) {
//        			stars += "*";
//        		}
//        		System.out.println(stars);
//        		
//        	} else {
//        		
//        		int lowerI = i - userNum +1; 
//        		
//        		for (int j =1; j <= lowerI - 1; j++ ) {
//        			stars += " ";
//        		}
//        		
//        		for (int j= 1; j <= 2 * userNum + 1 - 2 * lowerI ; j++) {
//        			stars += "*";
//        		}
//        		System.out.println(stars);
//        	}
//        }
        
        	int maxHeight = 2 * userNum -1;
        	
        	for(int i = 1; i <= maxHeight; i++) {
        		String stars = "";
        		
        		// i 번째 줄의 공백의 갯수를 저장할 변수
        		int spaceWidth = 0;
        		
        		// i 번째 줄의 별의 갯수를 저장할 변수
        		int starWidth = 0;
        		
        		if(i < userNum) {
        			// 윗부분
        			spaceWidth = userNum - i;
        			starWidth = 2 * i - 1;
        		} else {
        			// 아랫부분
        			int lowerI = 2 * userNum - i;
        			
        			spaceWidth = userNum - lowerI;
        			starWidth = 2 * lowerI - 1;
        		} 
        		
        		// 공백을 담당하는 j for 문
        		for(int j = 1; j <= spaceWidth; j++) {
        			stars += " ";
        		}
        		// 별을 담당하는 j for 문
        		for(int j = 1; j <= starWidth; j++) {
        			stars += "*";
        		}
        		System.out.println(stars);
        	}
        
    
        scanner.close();
    }

}
