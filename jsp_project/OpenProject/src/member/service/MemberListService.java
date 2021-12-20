package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.Member;

public class MemberListService {

	// private MemberListService() {}
	// private static MemberListService listService = new MemberListService();
	// public static MemberListService getInstance() {
	// 	return listService;
	// }
	
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		List<Member> list = null;
		MemberDao dao = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			dao = MemberDao.getInstance();
			
			list = dao.selectAll(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		request.setAttribute("memberList", list);
		
		return "/WEB-INF/views/member/list.jsp";
	}
}
