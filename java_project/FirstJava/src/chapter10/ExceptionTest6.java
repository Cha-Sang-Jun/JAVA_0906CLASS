package chapter10;

// 논리적인 오류로 발생한 예외처리를 하는 방법

public class ExceptionTest6 {

	public static void main(String[] args) throws Exception {

		try {
			// 1. 예외 객체 생성
			Exception e = new Exception("고의로 발생시킨 예외");

			// 2. 예외 발생
			throw e;

		} catch (Exception e) {
			System.out.println("예외 메시지: " + e.getMessage());
			e.printStackTrace();  // 이 부분들을 주석처리하면 예외처리하지 않고 넘어갈 수 있음.
		}

		System.out.println("프로그램이 종료됩니다.");

	}
}
