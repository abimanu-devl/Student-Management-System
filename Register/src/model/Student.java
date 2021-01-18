package model;

public class Student extends User{
	
	private String StudentID;
	private String GuardianName;
	private String GuardianMobile;
	
	public String getGuardianName() {
		return GuardianName;
	}
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public void setGuardianName(String guardianName) {
		GuardianName = guardianName;
	}
	public String getGuardianMobile() {
		return GuardianMobile;
	}
	public void setGuardianMobile(String guardianMobile) {
		GuardianMobile = guardianMobile;
	}
	
	

}
