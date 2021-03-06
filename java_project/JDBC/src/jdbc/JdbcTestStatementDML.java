package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTestStatementDML {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// Dept 저장을 위한 List<Dept>
		List<Dept> list = new ArrayList<Dept>();

		// 1. 드라이버를 로드한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 (Connection 객체)

			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결  성공!");

			// 3. 작업 : CRUD -> Statement 객체 생성
			stmt = conn.createStatement();

			// Sql : insert
			String sql = "insert into dept (deptno, dname, loc) values (50, 'test', 'SEOUL')";

			// 실행횟수 반환
			int cnt = stmt.executeUpdate(sql);

			if (cnt > 0) {
				System.out.println("입력되었습니다.");
			} else {
				System.out.println("입력실패!");
			}

			// 4. 연결종료(Close())

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결실패!");
			e.printStackTrace();

		} finally { // 닫아줄때는 역순으로

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

	}

}
