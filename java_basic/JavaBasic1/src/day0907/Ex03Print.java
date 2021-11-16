package day0907;
// 자바 콘솔에 출력하는 3가지 방법
// 1. print():
//    ()안의 내용을 그대로 출력하고, 그 다음 출력할 내용이 있으면 출력된 내용 오른쪽 칸부터 다시 출력을 시작한다.
// 2. println():
//    print a line의 줄임말로써, ()안의 내용을 그대로 출력하고 그 다음 출력할 내용이 있으면
//    출력된 내용의 다음줄의 첫번째 칸부터 다시 출력을 시작한다.
// 3. printf():
//    print in foramt의 줄임말로써, ()안의 내용을 형식에 맞추어 출력하고
//    그 다음 출력할 내용이 있으면, 출력된 내용의 오른쪽 칸부터 다시 출력을 시작한다.

// 이스케이프 문자
// 이스케이프 문자란, 공백이나 문장 부호등의 특수한 기호에서 사용되는 문자로써
// \와 조합되서 사용이 된다.
// 이스케이프 문자는 주로 두 글자로 이루어져 있지만, 실제 문자로써는 한 글자로 취급이 된다.

public class Ex03Print {
    public static void main(String[] args) {
        // 출력에서 사용할 String 변수를 str1과 str2를 선언하고 각각 "ABC", "def"를 저장
        String str1 = "ABC";
        String str2 = "def";
        
        // 1. print()의 경우
        System.out.println("1. print()");
        
        System.out.print(str1);
        System.out.print(str2);
        
        System.out.println("\n-----------------");
        System.out.println();
        
        // 2. println()의 경우
        System.out.println("2. println()");
        
        System.out.println(str1);
        System.out.println(str2);
        
        System.out.println("-----------------");
        System.out.println();
        
        // 3. printf()의 경우
        System.out.println("3. printf()");
        
        System.out.printf("[%s]", str1);
        System.out.printf("[%s]", str2);
        
        System.out.println();
        System.out.println("----------------");
        
        // 이스케이프 문자
        // 이스케이프 문자는 특수한 공백(탭 공백이나 빈줄 공백) 혹은
        // 문장 부호들을 입력할 때 사용이 된다.
        
        // 1. 탭 공백
        //    탭 공백은 \t라고 적으며
        //    스페이스 공백보다 커다란 공백이 들어가게 된다.
        System.out.println("1. 탭공백 ");
        System.out.println(str1+ "\t" +str2);
        System.out.println();
        
        // 2. 빈줄 공백
        //    빈줄 공백은 \n 이라고 적으며
        //    만나는 즉시 출력 위치를 다음줄의 첫번째 칸으로 바꾼다.
        System.out.println("2. 빈줄 공백");
        System.out.print(str1+"\n"+str2);
        System.out.println();
        
        // 3. \\
        //    만약 우리가 이스케이프 문자의 시작을 뜻하는 \가 아닌
        //    글자 그대로의 \를 적고 싶다면, \\라고 입력하면 된다.
        System.out.println("3. \\");
        System.out.println("\t");
        System.out.println("\\t");
        System.out.println();
        
        // 4. \"
        //    코드 상에서 "는 String 값의 시작 혹은 끝을 뜻하게 된다.
        System.out.println("4. \"");
        // """ 이라고 쓰면 스트링 값이 시작 종료 후 다시 새로운 스트링 값이 곧장 시작되고 끝나지 않고,
        // 두 개의 값이 연산자 없이 붙어있기 때문에 에러가 발생.
        // 따라서, 문자 "를 적어주기 위해서는 이스케이프 문자인 \" 로 써줘야 함.
        System.out.println("\"내 사전에 불가능이란 없다! - 나폴레옹\"");
        
    
    }
}
