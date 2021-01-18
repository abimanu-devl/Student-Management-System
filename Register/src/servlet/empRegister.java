package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import services.IUserServices;

/**
 * Servlet implementation class empRegister
 */
@WebServlet("/empRegister")
public class empRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empRegister() {
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
		Employee e1 = new Employee();   
		
		e1.setFirstName(request.getParameter("fname"));
		e1.setLastName(request.getParameter("lname"));
		e1.setDob(request.getParameter("dob"));
		e1.setGender(request.getParameter("gender"));
		e1.setNIC(request.getParameter("nic"));
		e1.setEmail(request.getParameter("email"));
		e1.setAddress(request.getParameter("address"));
		e1.setTelephone(request.getParameter("phone"));
		e1.setDesignation(request.getParameter("desingnation"));
		e1.setEmployeeType(request.getParameter("type"));
		e1.setOT_hours(Integer.parseInt(request.getParameter("otHours")));
		e1.setOT_Rate(Integer.parseInt(request.getParameter("otRate")));
		
		IUserServices addemployee = new IUserServices();
		addemployee.addEmployee(e1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allEmployees.jsp");
		dispatcher.forward(request, response);
	}

}
