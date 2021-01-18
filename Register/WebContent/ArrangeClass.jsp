<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/exSlideBar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hall Arrangements</title>

<!-- Icons font CSS-->
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">

</head>
<body>



	<!-- registration form -->

	<div>

		<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
			<div class="wrapper wrapper--w790">
				<div class="card card-5">

					<div class="card-body">
						<form action="HallInsertController">

							<div class="form-row">
								<div class="name">Hall Number</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="HallNumber"
											placeholder="F1B3">
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Teacher ID</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="TeacherId"
											placeholder="EMP32">
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="name">Type</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="Type"
											placeholder="Regular">
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Subject</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="Subject"
											placeholder="Science">
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Grade</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="Grade"
											placeholder="10">
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Day</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="Day"
											placeholder="Monday">
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Start Time</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="StartTime"
											placeholder="10.00 AM">
									</div>
								</div>
							</div>

							<div class="form-row">
								<div class="name">End Time</div>
								<div class="value">
									<div class="input-group">
										<input class="input--style-5" type="text" name="EndTime"
											placeholder="03.00 PM">
									</div>
								</div>
							</div>


							<center>
								<div class="form-group" style="width: 200px;">
									<input type="submit" value="Arrange"
										class="btn btn--radius-2 btn--blue"> <a
										href="HallListController">List</a>
								</div>
							</center>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Jquery JS-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<!-- Vendor JS-->
		<script src="vendor/select2/select2.min.js"></script>
		<script src="vendor/datepicker/moment.min.js"></script>
		<script src="vendor/datepicker/daterangepicker.js"></script>

		<!-- Main JS-->
		<script src="js/global.js"></script>
	</div>

</body>
</html>