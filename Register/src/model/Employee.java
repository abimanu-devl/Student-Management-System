package model;

public class Employee extends User{
	
	private String EmployeeID;
	private String Designation;
	private int OT_hours;
	private int OT_Rate;
	private String EmployeeType;
	
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getOT_hours() {
		return OT_hours;
	}
	public void setOT_hours(int oT_hours) {
		OT_hours = oT_hours;
	}
	public int getOT_Rate() {
		return OT_Rate;
	}
	public void setOT_Rate(int oT_Rate) {
		OT_Rate = oT_Rate;
	}
	public String getEmployeeType() {
		return EmployeeType;
	}
	public void setEmployeeType(String employeeType) {
		EmployeeType = employeeType;
	}
	
	
	
	
	

}
