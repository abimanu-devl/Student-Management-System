package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HallsDao;
import model.HallArrangements;

/**
 * Servlet implementation class SelectedHallDataController
 */
@WebServlet("/SelectedHallDataController")
public class SelectedHallDataController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ReservationId = Integer.parseInt(request.getParameter("ReservationId"));
		HallArrangements selectedHall = HallsDao.selectedHall(ReservationId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateArrange.jsp");
		request.setAttribute("selectedHall", selectedHall);
		dispatcher.forward(request, response);

	}

}
