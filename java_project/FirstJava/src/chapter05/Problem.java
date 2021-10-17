package chapter05;

public class Problem {
	public static void main(String[] args) {

//	StringBuffer 클래스
//	문제 1. 다음 형태로 String 인스턴스를 생성.
//	 String str = “ABCDEFGHIJKLMN”;
//	  그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.
		String str = "ABCDEFGHIJKLMN";
		// reverse
		StringBuffer sb = new StringBuffer(str);
		String reversedStr = sb.reverse().toString();
		System.out.println(reversedStr);
		
//	문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
//	String str = “990929-1010123”
//	 이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.
		String str2 = "990929-1010123";
		String s2;
		
		s2 = str2.replace("-", "");
		System.out.println(s2);
		
	}
}