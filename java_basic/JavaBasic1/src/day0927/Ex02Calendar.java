package day0927;
// 시간을 관리하는 Calendar

import java.text.SimpleDateFormat;

// Calendar 클래스의 경우
// java.util.DateTime 이라는 클래스의 좀 더 세련된 버전이다.
// 기존의 DateTime 은 더 이상 사용되지 않는다.

import java.util.Calendar;

public class Ex02Calendar {
	public static void main(String[] args) {
		// Calendar 클래스 객체는 초기화 할 때
		// 생성자가 아닌 Calendar 클래스의 getInstance() 라는 static 메소드를 통하여 초기화한다.
		Calendar cal = Calendar.getInstance();

		// Calendar 객체를 화면에 직접 출력해보자
		System.out.println(cal);

		// Calendar 클래스 객체의 경우
		// 그리니치 표준시간 기준 1970년 1월 1일 0시 0분부터 현재 시간을
		// 1/1000 초로 저장하여 다루게 된다.

		// Calendar 객체의 필드 값들을 우리가 한번 알아보자
		// 필드에 저장된 값을 호출할 때에는
		// 객체.get(필드명) 으로 불러올 수 있다.

		System.out.println("연도: " + cal.get(Calendar.YEAR));
		// 월의 경우, 1~12가 아닌 0~11로 설정되어 있다.
		System.out.println("월: " + cal.get(Calendar.MONTH));
		System.out.println("일: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("시(12시간기준): " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간기준): " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분: " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("=================================\n");

		// Calendar 객체에 임의의 시간을 저장할 때는 set() 메소드를 사용하면 된다.
		// 이 때에는 3가지 방법이 있다.
		// 1. 특정 필드에 특정 값을 넣는다.
		cal.set(Calendar.YEAR, 1999);
		System.out.println("연도: " + cal.get(Calendar.YEAR));
		// 2. 파라미터로 연, 월, 일을 넣는다.
		cal.set(2002, 5, 20);
		System.out.println("연도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + cal.get(Calendar.MONTH));
		System.out.println("일: " + cal.get(Calendar.DAY_OF_MONTH));
		// 3. 파라미터로 연, 월, 일, 시, 분, 초 를 넣는다.
		cal.set(1999, 1, 1, 13, 24);
		System.out.println("연도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + cal.get(Calendar.MONTH));
		System.out.println("일: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("시(24시간기준): " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분: " + cal.get(Calendar.MINUTE));

		// 4. 파라미터로 연, 월, 일 , 시, 븐 , 초를 넣는다.
		cal.set(2021, 8, 27, 16, 52, 30);
		System.out.println("연도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + cal.get(Calendar.MONTH));
		System.out.println("일: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("시(24시간기준): " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분: " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("=================================\n");
		
		// 만약 우리가 캘린더 객체를 우리가 원하는 양식으로 출력하려면?
		// SimpleDateFormat 이라는 객체를 사용하여 출력해야 한다.
		// 단, 캘린더 객체를 그대로 넣어주는 것이 아니라 현재 저장된 1/1000초 값인
		// time을 getTime() 이라는 메소드를 통해 넣어주어야 한다.
		
		SimpleDateFormat sdf;
		
		// SimpleDateFormat의 객체를 초기화할 때
		// 파라미터 있는 생성자를 선택해서 우리가 원하는 양식을 지정해준다.
		String format = new String("y년 M월 d일 H시 m분 s초");
			
		sdf = new SimpleDateFormat(format);
		
		// SimpleDateFormat 객체를 통하여 우리의 시간을 출력해보자
		System.out.println(sdf.format(cal.getTime()));
		
		// Calendar 객체의 경우, 기본적으로 lenient 라는 필드가 true로 되어 있는데
		// 그 의미는 어느정도 유도리 있게 값 저장을 받겠다라는 뜻이 된다.
		// 즉, 해당 월의 날짜를 1~30이 아닌 59 같은 날짜도 저장 가능하다,
		// 이때에는 자동으로 지정한 달 + 29 일째가 저장된다.
		cal.set(Calendar.DAY_OF_MONTH, 59);
		System.out.println(sdf.format(cal.getTime()));
		
		// 단, lanient를 false 로 하면 범위를 벗어난 값을 입력시 에러가 발생한다.
		cal.setLenient(false);
		cal.set(Calendar.DAY_OF_MONTH, 59);
		System.out.println(sdf.format(cal.getTime()));
	}
}
