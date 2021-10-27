package chapter13;

import javax.swing.JOptionPane;

// 실제 스레드를 만드는 것이 아닌 스레드가 필요한 상황을 만든다.

public class ThreadTest3 {
	
	public static void main(String[] args) throws InterruptedException {
		String input = JOptionPane.showInputDialog("아무 데이터나 입력하세요.");
		System.out.println("입력하신 데이터는 " + input + " 입니다.");
		
		for(int i=10; i > 0; i--) {
			System.out.println(i);
			
			Thread.sleep(1000);
		}
	
	
	}
	
}
