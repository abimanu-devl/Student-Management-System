package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HallArrangements;

public class HallsDao {

	// CLOUD SERVER
	public final static String cloudURL = "jdbc:mysql://52.237.113.122:3306/student_ms?autoReconnect=true&useSSL=false&verifyServerCertificate=false";
	public final static String cloudUser = "itpuser";
	public final static String cloudUserPW = "itp@123AdminPassword";

	// LOCALHOST
	public final static String localURL = "jdbc:mysql://localhost:3306/student_ms";
	public final static String localUser = "root";
	public final static String localUserPW = "";

	public static List<HallArrangements> selectAllHalls() {

		List<HallArrangements> Halls = new ArrayList<>();
		String SELECT_ALL_HALLS = "select * from HallArangements";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);
			// Connection con = DriverManager.getConnection(localURL, localUser,
			// localUserPW);
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_HALLS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int ReserveId = rs.getInt("ReservationId");
				String HallNumber = rs.getString("HallNumber");
				String TeacherName = rs.getString("TeacherName");
				String TeacherId = rs.getString("TeacherId");
				String Type = rs.getString("Type");
				String Subject = rs.getString("Subject");
				String Grade = rs.getString("Grade");
				String Day = rs.getString("Day");
				String StartTime = rs.getString("StartTime");
				String EndTime = rs.getString("EndTime");

				Halls.add(new HallArrangements(ReserveId, HallNumber, TeacherName, TeacherId, Type, Subject, Grade, Day,
						StartTime, EndTime));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

