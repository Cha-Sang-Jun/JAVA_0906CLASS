package chapter06;
//1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 평균 점수를 출력하는 프로그램을 작성해봅시다. 
//각 점수는 랜덤한 값을 생성해서 입력

public class ScoreArray {
	public static void main(String[] args) {
		
		// 국영수 점수를 각 10개씩 저장할 수 있는 2차원 배열
		int[][] score = new int[10][3];
		
		// 과목별 총합을 저장하는 변수
		int totalKorScore = 0;
		int totalEngScore = 0;
		int totalMathScore = 0;
		
		// 랜덤한 숫자를 점수로 저장
		for(int i=0; i < score.length; i++) {
			for(int j=0; j < score[i].length; j++) {
				
				// 랜덤한 숫자 구하기 0~100
				int num = (int)(Math.random() * 71) + 30  ;
				// int num = (int)(Math.random()* 101);
				// Math.random() =>   0 <= r < 1.0
				// Math.random() * 101 =>   0.0 <= r < 101.0
				// (int)(Math.random()*101) =>   0 <= r <= 100
				
				score[i][j] = num;
				
			}
		}
	
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------");
		
		// for-each 를 이용한 출력
		for(int[] arr : score) {
			// 과목 3개의 총합
			int scoreSum = 0;
			
			for(int n: arr) {
				System.out.print(n + "\t");
				scoreSum += n;
			}
			
			System.out.println(scoreSum + "\t" + (float)scoreSum/arr.length );
		}
		
		// 과목의 총점을 구하기
		for(int i=0; i < score.length; i++) {
			for(int j=0; j < score[i].length; j++) {
				if(j == 0) {
					totalKorScore += score[i][j];
				} else if(j == 1) {
					totalEngScore += score[i][j];
				} else {
					totalMathScore += score[i][j];
				}
			}
		}
		
		System.out.println("------------------------------------");
		System.out.println(totalKorScore + "\t" + totalEngScore + 
				"\t" + totalMathScore + "\t과목총점");
		/////////////////////////////////////////////////////////
		
		// 평균 구하기
		float avgKor = (float)totalKorScore / score.length;
		float avgEng = (float)totalEngScore / score.length;
		float avgMath = (float)totalMathScore / score.length;
		System.out.println(avgKor + "\t" + avgEng + "\t" + avgMath + "\t과목평균");
	} 

}
