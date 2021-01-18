<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
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
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
        <h3>Student Registration</h3>
            <div class="card card-5">
                
                <div class="card-body">
                   <form method="POST" action="registerServlet">
                        
                        <div class="form-row">
                            <div class="name">First Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="fname" placeholder="First Name" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Last Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="lname" placeholder="Last Name" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Date of Birth</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="dob" placeholder="mm/dd/yyyy" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Address</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="address" placeholder="Address" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="email" placeholder="E-mail" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">NIC</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="nic" placeholder="NIC" maxlength="12" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Guardian Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="gname" placeholder="Guardian Name" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Guardian Mobile</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="gmobile" placeholder="Guardian Mobile" maxlength="10" required>
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">Telephone</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="phone" placeholder="Telephone" maxlength="10" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Gender</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender">
                                            <option disabled="disabled" selected="selected">Choose option</option>
                                            <option>Male</option>
                                            <option>Female</option>
                                           
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                       <!--   <input type="hidden" value="std" name="stufrom">-->
                        <div><center>
                            <button class="btn btn--radius-2 btn--blue" type="submit">Confirm</button>
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