package com.javahonk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HallArrangements;
import dao.HallsDao;
import java.util.List;

/**
 * @author Java Honk Servlet implementation class ReportServlet
 */
@WebServlet("/CSVReportServlet")
public class CSVReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CSVReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String SelectedDate = request.getParameter("SelectedDay");
		

		response.setContentType("text/csv");
		String reportName = "CurrentArrangements" + System.currentTimeMillis() + ".csv";
		response.setHeader("Content-disposition", "attachment; " + "filename=" + reportName);

		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Reserve ID,Hall Number,Teacher,Teacher ID,Type,Subject,Grade,Day,Start Time,End Time");
		rows.add("\n");
		
		List<HallArrangements> arrayList;

		if (SelectedDate.equals("All")) {
			
			arrayList = HallsDao.selectAllHalls();
			
		}
		else {
			
			arrayList = HallsDao.selectAllHallsDay(SelectedDate);
		}
		

		for (HallArrangements u1 : arrayList) {
			String ROW_DATA = String.valueOf(u1.getReserveId()) + "," + u1.getHallNumber() + "," + u1.getTeacherName()
					+ "," + u1.getTeacherId() + "," + u1.getType() + "," + u1.getSubject() + "," + u1.getGrade() + ","
					+ u1.getDay() + "," + u1.getStartTime() + "," + u1.getEndTime();
			rows.add(ROW_DATA);
			rows.add("\n");
		}

		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}

		response.getOutputStream().flush();

	}

}