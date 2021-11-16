package day0914;
// 구구단을 출력하는 프로그램을 작성하시오.
// 단, 2차원 배열을 사용하여
// 각 단의 결과값을 배열에 저장하시오

public class Ex04Gugudan {
	public static void main(String[] args) {
		int[][] gugudan = new int[8][9];
		
		for(int i = 0; i < gugudan.length; i++) {
			for(int j = 0; j < gugudan[i].length; j++) {
				int left = i + 2;
				int right = j + 1;
				gugudan[i][j] = left * right;
			}
		}
		
		for(int i = 0; i < gugudan.length; i++) {
			for(int j = 0; j < gugudan[i].length; j++) {
				System.out.println(i + "x" + j + "= " + gugudan[i][j]);
				
			}
		}
	}

}
