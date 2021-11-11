package reservation4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class Reservate {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		ReservationDAO reservationDAO = ReservationDAO.getInstance();

		Connection conn = null;
		List<Reservation> list = null;


			conn = ConnectionProvider.getConnection();

			list = reservationDAO.show(conn);

			System.out.println("예약하시겠습니까? y/n");
			String yesNo = sc.nextLine();
			if(yesNo.equalsIgnoreCase("y")) {
				System.out.println("예약하고자 하는 날짜를 입력해주세요.");
				String rdate = sc.nextLine();
				
				System.out.println("이름을 입력해주세요.");
				String rname = sc.nextLine();
				
				System.out.println("휴대폰 번호를 입력해주세요.");
				String rphone = sc.nextLine();
				
				System.out.println("예약 인원수를 입력해주세요.");
				int rnum = Integer.parseInt(sc.nextLine());
				
				System.out.println("원하시는 테이블 번호를 입력해주세요. (1~5)"); 
				// 테이블 번호 중복 체크 후 다시 입력 받거나 예약 불가 통보 or 테이블 번호 자동 생성
				int tid = Integer.parseInt(sc.nextLine());
			
				Reservation insert = new Reservation(rdate, rname, rphone, rnum, tid);

				int insertCnt = reservationDAO.insert(conn, insert);

				if (insertCnt != 0) {
					System.out.println("예약되었습니다.");

				} else {
					System.out.println("입력이 실패하였습니다.");
				}

				System.out.println("예약정보 :" + reservationDAO.selectByReservation(conn, "황희찬"));

				System.out.println("------------------------------------");

			
			}


		
	}
}
