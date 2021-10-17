package chapter04;

import java.util.Calendar;
import java.util.Scanner;

public class Member {
	// 1. 앞에서 만든 Member 클래스에는 아래 요구사항에 맞는 메소드를 정의하고, main()메소드에 해당 메소드를 호출해서 결과를
	// 확인해보세요. 메소드의 이름도 JAVA의 규칙에 맞게 정의해 봅시다.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Member member = new Member();
		
		member.vaccinCheck(1940);
		member.checkUp(1970);
		
		System.out.println("태어난 년도를 입력해주세요.");
		System.out.println("> ");
		int num1 = Integer.parseInt(scanner.nextLine());
		member.vaccinCheck(num1);
		member.checkUp(num1);
		
	}

	// ① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
	// - 매개변수로 태어난 해(년도)를 전달받습니다.
	// - 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
	// - 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.

	public void vaccinCheck(int birthYear) {
		int age = 2021 - birthYear - 1; 
		
		// boolean checkAge1 = age < 15 || age >= 65;
		// boolean checkAge2 = !(age >= 15 && age < 65); --> 이 비교 연산자를 만드는 것이 중요함. 범위를 어떻게 만드느냐에 따라 나중에 어려워질수도 편해질수도 있다.
		
		if(age < 15 || age >= 65) {
			System.out.println("무료예방 접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}

	}
	// ② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
	// - 매개변수로 태어난 해(년도)를 전달받습니다.
	// - 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
	// - 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
	// - 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
	
	public void checkUp(int birthYear) {
		int age = 2021 - birthYear - 1;  // 나이 연산은 위와 중첩된다. 중첩되는 것은 메소드 하나로 만들면 편하다.

		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		boolean check = birthYear %2 == year %2;
		
		if(age >= 20 && check) {
			System.out.println("무료로 건강검진을 받을 수 있습니다.");
		} else if(age >= 40) {
			System.out.println("무료로 암 검사를 받을 수 있습니다.");
		} else {
			System.out.println("무료 건강검진 대상이 아닙니다.");
		}
	}

}
