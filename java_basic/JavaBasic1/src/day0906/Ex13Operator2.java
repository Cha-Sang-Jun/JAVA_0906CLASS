package day0906;
// 연산자 02
// 할당 연산자
// 할당 연산자는 연산자 뒤의 값을 연산하여 앞의 공간에 저장한다.

// =, +=, -=, /=, %=, ++, --

public class Ex13Operator2 {
    public static void main(String[] args) {
        // 1. =
        //    뒤의 값을 앞에 변수/상수에 할당(=저장) 하라.
        
        int number = 5;
        System.out.println("= 연산 후 number의 현재 값: " + number);
        
        // 2. +=
        //    앞의 변수의 현재 값에 뒤의 값을 더한 결과값을 다시 해당 변수에 저장해라.
        number += 3;
        System.out.println("+=연산 후 number의 현재 값: " + number);
        
        // 3. -=
        //    앞의 변수의 현재 값에 뒤의 값을 뺀 결과값을 다시 해당 변수에 저장하라.
        number -= 2;
        System.out.println("-=연산 후 number의 현재 값: " + number);
        
        // 4. *=
        //    앞의 변수의 현재 값에 뒤의 값을 곱한 결과값을 다시 해당 변수에 저장하라.
        number *= 4;
        System.out.println("*=연산 후 number의 현재 값: " + number);
        
        // 5. /=
        //    앞의 변수의 현재 값에 뒤의 값을 나눈 몫을 다시 해당 변수에 저장하라.
        number /= 5;
        System.out.println("/=연산 후 number의 현재 값: " + number);
        
        // 6. %=
        //    앞의 변수의 현재 값에 뒤의 값을 나눈 나머지 값을 다시 해당 변수에 저장하라.
        number %= 3;
        System.out.println("%=연산 후 number의 현재 값: " + number);
        
        System.out.println("---------------------");
        System.out.println();
        
        // 7. ++, --
        //    ++와 --는 해당 변수의 값을 1씩만 변화시킨다.
        //    하지만 변수의 앞에 붙냐 뒤에 붙냐에 따라서 의미가 달라진다.
        //    ++, --가 변수의 앞에 붙을 때에는 전위증가(감소) 연산자라고 부르고
        //    ++, --가 변수의 뒤에 붙을 때에는 후위증가(감소) 연산자라고 부른다.
        
        // 전위증감연산자의 경우
        // 전위증감연산자는 해당 줄에서 가장 먼저 실행이 된다.
        
        // number의 현재값을 화면에 출력한다.
        System.out.println("전위 증감연산자");
        System.out.println("number의 현재 값: " + number);
        System.out.println("++number: " + ++number);
        // 위 코드는 한줄로 작성되어있지만 실제론 크게 3단계로 나뉘어서 코드가 실행이 된다.
        // 첫 번째, ++number가 실행되어 int 변수 number의 현재 저장된 값이 1에서 2로 1증가된다.
        // 두 번쨰, String 값인 "++number: " 뒤에 스트링 +연산자가 실행되서 number에 현재 저장된
        //        값인 2가 "number: " 뒤에 이어져서 "++number: 2"라는 스트링 값이 만들어진다.
        // 세 번째, System.out.println이 ()의 값인 "++number: 2" 를 화면에 출력시킨다.
        
        System.out.println("number의 현재 값: " + number);
        System.out.println("--------------------");
        System.out.println();
        
        System.out.println("후위 증감연산자");
        // 후위 증감연산자는 해당 줄에서 가장 마지막에 실행되는 코드가 된다.
        System.out.println("number의 현재 값: " + number);
        System.out.println("number++: " + number++);
        System.out.println("number의 현재 값: " + number);
        // 위 코드는 전위증감연산자와 마찬가지로
        // 한 줄로 적혀있지만 실제론 크게 3단계로 나뉘어서 코드가 실행이 된다.
        // 첫 번째, String 값 "number++: " 뒤에 int 변수 number의 현재 값인
        //        2가 이어져서 "number++: 2" 라는 String 값이 만들어진다.
        // 두 번째, System.out.println()이 () 안의 "number++: 2" 라는 값을 화면에 출력시킨다.
        // 세 번째, number++이 실행되서 int 변수 number의 현재 값이 2에서 3으로 1 증가된다.
        
        
        
    }

}
