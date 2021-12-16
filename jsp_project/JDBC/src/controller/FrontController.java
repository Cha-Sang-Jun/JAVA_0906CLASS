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

import dept.service.BadRequestCommandImpl;
import dept.service.Command;

public class FrontController extends HttpServlet  {
	
	private Map<String, Command> commands = new HashMap<String, Command>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿의 기능이나 역할에 따라 서블릿 객체가 생성되는 시점에 필요한 행동들이 있으며, 그에 대한 내용을 원하는 init메소드를 오버라이딩하여 구현한다.
			 
		System.out.println("서블릿이 생성될때 한번 실행합니다 -> 초기화 처리 합니다!!!");
		
		// 설정 파일에 init-param 설정된 경로 가져오기 
		String configFile = config.getInitParameter("configPath");  // => getInitParameter : 매개변수로 web.xml에서 지정했던 param-name을 넘겨주면 그에 해당하는 값을 가져온다.

		// 시스템 경로 실제 경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
				
		// properties (MAP 파생된 클래스) 파일 생성
		// 파일 -> 객체
		
		Properties prop = new Properties();
		FileInputStream fis = null;  // FileInputStream : 파일을 읽어오는 메소드
		
		try {
			fis = new FileInputStream(configPath);  
			
			// 파일 -> 객체 Properties로 변환
			prop.load(fis);
			
			fis.close(); // FileInputStream 실행 후 닫아주어야 한다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<Object> itr = prop.keySet().iterator();
		
		while(itr.hasNext()) {
			
			String command = (String) itr.next();
			String commandClassName = prop.getProperty(command);
			
			System.out.println(command+"="+commandClassName);
			
			// commands Map 에 command(key), commandClassName의 인스턴스를 저장
			
			// commandClassName 이름의 클래스로 인스턴스 생성 -> Class 클래스를 이용
			
			try {
				// 클래스 이름(full name)으로 인스턴스 생성
				Class commandClass = Class.forName(commandClassName);
				
				// 인스턴스 생성
				Command commandObj = (Command)commandClass.newInstance();
				
				// commands Map에 <요청, 객체> 저장
				commands.put(command, commandObj);
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("초기화된 요청 : " + commands.size());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 받기
		doProcess(request, response);		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 받기
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 사용자의 요청을 분석 : URI를 이용한 사용자 요청 분석
		
		String commandURI = request.getRequestURI();

		if(commandURI.startsWith(request.getContextPath())) {
			commandURI = commandURI.substring(request.getContextPath().length());
		}
		
		// 3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기

		Command command = commands.get(commandURI);
		if(command == null) {
			command = new BadRequestCommandImpl();
		}
		
		String viewPage = command.getPage(request, response);
		
		// 5.  view 페이지를 지정(선택) -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
