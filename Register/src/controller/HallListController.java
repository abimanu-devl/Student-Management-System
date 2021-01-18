package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HallsDao;
import model.HallArrangements;

/**
 * Servlet implementation class HallListController
 */
@WebServlet("/HallListController")
public class HallListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<HallArrangements> ListHalls = HallsDao.selectAllHalls();
		request.setAttribute("listHalls", ListHalls);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewArrangements.jsp");
		dispatcher.forward(request, response);
		
	}


}
