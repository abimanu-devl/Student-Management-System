package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employee;
import services.IUserServices;

/**
 * Servlet implementation class empUpdate
 */
@WebServlet("/empUpdate")
public class empUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empUpdate() {
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
		Employee u1= new Employee();
		String eid=request.getParameter("empID");
		
		u1.setFirstName(request.getParameter("fname"));
		u1.setLastName(request.getParameter("lname"));
		u1.setDesignation(request.getParameter("desingnation"));
		u1.setGender(request.getParameter("gender"));
		u1.setNIC(request.getParameter("nic"));
		u1.setAddress(request.getParameter("address"));
		u1.setEmail(request.getParameter("email"));
		u1.setTelephone(request.getParameter("phone"));
		u1.setPassword(request.getParameter("password"));
		u1.setOT_hours(Integer.parseInt(request.getParameter("otHours")));
		u1.setOT_Rate(Integer.parseInt(request.getParameter("otRate")));
		u1.setEmployeeType(request.getParameter("type"));
		
		IUserServices upempDetails = new IUserServices();
		upempDetails.UpdateEmployeeDetails(eid, u1);
		
		request.setAttribute("empdetails", u1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allEmployees.jsp");
		dispatcher.forward(request, response);
	}

}
