package day0908;
// 사용자로부터 성별, 나이, 신체등급을 입력받아

// 현역, 공익, 면제를 출력하는 프로그램을 작성하시오
// 단, 사용자가 여성일 경우, 추가적인 입력 없이
// "여성에게는 국방의 의무가 부여되지 않습니다." 만 출력되게 코드 작성
// 단, 사용자가 남성이지만 미성년자인 경우
// "아직 미성년자에게는 신체등급이 부여되지 않습니다." 만 출력되게 코드 작성

// 성별의 경우, 입력시에 int로 입력을 받아 1이면 남자 2면 여자로 판정
// 현역: 1~3
// 공익: 4
// 면제: 그 외

import java.util.Scanner;

public class Ex11Army {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 성별을 입력 받는다.
        System.out.println("성별을 입력해주세요. (1:남자 2:여자)");
        System.out.print("> ");
        int gender = scanner.nextInt();

        if (gender == 1) {
            // 남자이므로 나이를 입력 받는다.
            System.out.println("나이를 입력해주세요.");
            System.out.println("> ");
            int age = scanner.nextInt();
            // 나이를 확인한다.

            if (age >= 19) {
                // 성인이므로 신체 등급을 입력 받는다
                System.out.println("신체등급을 입력해주세요.");
                System.out.println("> ");
                int category = scanner.nextInt();

                if (category <= 3) {
                    System.out.println("현역입니다.");
                } else if (category == 4) {
                    System.out.println("공익 입니다.");
                } else {
                    System.out.println("면제입니다.");
                }

            } else { // 미성년자이므로 메시지만 출력
                System.out.println("아직 미성년자에게는 신체등급이 부여되지 않습니다.");
            }

        } else { // 여자이므로 메시지만 출력
            System.out.println("여성에게는 국방의 의무가 부여되지 않습니다.");
        }

        scanner.close();
    }
}
