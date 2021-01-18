<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.HallArrangements"%>
<%@page import="dao.HallsDao"%>
<%@page import="java.util.List"%>
<jsp:include page="/exSlideBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>

<title>View Arrangements</title>

<!-- Required meta tags -->
<meta charset="utf-8">


<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">



</head>
<body>

	<div class="container">
		<table
			class="table table-striped table-hover mydatatable table-bordered table-responsive">

			<thead>
				<tr>

					<th>Reserve ID</th>
					<th>Hall Number</th>
					<th>Teacher</th>
					<th>Teacher ID</th>
					<th>Type</th>
					<th>Subject</th>
					<th>Grade</th>
					<th>Day</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Options</th>



				</tr>
			</thead>
			<%
				List<HallArrangements> arrayList = HallsDao.selectAllHalls();

				for (HallArrangements u1 : arrayList) {
			%>
			<tr>
				<td><%=u1.getReserveId()%></td>
				<td><%=u1.getHallNumber()%></td>
				<td><%=u1.getTeacherName()%></td>
				<td><%=u1.getTeacherId()%></td>
				<td><%=u1.getType()%></td>
				<td><%=u1.getSubject()%></td>
				<td><%=u1.getGrade()%></td>
				<td><%=u1.getDay()%></td>
				<td><%=u1.getStartTime()%></td>
				<td><%=u1.getEndTime()%></td>
				<td><a
					href="SelectedHallDataController?ReservationId=<%=u1.getReserveId()%>">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="HallDeleteController?ReservationId=<%=u1.getReserveId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form action="CSVReportSubject">

		<select name="SelectedSubject" id="cars">
			<option value="AllSub">All Subjects </option>

			<%
				List<HallArrangements> arrayList1 = HallsDao.SubjectsController();

				for (HallArrangements u1 : arrayList1) {
			%>
			
			<option value="<%=u1.getSubject()%>"><%=u1.getSubject()%></option>

			<%
				}
			%>
			
		</select> <input type="submit" value="Generate CSV report">
	</form>

	<form action="CSVReportServlet">

		<select name="SelectedDay" id="cars">
			<option value="All">All Days </option>
			<option value="Monday">Monday</option>
			<option value="Tuesday">Tuesday</option>
			<option value="Wednesday">Wednesday</option>
			<option value="Thursday">Thursday</option>
			<option value="Friday">Friday</option>
			<option value="Saturday">Saturday</option>
			<option value="Sunday">Sunday</option>
		</select> <input type="submit" value="Generate CSV report">
	</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	<!-- <script>
	    $('.mydatatable').DataTable(
	    		
	    		{     

	    		      "aLengthMenu": [[5, 10, 25, -1], [5, 10, 25, "All"]],
	    		        "iDisplayLength": 5
	    		 } 
	    		        
	    
	    );
	    
	</script> -->
	<script>
		$('.mydatatable').DataTable();
	</script>
</body>
</html>