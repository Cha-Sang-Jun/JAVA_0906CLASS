package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptDeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 삭제 할 deptno 받고 
		String deptno = request.getParameter("deptno");
		
		// Dao 삭제
		Connection conn = null;
		int cnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			cnt = DeptDao.getInstance().deleteDept(conn, deptno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		// 결과 message => request 속성에 저장
		request.setAttribute("result", cnt>0? "삭제되었습니다." : "잘못된 요청입니다.");
		
		return "/WEB-INF/views/dept/delete.jsp";
	}

}
