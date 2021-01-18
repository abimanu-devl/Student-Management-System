package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HallsDao;

/**
 * Servlet implementation class HallDeleteController
 */
@WebServlet("/HallDeleteController")
public class HallDeleteController extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ReservationId = Integer.parseInt(request.getParameter("ReservationId"));
		try {
			HallsDao.deleteHall(ReservationId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("HallListController");
		
		
	}

}
