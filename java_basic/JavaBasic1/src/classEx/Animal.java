package classEx;
// 상속을 위한 부모 클래스

public class Animal {
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void makeSound() {
		System.out.println("동물이 소리를 냅니다.");
	}
	
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
	
	public void showInfo() {
		System.out.println("이 동물은 " + type + "입니다.");
	}
	
	public Animal() {
		System.out.println("---------------------------");
		System.out.println("Anmimal 클래스 생성자 호출");
		System.out.println("---------------------------");
	}

}
