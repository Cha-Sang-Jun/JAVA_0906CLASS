package chapter13;

public class IHaveTwoNum {

	int num1;
	int num2;
	Object key = new Object();
	
	public void addOneNum1() {
		// ....
		// .... --> 처리해야할 부분이 많다면
		synchronized(this) {  // 동기화블락을 사용하여 아무때나 사용되지 못하는 상태로 만든다.
			num1 += 1;  
		}   
	System.out.println("num1 + 1");	
	
	}
	
	public void addTwoNum1(){
		synchronized(this) {
			num1 += 2;
			
		}
	}

	public void addOneNum2() {
		synchronized(key) {
			num2 += 1;
		}
	}
	
	public void addTwoNum2() {
		synchronized(key) {
			num2 += 2;
		}
	}

	public void showAllNumber() {
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
	}
	
	
}
