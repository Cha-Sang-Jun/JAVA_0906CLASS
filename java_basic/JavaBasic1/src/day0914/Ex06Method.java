package day0914;
// 메소드 (★★★★★)

// 메소드란, 여러 줄의 코드를 합쳐서
// 하나의 기능으로 만들어 놓은 것을 메소드라고 한다.

// 예를 들어, Scanner 클래스 변수의 nextInt() 라는 메소드를 실행했을 때,
// 우리가 적은 것은 한줄이지만 (scanner.nextInt())
// 실제로는, 해당 메소드 안에 적혀있는 모든 코드들이 차례대로 실행이 되는 구조이다.
// 즉, 하나의 단축어라고도 할 수 있다.

// 예를들어
// "라면 끓여와" 라는 메소드를 실행하게 된다면 실제로는
// 1. 라면을 준비한다.
// 2. 냄비를 준비한다.
// 3. 냄비에 물을 넣는다.
// 4. 냄비를 가스렌지 위에 올린다.
// 5. 라면 봉지를 연다.
// 6. 라면 물이 끓으면 라면 봉지의 내용물을 냄비에 넣는다 ~~~ 등등
// 메소드는 한 개의 명령으로 끝나지만
// 실제로는 위와 같은 여러 단계를 거치는 것과 마찬가지다.

// 메소드의 경우, 선언과 구현으로 나눌 수가 있는데
// 클래스의 경우, 메소드는 반드시 선언과 구현이 같이 이루어져야 한다.

// 메소드의 선언은 다음과 같이 이루어진다.
// 접근제한자 (static) 리턴타입 메소드이름(파라미터)

// 접근제한자: 해당 메소드를 외부 클래스가 접근할때
//          어디에 있는 외부 클래스가 접근 가능한지 설정하는 키워드.
// 	        Access Modifier 라고 한다.
//          접근제한자는 public, protected, package, private 4종류가 있다.

//          public : 다른 패키지에 있는 다른 클래스도 실행 가능
//          protected: 같은 패키지에 있는 다른 클래스는 실행 가능
//                     다른 패키지에 있는 다른 클래스의 경우는 상속관계 일때에만 실행 가능
//          package : 같은 패키지에 있는 다른 클래스들만 실행 가능.         
//                    단, 패키지 접근 제한자는 우리가 아무런 접근제한자를 적어주지 않을때에만 적용된다.
//          private : 다른 패키지는 어디에 있던간에 실행할 수 없다.
//                    즉, 해당 클래스만 실행가능하다.

// static: static 키워드는 해당 메소드를 클래스 변수를 선언하지 않고 사용할 수 있게 한다.
//         예를들어, 만약 우리가 기존에 사용하던 Scanner 클래스의 nextInt() 메소드에
//         static 키워드가 붙어있다면, Scanner scanner = new Scanner(System.in) -> scanner.nextInt() 로 사용하는 것이 아니라
//         Scanner.nextInt() 의 방식으로 사용하게 되는 것이다.
//         static 키워드는 우리가 생략할 수 있지만 만약 static 메소드가 다른 메소드를 곧장 호출할 때에는 그 다른 메소드에도
//         static이 반드시 붙어야 한다.

// 리턴타입: 리턴 타입이란, 해당 메소드가 종료될 때 호출된 곳으로 보내줄 값의 데이터타입을 말한다.
//         예를 들어서, 스캐너 클래스의 nextInt() 메소드는 리턴 타입이 int라고 적혀있고,
//         내부적으로 코드를 모두 다 실행 시킨 후에는 int 타입의 값을 호출한 곳으로 보내주는 형태가 된다.
//         리턴 타입이 존재할 시에는 해당 메소드의 내부에서 반드시 return 이라는 키워드를 통해서 해당 데이터타입과 일치하는 값을
//         "리턴" 해주어야 한다.
//         만약 해당 메소드가 아무런 값도 리턴하지 않을 때에는 리턴 타입에 void 라고 적어야 하며 이 때에는 오히려
//         return 키워드를 적으면 에러가 발생한다.

// 메소드이름: 소문자로 시작하고 낙타등 표기법을 따르는 동사

// 파라미터: 파라미터란, 해당 메소드를 실행시킬 때 필요하여 외부로부터 받아오는 값을 변수로 선언해둔 것이다.
//        예를들어, 라면끓이기() 라는 메소드를 실행하기 위해서는 "라면 진라면","냄비 양은냄비" 이런 식으로
//        재료가 필요하듯, 메소드를 실행 시킬 때 외부로부터 받아올 값을 우리가 변수로 만든 것이다.
//        그렇기 때문에 한국말로는 "매개변수" 라고도 한다.

public class Ex06Method {
	public static void main(String[] args) {
	
		int usernum = 24;
	
		printNum(usernum);	
//		printNum();	
		int score = 2;
		printNum(score);
		printNum(5);

		
		String name = "차상준";
	    printName(name);
		printName("아이스");
		String str = "이영이";
		printName(str);
		
		int num = selectNum();
		System.out.println("num의 현재 값: " + num);
	}

	public static void printNum(int usernum) {
		System.out.println(1);
		System.out.println(2);
		System.out.println(usernum);
		
	}
	
	public static void printName(String name) {
		System.out.println(name+"1");
		System.out.println(name+"2");

	}


	public static int selectNum() { // int 데이터타입의 메소드
		System.out.println("selectNum() 실행"); // 코드를 순차적으로 실행한 후 num 값을 5로 되돌려준다.
		System.out.println("이런 저런 코드 실행");
		System.out.println("최종 결과값 5를 호출된 곳으로 보내준다.");
		return 5; // int 데이터타입을 return 시켜줘야 오류가 나지 않는다.
	}
}
