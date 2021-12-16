package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		// 전송 방식을 확인
		System.out.println(request.getMethod());
		
		// post 방식에서의 한글 처리
		try {
			request.setCharacterEncoding("utf-8");  // 오버라이드 시 원래 메소드가 가지고 있던 예외처리 부분만 가지고 있어야 하고 더 많아지면 안된다. -> throws 불가
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 1. 사용자가 입력한 데이터를 받고
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// 2. 그 Data를 가지고 Dept 객체를 생성
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		
		// 3. Dao insert 메소드로 입력처리
		Connection conn = null;
		int regCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 4. 결과 반환
			regCnt = DeptDao.getInstance().insertDept(conn, dept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		// 5. request 속성에 저장
		request.setAttribute("result", regCnt);
		
		return "/WEB-INF/views/dept/reg.jsp";
	}

}
