package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	// 인스턴스 생성
	private EmpDao() {
	}

	private static EmpDao dao = new EmpDao();

	static public EmpDao getInstance() {
		return dao;
	}

	// 사원정보 입력
	public int insertEmp(Connection conn, Emp emp) {

		PreparedStatement pstmt = null;

		int resultCnt = 0;

		String sql = "insert into emp values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;

	}

	// 사원 정보 리스트 출력
	public List<Emp> selectAllList(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> result = new ArrayList<Emp>();

		try {
			stmt = conn.createStatement();

			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return result;

	}

	// 사원 정보 수정


	// 사원 정보 검색 (이름으로)
	public Emp selectByEname(Connection conn, String ename) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Emp emp = null;

		String sql = "select * from emp where ename = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ename);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return emp;

	}

}
