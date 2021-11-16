package day0910;
// 구구단을 출력하는 프로그램을 작성하시오.
// 단, 몇단인지는 i for문으로 출력하고
// a x b = ab는 j for문으로 출력하시오.


public class Ex06Gugudan {
    public static void main(String[] args) {
        
        int sum = 1;
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%d단\n", i);
            
            for(int j = 1; j <= 9; j++) {
                sum = i*j;
                System.out.printf("%d x %d = %d\n", i, j, sum);
            }
        }
    }

}
