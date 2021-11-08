package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcPreparedStatementDMLTest {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// 1. 드라이버를 로드 : 프로그램에서 한번만 실행해주면 된다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 (Connection 객체)

			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결  성공!");

			// 3. 작업 : CRUD -> PreparedStatement 객체 생성, 먼저 SQL 등록 후 사용
			String sql = "insert into dept values (?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 80);
			pstmt.setString(2, "DEV");
			pstmt.setString(3, "PUSAN");

			// DML 실행
			int resultCnt = pstmt.executeUpdate(); // 위에서 ?에 들어갈 sql을 다 정해놨기 때문에 sql이 들어가면 안되고 그냥 실행

			if (resultCnt > 0) {
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

			if (pstmt != null) {
				try {
					pstmt.close();
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
