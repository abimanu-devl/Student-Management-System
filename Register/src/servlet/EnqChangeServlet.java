package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnquiryDao;
import model.Enquiry;

/**
 * Servlet implementation class EnqChangeServlet
 */
@WebServlet("/EnqChangeServlet")
public class EnqChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnqChangeServlet() {
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
		Enquiry enq = new Enquiry();
		
		enq.setEmail(request.getParameter("email"));
		enq.setSubject(request.getParameter("subject"));
		enq.setMessage(request.getParameter("message"));
		
		
		
		enq.setEid(Integer.parseInt(request.getParameter("eid")));
		
		
		
		EnquiryDao EnqDao = new EnquiryDao();
		EnqDao.UpdateEnq(enq);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EnquiryHistory1.jsp");
		dispatcher.forward(request, response);
	}

}
