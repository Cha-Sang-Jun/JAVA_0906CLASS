package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import member.service.BadRequestCommandImpl;
import member.service.Command;

public class FrontController extends HttpServlet {

	private Map<String, Command> commands = new HashMap<String, Command>();

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("서블릿이 생성될 때 한번 실행");

		// 설정 파일에 init-param 설정된 경로 가져오기
		String configFile = config.getInitParameter("configPath");

		// 시스템 경로의 실제 경로
		String configPath = config.getServletContext().getRealPath(configFile);

		Properties prop = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(configPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Iterator<Object> itr = prop.keySet().iterator();

		while (itr.hasNext()) {

			String command = (String) itr.next();
			String commandClassName = prop.getProperty(command);

			System.out.println(command + "=" + commandClassName);

			try {
				Class commandClass = Class.forName(commandClassName);

				Command commandObj = (Command) commandClass.newInstance();

				commands.put(command, commandObj);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		System.out.println("초기화된 요청: " + commands.size());
	}

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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String commandURI = request.getRequestURI();
		
		if (commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());
		}

		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기

		Command command = commands.get(commandURI);
		if (command == null) {
			command = new BadRequestCommandImpl();
		}

		String viewPage = command.getPage(request, response);

		// 5. view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
