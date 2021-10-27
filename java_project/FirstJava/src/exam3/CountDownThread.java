package exam3;

import java.util.Random;

import exam3.HighLowGame;

public class CountDownThread extends Thread {

	@Override
	public void run() {

		for (int i = 30; i > 0; i--) {

			if (HighLowGame.inputCheck) {
				System.out.println("숫자 맞추기에 성공하여 카운트다운을 멈춥니다.");
				return;
			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("입력시간이 초과되었습니다. 프로그램을 종료합니다.");
		System.exit(0);

	}
}
