package chapter06;

public class Test {
	public static void main(String[] args) {

		// 국영수 점수를 각 10개씩 저장할 수 있는 2차원 배열
		int[][] score = new int[10][3];

		// 과목별 총합을 저장하는 변수
		int totalKoreanScore = 0;
		int totalEnglishScore = 0;
		int totalMathScore = 0;
		
		// 랜덤한 숫자를 점수로 저장
		for(int i=0; i< score.length; i++) {
			for(int j=0; j< score[i].length; j++) {
				
				// 랜덤한 숫자 구하기 0~100
				int num = (int)(Math.random() * 60) + 41;
				
				score[i][j] = num;
			}
		}
		
		// for-each 를 이용한 출력
		for(int[] arr : score) {
			
		}
		// 과목 3개의 총합

		// 과목의 총점을 구하기

		// 평균 구하기

	}
}
