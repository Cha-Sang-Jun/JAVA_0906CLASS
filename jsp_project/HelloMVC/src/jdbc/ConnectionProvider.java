package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		
		return DriverManager.getConnection(url, "bit", "bit");
	}
}
