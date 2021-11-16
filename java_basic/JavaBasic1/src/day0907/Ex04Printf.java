package day0907;
// printf()
// printf()는 출력할 내용을 %문자를 사용하여 형식을 맞추어 출력 할 수 있게 만들어준다.

public class Ex04Printf {
    public static void main(String[] args) {
        // 1. 10진법 정수('d'ecimal)
        int number = 123;
        System.out.println("1. 10진법 정수");
        // A. 10진법 정수를 그대로 출력해라
        System.out.printf("1-A. [%d]\n", number);
        // B. 10진법 정수를 오른쪽 정렬 5자리로 출력해라
        System.out.printf("1-B. [%5d]\n", number);
        // C. 10진법 정수를 오른쪽 정렬 2자리로 출력해라
        System.out.printf("1-C. [%2d]\n", number);
        // D. 10진법 정수를 왼쪽 정렬 5자리로 출력해라
        System.out.printf("1-D. [%-5d]\n", number);
        // E. 10진법 정수를 오른쪽 정렬 5자리로 맞추고
        //    왼쪽 빈 공간이 있으면 0으로 채워서 출력해라
        System.out.printf("1-E. [%05d]\n", number);
        
        System.out.println("-----------------------\n"); 
        
        // 2. 16진법 정수(he'x'adecimal)
        number = 431;
        // A. 16진법 정수를 그대로 출력하되, 알파벳이 존재할 경우 소문자로 출력하라
        System.out.printf("2-A. [%x]\n", number);
        // B. 16진법 정수를 그대로 출력하되, 알파벳이 존재할 경우 대문자로 출력하라
        System.out.printf("2-B. [%X]\n", number);
        // C. 16진법 정수를 5자리 오른쪽 정렬로 출력하되, 알파벳이 존재할경우 대문자로 출력
        System.out.printf("2-C. [%5X]\n", number);
        // D. 16진법 정수를 5자리 왼쪽 정렬로 출력하되, 알파벳이 존재할경우 소문자로 출력
        System.out.printf("2-D. [%-5x]\n", number);
        // E. 16진법 정수를 5자리 오른쪽 정렬로 맞추고, 왼쪽 빈자리는 0으로 채우고 알파벳은 대문자로 출력
        System.out.printf("2-E. [%05X]\n", number);
           
        System.out.println("--------------------\n");
        
        // 3. 실수('f'loat)
        System.out.println("3. 실수");
        double d = 123.45;
        // A. 실수를 그대로 출력해라
        System.out.printf("3-A. [%f]\n", d);
        // B. 실수를 오른쪽 정렬 15자리로 맞추어 출력해라
        System.out.printf("3-B. [%15f]\n", d);
        // C. 실수를 소숫점 첫번째 자리까지만 출력해라
        System.out.printf("3-C. [%.1f]\n", d);
        // D. 실수를 왼쪽 정렬 8자리로 맞추고 소숫점 첫번째 자리까지만 출력하라
        System.out.printf("3-D. [%-8.1f]\n", d);
        // E. 실수를 오른쪽 정렬 8자리로 맞추고 왼쪽 빈자리는 0으로 채우며 소숫점은 첫번째 자리까지만 출력
        System.out.printf("3-E. [%08.1f]\n", d);
        
        System.out.println("-----------------\n");
        
        // 4. 스트링('s'tring)
        System.out.println("4. 스트링");
        String str = "abcDEF";
        // A. 스트링을 그대로 출력해라
        System.out.printf("4-A. [%s]\n", str);
        // B. 스트링을 모두 대문자로 출력해라
        System.out.printf("4-B. [%S]\n", str);
        // C. 스트링을 8자리 오른쪽 정렬하여 그대로 출력해라
        System.out.printf("4-C. [%8s]\n", str);
        // D. 스트링을 8자리 왼쪽 정렬하여 모두 대문자로 출력해라
        System.out.printf("4-D. [%-8S]\n", str);
        
        System.out.println("--------------------\n");
        
        // printf()를 사용할 때 주의할점
        // 1. 존재하지 않는 %문자를 사용하면 에러가 발생한다.
        //    System.out.printf("%p\n", 123);
        // 2. %문자와 뒤의 값의 종류가 일치하지 않으면 에러가 발생한다.
        //    심지어, 여기서는 암시적 형변환도 발생하지 않는다.
        //    System.out.printf("%f\n", 3);
        // 3. printf와 관련된 예제는 여러가지 %문자를 조합해서
        //    우리가 원하는대로 형식을 맞추어서 출력하게 되는데
        //    이때, %문자의 갯수가 뒤의 값의 갯수보다 적으면 문제없다.
        //    System.out.printf("%d %f %d %s", 1, 1.1, 2, "33", 4, 5, 6);
        //    하지만 반대로 %문자의 갯수가 뒤의 값의 갯수보다 많으면 에러 발생.
        //    System.out.printf("%d, %d %d", 1, 2);
    }

}
