package dept.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dept.domain.Dept;

public class DeptDao {
	
	// 기능만 있는 클래스 -> 여러개의 인스턴스 생성이 필요 없다! -> 인스턴스 생성을 제한!
	// 싱글톤 패턴 : 
	//  1. 생성자를 private 해주어서 인스턴스 생성을 막는다.
	//  2. 클래스 내부에서 인스턴스를 생성, 참조변수는 private, static
	//  3. 참조값을 제공하는 메소드가 필요! -> public static 
	
	private DeptDao() {}
	
	private static DeptDao dao = new DeptDao();
	
	public DeptDao getInstance() {
		return dao;
	}
	
	// 부서 리스트 출력을 위한 데이터들을 반환하는 메소드
	public List<Dept> selectAll(Connection conn){
		
		// 응답 결과 객체
		List<Dept> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from dept;";

		try {
			stmt = conn.createStatement();
		
			rs = stmt.executeQuery(sql);
			// 결과를 객체에 담는다!
			while(rs.next()) {
				// int deptno = rs.getInt("deptno");
				// String dname = rs.getString("dname");
				// String loc = rs.getString("loc");
				// Dept dept = new Dept(deptno, dname, loc);
				// list.add(dept);
				
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}
