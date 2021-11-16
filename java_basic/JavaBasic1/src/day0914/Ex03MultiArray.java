package day0914;
// 다차원 배열
// 배열은 똑같은 데이터타입을 모아둔 하나의 데이터타입이다.
// 그렇기 때문에 배열을 모아둔 배열도 가능하다.
// 이렇게 배열을 모아둔 배열을 이차원 혹은 다차원 배열이라고 한다.

// 2차원 배열을 좀 더 쉽게 이해하기 위해서
// 표를 그린다고 생각하면 된다.

// 2차원 배열의 선언과 초기화는 다음과 같다.
// int[][] 배열이름 = new int[배열의 갯수][각 배열의 칸수];

public class Ex03MultiArray {
	public static void main(String[] args) {
		int[][] arr = new int[3][2];
		// 위의 int 2차원 배열 arr은
		// int가 2개 모여있는 배열이 3개 있는
		// 2차원 배열이란 의미이다.
		
		// 만약 우리가 0번째 배열의 1번째 칸(인덱스)에
		// 값을 넣을 때에는
		arr[0][1] = 40;
		// 으로 넣어줄수 있다.


	}

}
