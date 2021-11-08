package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest1 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select의 결과는 ResultSet으로 받음

		// 1. 드라이버를 로드한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 (Connection 객체)
			// String jdbcUrl = "jdbc:oracle:thin:@[ip주소]:[포트]:[데이터베이스]";
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결  성공!");
			
			// 3. 작업(CRUD)
			// 4. 연결종료(Close())

		} catch (ClassNotFoundException e) { // 라이브러리 연결을 안했거나 클래스 이름에 오타가 났을 경우
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결실패!");
			e.printStackTrace();

		} finally {
				// rs.close();
				// stmt.close();
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
