package ver03;

//2. 그룹에 해당하는 정보들을 추가적으로 정의하는 새로운 클래스들을 정의합니다. 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. 
//① CompanyContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. - 회사이름, 부서이름, 직급 변수 추가 - 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력 
public class CompanyContact extends Contact {
	private String companyName;
	private String divName;
	private String job;

	public CompanyContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String companyName, String divName, String job) {
		super(name, phoneNumber, email, address, birthday, group);
		this.companyName = companyName;
		this.divName = divName;
		this.job = job;

	}

	public CompanyContact(String name, String phoneNumber, String email, String address, String birthday,
			String group) {
		super(name, phoneNumber, email, address, birthday, group);
		this.companyName = companyName;
		this.divName = divName;
		this.job = job;

	}

	@Override
	public void printContact() {
		super.printContact();
		System.out.println("회사이름: " + companyName);
		System.out.println("부서이름: " + divName);
		System.out.println("직급: " + job);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
