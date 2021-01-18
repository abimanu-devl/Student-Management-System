package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Enquiry;

/**
 * Servlet implementation class showHistoryServlet
 */
@WebServlet("/showHistoryServlet")
public class showHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showHistoryServlet() {
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
		
		String email=request.getParameter("email");
		String subject =request.getParameter("subject");
		String message =request.getParameter("message");
		
		//
		int eid =Integer.parseInt(request.getParameter("eid"));
		//
		
		Enquiry e1 =new Enquiry();
		
		e1.setEmail(email);
		e1.setSubject(subject);
		e1.setMessage(message);
		//
		e1.setEid(eid);
		//
		
		
		request.setAttribute("Enq", e1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EnqChange.jsp");
		dispatcher.forward(request, response);
	}

}
