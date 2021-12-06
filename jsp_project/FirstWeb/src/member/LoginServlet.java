package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 : 자바 문법 X, 주석 X, 약속된 추가적인 처리를 해주는 키워드.
// 예) @Override
// http://localhost:8080/FirstWeb/Login
// http://localhost:8080/FirstWeb/login
// 이 두개의 요청을 처리하겠다라는 의미가 된다.
@WebServlet({ "/Login", "/login" })
public class LoginServlet extends HttpServlet {

	// 사용자가 요청할 때 Get 방식으로 요청 했을 때 처리되는 메소드
	// HttpServletRequest => 사용자의 요청정보를 모두 가지고 있는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// request : 사용자의 요청 데이터 처리
		// response : 사용자에게 응답할 데이터 처리

		// 사용자가 입력한 userid, pw를 받아서 응답 메시지에 포함해서 처리하기
		String uid = request.getParameter("userid"); // 여기에 들어간 userid는 name 속성
		String pw = request.getParameter("pw");
		System.out.println("userid :" + uid);
		System.out.println("pw : " + pw);
		
		PrintWriter out = response.getWriter(); // 어플리케이션 서버에서 요청한 쪽으로 문자열을 반환, 출력 해준다.
		out.println("<html>");
		out.println(" <head> <title> 파라미터 데이터 받기 </title> </head>");
		out.println("  <body>");
		out.println("    <h1>");
		out.println("       userid : " + uid + "<br>");
		out.println("       pw : " + pw);
		out.println("   </h1>");
		out.println("  </body>");
		out.println("</html>");
	}

	// 사용자가 요청할 때 Post 방식으로 요청 했을 때 처리되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post 방식으로 요청 처리!!!");
		doGet(request, response);
	}

}
