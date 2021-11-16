package day0906;
// 오버플로우와 언더플로우

// 정수형 데이터타입의 경우,
// 크기가 정해져있기 때문에
// 만약 그 크기를 벗어나는 값을 강제로 명시적 형변환을 통해서 저장할 때에는
// 문제가 생길수도 있다.

// 어떠한 문제냐, 컴퓨터에서는 가장 앞자리수가 0이면 +, 1이면 -이기 때문에
// 최대값보다 더 큰 값을 저장하면 더 큰 수가 아니라 -의 값이나 다른 부정확한 값으로 옮겨갈 수 있다
// 이렇게 최대값보다 더 큰 값을 저장하여 부정확해지는 것을 우리는 오버플로우(Overflow) 라고 한다.

// 반대로, 최소값보다 더 작은 값을 저장하여 값이 부정확해지는 것을 언더플로우(Underflow) 라고 한다.

public class Ex11Flow {
    public static void main(String[] args) {
        // byte 변수 myByte를 선언해보자
        byte myByte;
        
        System.out.println("=====오버플로우========");
        // myByte에 127을 저장해보자
        myByte = 127;
        // myByte의 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        // myByte에 128을 명시적 형변환을 통하여 저장해보자
        myByte = (byte)128;
        // 128 = 128 + 0 이다.
        // 하지만 128은 byte 기준 오버플로우가 발생하여 -128이 된다.
        // 즉, -128 + 0 이 되므로 저장된 값은 -128이 된다.
        
        // myByte에 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        // myByte에 129를 명시적 형변환을 통하여 저장해보자
        myByte = (byte)129;
        // 129 = 128 + 1 이다.
        // 하지만 128은 byte 기준 오버플로우가 발생 -128이 되고,
        // -128 + 1이 되므로 -128 + 1 이 되어 -127의 값이 저장됨.
        
        // myByte의 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        // myByte에 256을 명시적 형변환을 통하여 저장해보자
        myByte = (byte)256;
        // 256 = 128 + 128 이다.
        // 128은 byte 기준 -128이 되고,
        // -128 + 128이 되어 myByte에 저장된 값은 0이 된다.
        
        // myByte의 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        
        System.out.println("--------------------");
        System.out.println();
        
        System.out.println("====언더플로우========");
        // myByte에 -128을 저장해보자
        myByte = -128;
        // myByte에 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        // myByte에 -130을 명시적 형변환을 통하여 저장해보자
        myByte = (byte)-130;
        // myByte의 현재 값을 화면에 출력해보자
        System.out.println(myByte);
        // myByte에 -65536을 명시적 형변환을 통하여 저장해보자
        myByte = (byte)-65536;
        // -65536은 int로 표현하면
        // 1111 1111 1111 1111 1000 0000 0000 0000 이 된다.
        // 하지만 byte로 형 변환을 하면 가장 마지막 8자리만 myByte에 저장이 되므로
        // 0이 저장되게 된다.
        
        // myByte에 현재 값을 화면에 출력해보자  
        System.out.println(myByte);
        
        System.out.println("----------------");
        System.out.println();
    }

}