		return Halls;
	}

	public static void insertArrange(HallArrangements newHall) throws SQLException {

		String TeacherFName = null;
		String TeacherLName = null;
		String FullTeacherName = null;
		String INSERT_NEW_HALL = "INSERT INTO HallArangements"
				+ "  (HallNumber, TeacherName, TeacherId, Type, Subject, Grade, Day, StartTime, EndTime) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		String SELECT_DETAILS_BY_ID = "select * from User where UserId =?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);

			PreparedStatement ps1 = con.prepareStatement(SELECT_DETAILS_BY_ID);
			ps1.setString(1, newHall.getTeacherId());
			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) {

				TeacherFName = rs1.getString("FirstName");
				
				TeacherLName = rs1.getString("LastName");

			}
			FullTeacherName=TeacherFName+" "+TeacherLName;
			PreparedStatement ps = con.prepareStatement(INSERT_NEW_HALL);

			ps.setString(1, newHall.getHallNumber());
			ps.setString(2, FullTeacherName);
			ps.setString(3, newHall.getTeacherId());
			ps.setString(4, newHall.getType());
			ps.setString(5, newHall.getSubject());
			ps.setString(6, newHall.getGrade());
			ps.setString(7, newHall.getDay());
			ps.setString(8, newHall.getStartTime());
			ps.setString(9, newHall.getEndTime());
			
			

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static HallArrangements selectedHall(int ReservationId) {
		HallArrangements selectedHall = null;
		String SELECT_HALL_BY_ID = "select * from HallArangements where ReservationId =?";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);

			PreparedStatement ps = con.prepareStatement(SELECT_HALL_BY_ID);
			ps.setInt(1, ReservationId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int ReserveId = rs.getInt("ReservationId");
				String HallNumber = rs.getString("HallNumber");
				String TeacherName = rs.getString("TeacherName");
				String TeacherId = rs.getString("TeacherId");
				String Type = rs.getString("Type");
				String Subject = rs.getString("Subject");
				String Grade = rs.getString("Grade");
				String Day = rs.getString("Day");
				String StartTime = rs.getString("StartTime");
				String EndTime = rs.getString("EndTime");

				selectedHall = new HallArrangements(ReserveId, HallNumber, TeacherName, TeacherId, Type, Subject, Grade,
						Day, StartTime, EndTime);
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

		return selectedHall;
	}

	public static boolean updateArrange(HallArrangements Hall) throws SQLException {
		boolean rawUpdated = false;

		String UPDATE_SELECTED_ARRANGE = "update HallArangements set HallNumber=?, TeacherName=?, TeacherId=?, Type=?, Subject=?, Grade=?, Day=?, StartTime=?, EndTime=? where ReservationId=?;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);

			PreparedStatement ps = con.prepareStatement(UPDATE_SELECTED_ARRANGE);
			ps.setString(1, Hall.getHallNumber());
			ps.setString(2, Hall.getTeacherName());
			ps.setString(3, Hall.getTeacherId());
			ps.setString(4, Hall.getType());
			ps.setString(5, Hall.getSubject());
			ps.setString(6, Hall.getGrade());
			ps.setString(7, Hall.getDay());
			ps.setString(8, Hall.getStartTime());
			ps.setString(9, Hall.getEndTime());
			ps.setInt(10, Hall.getReserveId());

			rawUpdated = ps.executeUpdate() > 0;

		} catch (Exception E) {
			E.printStackTrace();
		}

		return rawUpdated;

	}

	public static boolean deleteHall(int ReservationId) throws SQLException {
		boolean rawDeleted = false;
		String DELETE_SELECTED_HALL = "delete from HallArangements where ReservationId = ?;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);

			PreparedStatement ps = con.prepareStatement(DELETE_SELECTED_HALL);
			ps.setInt(1, ReservationId);
			rawDeleted = ps.executeUpdate() > 0;

		} catch (Exception E) {
			E.printStackTrace();
		}

		return rawDeleted;

	}
	
	public static List<HallArrangements> selectAllHallsDay(String mDay) {

		List<HallArrangements> Halls = new ArrayList<>();
		String SELECT_ALL_HALLS_DAY = "select * from HallArangements where Day = ?";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);
			// Connection con = DriverManager.getConnection(localURL, localUser,
			// localUserPW);
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_HALLS_DAY);
			ps.setString(1, mDay);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int ReserveId = rs.getInt("ReservationId");
				String HallNumber = rs.getString("HallNumber");
				String TeacherName = rs.getString("TeacherName");
				String TeacherId = rs.getString("TeacherId");
				String Type = rs.getString("Type");
				String Subject = rs.getString("Subject");
				String Grade = rs.getString("Grade");
				String Day = rs.getString("Day");
				String StartTime = rs.getString("StartTime");
				String EndTime = rs.getString("EndTime");

				Halls.add(new HallArrangements(ReserveId, HallNumber, TeacherName, TeacherId, Type, Subject, Grade, Day,
						StartTime, EndTime));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

		return Halls;
	}
	
	public static List<HallArrangements> SubjectsController() {

		List<HallArrangements> Halls = new ArrayList<>();
		String SELECT_ALL_HALLS = "select DISTINCT Subject from HallArangements";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);
			
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_HALLS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				String Subject = rs.getString("Subject");
				

				Halls.add(new HallArrangements(Subject));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

		return Halls;
	}
	
	public static List<HallArrangements> selectAllHallsSub(String mSubject) {

		List<HallArrangements> Halls = new ArrayList<>();
		String SELECT_ALL_HALLS_SUBJECT = "select * from HallArangements where Subject = ?";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(cloudURL, cloudUser, cloudUserPW);
			// Connection con = DriverManager.getConnection(localURL, localUser,
			// localUserPW);
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_HALLS_SUBJECT);
			ps.setString(1, mSubject);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int ReserveId = rs.getInt("ReservationId");
				String HallNumber = rs.getString("HallNumber");
				String TeacherName = rs.getString("TeacherName");
				String TeacherId = rs.getString("TeacherId");
				String Type = rs.getString("Type");
				String Subject = rs.getString("Subject");
				String Grade = rs.getString("Grade");
				String Day = rs.getString("Day");
				String StartTime = rs.getString("StartTime");
				String EndTime = rs.getString("EndTime");

				Halls.add(new HallArrangements(ReserveId, HallNumber, TeacherName, TeacherId, Type, Subject, Grade, Day,
						StartTime, EndTime));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}

		return Halls;
	}

}
