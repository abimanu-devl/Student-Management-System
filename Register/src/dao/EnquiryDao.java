package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import model.Enquiry;
import util.DBConnection;

public class EnquiryDao {

	private static Connection con;

	private static PreparedStatement ps;
	

public  void sendEnquiry(Enquiry enquiry) {

				
		try {
			
			con=DBConnection.dbconnect();
			
			
			String sql="insert into enquiry (UserID,email,subject,message) values(?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(sql);
			
			ps1.setString(1,enquiry.getUserID());
			ps1.setString(2, enquiry.getEmail());
			ps1.setString(3, enquiry.getSubject());
			ps1.setString(4, enquiry.getMessage());
				
			
			ps1.executeUpdate();
			//con.commit();

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}


private ArrayList<Enquiry> actionUser(String UserID) {
		ArrayList<Enquiry> EnqList = new ArrayList<Enquiry>();
		ResultSet rs;
		try {
			
			
			con=DBConnection.dbconnect();
			
			if (UserID!= null && !UserID.isEmpty()) {
				
				ps=con.prepareStatement("select * from enquiry where UserID=?");
				ps.setString(1,UserID );
				rs=ps.executeQuery();
				
			}else {
				ps=con.prepareStatement("select * from enquiry");
				rs=ps.executeQuery();
				
				
			}
			while(rs.next()) {
				Enquiry e1=new Enquiry();
				e1.setEid(rs.getInt(1));
				e1.setUserID(rs.getString(2));
				e1.setEmail(rs.getString(3));
				e1.setSubject(rs.getString(4));
				e1.setMessage(rs.getString(5));
				EnqList.add(e1);				
			}
									
		}catch(Exception e) {
			e.printStackTrace();						
		}
		return EnqList;
}

//  *** This method is for generate a Report only ***
public static List<Enquiry> selectAllEnquiries() {

	List<Enquiry> AllEnq = new ArrayList<>();
	String SELECT_ALL_ENQS = "select * from enquiry";
	try {

		con=DBConnection.dbconnect();
		
		PreparedStatement ps = con.prepareStatement(SELECT_ALL_ENQS);
		ResultSet rs = ps.executeQuery();
		
		

		while (rs.next()) {
			
			Enquiry e1=new Enquiry();
			e1.setEid(rs.getInt("EnqID"));
			e1.setUserID(rs.getString("UserID"));
			e1.setEmail(rs.getString("email"));
			e1.setSubject(rs.getString("subject"));
			e1.setMessage(rs.getString("message"));
			///
			/*String Subject = rs.getString("Subject");
			String Grade = rs.getString("Grade");
			String Day = rs.getString("Day");
			String StartTime = rs.getString("StartTime");
			String EndTime = rs.getString("EndTime");*/

			AllEnq.add(e1);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	return AllEnq;
}


	
	    
public Enquiry getEnqByID(String eID) {
		
		return actionUser(eID).get(0);
	}


public ArrayList<Enquiry> getEnq() {
	
	return actionUser(null);
}  



public void DeleteEnquiry(int id) {
	
		try {
			
			con=DBConnection.dbconnect();
			ps=con.prepareStatement("delete from enquiry where EnqID=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}

}

public void UpdateEnq(Enquiry e1) {
	
		try {
			
			con=DBConnection.dbconnect();
			ps=con.prepareStatement("update enquiry set email=?,subject=?,message=? where EnqID=?");
			
			
			ps.setString(1,e1.getEmail());
			ps.setString(2,e1.getSubject());
			ps.setString(3,e1.getMessage());
			ps.setInt(4,e1.getEid());
			
			
			ps.executeUpdate();
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	

    
    
}
