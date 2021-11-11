package reservation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// 
public class ReservationMain {

	public static void main(String[] args) {

		ReservationDAO reservationDAO = ReservationDAO.getInstance();

		Connection conn = null;
		List<Reservation> list = null;

		try {
			conn = ConnectionProvider.getConnection();

//			conn.setAutoCommit(false);

			list = reservationDAO.show(conn);

			// 예약자 명단 확인
			System.out.println("예약자 명단 확인");
			System.out.println("----------------------------");
			for (Reservation reservation : list) {
				System.out.println(reservation);
			}
			System.out.println("------------------------------");

			// 예약자 정보 검색 : 예약자 이름으로 검색 -> 예약 번호로 검색하기 변경함
			Reservation reservation = reservationDAO.selectByReservation(conn, 1);
			System.out.println("예약 정보 검색");
			System.out.println("1번 예약 정보: " + reservation);

			System.out.println("------------------------------");

			// 예약자 정보 입력
			Reservation insert = new Reservation(6, "2021.11.19", "황희찬", "010-2222-3333", 2, 2);
			// Reservation insert = new Reservation(7, "2021.11.21", "한효주", "010-2222-4545", 2, 7);

			int insertCnt = reservationDAO.insert(conn, insert);

			if (insertCnt != 0) { // insertCnt > 0 으로하면 입력실패? 라고 뜨는데 입력은 됨
				System.out.println("예약정보가 입력되었습니다.");

			} else {
				System.out.println("입력이 실패하였습니다.");
			}

			System.out.println("예약자 정보 입력");
			System.out.println("입력결과 :" + reservationDAO.selectByReservation(conn, 6));

			System.out.println("------------------------------------");

//			// 예약자 정보 수정
//			Reservation update = new Reservation(3, "2021.11.13", "남궁성", "010-3333-4444", 2, 1);
//			int updateCnt = reservationDAO.update(conn, update);
//			if (updateCnt != 0) { // Cnt > 0 으로하던 Cnt != 0 으로 하던 오류메세지 출력, 그런데 정보 수정은 됩니다.
//				System.out.println("예약정보가 수정되었습니다.");
//			} else {
//				System.out.println("수정 실패 또는 조건에 맞는 정보가 없습니다.");
//			}
//			System.out.println("수정결과 : " + reservationDAO.selectByReservation(conn, 3));
//
//			System.out.println("--------------------------------------------");

			// 예약 정보 삭제
			int delCnt = reservationDAO.delete(conn, 2);
			System.out.println("예약 정보가 삭제되었습니다.");
			System.out.println("삭제 결과: " + reservationDAO.selectByReservation(conn, 1));

		} catch (SQLException e) {
			e.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}
}
