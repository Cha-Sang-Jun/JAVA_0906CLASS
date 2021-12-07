package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Signup", "/signup" })
public class SignupServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// post 방식으로 데이터를 받을 때 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 데이터 받기
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String name = request.getParameter("username");
		String comment = request.getParameter("comment");
		String gender = request.getParameter("gender");
		// 여러개의 값을 처리할 때 -> 배열로 저장
		String[] interests = request.getParameterValues("interest");
		String byear = request.getParameter("byear");

		// 응답하는 데이터의 타입 => 응답할수 있는 데이터 타입이 안맞으면 출력X
		response.setContentType("text/html; charset=utf-8");
//		response.setContentType("application/doc; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("		<meta charset=\"utf-8\">");
		out.println("<title> 회원가입 파라미터 받기 </title>");
		out.println("</head>");
		out.println("  <body>");
		out.println("  <h1> ");
		out.println("   userid : " + uid + "<br>");
		out.println("   pw : " + pw + "<br>");
		out.println("   name : " + name + "<br>");
		out.println(" comment :" + comment + "<br>");
		out.println(" gender :" + gender + "<br>");

		if (interests != null) {
			for (int i = 0; i < interests.length; i++) {
				out.println(" interest :" + interests[i] + "<br>");
			}
		} else {
			out.println("interests: 선택된 관심사가 없습니다." + "<br>");
		}

		out.println("  byear :" + byear + "<br>");
		out.println("   </h1>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
