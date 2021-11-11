package reservation4;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

// 공통코드들을 메소드로 빼거나 클래스를 별도로 빼서 처리하기 (Refactoring)
public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {  
		// 필요할때마다 인스턴스를 만들고 지우는 작업 + 메모리저장 작업을 해야하기 때문에 자주 사용하는 것은 static 쓰는게 좋음. 

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}
}
