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

		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String repw = request.getParameter("pw");
		String name = request.getParameter("username");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(" <head> <title> 회원 가입 정보 받기 </title> <head>");
		out.println("  <body>");
		out.println("  <h1> ");
		out.println("   userid : " + uid + "<br>");
		out.println("   pw : " + pw + "<br>");
		out.println("   name : " + name + "<br>");
		out.println("   </h1>");
		out.println("   </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
