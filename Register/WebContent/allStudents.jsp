<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Student"%>
<%@page import="services.IUserServices"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/exSlideBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
   
    

    <!-- Title Page-->
    <title>View Students</title>

    <!-- Icons font CSS
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">-->

    <!-- Vendor CSS
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">-->

    <!-- Main CSS-->
  	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link href="css/style.css" rel="stylesheet" media="all">    
</head>
<body>
<div class="container">
 <caption><h2>Student Details</h2></caption>
<table class="table table-striped table-hover mydatatable table-bordered table-responsive">
		
	<thead>	
		  <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Address</th>
                <th>Birthday</th>
                <th>NIC</th>
                <th>Email</th>
                <th>Guardian Name</th>
                <th>Guardian Mobile</th>
                <th>Telephone</th>
                <th>Password</th>
              	<th>Action</th>
                
            </tr>
       </thead>
            <%
            IUserServices s1 = new IUserServices();
			ArrayList<Student> arrayList = s1.getUsers();
			
			for(Student u1 : arrayList){
			%>
			 <tr>
				<td> <%=u1.getStudentID() %> </td>
				<td> <%=u1.getFirstName() %> </td>
				<td> <%=u1.getLastName() %> </td>
				<td> <%=u1.getGender() %> </td>
				<td> <%=u1.getAddress() %> </td>
				<td> <%=u1.getDob() %> </td>
				<td> <%=u1.getNIC() %> </td>
				<td> <%=u1.getEmail() %> </td>
				<td> <%=u1.getGuardianName() %> </td>
				<td> <%=u1.getGuardianMobile() %> </td>
				<td> <%=u1.getTelephone() %> </td>
				<td> <%=u1.getPassword() %> </td>
				
				<td> 
				<form method="POST" action="getDetailsServlet">
				<input type="hidden" name="userID" value="<%=u1.getStudentID()%>"/>
				 <input type="submit" value= "Edit" class=" btn-primary" style="width:75px;height:30px;"/> 
				 </form>
				
				 
				<form method="POST" action="deleteServlet">
				<input type="hidden" name="userID" value="<%=u1.getStudentID()%>"/>
				 <input type="submit" value= "Delete" class=" btn-danger" style="width:75px;height:30px;" /> 
				 </form>
				 </td>		
				</tr>			
			<%	
			   }
            
            %>     
		</table>
		<form method="post" action="StudentReportServlet">
		<select name="report">
			<option value="all">All Students</option>
  			<option value="male">Male</option>
  			<option value="female">Female</option>			
		</select>
		<input type="submit" value="Generate Report" class="btn btn-primary">
		</form>
		
</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
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