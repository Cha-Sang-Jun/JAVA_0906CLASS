package day0906;
// 주석(Comment)
// 주석이란, 우리가 클래스 안에 적더라도
// 실제 실행가능한 프로그램으로 변환하는
// 컴파일이라는 단계에서는 무시가 되는 글자들을 주석이라고 한다.
// 주석의 경우, 우리가 해당 코드에 대한 설명을 적으므로
// 굳이 프로그래밍 문법에 맞추지 않아도 된다.

// 주석에는 한줄 주석과 여러줄 주석이 있는데
// 한줄 주석은 // 으로 시작하고 그 줄이 끝나기 전까지(엔터를 치기 전까지)의 모든 글자를 주석으로 처리한다.

// 여러줄 주석은 /*으로 시작하고 */가 나오기 전까지의 모든 줄을 주석으로 처리한다.
public class Ex05Comment {
    public static void main(String[] args) {
        System.out.println("Hellow, World!!");
        
        System.out.println(1);
        System.out.println(2);
        /* System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        */
    }

}
