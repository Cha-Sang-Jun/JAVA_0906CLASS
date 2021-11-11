package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
	
	private ReservationDAO() {
		
	}
	
	private static ReservationDAO dao = new ReservationDAO();
	
	public static ReservationDAO getInstance() {
		return dao;
	}
	
	// 전체 리스트 출력 메소드
	public List<Reservation> show(Connection conn) {

		Statement stmt = null;
		ResultSet rs = null;
		List<Reservation> result = new ArrayList<>();

		try {
			stmt = conn.createStatement();

			String sql = "select * from reservation";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				result.add(new Reservation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),  rs.getInt(6)));
			}
		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return result;
	}

	// 예약 정보 검색 메소드
	public Reservation selectByReservation(Connection conn, int rId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Reservation r = null;

		String sql = "select * from reservation where rid= ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				r = new Reservation(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getInt(5), rs.getInt(6));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return r;
	}

	// 예약 정보 입력 메소드
	public int insert(Connection conn, Reservation r) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "insert into Reservation values (?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getRid());
			pstmt.setString(2, r.getRdate());
			pstmt.setString(3, r.getRname());
			pstmt.setString(4, r.getRphone());
			pstmt.setInt(5, r.getRnum());
			pstmt.setInt(6, r.getTid());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	// 예약 정보 수정 메소드
	public int update(Connection conn, Reservation r) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		String sql = "update reservation set rdate = ?, rname = ?, rphone =?, rnum = ?, tid = ? where rid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getRdate());
			pstmt.setString(2, r.getRname());
			pstmt.setString(3, r.getRphone());
			pstmt.setInt(4, r.getRnum());
			pstmt.setInt(5, r.getTid());
			pstmt.setInt(6, r.getRid());
			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

	// 예약 정보 삭제 메소드
	public int delete(Connection conn, int rId) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		String sql = "delete from reservation where rid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}
