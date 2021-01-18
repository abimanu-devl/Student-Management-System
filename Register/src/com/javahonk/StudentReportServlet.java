package com.javahonk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import services.IUserServices;

/**
 * Servlet implementation class StudentReportServlet
 */
@WebServlet("/StudentReportServlet")
public class StudentReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String gender = request.getParameter("report");
		
		 response.setContentType("text/csv");
		 if(gender.equals("male")) {
		 String reportName =  "Male_Student_Details"
	                +System.currentTimeMillis()+".csv";     
	        response.setHeader("Content-disposition", "attachment; " +
	                "filename=" + reportName);   

	        ArrayList<String> rows = new ArrayList<String>();
	        rows.add("Student ID,First Name,Last Name,Gender,Address,Date Of Birth,NIC,Email,Guardian Name,Guardian Mobile,Telephone");       
	        rows.add("\n");
	        
			
			IUserServices iuser=new IUserServices();
			ArrayList<Student> stdlist=iuser.getStudentByGender(gender);
			
			for(Student s1:stdlist) {
				
				String data = String.valueOf(s1.getStudentID())+","+s1.getFirstName()+","+s1.getLastName()+","
						+s1.getGender()+","+s1.getAddress()+","+s1.getDob()+","+s1.getNIC()+","+s1.getEmail()+","+s1.getGuardianName()+","
						+s1.getGuardianMobile()+","+s1.getTelephone();
				rows.add(data);
				rows.add("\n");
				
			}
			
			Iterator<String> iter = rows.iterator();
	        while (iter.hasNext()){
	            String outputString = (String) iter.next();
	            response.getOutputStream().print(outputString);
	        }

	        response.getOutputStream().flush();
	        
		 } else if(gender.equals("female")) {
			 
			 String reportName =  "Female_Student_Details"
		                +System.currentTimeMillis()+".csv";     
		        response.setHeader("Content-disposition", "attachment; " +
		                "filename=" + reportName);   

		        ArrayList<String> rows = new ArrayList<String>();
		        rows.add("Student ID,First Name,Last Name,Gender,Address,Date Of Birth,NIC,Email,Guardian Name,Guardian Mobile,Telephone");       
		        rows.add("\n");
		        
				
				IUserServices iuser=new IUserServices();
				ArrayList<Student> stdlist2=iuser.getStudentByGender(gender);
				
				for(Student s2:stdlist2) {
					
					String data = String.valueOf(s2.getStudentID())+","+s2.getFirstName()+","+s2.getLastName()+","
							+s2.getGender()+","+s2.getAddress()+","+s2.getDob()+","+s2.getNIC()+","+s2.getEmail()+","+s2.getGuardianName()+","
							+s2.getGuardianMobile()+","+s2.getTelephone();
					rows.add(data);
					rows.add("\n");
					
				}
				
				Iterator<String> iter = rows.iterator();
		        while (iter.hasNext()){
		            String outputString = (String) iter.next();
		            response.getOutputStream().print(outputString);
		        }

		        response.getOutputStream().flush();
			 
		 } else if(gender.equals("all")) {
			 
			 String reportName =  "All_Student_Details"
		                +System.currentTimeMillis()+".csv";     
		        response.setHeader("Content-disposition", "attachment; " +
		                "filename=" + reportName);   

		        ArrayList<String> rows = new ArrayList<String>();
		        rows.add("Student ID,First Name,Last Name,Gender,Address,Date Of Birth,NIC,Email,Guardian Name,Guardian Mobile,Telephone");       
		        rows.add("\n");
		        
				
				IUserServices iuser=new IUserServices();
				ArrayList<Student> stdlist3=iuser.getUsers();
				
				for(Student s3:stdlist3) {
					
					String data = String.valueOf(s3.getStudentID())+","+s3.getFirstName()+","+s3.getLastName()+","
							+s3.getGender()+","+s3.getAddress()+","+s3.getDob()+","+s3.getNIC()+","+s3.getEmail()+","+s3.getGuardianName()+","
							+s3.getGuardianMobile()+","+s3.getTelephone();
					rows.add(data);
					rows.add("\n");
					
				}
				
				Iterator<String> iter = rows.iterator();
		        while (iter.hasNext()){
		            String outputString = (String) iter.next();
		            response.getOutputStream().print(outputString);
		        }

		        response.getOutputStream().flush();
			 
			 
		 }
	}

}
