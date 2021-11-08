package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcPreparedStatementSelectTest {

	public static void main(String[] args) {

		Connection conn = null;
		// Statement stmt = null;
		PreparedStatement pstmt = null;
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

			// 3. 작업 : CRUD -> PreparedStatement 객체 생성
			//    SQL을 등록해서 생성하기 때문에 Sql 먼저 작성
			
			// Sql : select
			String sql = "select * from dept where deptno = ?"; // 이 '?' 안에 들어갈 값을 setting 해주어야한다.
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 90);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
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

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

		System.out.println("부서리스트");
		System.out.println("------------------------");
		System.out.println("부서번호 \t 부서이름 \t 위치");
		System.out.println("-----------------------");
		for (Dept dept : list) { // Dept객체를 따로 생성하면 출력 or 다른곳에 정보만 보내주는 등 다양하게 활용할  수 있다.
			System.out.println(dept);
		}

	}

}
