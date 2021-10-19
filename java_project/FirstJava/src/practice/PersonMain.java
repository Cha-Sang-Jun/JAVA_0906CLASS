package practice;

public class PersonMain {
//	3. main()메소드를 정의해봅시다. 
//	① Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다. 
//	② 생성된 인스턴스들을 이용해서 메소드를 호출해봅시다. 
	public static void main(String[] args) {
		Male m1 = new Male();
		Female f1 = new Female();
		
		m1.sayHello("차상준", "111111-111111");
		
		
	}
}
