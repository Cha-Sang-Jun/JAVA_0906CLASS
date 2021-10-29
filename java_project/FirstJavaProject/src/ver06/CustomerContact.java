package ver06;

// ② CustomerContact 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다. 
//   - 거래처회사이름, 거래품목, 직급 변수 추가 
//   - 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력 

public class CustomerContact extends Contact {

	private String customerName; // 거래처 회사명
	private String product; // 거래 품목
	private String rank; // 직급

	public CustomerContact(String name, String callNum, String email, String address, String birth, String group,
			String customerName, String product, String rank) {
		super(name, callNum, email, address, birth, group);
		this.customerName = customerName;
		this.product = product;
		this.rank = rank;
	}

	public CustomerContact(String name, String callNum, String email, String birth, String address, String group) {
		super(name, callNum, email, address, birth, group);
		this.customerName = customerName;
		this.product = product;
		this.rank = rank;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("거래처 이름: " + customerName);
		System.out.println("거래품목: " + product);
		System.out.println("직급: " + rank);
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
