package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Student;

import util.CommonUtils;
import util.DBConnection;

public class IUserServices {
	
	private static Connection con;
	
	//Student Crude Operations -------------------------------------------------------------------------------------
	
	public  void addStudent(Student user) {

		String userID = CommonUtils.generateStudentIDs(getUserIDs());
		
		try {
			con = DBConnection.dbconnect();
			PreparedStatement ps;
			PreparedStatement ps1;
			
			String sql="insert into User(UserID,FirstName,LastName,Gender,Address,DOB,NIC,Email,Telephone,Password) values(?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			//Generate user IDs
			user.setUserID(userID);
			ps.setString(1,user.getUserID());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getDob());
			ps.setString(7, user.getNIC());
			ps.setString(8, user.getEmail());
			ps.setString(9, user.getTelephone());
			ps.setString(10, user.getNIC());
			ps.executeUpdate();
			
			String sql1="insert into Student(StudentID,GuardianName,GuardianMobile) values(?,?,?)";
			ps1=con.prepareStatement(sql1);
			
			user.setStudentID(userID);
			ps1.setString(1,user.getUserID());
			ps1.setString(2,user.getGuardianName());
			ps1.setString(3,user.getGuardianMobile());
			ps1.executeUpdate();
	
			
			
			con.commit();

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	private ArrayList<String> getUserIDs() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		
		try {
			  con= DBConnection.dbconnect();
			  PreparedStatement ps;
			  
			  ps=con.prepareStatement("select UserID from User where UserID like'STD%'");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1));
			}
		}  catch (Exception e) {
			
			e.printStackTrace();
			

		}
		
		return arrayList;
	}
	
	private ArrayList<Student> actionUser(String UserID) {
		ArrayList<Student> UserList = new ArrayList<Student>();
		ResultSet rs;
		try {
			
			
			con=DBConnection.dbconnect();
			PreparedStatement ps;
			
			if (UserID!= null && !UserID.isEmpty()) {
				
				ps=con.prepareStatement("select * from User,Student where UserID=StudentId and UserID=?");
				ps.setString(1,UserID );
				rs=ps.executeQuery();
				
			}else {
				ps=con.prepareStatement("select * from User,Student where StudentID=UserId");
				rs=ps.executeQuery();
				
				
			}
			while(rs.next()) {
				Student u1=new Student();
				//User u1=new User();
				u1.setStudentID(rs.getString(1));
				u1.setFirstName(rs.getString(2));
				u1.setLastName(rs.getString(3));
				u1.setGender(rs.getString(4));
				u1.setAddress(rs.getString(5));
				u1.setDob(rs.getString(6));
				u1.setNIC(rs.getString(7));
				u1.setEmail(rs.getString(8));
				u1.setTelephone(rs.getString(9));
				u1.setPassword(rs.getString(10));
				u1.setGuardianName(rs.getString(12));
				u1.setGuardianMobile(rs.getString(13));
				UserList.add(u1);
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		return UserList;
		
		
	}
	
	public Student getUserByID(String UserID) {
		
		return actionUser(UserID).get(0);
	}
	
	public ArrayList<Student> getUsers() {
		
		return actionUser(null);
	}
	
	public void DeleteStudentDetails(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				
				con=DBConnection.dbconnect();
				PreparedStatement ps;
				PreparedStatement ps1;
				PreparedStatement ps2;
				
				ps2=con.prepareStatement("delete from Card where StudentID=?");
				ps2.setString(1,id);
				ps=con.prepareStatement("delete from Student where StudentID=?");
				ps.setString(1,id);
				ps1=con.prepareStatement("delete from User where UserId=?");
				ps1.setString(1,id);
				
				int i=ps.executeUpdate();
				if(i==1) {
					
					ps1.executeUpdate();
					
				}
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
	}
	
	public Student UpdateStudentDetails(String id,Student u1) {
		if (id != null && !id.isEmpty()) {
			try {
				
				con=DBConnection.dbconnect();
				PreparedStatement ps;
				
				ps=con.prepareStatement("update User u,Student s set u.FirstName=?,u.LastName=?,u.Gender=?,u.Address=?,u.DOB=?,u.NIC=?,u.Email=?,u.Telephone=?,u.Password=?,s.GuardianName=?,s.GuardianMobile=? where u.UserId=s.StudentID and u.UserId=?");
				
				ps.setString(1,u1.getFirstName());
				ps.setString(2,u1.getLastName());
				ps.setString(3,u1.getGender());
				ps.setString(4,u1.getAddress());
				ps.setString(5,u1.getDob());
				ps.setString(6,u1.getNIC());
				ps.setString(7,u1.getEmail());
				ps.setString(8,u1.getTelephone());
				ps.setString(9,u1.getPassword());
				ps.setString(10,u1.getGuardianName());
				ps.setString(11,u1.getGuardianMobile());
				ps.setString(12,id);
				
				ps.executeUpdate();
				
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		return getUserByID(id);
		
	}
	
	
	//Employee Crude Operations -------------------------------------------------------------------------------------
	
	public void addEmployee(Employee user) {

		String userID = CommonUtils.generateEmoyeeIDs(getEmpIDs());
		
		try {
			con = DBConnection.dbconnect();
			PreparedStatement ps;
			PreparedStatement ps1;
			
			String sql="insert into User(UserID,FirstName,LastName,Gender,Address,DOB,NIC,Email,Telephone,Password) values(?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			//Generate user IDs
			user.setUserID(userID);
			ps.setString(1,user.getUserID());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getDob());
			ps.setString(7, user.getNIC());
			ps.setString(8, user.getEmail());
			ps.setString(9, user.getTelephone());
			ps.setString(10, user.getNIC());
			ps.executeUpdate();
			
			String sql1="insert into Employee(EmployeeID,Designation,OT_hours,OT_rate,EmployeeType) values(?,?,?,?,?)";
			ps1=con.prepareStatement(sql1);
			
			user.setEmployeeID(userID);
			ps1.setString(1,user.getUserID());
			ps1.setString(2,user.getDesignation());
			ps1.setInt(3,user.getOT_hours());
			ps1.setInt(4,user.getOT_Rate());
			ps1.setString(5,user.getEmployeeType());
			ps1.executeUpdate();
	
			
			
			con.commit();

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private ArrayList<String> getEmpIDs() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		
		try {
			  con= DBConnection.dbconnect();
			  PreparedStatement ps;
			  
			  ps=con.prepareStatement("select UserID from User where UserID like'EMP%'");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1));
			}
		}  catch (Exception e) {
			
			e.printStackTrace();
			

		}
		
		return arrayList;
	}
	
	private ArrayList<Employee> actionEmployee(String UserID) {
		ArrayList<Employee> UserList = new ArrayList<Employee>();
		ResultSet rs;
		try {
			
			
			con=DBConnection.dbconnect();
			PreparedStatement ps;
			
			if (UserID!= null && !UserID.isEmpty()) {
				
				ps=con.prepareStatement("select * from User,Employee where UserID=EmployeeID and UserID=?");
				ps.setString(1,UserID );
				rs=ps.executeQuery();
				
			}else {
				ps=con.prepareStatement("select * from User,Employee where EmployeeID=UserId");
				rs=ps.executeQuery();
				
				
			}
			while(rs.next()) {
				Employee u1=new Employee();
				//User u1=new User();
				u1.setEmployeeID(rs.getString(1));
				u1.setFirstName(rs.getString(2));
				u1.setLastName(rs.getString(3));
				u1.setGender(rs.getString(4));
				u1.setAddress(rs.getString(5));
				u1.setDob(rs.getString(6));
				u1.setNIC(rs.getString(7));
				u1.setEmail(rs.getString(8));
				u1.setTelephone(rs.getString(9));
				u1.setPassword(rs.getString(10));
				u1.setDesignation(rs.getString(12));
				u1.setOT_hours(Integer.parseInt(rs.getString(13)));
				u1.setOT_Rate(Integer.parseInt(rs.getString(14)));
				u1.setEmployeeType(rs.getString(15));
				UserList.add(u1);
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		return UserList;
		
		
	}
	
	public Employee getEmployeeByID(String UserID) {
		
		return actionEmployee(UserID).get(0);
	}
	
	public ArrayList<Employee> getEmployees() {
		
		return actionEmployee(null);
	}
	
	public void DeleteEmployeeDetails(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				
				con=DBConnection.dbconnect();
				PreparedStatement ps;
				PreparedStatement ps1;
				
				
				ps=con.prepareStatement("delete from Employee where EmployeeID=?");
				ps.setString(1,id);
				ps1=con.prepareStatement("delete from User where UserId=?");
				ps1.setString(1,id);
				int i=ps.executeUpdate();
				if(i==1) {
					
					ps1.executeUpdate();
					
				}
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		
	}
	
	public Employee UpdateEmployeeDetails(String id,Employee u1) {
		if (id != null && !id.isEmpty()) {
			try {
				
				con=DBConnection.dbconnect();
				PreparedStatement ps;
				
				ps=con.prepareStatement("update User u,Employee e set u.FirstName=?,u.LastName=?,u.Gender=?,u.Address=?,u.NIC=?,u.Email=?,u.Telephone=?,u.Password=?,e.Designation=?,e.OT_hours=?,e.OT_rate=?,e.EmployeeType=? where u.UserId=e.EmployeeID and u.UserId=?");
				
				ps.setString(1,u1.getFirstName());
				ps.setString(2,u1.getLastName());
				ps.setString(3,u1.getGender());
				ps.setString(4,u1.getAddress());
				ps.setString(5,u1.getNIC());
				ps.setString(6,u1.getEmail());
				ps.setString(7,u1.getTelephone());
				ps.setString(8,u1.getPassword());
				ps.setString(9,u1.getDesignation());
				ps.setInt(10,u1.getOT_hours());
				ps.setInt(11,u1.getOT_Rate());
				ps.setString(12,u1.getEmployeeType());
				ps.setString(13,id);
				
				ps.executeUpdate();
				
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
		}
		return getEmployeeByID(id);
		
	}
	
	//Generate Employee Reports Using Type -------------------------------------------------------------------------------------
	
	private ArrayList<Employee> actionEmpType(String Type) {
		ArrayList<Employee> UserList = new ArrayList<Employee>();
		ResultSet rs;
		try {
			
			
			con=DBConnection.dbconnect();
			PreparedStatement ps;
			
			if (Type!= null && !Type.isEmpty()) {
				
				ps=con.prepareStatement("select * from User,Employee where UserID=EmployeeID and EmployeeType=?");
				ps.setString(1,Type );
				rs=ps.executeQuery();
				
			}else {
				ps=con.prepareStatement("select * from User,Employee where EmployeeID=UserId");
				rs=ps.executeQuery();
				
				
			}
			while(rs.next()) {
				Employee u1=new Employee();
				//User u1=new User();
				u1.setEmployeeID(rs.getString(1));
				u1.setFirstName(rs.getString(2));
				u1.setLastName(rs.getString(3));
				u1.setGender(rs.getString(4));
				u1.setAddress(rs.getString(5));
				u1.setDob(rs.getString(6));
				u1.setNIC(rs.getString(7));
				u1.setEmail(rs.getString(8));
				u1.setTelephone(rs.getString(9));
				u1.setPassword(rs.getString(10));
				u1.setDesignation(rs.getString(12));
				u1.setOT_hours(Integer.parseInt(rs.getString(13)));
				u1.setOT_Rate(Integer.parseInt(rs.getString(14)));
				u1.setEmployeeType(rs.getString(15));
				UserList.add(u1);
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		return UserList;
		
		
	}
	
	public ArrayList<Employee> getEmployeeByType(String Type) {
		
		return actionEmpType(Type);
	}
	
	//Generate Student Reports Using Gender -------------------------------------------------------------------------------------
	
	private ArrayList<Student> actionStdGend(String gender) {
		ArrayList<Student> UserList = new ArrayList<Student>();
		ResultSet rs;
		try {
			
			
			con=DBConnection.dbconnect();
			PreparedStatement ps;
			
			if (gender!= null && !gender.isEmpty()) {
				
				ps=con.prepareStatement("select * from User,Student where UserID=StudentID and Gender=?");
				ps.setString(1,gender );
				rs=ps.executeQuery();
				
			}else {
				ps=con.prepareStatement("select * from User,Student where StudentID=UserId");
				rs=ps.executeQuery();
				
				
			}
			while(rs.next()) {
				Student u1=new Student();
				//User u1=new User();
				u1.setStudentID(rs.getString(1));
				u1.setFirstName(rs.getString(2));
				u1.setLastName(rs.getString(3));
				u1.setGender(rs.getString(4));
				u1.setAddress(rs.getString(5));
				u1.setDob(rs.getString(6));
				u1.setNIC(rs.getString(7));
				u1.setEmail(rs.getString(8));
				u1.setTelephone(rs.getString(9));
				u1.setPassword(rs.getString(10));
				u1.setGuardianName(rs.getString(12));
				u1.setGuardianMobile(rs.getString(13));
				UserList.add(u1);
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		return UserList;
		
		
	}
	
	public ArrayList<Student> getStudentByGender(String gender) {
		
		return actionStdGend(gender);
	}
}
	


