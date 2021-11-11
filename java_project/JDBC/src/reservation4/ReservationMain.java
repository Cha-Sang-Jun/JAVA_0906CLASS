package reservation4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ReservationMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int select;

//		// 예약 시스템
//		while (true) {
//			System.out.println("원하시는 메뉴를 선택해주세요.");
//			System.out.print("예약<1>, 예약조회<2>, 예약수정<3>, 예약 취소<4>, 종료<5>");
//			select = scanner.nextInt();
//			switch (select) {
//			case 1:
//				// 예약 메소드
//				break;
//			case 2:
//				// 예약 조회 메소드
//				break;
//			case 3:
//				// 수정 메소드
//				break;
//			case 4:
//				// 취소 메소드
//				break;
//			case 5:
//				return; // 끝내기
//			default:
//				System.out.println("잘못 입력하셨습니다 (1 ~ 5).");
//				continue;
//
//			}
//		}
		
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

			// 예약자 정보 검색 : 예약자 이름으로 검색
			Reservation reservation = reservationDAO.selectByReservation(conn, "손흥민");
			System.out.println("예약 정보 검색");
			System.out.println("손흥민의 예약 정보 : " + reservation);

			System.out.println("------------------------------");

			// 예약자 정보 입력
			Reservation insert = new Reservation("2021.11.19", "황희찬", "010-2222-3333", 2, 6);

			int insertCnt = reservationDAO.insert(conn, insert);

			if (insertCnt != 0) {
				System.out.println("예약정보가 입력되었습니다.");

			} else {
				System.out.println("입력이 실패하였습니다.");
			}

			System.out.println("예약자 정보 입력");
			System.out.println("입력결과 :" + reservationDAO.selectByReservation(conn, "황희찬"));

			System.out.println("------------------------------------");

			// 예약자 정보 수정
			Reservation update = new Reservation("2021.11.13", "박명수", "010-3333-4444", 2, 7);
			int updateCnt = reservationDAO.update(conn, update);
			if (updateCnt != 0) { // Cnt > 0 으로하던 Cnt != 0 으로 하던 오류메세지 출력, 정보수정은 됨.
				System.out.println("예약정보가 수정되었습니다.");
			} else {
				System.out.println("수정 실패 또는 조건에 맞는 정보가 없습니다.");
			}
			System.out.println("수정결과 : " + reservationDAO.selectByReservation(conn, "박명수"));

			System.out.println("--------------------------------------------");

			// 예약 정보 삭제
			int delCnt = reservationDAO.delete(conn, "박지성");
			System.out.println("예약 정보가 삭제되었습니다.");
			System.out.println("삭제 결과: " + reservationDAO.selectByReservation(conn, "박지성"));

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
