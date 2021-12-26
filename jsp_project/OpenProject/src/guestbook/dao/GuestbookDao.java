package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.domain.WriteInfo;
import jdbc.util.JdbcUtil;

public class GuestbookDao {
	
	
	private GuestbookDao() {
	}
	
	private static GuestbookDao dao = new GuestbookDao();
	
	public static GuestbookDao getInstance() {
		
		return dao;
	}

	public int insertGuestBook(Connection conn, WriteInfo write) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO guestbook(subject, content, memberidx) values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, write.getSubject());
			pstmt.setString(2, write.getContent());
			pstmt.setInt(3, write.getMemberidx());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return 0;
	}
	
	
}
