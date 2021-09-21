package Project_0.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=hrms";
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		return DriverManager.getConnection(url, username, password);
		
		
	}

}
