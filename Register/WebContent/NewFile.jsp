<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Main Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Multiple Login Forms template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'> 
<link href='//fonts.googleapis.com/css?family=Athiti:400,200,300,500,600,700' rel='stylesheet' type='text/css'>
<!-- //web font --> 
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>Student Management System</h1>
		<!-- login form one -->
		<div class="login-form" style="float:left;">  
			<div class="agile-row">
				<h2>Admin Login</h2>   
				<div class="login-agileits-top"> 
					<form action="AdminLoginServlet" method="post"> 
						<div class="input-row">
							<input type="text" class="user" name="username" placeholder="Username" required=""/> 
							<input type="password" class="password" name="pass" placeholder="Password" required=""/>	
						</div>	
						<div class="agileits-row2">
							<input type="checkbox" id="brand" value="">
							<label for="brand"><span></span> Remember me</label> 
						</div>
						<input type="submit" value="LOGIN">
					</form>  
				</div>
				<div class="login-agileits-bottom"> 
					<p><a href="#">Forgot password ?</a></p>  
				</div> 
			</div>  
		</div>
		<div class="login-form" style="float:right;">  
			<div class="agile-row">
				<h2>Teacher Login</h2>   
				<div class="login-agileits-top"> 
					<form action="#" method="post"> 
						<div class="input-row">
							<input type="text" class="user" name="Username" placeholder="Username" required=""/> 
							<input type="password" class="password" name="Password" placeholder="Password" required=""/>	
						</div>	
						<div class="agileits-row2">
							<input type="checkbox" id="brand" value="">
							<label for="brand"><span></span> Remember me</label> 
						</div>	
						<input type="submit" value="LOGIN">
					</form>  
				</div>
				<div class="login-agileits-bottom"> 
					<p><a href="#">Forgot password ?</a></p>  
				</div> 
			</div>  
		</div>
		<div class="login-form">  
			<div class="agile-row">
				<h2>Student Login</h2>   
				<div class="login-agileits-top"> 
					<form action="#" method="post"> 
						<div class="input-row">
							<input type="text" class="user" name="User Name" placeholder="Username" required=""/> 
							<input type="password" class="password" name="Password" placeholder="Password" required=""/>	
						</div>	
						<div class="agileits-row2">
							<input type="checkbox" id="brand" value="">
							<label for="brand"><span></span> Remember me</label> 
						</div>	
						<input type="submit" value="LOGIN">
					</form>  
				</div>
				<div class="login-agileits-bottom"> 
					<p><a href="#">Forgot password ?</a></p>  
				</div> 
			</div>  
		</div>
</body>
</html>