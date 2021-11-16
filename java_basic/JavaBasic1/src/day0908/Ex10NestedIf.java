package day0908;
// 중첩 if(Nested if)
// 중첩 if문은 한개의 if문 안에 또 다른 if문이 들어가 있는 형태를 말한다.
// 만약 안쪽 if문의 코드가 실행되기 위해서는
// 바깥 쪽의 if문 조건식이 true가 나오고
// 다시 안쪽 if문 조건식도 true가 나와야 한다.

// 하나의 커다란 if문 안에 AND 연산자를 쓴 조건식을 사용하는 것과는
// 다른 용도로, 하나의 조건을 체크하고 코드를 실행 후
// 다시 또 다른 조건을 체크해야하는 경우에
// 주로 중첩 if문이 사용된다.

public class Ex10NestedIf {
    public static void main(String[] args) {
        int num = -5;
        
        if(num >= 1 && num <= 9) {
            System.out.println("num은 한자리 자연수입니다.");
        } else {
            System.out.println("num은 한자리 자연수가 아닙니다.");
        } 
        System.out.println("-----------------------\n");
        
        // 중첩 if문을 사용할 경우
        System.out.println("중첩 if문을 사용한 경우");
        
        if(num >= 1) {
            System.out.println("자연수입니다.");
            
            if(num <= 9) {
                System.out.println("num은 한자리 자연수입니다.");
            } else {
                System.out.println("num은 자연수이지만 한자리가 아닙니다.");
            }
            
        } else {
            System.out.println("자연수가 아닙니다.");
            
        }
    }

}
