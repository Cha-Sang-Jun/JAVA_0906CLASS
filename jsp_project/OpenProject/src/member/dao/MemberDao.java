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
import member.domain.RegRequest;

public class MemberDao {

	// 싱글톤 처리
	private MemberDao() {

	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {

		return dao;
	}

	// Connection, Member 객체를 전달 받아 DB에 데이터 입력
	public int insertMember(Connection conn, RegRequest request) throws SQLException {

		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member(userid, password, username, photo) VALUES (?, ?, ?, ?)";

		// 예외처리를 했음에도 try-catch를 쓰는 이유는 finally를 실행하기 위해서이다.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getUserid());
			pstmt.setString(2, request.getPassword());
			pstmt.setString(3, request.getUsername());
			pstmt.setString(4, request.getFileName());

			resultCnt = pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);

		}

		return resultCnt;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////

	// 로그인 처리를 위한 Select 메소드
	public Member selectByIdPw(Connection conn, String userId, String pw) throws SQLException {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where userid = ? and password = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt("idx"), rs.getString("userid"), rs.getString("password"), rs.getString("username"),
						rs.getString("regdate"), rs.getString("photo"));
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return member;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	// 전체출력
	public Member selectById(Connection conn, String userId) {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where userid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getInt("idx"), rs.getString("userid"), rs.getString("password"), rs.getString("username"),
						rs.getString("regdate"), rs.getString("photo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return member;
	}
}
