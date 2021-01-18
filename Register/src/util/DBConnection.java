package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection dbconnect() {
		 Connection con=null;
		 String connurl = "jdbc:mysql://52.237.113.122:3306/student_ms?autoReconnect=true&useSSL=false&verifyServerCertificate=false"; 
		 String username = "itpuser";
		 String password = "itp@123AdminPassword";
		 
		 /*Connection con=null;
		 String connurl = "jdbc:mysql://localhost:3306/itp"; 
		 String username = "root";
		 String password = "";*/
		 
		 try {
			 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(connurl, username, password);
			
			 
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
			 
			 
		 }catch(SQLException e) {
			 
			 e.printStackTrace();
			 
			 
		 }
		 
		return con;
	}

}
