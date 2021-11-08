package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTestStatementSelect {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 마지막에 close를 해주어야 하기 때문에 위쪽에서 선언해준다. ??

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

			// Sql : select
			String sql = "select * from dept order by deptno";

			// Sql을 실행 --> select의 결과를 담아서 rs에 반환
			rs = stmt.executeQuery(sql);

			// 반복을 통해 행단위 데이터 검색
			while (rs.next()) { // rs.next() : 밑으로 내려오면서 다음행이 존재하는지 확인한다
				int deptno = rs.getInt("deptno"); // dept 테이블에 있는 deptno의 column을 가져온다.
				String dname = rs.getString(2); // column 이름 뿐 아니라 column index를 입력해도 가져올 수 있다.
				String loc = rs.getString("loc");
				// System.out.print(deptno + "\t" + dname + "\t" + loc + "\n"); -> 그냥 출력만할 경우
				Dept dept = new Dept(deptno, dname, loc);
				list.add(dept);
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
