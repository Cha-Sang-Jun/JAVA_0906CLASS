package day0909;

import java.util.Scanner;

public class Ex10BmiChecker4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 상수
        // 최대키
        final double MAX_HEIGHT = 2.72;
        // 최대몸무게
        final double MAX_WEIGHT = 650;
        // bmi 기준1
        final double BMI_STD1 = 18.5;
        // bmi 기준2
        final double BMI_STD2 = 23;
        // bmi 기준3
        final double BMI_STD3 = 25;

        // 변수
        double height = 0;
        double weight = 0;
        String name = "";

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print(" >");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 입력 코드 구현

                // 이름 입력
                System.out.println("이름을 입력해주세요");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                // 키 입력
                System.out.println("키를 입력해주세요");
                System.out.print("> ");
                height = scanner.nextDouble();

                while (height <= 0 || height > MAX_HEIGHT) {
                    System.out.println("잘못 입력하셨습니다.");

                    System.out.println("키를 다시 입력해주세요.");
                    System.out.print("> ");
                    height = scanner.nextDouble();
                }

                // 몸무게 입력
                System.out.println("몸무게를 입력해주세요");
                System.out.print("> ");
                weight = scanner.nextDouble();

                while (weight <= 0 || weight > MAX_WEIGHT) {
                    System.out.println("잘못 입력하셨습니다.");

                    System.out.println("몸무게를 다시 입력해주세요.");
                    System.out.print("> ");
                    weight = scanner.nextDouble();
                }

            } else if (userChoice == 2) {
                // 출력 코드 구현
                
                // 사용자가 입력을 했는지 안했는지 확인하기 위해서
                // height의 값이 0과 같은지 확인한다.
                // 만약 0과 같다는 것은 '입력 코드가 실행된 적 없다' 라는 의미이므로
                // "아직 입력된 정보가 없습니다." 를 출력해주고
                // 그 외의 경우에는 정보를 출력하는 코드를 차례대로 실행시킨다.
                
                if(height == 0) {
                    System.out.println("아직 입력된 정보가 없습니다.");
                } else {
                    
                // 저장된 값을 토대로 BMI 계산
                double bmi = weight / height / height;
                // BMI를 토대로 비만도 결정
                String result = "비만";
                if (bmi < BMI_STD1) {
                    result = "저체중";
                } else if (bmi < BMI_STD2) {
                    result = "정상체중";
                } else if (bmi < BMI_STD3) {
                    result = "과체중";
                }
                
                /// 출력
                System.out.printf("이름: [%s] 키: %.2f 몸무게: %.2f\n", name, height, weight);
                System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);
                
                }
                
            } else if (userChoice == 3) {
                
                // 메시지 출력 후 break
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }

        scanner.close();
    }

}
