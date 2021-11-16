package day0909;
// 사용자로부터 키와 몸무게를 입력 받아

// BMI 수치를 계산하고 비만도를 출력하는 프로그램을 작성

// 기네스 북에 따르면 세계에서 가장 키가 컸더 사람의 키는 2.72m 였습니다.
// 기네스북에 따르면 세계에서 가장 몸무게가 무거웠떤 사람의 몸무게는 650kg이였습니다.

// 만약 사용자가 잘못된 값을 입력할 경우, 추가적인 입력 없이
// "잘못된 입력을 감지하여 프로그램을 종료합니다." 라는
// 메시지가 출력되면서 프로그램이 종료되게 코드를 작성하시오.

import java.util.Scanner;

public class Ex05BmiChecker3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double HEIGHT_MAX = 2.72;
        final double WEIGHT_MAX = 650;
        final double BMI_STD1 = 18.5;
        final double BMI_STD2 = 23;
        final double BMI_STD3 = 25;

        // 키
        System.out.println("키를 m 단위로 입력해주세요.");
        System.out.print("> ");
        double height = scanner.nextDouble();

        while (height > HEIGHT_MAX || height < 0) {
            System.out.println("잘못된 입력입니다. 키를 다시 입력해주세요");
            System.out.print("> ");

            height = scanner.nextDouble();
        }

        if (height > 0 && height < HEIGHT_MAX) {
            // 키가 올바른 값이므로 몸무게 입력을 받는다.
            System.out.println("몸무게를 kg 단위로 입력해주세요.");
            System.out.print("> ");
            double weight = scanner.nextDouble();

            while (weight > WEIGHT_MAX || weight < 0) {
                System.out.println("잘못된 입력입니다. 몸무게를 다시 입력해주세요");
                System.out.print("> ");

                weight = scanner.nextDouble();
            }

            if (weight > 0 && weight <= WEIGHT_MAX) {
                // 몸무게가 올바른 값이므로 BMI 계산 -> 비만도 결정 -> 결과출력실행

                // 이름
                System.out.println("이름을 입력해주세요.");
                System.out.print("> ");
                scanner.nextLine();
                String name = scanner.nextLine();

                // BMI계산
                double bmi = weight / height / height;

                // 비만도 결정
                String result;

                if (bmi < BMI_STD1) {
                    result = "저체중";
                } else if (bmi < BMI_STD2) {
                    result = "정상체중";
                } else if (bmi < BMI_STD3) {
                    result = "과체중";
                } else {
                    result = "고도비만";
                }

                // 결과 출력
                System.out.printf("이름: [%s] 키: %.2f 몸무게: %.2f\n", name, height, weight);
                System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);
            }
        }

        
        System.out.println("\n----------------------\n");
        
        // 상수
        final double MAX1 = 2.72;
        final double MAX2 = 650;
        final double STD1 = 18.5;
        final double STD2 = 23;
        final double STD3 = 25;
        
        // 키
        System.out.println("키 입력해주세요");
        System.out.print("> ");
        double hei = scanner.nextDouble();
        
        while(!(hei > 0 && hei <= MAX1)) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            System.out.print("> ");
            hei = scanner.nextDouble();
        }
        
        // 몸무게
        System.out.println("몸무게를 입력해주세요");
        System.out.print("> ");
        double wei = scanner.nextDouble();
        
        while(!(wei > 0 && wei <= MAX2)) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            System.out.print("> ");
            wei = scanner.nextDouble();
        }
        
        // BMI 계산
        double bmi2 = wei / hei / hei;
       
        // 결과값
        String result2 = "비만";
        
        if(bmi2 < STD1) {
            result2 = "저체중";
        } else if (bmi2 < STD2) {
            result2 = "정상체중";
        } else if (bmi2 < STD3) {
            result2 = "과체중";          
        }
        
        System.out.println(result2);

            

        scanner.close();
    }

}
