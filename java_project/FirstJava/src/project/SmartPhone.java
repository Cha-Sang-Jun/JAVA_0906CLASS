package project;

public class SmartPhone {
//	1. SmartPhone 클래스를 정의합니다. 이 클래스는 연락처 정보를 관리하는 클래스입니다. 
//	① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다. 
//	② 배열에 인스턴스를 저장하고, 수정하고, 삭제, 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다. 

	private Contact[] phoneNum;
	private int numOfContact;

	public SmartPhone(int size) {
		phoneNum = new Contact[size];
		numOfContact = 0;
	}

	public SmartPhone() {
		this(10);
	}
	
	public void showAllData() {
		
	}
}
