package classEx;

public class OracleConnector implements DBConnector {

	@Override
	public void makeConnection() {
		System.out.println("Oracle 데이터 베이스 연결 시작");
		
	}

	@Override
	public void destroyConnection() {
		System.out.println("Oracle 데이터 베이스 연결 시작");
		
	}

	@Override
	public void insert() {
		System.out.println("Oracle 데이터 베이스 연결 종료");
		
	}

	@Override
	public void delete() {
		System.out.println("Oracle 데이터 베이스 delete() 실행");
		
	}

	@Override
	public void selectAll() {
		System.out.println("Oracle 데이터 베이스 selectAll() 실행");		
	}

	@Override
	public void selectOne() {
		System.out.println("Oracle 데이터 베이스 selectOne() 실행");		
	}

	@Override
	public void update() {
		System.out.println("Oracle 데이터 베이스 update() 실행");		
	}

}
