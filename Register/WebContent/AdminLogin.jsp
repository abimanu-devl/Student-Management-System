<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
 <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>
<body background="sss.jpg" style=" background-repeat: no-repeat;
  background-size: 1600px 1960px;">
<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790" style=" border: 1px solid;
  padding: 5px;
  box-shadow: 5px 10px #4287f5;margin-top:120px;width:570px;background:#FFFFFF">
        <h2><b>Admin Login</b></h2><br><br>
			<form method="post" action="AdminLoginServlet">
				<div class="form-row">
                            <div class="name">Username</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="username" placeholder="Username" style="width:300px;" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Password</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="password" name="pass" placeholder="Password" style="width:300px;" required>
                                </div>
                            </div>
                        </div>
                        <b><p style="color:red;margin-left:125px;"><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%></p></b>
                        
                        <button class="btn btn--radius-2 btn--blue" type="submit" style="margin-left:125px;">Login</button>
				</form>
		 	</div>
</div>
</body>
</html>