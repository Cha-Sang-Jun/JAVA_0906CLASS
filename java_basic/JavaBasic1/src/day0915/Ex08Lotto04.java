package day0915;
// ArrayUtil을 사용한 로또 번호 제작기
import java.util.Random; 

import util.ArrayUtil;

public class Ex08Lotto04 {
	public static void main(String[] args) {
		Random random = new Random();
		int[] numbers = new int[0];
		
		while(ArrayUtil.size(numbers) < 6) {
			int num = random.nextInt(45) + 1;
			if(!ArrayUtil.contains(numbers, num)) {
				numbers = ArrayUtil.add(numbers, num);
			}
		}
		
		for(int i = 0; i < ArrayUtil.size(numbers); i++) {
			System.out.println(ArrayUtil.get(numbers, i));
		}
	}

}
