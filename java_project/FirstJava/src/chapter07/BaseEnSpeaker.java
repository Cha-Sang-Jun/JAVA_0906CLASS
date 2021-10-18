package chapter07;

public class BaseEnSpeaker extends Speaker {
	
	private int volumeRate;
	
	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	// 오버라이딩
	// 상위 클래스의 메소드의 선언부를 일치시키고
	// 처리부를 변경하는것
	
	// @(에노테이션) : 추가적인 기능을 하거나 추가적인 의미부여를 해줄때 사용
	// @Override : 상위 클래스의 메소드를 오버라이딩한다.
	//             오버라이딩의 규칙에 맞게 정의하는지 체크
	@Override
	public void showCurrentState() {
		super.showCurrentState();
		System.out.println("베이스 크기: " + baseRate);
	}
	
	public static void main(String[] args) {
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.showCurrentState(); // 오버라이딩 된게 출력된다.
		
		System.out.println("=============================");
		
		Speaker speaker = new Speaker();
		speaker.showCurrentState();
		
		System.out.println("=============================");
		// 다형성
		// 상위 타입의 참조변수 = 하위 타입의 인스턴스
		// 참조변수의 타입에 정의된 멤버만 사용이 가능하다.
		Speaker sp = new BaseEnSpeaker();
		// 하나의 타입(Speaker)으로 여러타입 (BaseEnSpeaker 등)을 만들어 낼 수 있다.
		// is a => BaseEnSpeaker is a Speaker
		sp.showCurrentState();
//		sp.setBaseRate(100); -> // 메모리에는 남아있지만 Speaker 클래스에 setBaseRate()가 없기 떄문에 실행은 되지 않는다.
	
	}

}
