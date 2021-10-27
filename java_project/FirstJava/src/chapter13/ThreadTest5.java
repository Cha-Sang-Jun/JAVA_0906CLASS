package chapter13;
// Increment -> IncThread -> ThreadTest5

public class ThreadTest5 {

	public static void main(String[] args) {
		Increment increment = new Increment();
		
		IncThread thread1 = new IncThread(increment);
		IncThread thread2 = new IncThread(increment);
		
		thread1.start();
		thread2.start(); // 2번 돌리면 2억이 나와야하는데 안나오는 이유 -> thread1 이 처리되는 과정에서 정상적으로 데이터를 가져올 수 없었다는 것. -> why? -> Increment 메소드를 synchronized(동기화)처리 해야 한다.
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(increment.getNum());
		
		
	}
}
