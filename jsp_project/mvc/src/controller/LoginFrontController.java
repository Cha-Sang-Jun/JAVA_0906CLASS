package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String commandURI = request.getRequestURI();

		if (commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());

		}

		// 결과 데이터를 생성 (요청에 맞는 결과 데이터를 만든다)
		// 응답 결과 객체
		Object result = null;
		
		String viewPage = "/WEB-INF/member/loginForm.html";

		if (commandURI.equals("/member/login.jsp")) {
			result = "로그인 성공!";
			viewPage = "/WEB-INF/member/login.jsp";
		} else { 
			result = "Invalid Request";
		}

		// 4. 결과를 request 객체의 속성에 저장 : view 페이지에 결과 데이터를 공유(전달)
		request.setAttribute("result", result);

		// 5. view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
