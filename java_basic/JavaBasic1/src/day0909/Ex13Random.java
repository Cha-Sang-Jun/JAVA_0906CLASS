package day0909;
// Random 클래스
// Random 은 정해진 규칙 없이 무수히 많은 숫자들이
// 나열 되어있꼬 그것을 우리가 하나씩 뽑는 개념인
// 난수를 담당하는 클래스로써
// 우리가 랜덤한 숫자를 뽑을 수 있게 해준다.
// Scanner 와 마찬가지로, java.util에 있는
// Random 클래스를 우리가 불러와야 정상적으로 사용할 수있따.

import java.util.Random;
public class Ex13Random {
    public static void main(String[] args) {
        Random random = new Random();
        //random은 내부적으로
        // 0부터 1사이를 무수한 실수를 뒺구박죽 순서로 가지고있따
        // 우리가 요청할때마다 그 실수를 하나씩 꺼내주는 개념이다
        
        // double 타입의 난수가 필요한 경우
        // nextDouble() 메소드를 사용하면 된다.
        // 이 때에는 double 범위 전체가 난수 범위가 된다.
        System.out.println("1. nextDouble()");
        System.out.println("2: " + random.nextDouble());
        System.out.println("3: " + random.nextDouble());
        System.out.println("4: " + random.nextDouble());
        System.out.println("5: " + random.nextDouble());
        System.out.println("--------------------\n");
        
        
        
        // 만약 int 타입의 난수가 필요할 경우
        // nextInt() 메소드를 사용하면 된다.
        // 이 때에는 int 범위 전체가 난수의 범위가 된다.
        System.out.println("2. nextInt()");
        System.out.println("1: " + random.nextInt());
        System.out.println("2: " + random.nextInt());
        System.out.println("3: " + random.nextInt());
        System.out.println("4: " + random.nextInt());
        System.out.println("------------------------\n");
        
        // 만약 우리가 0부터 특정 범위의 값이 필요한 경우
        // nextInt(최대값) 메소드를 사용하면 된다.
        // 이 때에는 '0'부터 '최대값 -1' 까지의 값이
        // 난수가 범위가 된다.
        System.out.println("3. nextInt(MAX)");
        System.out.println("1: " + random.nextInt(1));
        System.out.println("2: " + random.nextInt(1));
        System.out.println("3: " + random.nextInt(1));
        System.out.println("4: " + random.nextInt(1));
        System.out.println("------------------------\n");
        
        // 그렇다면 만약 우리가
        // 0부터 특정값-1 이 아닌
        // 1부터 특정값 까지의 난수가 필요할 때에는
        // 어떻게 해야 할까?
        System.out.println("4. nextInt(MAX) + 1");
        System.out.println("1: " + (random.nextInt(4) + 1));
        System.out.println("2: " + (random.nextInt(4) + 1));
        System.out.println("3: " + (random.nextInt(4) + 1));
        System.out.println("4: " + (random.nextInt(4) + 1));
        System.out.println("------------------------\n");
    }

}
