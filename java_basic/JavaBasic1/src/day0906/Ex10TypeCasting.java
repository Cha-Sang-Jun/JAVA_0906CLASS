package day0906;
// 형 변환(Type Casting)

// 형 변환이란? 어떤 데이터타입의 값을 다른 데이터타입으로 변환하는 것을
// 형 변환이라고 한다.

// 형 변환에는 암시적 형변환과 명시적 형변환 두가지가 존재한다.
// 암시적 형변환: 
// 암시적 형변환(Implicit Type Casting)이란, 더 작은 데이터타입의 값을 더 큰 데이터타입으로 변환할 때 발생한다
// 우리가 특별히 코드를 적어주지 않더라도 자동으로 변환이 된다.

// 명시적 형변환:
// 명시적 형변환(Explicit Type Casting)이란, 더 큰 데이터타입의 값을 더 작은 데이터타입으로 변환할 때 발생한다.
// 이 때, (바꿀 데이터타입)값; 으로 형변환을 강제해야 한다.

public class Ex10TypeCasting {
    public static void main(String[] args) {
        // 암시적 형변환의 경우
        
        // byte 데이터타입의 변수 myByte를 만들고 30으로 초기화
        byte myByte = 30;
        
        // int 데이터타입의 변수 myInt를 만들고 myByte의 현재 값으로 초기화해보자
        int myInt = myByte;
        
        // myByte의 현재값을 출력해보자
        System.out.println(myByte);
        
        // myInt의 현재값을 출력해보자
        System.out.println(myInt);
        
        // 정수형 데이터타입의 값을 실수형 데이터타입의 변수에 초기화해보자
        double d = myByte;
        
        // d의 현재값을 출력해보자
        System.out.println(d);
        
        // 명시적 형변환
        
        // myInt에 5를 저장해보자
        myInt = 5;
        
        // byte 변수 myByte에 myInt의 현재 값을 저장해보자
        myByte = (byte)myInt;
        
        // myByte의 현재 값을 출력해보자
        System.out.println(myByte);
        
        // double 데이터타입 변수 d에 3.14 를 저장해보자
        d = 3.14;
                
        // int 데이터타입 변수 myInt에 double 데이터타입 변수 d의 현재 값을 저장해보자
        myInt = (int)d;
        
        // myInt의 현재 값을 출력해보자
        System.out.println(myInt);
        
    }

}
