<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Employee"%>
<%@page import="services.IUserServices"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/exSlideBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
   
    

    <!-- Title Page-->
    <title>View Employees</title>

    <!-- Icons font CSS
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">-->
	
	
    <!-- Vendor CSS  
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">-->

    <!-- Main CSS --> 
  	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css"> 
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">  
</head>
<body>
<div class="container">
 <caption><h2>Employee Details</h2></caption>
<table class="table table-striped table-hover mydatatable table-bordered table-responsive">
		
		<thead>	
		  <tr>
                <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Address</th>
                <th>NIC</th>
                <th>Email</th>
                <th>Designation</th>
                <th>OT Hours</th>
                <th>OT Rate</th>
                <th>Telephone</th>
                <th>Password</th>
                <th>Employee Type</th>
                <th>Action</th>
                
            </tr>
         </thead>
            <%
      
            IUserServices s1 = new IUserServices();
			ArrayList<Employee> arrayList = s1.getEmployees();
			
			for(Employee u1 : arrayList){
			%>
			 <tr>
				<td> <%=u1.getEmployeeID() %> </td>
				<td> <%=u1.getFirstName() %> </td>
				<td> <%=u1.getLastName() %> </td>
				<td> <%=u1.getGender() %> </td>
				<td> <%=u1.getAddress() %> </td>
				<td> <%=u1.getNIC() %> </td>
				<td> <%=u1.getEmail() %> </td>
				<td> <%=u1.getDesignation() %></td>
				<td> <%=u1.getOT_hours() %> </td>
				<td> <%=u1.getOT_Rate() %> </td>
				<td> <%=u1.getTelephone() %> </td>
				<td> <%=u1.getPassword() %> </td>
				<td> <%=u1.getEmployeeType() %></td>
				
				<td> 
				 <form method="POST" action="empGetDetails">
				 	<input type="hidden" name="empID" value="<%=u1.getEmployeeID()%>"/>
				 	<input type="submit" value= "Edit" class=" btn-primary" style="width:75px;height:30px;"/> 
				 </form>
				
				 <form method="POST" action="empDelete">
				 	<input type="hidden" name="empID" value="<%=u1.getEmployeeID()%>"/>
				 	<input type="submit" value= "Delete" class=" btn-danger" style="width:75px;height:30px;" /> 
				 </form>
				</td>		
			</tr>			
			<%	
			   }
           
            %>     
		</table>
		<form method="post" action="EmployeeResultServelt">
		<select name="report">
			<option value="All">All Employees</option>
  			<option value="Academic">Academic</option>
  			<option value="Non-Academic">Non-Academic</option>
  			<option value="Teacher">Teacher</option>					
		</select>
		<input type="submit" value="Generate Report" class="btn btn-primary">
		</form>
</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	 <!--<script>
	    $('.mydatatable').DataTable(
	    		
	    		{     

	    		      "aLengthMenu": [[5, 10, 25, -1], [5, 10, 25, "All"]],
	    		        "iDisplayLength": 5
	    		 } 
	    		        
	    
	    );
	    
	</script>-->  
	<script>
	    $('.mydatatable').DataTable();
	</script>
</body>
</html>