package day0906;
// 기본형 데이터타입 03
// 문자형 기본데이터타입

// 문자형 기본데이터타입은 char 라는 기본형 데이터타입이 있다.
// char는 character 라는 '문자'를 뜻하는 영어 단어의 줄임말로써
// "캐릭터" 라고 읽는것이 맞다.

// 캐릭터는 현실에서는 거의 쓰이지 않는 데이터타입인데 그 이유는
// 한번에 한개의 글자만 저장가능하기 때문이다.

// char 데이터타입의 값은 ' ' 안에 저장할 글자를 적어주면 된다.

// 우리가 char에 값을 저장할 때에는 해당 글자에 해당하는 코드 값을
// ASCII 테이블이란 문자표에서 찾아서 그 값을 2진법으로 변환하여 저장한다.


public class Ex08Character {
    public static void main(String[] args) {
        // char 데이터타입 변수 myChar를 선언하고 대문자 A를 저장해보자
        char myChar = 'A';
        // 위 코드는 대문자 A를 ASCII 테이블에서 찾아서
        // 코드값인 65를 2진법으로 변환해서 저장하게 된다.
        System.out.println(myChar);
        
        // myChar에 70을 저장해라
        myChar = 70;
        System.out.println(myChar);
        
        // 다만 문자 값을 저장할 때에는
        // char의 한계, 즉 한번의 한개의 글자만 저장할 수 있다
        // 라는 단점 때문에
        // char 데이터 타입을 쓰기보다는
        // 참조형 데이터타입 중 클래스형 데이터타입에 해당되는
        // String 클래스 데이터타입의 변수를 만들어서 거기에 여러개의 글자를 저장하는 경우가 대부분이다.
        
        // String 클래스 데이터타입의 값은 우리가 "  " 에 필요한 글자들을 넣어서 만들게 된다.
        
        // String 데이터타입의 변수 str을 선언해보자
        String str;
        
        // str에 "abcd"를 저장해보자
        str = "abcd";
        
        // 화면에 str의 현재 값을 출력해보자
        System.out.println(str);
        
              
    }

}
