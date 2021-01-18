package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HallsDao;
import model.HallArrangements;

/**
 * Servlet implementation class HallInsertController
 */
@WebServlet("/HallInsertController")
public class HallInsertController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String HallNumber = request.getParameter("HallNumber");
		String TeacherName = request.getParameter("TeacherName");
		String TeacherId = request.getParameter("TeacherId");
		String Type=request.getParameter("Type");
		String Subject=request.getParameter("Subject");
		String Grade=request.getParameter("Grade");
		String Day=request.getParameter("Day");
		String StartTime=request.getParameter("StartTime");
		String EndTime=request.getParameter("EndTime");
		
		HallArrangements newArrange = new HallArrangements(HallNumber, TeacherName, TeacherId, Type, Subject, Grade, Day, StartTime, EndTime);
		try {
			HallsDao.insertArrange(newArrange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("HallListController");
		
	}

}
