package member.service;

import java.sql.Connection; 
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegServiceOld {
	
	// Service 클래스도 메소드만 있는 클래스다! -> 싱글톤 처리
	private MemberRegServiceOld () {}
	private static MemberRegServiceOld regService = new MemberRegServiceOld();
	public static MemberRegServiceOld getInstance() {
		return regService;
	}

	// 사용자가 전달한 요청 데이터를 받아서 Dao insert 메소드로 전달하는 기능
	// return : 입력 결과 데이터 반환한다. 사용자 요청 처리 및 응답 처리를 필요로 한다.
	public int insertMember(HttpServletRequest request, HttpServletResponse response) {

		// 결과 생성
		// Connection 객체 생성 -> Dao.insertMember(conn, member) 호출 -> insertMember의 결과가
		// 들어간다.

		// 데이터 받기 (나중가면 Spring 컨테이너가 처리 해준다.)
		String userId = request.getParameter("userid");
		String pw = request.getParameter("password");
		String userName = request.getParameter("username");

		// RegRequest regRequest = new RegRequest(userId, pw, userName);

//		Member member = null;
//		member = regRequest.getMember();

		// Dao 호출
		Connection conn = null;
		int resultCnt = 0;

		try {
			conn = ConnectionProvider.getConnection();

			// resultCnt = MemberDao.getInstance().insertMember(conn, member);
			// resultCnt = MemberDao.getInstance().insertMember(conn, regRequest.getMember());

		} catch (SQLException e) {
			resultCnt = -1;
			e.printStackTrace();
		}

		return resultCnt; // 결과 값은 0과 1 혹은 예외 발생시 -1이 나온다.

	}

}
