package dept;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object) : Sql 처리만 하는 클래스
public class DeptDao {

	// 전체 리스트 구하는 메소드 : select -> 매개변수로 Connection을 전달 받고, List<Dept>
	public List<Dept> selectAllList(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;
		List<Dept> result = new ArrayList<Dept>();

		try {
			// 결과 생성
			stmt = conn.createStatement();

			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {     // 만약 데이터가 없으면 여기서 넘어가지 않는다.
				result.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		}

		return result;
	}

	// 부서 정보를 검색하는 메소드 : select -> Connection을 전달 받고, Dept

	// 부서 정보를 입력하는 메소드 : insert -> Connection을 전달 받고, Dept 객체를 전달 받아서 입력

	// 부서 정보를 수정하는 메소드 : update -> Connection을 전달 받고, Dept 객체를 전달 받아서 수정

	// 부서 정보를 삭제하는 메소드 : delete -> Connection을 전달 받고, 부서번호(PK) 를 전달받아서 삭제
}
