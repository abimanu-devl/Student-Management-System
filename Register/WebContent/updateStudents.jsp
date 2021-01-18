<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="model.Student"%>
<%@page import="services.IUserServices"%>
<jsp:include page="/exSlideBar.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->


    <!-- Title Page-->
    <title>Register</title>

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

<body bgcolor="#FFFFF1">
<%
		Student u1 = (Student) request.getAttribute("userdetails");
		
%>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
        <h3>Edit Student Details</h3>
            <div class="card card-5">
                
                <div class="card-body">
                   <form method="POST" action="updateServlet">
                        
                        <div class="form-row">
                            <div class="name">First Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="fname" placeholder="First Name" value="<%=u1.getFirstName()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Last Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="lname" placeholder="Last Name" value="<%=u1.getLastName()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Date of Birth</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="dob" placeholder="mm/dd/yyyy" value="<%=u1.getDob()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Address</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="address" placeholder="Address" value="<%=u1.getAddress()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="email" placeholder="E-mail" value="<%=u1.getEmail()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">NIC</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="nic" placeholder="NIC" maxlength="12" value="<%=u1.getNIC()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Guardian Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="gname" placeholder="Guardian Name" value="<%=u1.getGuardianName()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Guardian Mobile</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="gmobile" placeholder="Guardian Mobile" maxlength="10" value="<%=u1.getGuardianMobile()%>">
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">Telephone</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="phone" placeholder="Telephone" value="<%=u1.getTelephone()%>">
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">Password</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="password" placeholder="Password" value="<%=u1.getPassword()%>">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Gender</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender">
                                            <option value="<%=u1. getGender()%>" selected><%=u1. getGender()%></option>
                                            <option>Male</option>
                                            <option>Female</option>
                                           
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" value="std" name="stufrom">
                        <div><center>
                            <button class="btn btn--radius-2 btn--blue" type="submit" name="userID" value="<%=u1.getStudentID()%>">Save</button>
                        </center></div>
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

</body>

</html>
<!-- end document-->