package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnquiryDao;
import model.Enquiry;

/**
 * Servlet implementation class CSVReportEnqServlet
 */
@WebServlet("/CSVReportEnqServlet")
public class CSVReportEnqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSVReportEnqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/csv");
	        String reportName =  "Enquiry_History_Details"
	                +System.currentTimeMillis()+".csv";     
	        response.setHeader("Content-disposition", "attachment; " +
	                "filename=" + reportName);   

	        ArrayList<String> rows = new ArrayList<String>();
	        rows.add("Enquiry ID,User ID,Email,Subject,Message");       
	        rows.add("\n");

	        
	        List<Enquiry> arrayList = EnquiryDao.selectAllEnquiries();

			for (Enquiry u1 : arrayList) {
				String ROW_DATA = String.valueOf(u1.getEid())+","+u1.getUserID()+","+u1.getEmail()+","
						+u1.getSubject()+","+u1.getMessage();
				rows.add(ROW_DATA);
				rows.add("\n");
			}

	        Iterator<String> iter = rows.iterator();
	        while (iter.hasNext()){
	            String outputString = (String) iter.next();
	            response.getOutputStream().print(outputString);
	        }

	        response.getOutputStream().flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
