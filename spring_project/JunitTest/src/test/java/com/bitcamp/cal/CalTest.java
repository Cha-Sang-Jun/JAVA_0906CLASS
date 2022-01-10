package com.bitcamp.cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalTest {
	
	// 참조변수
	Calculator cal;
	
	// 테스트 코드 작성 전 -> 테스트 케이스 정의
	// ex) add 클래스 num1 10과  num2 20을 주었을 때 성공은 30 그 외에는 Fail이라는 명확한 케이스가 있어야 한다.

	// @Before : @Test 실행 전에 실행
	@Before
	public void setup() {
		System.out.println("@Before 메소드 실행");
		cal = new Calculator();
	}
	
	// @After : @Test 실행 후에 실행
	@After
	public void tearDown() {
		System.out.println("@After 메소드 실행");
	}
	
	// @BeforeClass : (테스트)객체가 생성되기 전
	@BeforeClass
	public static void setupForClass() {
		System.out.println("@BeforeClass 메소드 실행");
	}
	
	// @AfterClass : 객체 소멸 전
	@AfterClass
	public static void tearDownForClass() {
		System.out.println("@AfterClass 메소드 실행");
	}
	
	// @Test
	@Test
	public void test1() {
		
		System.out.println("@Test 단위 테스트 메소드 실행");
		
		int num1 = 20;
		int num2 = 10;
		
		// assertEquals(expected, actual) : 기대값과 실행값이 같으면 성공
		// add메소드의 테스트 케이스 -> 값을 전달하면 10을 반환해야 성공  => 잘못된 테스트 케이스의 경우
		// 30을 반환해야 성공  => 제대로 된 테스트 케이스의 경우
		assertEquals("add(20,10)", 30, cal.add(num1, num2));
		
		// substract -> 20, 10 전달하면 결과값은 10 반환 => 성공
		assertEquals("substract(20,10)", 10, cal.substract(num1, num2));
		
		// multiply -> 20, 10 전달하면 결과값은 200 반환 => 성공
		assertEquals("multiply(20,10)", 200, cal.multiply(num1, num2));
		
		// divide -> 결과값 2 => 성공
		assertEquals("divide(20,10)", 2, cal.divide(num1, num2));
		
		// fail("무조건 실패!!!");
		
		// 논리값을 가지고 비교 결과 처리
		// 특정 결과를 어떤 값과 비교 or 논리 연산을 통해 성공, 실패
		// assertTrue("비교=>", false);
		assertTrue("비교", cal.add(num1, num2) > 20);
		
		// null 값을 비교 : null 이면 성공
		assertNull("null이면 성공", null);
		// assertNull("null이면 성공", "");
		
		// not null 비교 : null이 아니면 성공
		assertNotNull("not null이면 성공", cal.add(num1, num2));
		assertNotNull("not null이면 성공", "");
	}

}
