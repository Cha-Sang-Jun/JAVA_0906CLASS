package ver03;
//② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. 
// - 거래처회사이름, 거래품목, 직급 변수 추가 - 정보를 출력하는 메소드를 오버라이딩 해서
//   추가된 정보를 추가해서 출력 

public class CustomerContact extends Contact {

	private String customerName;
	private String product;
	private String job;

	public CustomerContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String customerName, String product, String job) {
		super(name, phoneNumber, email, address, birthday, group);
		this.customerName = customerName;
		this.product = product;
		this.job = job;
	}

	public CustomerContact(String name, String phoneNumber, String email, String address, String birthday,
			String group) {
		super(name, phoneNumber, email, address, birthday, group);
		this.customerName = customerName;
		this.product = product;
		this.job = job;
	}

	@Override
	public void printContact() {
		super.printContact();
		System.out.println("거래처 회사 이름: " + customerName);
		System.out.println("거래품목: " + product);
		System.out.println("직급: " + job);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
