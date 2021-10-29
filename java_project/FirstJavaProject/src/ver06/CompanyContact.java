package ver06;

public class CompanyContact extends Contact {
	

	private String companyName; // 회사 이름
	private String departName; // 부서 이름
	private String rank; // 직급

	public CompanyContact(String name, String callNum, String email, String address, String birth, String group,
			String companyName, String departName, String rank) {
		super(name, callNum, email, address, birth, group);
		this.companyName = companyName;
		this.departName = departName;
		this.rank = rank;
	}

	public CompanyContact(String name, String callNum, String email, String address, String birth, String group) {
		super(name, callNum, email, address, birth, group);
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
