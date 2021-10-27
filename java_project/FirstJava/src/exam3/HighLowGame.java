package exam3;

import java.util.Random;

import javax.swing.JOptionPane;

import exam3.CountDownThread;

public class HighLowGame {

	static boolean inputCheck = false;

	public static void main(String[] args) {

		CountDownThread t = new CountDownThread();
		t.start();

		Random ran = new Random();
		int randomNum = ran.nextInt(49) + 1;

		while (true) {
			int input = Integer.parseInt(JOptionPane.showInputDialog("'1~50' 까지의 숫자 하나를 입력하세요."));
			System.out.println("입력하신 숫자는 " + input + " 입니다.");

			if (randomNum > input) {
				System.out.println("입력하신 숫자보다 큰 숫자 입니다.");
			} else if (randomNum < input) {
				System.out.println("입력하신 숫자보다 작은 숫자 입니다.");
			} else if (randomNum == input) {
				System.out.println("랜덤숫자 맞추기에 성공하셨습니다.");
				inputCheck = true;
				break;
			}
		}

	}
}