package day0907;
// Scanner 
// 자바에서는 입력을 처리할 때
// 클래스 변수를 사용하여 처리를 하게 된다.
// 그 중에서 가장 대표적인 클래스가 바로 Scanner 클래스이다.
// 키보드 입력, 파일 입력, 스트링 입력 등 다양한 입력을 처리할 수 있는 클래스로써
// 우리는 키보드 입력을 위해, 스캐너 클래스를 사용하게 될 것이다.

// 단, 스캐너 클래스는 기본형 데이터타입도 아니고
// 기본형 데이터타입을 클래스의 형태로 포장한 "포장 클래스(Wrapper Class)"도 아니기 때문에
// 우리가 사용하기 위해서는 해당 프로그램에서 로딩해야 한다.

// 클래스 로딩은 우리가 import 라고 부르며
// public class~~~~ 전에 필요한 임포트를 모두 다 해주어야 한다.
// 단, 같은 패키지 안에 존재하는 클래스일 경우에는 import를 해줄 필요가 없다.

// import는
// import 불러올 클래스의 정확한 위치;
// 를 통해서 해줄 수 있다.
// Scanner 클래스의 경우, java.util 이라는 패키지 안에 속해있으므로
// import java.util.Scanner; 라고 적어주어야 한다.

import java.util.Scanner;
public class Ex06Scanner {
    public static void main(String[] args) {
        // 스캐너 클래스 변수를 선언하고 초기화해보자.
        // 단, 해당 변수를 초기화 할 때에는 해당 변수가
        // 어디서 데이터를 읽어올지를 저장해주어야 한다.
        // 키보드 입력은 System.in 이라는 곳에서 읽어오게 된다.
        Scanner scanner = new Scanner(System.in);
        
        // 1. 사용자로부터 int 입력을 받아보자
        System.out.println("1. int 입력");
        // int를 입력 받을 떄에는
        // Scanner 클래스 변수의 nextInt() 메소드를 호출하면 된다,
        System.out.println("숫자를 입력해주세요");
        System.out.print("> ");
        int number = scanner.nextInt();
        
        System.out.println("사용자가 입력한 숫자: " + number);
        
        System.out.println("-----------------\n");
        
        // 2. 사용자로부터 double을 입력 받아보자
        System.out.println("2. double 입력");
        // double을 입력 받을 떄에는
        // Scanner 클래스 변수의 nextDouble() 메소드를 호출하면 된다.
        System.out.println("숫자를 입력해주세요");
        System.out.print("> ");
        double d = scanner.nextDouble();
        
        System.out.println("사용자가 입력한 숫자: " + d);
        
        System.out.println("--------------------\n");
        
        // 3. 사용자로부터 String 을 입력받아보자
        System.out.println("3. String 입력");
        // String을 입력 받을 때에는
        // Scanner 클래스 변수의 nextLine() 메소드를 호출하면 된다.
        System.out.println("이름을 입력해주세요");
        System.out.println("> ");
        // Scanner에는 한가지 버그가 존재하는데
        // nextInt(),nextDouble()와 같은 숫자를 입력하는 메소드를 실행하고 나서
        // 버퍼메모리에 입력했던 엔터키(\n)가 남아있다고 생각하여
        // 엔터키가 남아있는 상태에서 계속해서 숫자를 입력받는 메소드를 실행하면 문제가 없지만
        // nextLine()을 실행하게 되면 nextLine()은 버퍼메모리에 남아있는 엔터키를 보고
        // 사용자가 입력을 종료했다고 생각하기 때문에, 공백제거등의 단계를 거쳐
        // 아무런 내용도 없는 String 값(" ")을 보내주게 된다.
        // 이 " "을 곧 장 String 변수에 저장하게 되면? 해당 String 변수도 아무런 내용도 없는 String 변수가 된다.
        // 따라서 이 버그를 해결하기 위해서는
        // 실제 변수에 저장하는 nextLine()을 실행하기 전에
        // nextLine()을 한 번 더 실행시켜서 엔터키를 버퍼메모리에서 날려버리면 된다.
        
        scanner.nextLine();
        String name = scanner.nextLine();
        
        System.out.printf("사용자의 이름: [%s]\n",  name);
        System.out.println("----------------------\n");
        
        // 프로그램에서 외부의 데이터를 읽어올 때에는
        // 반드시 버퍼 메모리 라는 임시 저장구역에서 저장된 값들을 읽어오게 된다.
        // 이렇게 외부로부터 값을 읽어오는 클래스의 변수는
        // 반드시 모든 사용이 끝나고 나서 close() 라는 메소드를 불러와서
        // 더 이상 버퍼 메모리 읽기를 못하게 닫아야 한다.
        scanner.close();
    }

        
    

}
