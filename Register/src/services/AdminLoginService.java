package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DBConnection;

public class AdminLoginService {
	
	private static Connection con;
	
	private static PreparedStatement ps;
	
	public String adminLogin(User u1) {
		
		String email=u1.getUserID();
		String pass=u1.getPassword();
		String logemail=null;
		String logpass=null;
		try {
			
			con=DBConnection.dbconnect();
			String sql="select UserId,Password from User,Employee where UserId=EmployeeID and UserId like 'EMP%' and Designation='Office Admin'";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				logemail=rs.getString(1);
				logpass=rs.getString(2);
			
			
				if(email.equals(logemail)&&pass.equals(logpass)) {
					return "Logged";
			
				}
			}
			
			}catch(SQLException e) {
					
				e.printStackTrace();
				
			}
		return "Username or Password Mismatch!!!";
		
	}

}
