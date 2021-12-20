package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.JdbcUtil;
import member.domain.Member;

public class MemberDao {

	// 싱글톤 처리
	private MemberDao() {
		
	}
	
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		
		return dao;
	}
	
	// Connection, Member 객체를 전달 받아 DB에 데이터 입력
	public int insertMember(Connection conn, Member member) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO member(userid, password, username) VALUES (?, ?, ?);";
		
		// 예외처리를 했음에도 try-catch를 쓰는 이유는 finally를 실행하기 위해서이다.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUsername());
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
			
		}
		
		return resultCnt;
	}
}
