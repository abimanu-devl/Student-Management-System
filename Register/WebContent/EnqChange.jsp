<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.EnquiryDao"%>
    <%@page import="model.Enquiry"%>
    <%@page import="model.Enquiry"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>

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
		<%
            Enquiry e1 = (Enquiry)request.getAttribute("Enq");		
			
			%>	
<div class="container-contact100">

		<div class="wrap-contact100">
			<form class="contact100-form validate-form" method="post" action="EnqChangeServlet" >
				<span class="contact100-form-title">
					Change Enquiry
				</span>

<b style="margin-left:30px;">Email</b>
				<div class="wrap-input100 validate-input" data-validate = "Please enter your email: e@a.x">
				
					<input class="input100" value="<%=e1.getEmail() %>" type="text" name="email" >
					<span class="focus-input100"></span>
				</div>

<b style="margin-left:30px;">Subject</b>
				<div class="wrap-input100 validate-input" data-validate = "Please enter your phone">
			
					<input class="input100"  value="<%=e1.getSubject() %>" type="text" name="subject" >
					<span class="focus-input100"></span>
				</div>

<b style="margin-left:30px;">Message</b>
				<div class="wrap-input100 validate-input" data-validate = "Please enter your message">
				
					<input type="text" class="input100" value="<%=e1.getMessage() %>" name="message" ></textarea>
					<span class="focus-input100"></span>
				</div>

<input type="hidden" name="eid" value="<%=e1.getEid()%>"/>


				<div class="container-contact100-form-btn">
					<button class= "btn btn-primary btn-lg" >
						<span>
							
							Change
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>




</body>
</html>