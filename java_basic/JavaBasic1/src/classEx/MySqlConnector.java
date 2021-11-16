package classEx;
// DBConnector 인터페이스를 상속 받는 MySqlConnector.
// 인터페이스 상속은 extends 가 아닌 implements 라는 키워드를 통해 이루어진다.
public class MySqlConnector implements DBConnector {

	@Override
	public void makeConnection() {
		System.out.println("MySQL 데이터베이스와의 연결 실행");
		
	}

	@Override
	public void destroyConnection() {
		System.out.println("MySQL 데이터베이스와의 연결 종료 ");
		
	}

	@Override
	public void insert() {
		System.out.println("MySQL 데이터베이스 insert() 실행");
		
	}

	@Override
	public void delete() {
		System.out.println("MySQL 데이터베이스 delete() 실행");
		
	}

	@Override
	public void selectAll() {
		System.out.println("MySQL 데이터베이스 selectAll() 실행");
		
	}

	@Override
	public void selectOne() {
		System.out.println("MySQL 데이터베이스 selectOne() 실행");
		
	}

	@Override
	public void update() {
		System.out.println("MySQL 데이터베이스 update() 실행");
		
	}
}

