package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BadRequestCommandImpl;
import service.Command;
import service.DateCommandImpl;
import service.GreetingCommandImpl;

public class FrontController extends HttpServlet {

	private Map<String, Command> commands = new HashMap<String, Command>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿이 생성될때 한 번 실행 -> 초기화 처리");

		// 설정 파일에 init-param 설정 된 경로 가져오기
		String configFile = config.getInitParameter("configPath");

		// property(Map에서 파생된 클래스) 파일 생성
		// 파일 -> 객체
		Properties prop = new Properties();

		// 시스템 경로 실제 경로
		String configPath = config.getServletContext().getRealPath(configFile);

		FileInputStream fis = null; // inputstream => 프로그램 기준으로 외부에 있는 파일을 가져온다?

		try {
			fis = new FileInputStream(configPath);
			// 파일 -> 객체 Properties

			try {
				prop.load(fis);

				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<Object> itr = prop.keySet().iterator();

		while (itr.hasNext()) {

			String command = (String) itr.next();
			String commandClassName = prop.getProperty(command);

			System.out.println(command + "=" + commandClassName);

			// commands Map에 command(key), commandClassName 의 인스턴스를 저장
			// commandClassName 이름의 클래스로 인스턴스 생성 -> Class 클래스를 이용
			try {
				// 클래스 이름(full name)으로 인스턴스 생성
				Class commandClass = Class.forName(commandClassName);

				// 인스턴스 생성
				try {
					Command commandObj = (Command) commandClass.newInstance();

					// commands Map에 <요청, 객체> 저장
					commands.put(command, commandObj);

				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(itr.next());

		}

		System.out.println("초기화 된 요청 :" + commands.size());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 요청 받기
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 요청 받기
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 2. 사용자의 요청을 분석 : URI를 이용한 사용자 요청 분석
		String commandURI = request.getRequestURI();

		if (commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());

		}

		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		// 응답 결과 객체
		Object result = null;

		// view page 경로
		Command command = commands.get(commandURI);
		if (command == null) {
			command = new BadRequestCommandImpl();
		}

		// 4. 결과를 request 객체의 속성에 저장 : view 페이지에 결과 데이터를 공유(전달)

		String viewPage = command.getPage(request, response);

		// 5. view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
