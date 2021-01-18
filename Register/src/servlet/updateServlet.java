package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import services.IUserServices;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		Student u1= new Student();
		String uid=request.getParameter("userID");
		
		u1.setFirstName(request.getParameter("fname"));
		u1.setLastName(request.getParameter("lname"));
		u1.setGender(request.getParameter("gender"));
		u1.setAddress(request.getParameter("address"));
		u1.setDob(request.getParameter("dob"));
		u1.setNIC(request.getParameter("nic"));
		u1.setEmail(request.getParameter("email"));
		u1.setTelephone(request.getParameter("phone"));
		u1.setGuardianName(request.getParameter("gname"));
		u1.setGuardianMobile(request.getParameter("gmobile"));
		u1.setPassword(request.getParameter("password"));
		
		IUserServices upDetails = new IUserServices();
		upDetails.UpdateStudentDetails(uid, u1);
		
		request.setAttribute("userdetails", u1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allStudents.jsp");
		dispatcher.forward(request, response);
	}

}
