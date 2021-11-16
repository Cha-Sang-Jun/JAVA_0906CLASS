package day0913;
// 배열(Array)
// 배열이란 우리가 지정한 갯수만큼의 똑같은 데이터타입의 변수들을
// 한개의 이름으로 묶어서 처리를 하는 자료형이다.

// 예를 들어서, 우리가 점수 4개를 score1, score2, score3, score4 이렇게
// 따로따로 변수를 만드는 것이 아니라 길이가 4인 int 배열을 만들어서
// 0번째칸, 1번째칸, 2번째칸, 3번째칸에 각각 값을 저장하거나 호출하는 방식으로 사용하겠다 라는 의미가 된다.

// 배열의 경우, 참조형 데이터타입이므로 다음과 같은 방법으로 초기화 해야한다.
// 데이터타입[] 배열이름 = new 데이터타입[길이];
// 'new' 라는 키워드는 heap 영역에 공간을 마련하라는 키워드가 된다.

public class Ex02Array {
	public static void main(String[] args) {
		
		// int 배열 intArray를 선언하기
		int[] intArray;
		
		// 배열을 초기화 할 때는 해당 배열이
		// 총 몇개의 변수를 관리할 것인지를 반드시 지정해주어야 한다.
		// 즉, 총 몇칸짜리 배열인지를 지정해주어야 한다.
		
		// intArray를 3칸짜리 배열로 초기화하기
		intArray = new int[3];
		
		// 우리가 일반적인 int변수는 각각의 int 변수의 이름을 호출하여 관리하였지만
		// 배열일 때는 이름이 아니라 칸의 번호를 호출하여 관리한다.
		// 칸의 번호는 0부터 시작하여 '총 길이 - 1' 이 마지막 칸의 번호가 된다.
		// 위에서 설정한 intArray는 총 길이가 3이므로
		// 0, 1, 2가 칸의 번호가 된다.
		// 이 칸의 번호는 '인덱스'라고 부른다.
		
		// 배열에 특정 인덱스번 칸에 값을 넣을 때에는
		// 배열이름[인덱스] = 값;
		// 으로 넣을 수 있다.
		intArray[0] = 40;
		intArray[1] = 27;
		intArray[2] = 33;
		
		// 배열에 특정 인덱스번 칸에 있는 값을 호출할 때에는
		// 배열이름[인덱스]로 호출할 수 있다.
		System.out.println("intArray[0]: " + intArray[0]);
		System.out.println("intArray[1]: " + intArray[1]);
		System.out.println("intArray[2]: " + intArray[2]);

		// 배열에 관한 팁들
		
		// 1. 초기화시에 길이는 우리가 다른 변수를 사용하여 초기화해줄 수 있다.
		int size = 4;
		intArray = new int[size];
		intArray[2] = 3;
		
		// 2. 해당 배열의 길이는
		//    배열이름.length로 알아볼 수 있다.
		System.out.println("intArray.length: " + intArray.length);
		
		// 3. 특정 인덱스의 값을 출력하거나 값을 저장할 때에는
		//    인덱스의 값을 직접 써줘도 되지만 int 변수를 적어주어도 된다.
		//    특히, 배열 전체의 인덱스를 차례대로 호출할 때는 for 문을 사용하면 된다.
		
		for(int i = 0; i < intArray.length; i++) {
			System.out.printf("intArray[%d]: [%d]\n", i, intArray[i]);
		}
		
		// 4. 만약 존재하지 않는 인덱스를 호출하면 에러가 발생한다.
	    //    System.out.println("intArray[-1]: " + intArray[-1]);
		// 	  System.out.println("intArray[5]:" + intArray[5]);
		
		// 5. 기본형 데이터타입의 배열일 경우 초기화하면 모든 인덱스가 0으로 초기화된다.
		//    참조형 데이터타입의 배열일 경우 초기화하면 모든 인덱스가 null로 초기화된다.
		//    null이란, 참조형 데이터타입에서만 발견되는 특수한 상태로써,
		//    주소값은 부여가 되어있지만 해당 주소값을 참조하여 heap 영역으로 가면
		//    아직 해당 공간이 확보가 안되어있는 상태이다.
		//    null 일 때는 아무것도 실행시킬 수 없다.
				
	}

}
