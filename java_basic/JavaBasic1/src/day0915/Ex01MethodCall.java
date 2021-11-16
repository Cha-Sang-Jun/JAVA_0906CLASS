package day0915;
// call by value 와 call by reference 의 차이
// 메소드를 우리가 호출 할 때 파라미터로 값을 넘기는 경우
// 두 가지 방법으로 값이 넘어가게 된다.

// 기본형 데이터타입의 경우, 해당 변수 혹은 값이 복사 되서 넘어간다.
// 즉 복사된 값이 넘어가므로 "값에 의한 호출" 혹은 call by value 라고 한다.

// 참조형 데이터타입의 경우, 해당 변수 혹은 값의 주소값이 넘어간다.
// 즉 참조 가능한 주소값이 넘어가므로 "참조에 의한 호출" 혹은 call by reference 라고 한다.

public class Ex01MethodCall {
	// call by value 가 발생하는
	// callByVal 메소드
	// 파라미터는 int a
	public static void callByVal(int a) {
		System.out.println("callByVal(int) 호출");
		a = 30;
		a++;
		System.out.println("a의 현재값: " + a);
	}
		// call by Refefrence가 발생하는
		// callByRef 메소드
		// 파라미터는 int[] arr
		public static void callByRef(int[] arr) {
			System.out.println("callByRef(int[])호출");
			arr[0] = 25;
			arr[0]++;
			System.out.println("arr[0]의 현재값: " + arr[0]);
		}
		
		// call By Reference를 사용하기 위해
		// 참조형 데이터타입을 파라미터로 받아올 경우
		// 다음과 같은 경우에는 원본에 아무런 영향을 미치지 않는다.
		public static void insertNewAddr(int[] arr) {
			System.out.println("insertNewAddr(int[]) 호츨");
			arr = new int[7];
			System.out.println("arr의 현재 길이: " + arr.length);
		}
		
		public static void main(String[] args) {
			// int 변수 선언
			int a = 40;
			System.out.println("a의 현재값: " + a);
			
			callByVal(a);
			
			System.out.println("a의 현재값: " + a);
			
			System.out.println("-----------------------------\n");
		
			// int[] 변수 선언
			int [] arr = new int[3];
			arr[0] = 7;
			System.out.println("arr[0]의 현재값: " + arr[0]);
			
			callByRef(arr);
			
			System.out.println("call by reference 이후 arr[0]의 현재값: " + arr[0]);
			
			System.out.println("-----------------------------\n");
			
			System.out.println("arr의 현재 길이: " + arr.length);
			insertNewAddr(arr);
			System.out.println("arr의 현재 길이: " + arr.length);
		}
}
