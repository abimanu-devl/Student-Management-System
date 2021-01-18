package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnquiryDao;
import model.Enquiry;

/**
 * Servlet implementation class EnquiryServlet
 */
@WebServlet("/EnquiryServlet")
public class EnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Enquiry enq = new Enquiry();
		enq.setUserID(request.getParameter("Userid"));
		enq.setEmail(request.getParameter("email"));
		enq.setSubject(request.getParameter("subject"));
		enq.setMessage(request.getParameter("message"));
		
	
		EnquiryDao EnqDao = new EnquiryDao();
		EnqDao.sendEnquiry(enq);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Enquiry1.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

}
