package ver05;

// 2. 그룹에 해당하는 정보들을 추가적으로 정의하는 새로운 클래스들을 정의합니다. 
//    회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. 

// ① CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. 
//   - 회사이름, 부서이름, 직급 변수 추가 
//   - 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력 

public class CompanyContact extends Contact {
	

	private String companyName; // 회사 이름
	private String departName; // 부서 이름
	private String rank; // 직급

	public CompanyContact(String name, String callNum, String email, String address, int birthDay, String group,
			String companyName, String departName, String rank) {
		super(name, callNum, email, address, birthDay, group);
		this.companyName = companyName;
		this.departName = departName;
		this.rank = rank;
	}

	public CompanyContact(String name, String callNum, String email, String address, int birthDay, String group) {
		super(name, callNum, email, address, birthDay, group);
		this.companyName = companyName;
		this.departName = departName;
		this.rank = rank;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("회사이름: " + companyName);
		System.out.println("부서이름: " + departName);
		System.out.println("직급: " + rank);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
