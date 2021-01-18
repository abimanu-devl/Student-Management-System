<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enquiry History</title>

	<title>Contact V10</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>-->
	<link rel="stylesheet" type="text/css" href="css/uj/bootstrap.css">
<!--===============================================================================================
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/uj/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/uj/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/uj/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/uj/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/uj/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/uj/util.css">
	<link rel="stylesheet" type="text/css" href="css/uj/main.css">
<!--===============================================================================================-->
</head>
<body>

<div class="container-contact100">

		<div class="wrap-contact100">
			<form class="contact100-form validate-form" method="post" action="EnquiryServlet" >
				<span class="contact100-form-title">
					CONTACT US
				</span>

				<div class="wrap-input100 validate-input" data-validate="Please enter your name">
					<input class="input100" type="text" name="Userid" placeholder="User ID">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Please enter your email: e@a.x">
					<input class="input100" type="text" name="email" placeholder="E-mail">
					<span class="focus-input100"></span>
				</div>


				<div class="wrap-input100 validate-input" data-validate = "Please enter your phone">
				
					<input class="input100" type="text" name="subject" placeholder="Message Subject">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Please enter your message">
					<textarea class="input100" name="message" placeholder="Your Message"></textarea>
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<button class="btn btn-primary btn-lg"  >
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							Send
						</span>
					</button>
				</div>
			</form>
			<hr><hr>
			
			<h2>Successfully send!!!!</h2>
			<hr><hr><hr><hr>
			
			
			<a href ="EnquiryHistory1.jsp">
			<button class="btn btn-primary btn-lg"  >
						<span>
							
							Enquiry History
						</span>
					</button>
			</a>
		</div>
	</div>



	<div id="dropDownSelect1"></div>
	
	<!--===============================================================================================-->
	<script src="vendor/uj/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/uj/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/uj/bootstrap/js/popper.js"></script>
	<script src="vendor/uj/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/uj/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/uj/daterangepicker/moment.min.js"></script>
	<script src="vendor/uj/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/uj/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>

	
</body>
</html>