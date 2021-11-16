package day0907;
// 연산자04
// 논리연산자
// 논리연산자는 boolean 데이터타입에 대한 연산을 한다.
// &&, ||, !

// &&: AND 연산자, 왼쪽과 오른쪽이 모두 true 일 때 true가 결과값으로 나온다.
// ||: OR 연산자. 왼쪽이나 오른쪽 중 한개라도 true면 true가 결과값으로 나온다,
// ! : NOT 연산자. true는 false로, false는 true로 연산한다.

public class Ex02Operator04 {
    public static void main(String[] args) {
        System.out.println("1. AND 연산자");
        System.out.println("true && true: " + (true && true));
        System.out.println("true && false: " + (true && false));
        System.out.println("false && true: " + (false && true));
        System.out.println("false && false: " + (false && false));
        
        System.out.println("-----------------");
        System.out.println();
        
        System.out.println("2. OR 연산자");
        System.out.println("true || true: " + (true || true));
        System.out.println("true || false: " + (true || false));
        System.out.println("false || true: " + (false || true));
        System.out.println("false || false: " + (false || false));
        
        System.out.println("-----------------");
        System.out.println();
        
        System.out.println("3. NOT 연산자");
        
        boolean b = true;
        
        System.out.println("!b: " + !b);
        System.out.println("b의 현재 값: " + b);
        
        System.out.println("------------------");
        System.out.println();
        
        // 우리가 비교연산자에서 안된다고 배웠던 범위를 체크하는 연산은
        // 논리연산자를 함께 써주면 된다.
        
        // 예를 들어서, int 변수 num의 값이 0초과 10미만인지 확인할 때는
        // && 연산자를 사용하면 된다.
        
        int num = 14;
        System.out.println("num > 0: " + (num > 0));
        System.out.println("num < 10: " + (num < 10)); // 위 두 코드는 아래와 같다.
        System.out.println("0 < num < 10: " + (num > 0 && num < 10));
    
    }

}
