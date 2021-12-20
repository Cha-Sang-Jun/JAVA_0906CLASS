package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.domain.Member;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	// 회원 정보 리스트 출력을 위한 데이터 반환
	public List<Member> selectAll(Connection conn) {

		List<Member> list = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			list = new ArrayList<Member>();

			while (rs.next()) {

				list.add(new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);

		}

		return list;

	}
	
	public int insertDept(Connection conn, Member member) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO member (userId, password, name, signdate) VALUES(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
}
