package chapter13;

public class Increment {
	
	int num;
	
	// 동기화 처리를 하는 위치가 중요하다.
	public synchronized void increment() {  // synchronized => 동기화 처리. 다음 스레드 객체는 사용하지 못하도록. 이 increment 메소드가 화장실이라고 생각하면 thread1이 먼저 들어왔으면 thread2는 밖에서 기다려야함.
		num++;
	}
	
	public int getNum() {
		return num;
	}
}
