package day0907;
// 연산자03
// 비교 연산자
// 비교 연산자는 앞의 값과 뒤의 값을 비교하여 연산자가 맞으면 true, 틀리면 false를 결과값으로 연산한다.

// >, >=, <=, ==, !=

public class Ex01Operator03 {
 public static void main(String[] args) {
     // int 변수 num1과 num2를 선언하고 각각 3과 7로 초기화한다.
     int num1 = 3;
     int num2 = 7;
     
     // 1. > 과 <
     System.out.println("1. > 과 <");
     System.out.println("num1 > 0: " + (num1 > 0));
     System.out.println("num1 > num2: " + (num1 > num2));
     System.out.println("num1 < 3: " + (num1 < 3));
            
     System.out.println("--------------------");
     System.out.println();
     
     // 2. >= 과 <=
     System.out.println("2. >= 과 <=");
     System.out.println("num1 >= 0: " + (num1 >= 0));
     System.out.println("num1 >= num2: " + (num1 >= num2));
     System.out.println("num1 <= 3: " + (num1 <= 3));
     
     System.out.println("-------------------");
     System.out.println();
     
     // 3. ==과 !=
     //    ==은 왼쪽의 값과 오른쪽의 값이 같으면 true, 다르면 false가 리턴된다.
     //    !=은 왼쪽의 값과 오른쪽의 값이 다르면 true, 같으면 false가 리턴된다.
     System.out.println("3. == 과 !=");
     System.out.println("num1 == 0: " + (num1 == 0));
     System.out.println("num1 != num2: " + (num1 != num2));
     System.out.println("num1 != 3: " + (num1 != 3));
     
     System.out.println("---------------------");
     System.out.println();
     
     // 비교 연산자를 사용할때 주의할 점
     // 1. 어떤 값이 특정 범위에 속하는지 확인 할 때에는
     // 값1 < 변수 < 값2 이렇게 쓸 수 없다.
     // 0 < num1 < 10 --> '0 < num1' 의 결과값 true or false 와 10은 비교불가
     // 2. 다른 연산자들과 마찬가지로
     //    두 글자 이상의 기호로 이루어져 있을 경우 기호 사이에 공백을 넣어선 안된다.
     //    0 < = 10 --> X
     // 3. 비교연산자는 참조형 데이터타입이 나오기 전부터 존재하는 개념이다.
     //    그렇기 때문에 참조형 데이터타입의 값들을 비교할 때에는
     //    비교연산자를 사용하면 부정확한 값이 나올 수 있으므로 다른 방법을 통해 비교해야함.

     System.out.println("--------------------");
     System.out.println("참조형 데이터타입의 값 비교하기");
     // String 타입은 클래스 타입이므로 참조형 데이터타입에 속한다.
     // 그러므로 String 타입의 변수 str1, str2, str3을 선언하고
     // "abc"라는 세 글자를 넣되, 방법을 다 제각각으로 넣어볼 것이다.
     
     String str1 = "abc";
     String str2 = new String("abc");
     String str3 = str1;
     
     // str1, str2, str3의 저장되어 있는 값을 화면에 한번 출력해보자
     System.out.println("str1: ["+str1+"]");
     System.out.println("str2: ["+str2+"]");
     System.out.println("str3: ["+str3+"]");
     
     System.out.println("---------------------");
     System.out.println();
     
     // 비교연산자를 사용하여 str1과 str2, str1과 str3, str2 와 str3을 비교해보자
     System.out.println(" 비교연산자를 통한 비교 ");
     System.out.println("str1 == str2: " + (str1 == str2));
     System.out.println("str1 == str3: " + (str1 == str3));
     System.out.println("str2 == str3: " + (str2 == str3));
     
     // 참조형 데이터타입의 값을 비교할 때 비교연산자를 사용하면 안되는 이유는
     // 참조형 데이터타입은 Stack 메모리 안에는 Heap 메모리 주소값만 저장이 되고,
     // 데이터타입의 실제 값은 해당 Heap 메모리 주소를 참조해서
     // Heap 메모리 안에 들어가야 확인이 가능하다.
     // 그러나, 비교 연산자의 경우 그 메모리 주소값을 참조해서 Heap 영역 안의 실제 값을
     // 확인하여 그 값을 비교하는 것이 아닌 Stack안의 메모리 주소값 자체를 비교하기 때문에
     // 위와 같이 부정확한 연산 결과가 나오게 된다.
     
     // 따라서, 우리가 참조형 데이터타입들의 값을 비교할 때에는
     // 비교연산자가 아닌 equals()라는 메소드를 통해서 비교해야 한다.
     // equals() 메소드는 다음과 같은 방법으로 사용한다.
     // equals를 시행할 변수.equals(비교대상)
     
     System.out.println("--------------------");
     System.out.println();
     
     System.out.println("eqals()를 통한 비교");
     System.out.println("str1.equals(str2): " + str1.equals(str2));
     System.out.println("str1.equals(str3): " + str1.equals(str3));
     System.out.println("str2.equals(str3): " + str2.equals(str3));
     
     // 또한 메소드를 사용하면 대/소문자 구별 없이
     // 같은 철자가 들어가 있는지도 비교가 가능하다.
     // 이 때, eqaulsIgnoreCase() 라는 메소드를 통해서 비교하면 된다.
     System.out.println("equals() vs equalsIgnoreCase()");
     System.out.println("str1.equals(ABC): " + str1.equals("ABC"));
     System.out.println("str1.equalsIgnoreCase(ABC): " + str1.equalsIgnoreCase("ABC"));
 }

}
