package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.GuestBookDao;
import jdbc.ConnectionProvider;

public class GuestBookDeleteService {

	private GuestBookDeleteService() {
	}

	private static GuestBookDeleteService service = new GuestBookDeleteService();

	public static GuestBookDeleteService getInstance() {
		return service;
	}

	public int deleteMessage(int idx, int memberIdx) {

		int resultCnt = 0;

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			resultCnt = GuestBookDao.getInstance().deleteMessage(conn, idx, memberIdx);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultCnt;
	}

}
