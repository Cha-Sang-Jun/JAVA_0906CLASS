package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestbookDao;
import guestbook.domain.WriteInfo;
import jdbc.ConnectionProvider;

public class GuestBookWriteService {
	
	
	private GuestBookWriteService() {
	}
	
	private static GuestBookWriteService service = new GuestBookWriteService();
	
	public static GuestBookWriteService getInstance() {
		return service;
	}
	
	public int Write(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String memberidx = request.getParameter("memberidx");
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			WriteInfo write = new WriteInfo(subject, content, Integer.parseInt(memberidx));
			
			resultCnt = GuestbookDao.getInstance().insertGuestBook(conn, write);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
}
