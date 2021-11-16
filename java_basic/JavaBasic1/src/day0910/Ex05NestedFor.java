package day0910;
// 중첩 for문

// 중첩 for문은
// 바깥쪽 for문이 한번 실행되는 동안
// 안쪽 for문은 전부 반복이 되는 형태이다.

public class Ex05NestedFor {
    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {
            
            for(int j = 101; j <= 104; j++) {
                System.out.printf("i의 현재값: [%d] j의 현재값: [%d]\n", i, j);
            }
            
            System.out.println("--------------\n");
        }
    }

}
