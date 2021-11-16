package day0908;
// 사용자로부터 정보를 입력 받아서

// 다음과 같은 형식으로 비만도를 출력하는 프로그램을 작성하시오

// 결과)))
// 이름: [###] 키: #.##m 몸무게: ##.## kg
// BMI : ##.### 비만도: ###

//단, BMI 공식은 몸무게 / 키(m) / 키(m)
// 비만도
// ~18.5 : 저체중, ~23 : 정상체중, ~25: 과체중 // 그 외 : 고도비만

import java.util.Scanner;

public class Ex09BmiChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");

        String name = scanner.nextLine();

        System.out.println("키를 입력해주세요");
        System.out.print("> ");

        double height = scanner.nextDouble();

        System.out.println("몸무게를 입력해주세요.");
        System.out.print("> ");

        double weight = scanner.nextDouble();

        double bmi = weight / height / height;

        System.out.printf("이름: [%s] 키: [%4.2f(m)] 몸무게: [%5.2f(kg)]\n", name, height, weight);
        System.out.printf("BMI: [%6.2f]  ", bmi);

        if (bmi <= 18.5) {
            System.out.println("비만도: 저체중");
        } else if (bmi <= 23) {
            System.out.println("비만도: 정상체중");
        } else if (bmi <= 25) {
            System.out.println("비만도: 과체중");
        } else {
            System.out.println("비만도: 고도비만");
        }

        System.out.println("--------------------\n");

        // 상수
        final double BMI_STD1 = 18.5;
        final double BMI_STD2 = 23;
        final double BMI_STD3 = 25;

        scanner.nextLine();
        // 이름 입력
        System.out.println("이름을 입력해주세요.");
        System.out.print("> ");
        String name1 = scanner.nextLine();

        // 키 입력
        System.out.println("키를 미터 단위로 입력해주세요.");
        System.out.print("> ");
        double key = scanner.nextDouble();

        // 몸무게 입력
        System.out.println("몸무게를 키로그램 단위로 입력해주세요.");
        System.out.print("> ");
        double wei = scanner.nextDouble();

        // BMI 계산
        double bmi1 = wei / key / key;

        // 비만도 값 결정
        // 비만도 값을 저장할 String 클래스 변수 선언
        String result;

        if (bmi1 < BMI_STD1) {
            result = "저체중";
        } else if (bmi1 < BMI_STD2) {
            result = "정상체중";
        } else if (bmi1 < BMI_STD3) {
            result = "과체중";
        } else {
            result = "고도비만"; // if문 안에 string result 값으로 다 묶어주게 되면
                              // if문이 끝난 후 결과 값에 출력할 수 없으므로
        }
        
            // 결과 출력
            System.out.printf("이름: [%s] 키: %.2f 몸무게: %.2f\n", name1, key, wei);
            System.out.printf("BMI: %.3f 비만도: %s\n", bmi, result);

            scanner.close();
       
    }

}
