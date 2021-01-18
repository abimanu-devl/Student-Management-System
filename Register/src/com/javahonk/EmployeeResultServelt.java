package com.javahonk;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import services.IUserServices;


/**
 * Servlet implementation class EmployeeResultServelt
 */
@WebServlet("/EmployeeResultServelt")
public class EmployeeResultServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeResultServelt() {
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
		
		String type = request.getParameter("report");
		
		response.setContentType("text/csv");
		if(type.equals("Academic")) {
        String reportName =  "Academic"
                +System.currentTimeMillis()+".csv";     
        response.setHeader("Content-disposition", "attachment; " +
                "filename=" + reportName);   

        ArrayList<String> rows = new ArrayList<String>();
        rows.add("Employee ID,First Name,Last Name,Gender,Address,NIC,Email,Designation,Telephone");       
        rows.add("\n");
        
		
		IUserServices iuser=new IUserServices();
		ArrayList<Employee> emplist=iuser.getEmployeeByType(type);
		
		for(Employee e1:emplist) {
			
			String data = String.valueOf(e1.getEmployeeID())+","+e1.getFirstName()+","+e1.getLastName()+","
					+e1.getGender()+","+e1.getAddress()+","+e1.getNIC()+","+e1.getEmail()+","+e1.getDesignation()+","+e1.getTelephone();
			rows.add(data);
			rows.add("\n");
			
		}
		
		Iterator<String> iter = rows.iterator();
        while (iter.hasNext()){
            String outputString = (String) iter.next();
            response.getOutputStream().print(outputString);
        }

        response.getOutputStream().flush();
        
		} else if(type.equals("Teacher")) {
			
			 String reportName =  "Teacher"
		                +System.currentTimeMillis()+".csv";     
		        response.setHeader("Content-disposition", "attachment; " +
		                "filename=" + reportName);   

		        ArrayList<String> rows = new ArrayList<String>();
		        rows.add("Employee ID,First Name,Last Name,Gender,Address,NIC,Email,Designation,Telephone");       
		        rows.add("\n");
		        
				
				IUserServices iuser=new IUserServices();
				ArrayList<Employee> emplist2=iuser.getEmployeeByType(type);
				
				for(Employee e2:emplist2) {
					
					String data = String.valueOf(e2.getEmployeeID())+","+e2.getFirstName()+","+e2.getLastName()+","
							+e2.getGender()+","+e2.getAddress()+","+e2.getNIC()+","+e2.getEmail()+","+e2.getDesignation()+","+e2.getTelephone();
					rows.add(data);
					rows.add("\n");
					
				}
				
				Iterator<String> iter = rows.iterator();
		        while (iter.hasNext()){
		            String outputString = (String) iter.next();
		            response.getOutputStream().print(outputString);
		        }

		        response.getOutputStream().flush();
			
			
		}else if(type.equals("Non-Academic")) {
			
			String reportName =  "Non-Academic"
	                +System.currentTimeMillis()+".csv";     
	        response.setHeader("Content-disposition", "attachment; " +
	                "filename=" + reportName);   

	        ArrayList<String> rows = new ArrayList<String>();
	        rows.add("Employee ID,First Name,Last Name,Gender,Address,NIC,Email,Designation,Telephone");       
	        rows.add("\n");
	        
			
			IUserServices iuser=new IUserServices();
			ArrayList<Employee> emplist3=iuser.getEmployeeByType(type);
			
			for(Employee e3:emplist3) {
				
				String data = String.valueOf(e3.getEmployeeID())+","+e3.getFirstName()+","+e3.getLastName()+","
						+e3.getGender()+","+e3.getAddress()+","+e3.getNIC()+","+e3.getEmail()+","+e3.getDesignation()+","+e3.getTelephone();
				rows.add(data);
				rows.add("\n");
				
			}
			
			Iterator<String> iter = rows.iterator();
	        while (iter.hasNext()){
	            String outputString = (String) iter.next();
	            response.getOutputStream().print(outputString);
	        }

	        response.getOutputStream().flush();
			
			
			
		}else {
				
				String reportName =  "All_Employees"
		                +System.currentTimeMillis()+".csv";     
		        response.setHeader("Content-disposition", "attachment; " +
		                "filename=" + reportName);   

		        ArrayList<String> rows = new ArrayList<String>();
		        rows.add("Employee ID,First Name,Last Name,Gender,Address,NIC,Email,Designation,Telephone");       
		        rows.add("\n");
		        
				
				IUserServices iuser=new IUserServices();
				ArrayList<Employee> emplist4=iuser.getEmployees();
				
				for(Employee e4:emplist4) {
					
					String data = String.valueOf(e4.getEmployeeID())+","+e4.getFirstName()+","+e4.getLastName()+","
							+e4.getGender()+","+e4.getAddress()+","+e4.getNIC()+","+e4.getEmail()+","+e4.getDesignation()+","+e4.getTelephone();;
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
