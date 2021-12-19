package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class DriverLoader extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		
		String driver = config.getInitParameter("driver");
		
		try {
			getClass().forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
