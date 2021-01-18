package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.AdminLoginService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		
		User u = new User();
		u.setUserID(request.getParameter("username"));
		u.setPassword(request.getParameter("pass"));
		
		AdminLoginService logservice = new AdminLoginService();
		String mesg=logservice.adminLogin(u);
		
		
		if(mesg.equals("Logged")) {
			HttpSession session=request.getSession();  
	        session.setAttribute("username",u.getUserID());  
	        response.sendRedirect("AddNewStudent.jsp");
			
		}else {
			
			request.setAttribute("error",mesg);
			RequestDispatcher rd =  request.getRequestDispatcher("/AdminLogin.jsp");
			rd.forward(request, response);
			
		}

	}
}
